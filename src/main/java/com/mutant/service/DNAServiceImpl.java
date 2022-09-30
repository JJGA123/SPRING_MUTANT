package com.mutant.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mutant.common.exception.NotValidMatrix;
import com.mutant.common.message.MessageCatalog;
import com.mutant.common.exception.InvalidCharacters;
import com.mutant.common.exception.NotSquare;
import com.mutant.common.message.MessageProperties;
import com.mutant.common.util.Util;
import com.mutant.entity.DNAEntity;
import com.mutant.model.RequestDto;
import com.mutant.model.ResponseDto;
import com.mutant.model.StatisticDto;
import com.mutant.repository.DNARepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.Math.max;
import static java.lang.Math.min;

@Service
public class DNAServiceImpl implements DNAService {

    private static final String AAAA = "AAAA";
    private static final String TTTT = "TTTT";
    private static final String GGGG = "GGGG";
    private static final String CCCC = "CCCC";
    private static final String MUTANT = "MUTANT";
    private static final String HUMAN = "HUMAN";
    private final MessageProperties messageSource;
    private final DNARepository DNARepository;

    public DNAServiceImpl(MessageProperties messageSource, DNARepository DNARepository){
         this.messageSource = messageSource;
         this.DNARepository = DNARepository;
    }

    /**
     * This method allows to validate if a DNA belongs to a mutant
     * @param dna array with information for validations
     * @return ResponseDTO with the data found
     */
    public ResponseDto isMutant(RequestDto dna) throws JsonProcessingException {
        DNAEntity DNA = DNARepository.findById(Util.toJSon(dna)).orElse(null);
        if(DNA!=null){
            return ResponseDto.builder().status(HttpStatus.OK.toString()).details(messageSource.getMessage(MessageCatalog.DNAEXIST)).errors(messageSource.getMessage(MessageCatalog.NOTERRORS)).objects(DNA).build();
        }
        if (dna == null || !isSquareMatrix(dna.getDna())) {
            throw new NotSquare(messageSource.getMessage(MessageCatalog.NOTSQUARE));
        }
        if (notValidMatrix(dna.getDna())) {
            throw new NotValidMatrix(messageSource.getMessage(MessageCatalog.NOTVALIDMATRIX));
        }
        if (notValidCharacters(dna.getDna())) {
            throw new InvalidCharacters(messageSource.getMessage(MessageCatalog.INVALIDCHARACTERS));
        }
        if(validateMutant(dna.getDna())){
            DNA = DNARepository.save(DNAEntity.builder().dna(Util.toJSon(dna)).type(MUTANT).build());
            return ResponseDto.builder().status(HttpStatus.OK.toString()).details(messageSource.getMessage(MessageCatalog.ISMUTANT)).errors(messageSource.getMessage(MessageCatalog.NOTERRORS)).objects(DNA).build();
        }
        DNA = DNARepository.save(DNAEntity.builder().dna(Util.toJSon(dna)).type(HUMAN).build());
        return ResponseDto.builder().status(HttpStatus.FORBIDDEN.toString()).details(messageSource.getMessage(MessageCatalog.ISHUMAN)).errors(messageSource.getMessage(MessageCatalog.NOTERRORS)).objects(DNA).build();
    }

    /**
     * This method allows to calculate validated DNA statistics
     * @return ResponseDTO with the data found
     */
    public ResponseDto statisticsDNA() {
        final List<DNAEntity> registersDNA = DNARepository.findAll();
        double count_mutant_dan = registersDNA.stream().filter(a -> a.getType().contains(MUTANT)).count();
        double count_human_dan = registersDNA.stream().filter(a -> a.getType().contains(HUMAN)).count();
        double ratio = count_mutant_dan == 0 || count_human_dan ==0 ? 0.0 : (count_mutant_dan/count_human_dan);
        BigDecimal formatNumber = new BigDecimal(ratio);
        formatNumber = formatNumber.setScale(1, RoundingMode.DOWN);
        return ResponseDto.builder()
                .status(HttpStatus.OK.toString())
                .details(messageSource.getMessage(MessageCatalog.STATISTICS))
                .objects(StatisticDto.builder().count_mutant_dan(count_mutant_dan).count_human_dan(count_human_dan).ratio(formatNumber.doubleValue()).build())
                .errors(messageSource.getMessage(MessageCatalog.NOTERRORS)).build();
    }

    /**
     * This method allows to validate if DNA is a squeare matrix
     * @param dna array with the information for validations
     * @return boolean with the validation status
     */
    private boolean isSquareMatrix(String[] dna) {
        int y = dna.length;
        for (String x : dna) {
            if (y != x.length()) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method allows to validate if DNA is a valid matrix
     * @param dna array with the information for validations
     * @return boolean with the validation status
     */
    private boolean notValidMatrix(String[] dna){
        int y = dna.length;
        return y < 4;
    }

    /**
     * This method allows to validate if DNA have only allowed characters
     * @param dna array with the information for validations
     * @return boolean with the validation status
     */
    private boolean notValidCharacters(String[] dna) {
        String stringDNA = Arrays.stream(dna).collect(Collectors.joining());
        int diferentCharacters = stringDNA.replace("A","").replace("C","")
                .replace("T","").replace("G","").length();
        return diferentCharacters != 0;
    }

    /**
     * This method allows to validate if DNA belongs a mutant
     * @param dna array with the information for validations
     * @return boolean with the validation status
     */
    private boolean validateMutant(String[] dna){
        int findSequence = isMutantX(dna);
        if(findSequence>1){
            return true;
        }
        findSequence += isMutantY(dna);
        if(findSequence>1){
            return true;
        }
        findSequence += isMutantZ(dna);
        if(findSequence>1){
            return true;
        }
        return false;
    }

    /**
     * This method allows to validate how many sequences have X axis
     * @param dna array with the information for validations
     * @return int with the corresponding amount
     */
    private int isMutantX(String[] dna) {
        int findSequence = 0;
        for (String string : dna) {
            findSequence += stringHaveDNA(string);
            if (findSequence > 1) {
                break;
            }
        }
        return findSequence;
    }

    /**
     * This method allows to validate how many sequences have Y axis
     * @param dna array with the information for validations
     * @return int with the corresponding amount
     */
    private int isMutantY(String[] dna) {
        int findSequence = 0;
        String string = "";
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                string += dna[j].substring(i, i + 1);
            }
            findSequence += stringHaveDNA(string);
            if (findSequence > 1) {
                break;
            }
            string = "";
        }
        return findSequence;
    }

    /**
     * This method allows to validate how many sequences have Z axis
     * @param dna array with the information for validations
     * @return int with the corresponding amount
     */
    private int isMutantZ(String[] dna) {
        int findSequence = 0;
        int n = dna.length;
        String string = "";
        for (int i = 0; i < n; i++) {
            for (int x = -min(0, i), y = max(0, i); x < n && y < n; x++, y++) {
                string = string + dna[y].substring(x, x + 1);
            }
            findSequence += stringHaveDNA(string);
            if (findSequence > 1) {
                break;
            }
            string = "";
        }
        return findSequence;
    }

    /**
     * This method allows to validate if a string have sequences
     * @param string string with the information for validations
     * @return int with the corresponding amount
     */
    private int stringHaveDNA(String string) {
        int init = 0;
        int findSequence = 0;
        while (init+4 <= string.length()) {
            if (isSequence(string.substring(init,init+4))) {
                init += 3;
                findSequence++;
            }
            if (findSequence>1) {
                break;
            }
            init++;
        }
        return findSequence;
    }

    /**
     * This method allows to validate if a string is a squence
     * @param string string with the information for validations
     * @return boolean with the validation status
     */
    private boolean isSequence(String string){
        return string.contains(AAAA) || string.contains(TTTT) || string.contains(GGGG) || string.contains(CCCC);
    }
}
