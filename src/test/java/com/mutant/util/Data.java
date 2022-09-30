package com.mutant.util;

import com.mutant.entity.DNAEntity;
import com.mutant.model.RequestDto;

import java.util.List;

public class Data {

    public final static String JSONDNA = "{dna:[ACGT,TGAA,GTCA,AACT]}";
    public final static String DNAEXIST[] = {"ACGT","TGAA","GTCA","AACT"};
    public final static String DNANOTSQUARE[] = {"ACGT","TGAA","GTCA","AA"};
    public final static String DNANOTVALID[] = {"ACG","TGA","GTC"};
    public final static String DNANOTVALIDCHARACTERS[] = {"AAAA","AAAA","AAAA","AAAE"};
    public final static String DNAMUTANTX[] = {"AAAA","AAAA","AAAA","AAAA"};
    public final static String DNAMUTANTY[] = {"ACTG","ACGT","ACGT","ACTG"};
    public final static String DNAMUTANTZ[] = {"ACGTTC","AAGTTG","AAATTG","CCAAAC","CCGAAC","CCGTAA"};
    public final static String DNAMUTANTXX[] = {"AAAAAAAA","AAAAAAAA","AAAAAAAA","AAAAAAAA","AAAAAAAA","AAAAAAAA","AAAAAAAA","AAAAAAAA"};
    public final static String DNAHUMAN[] = {"ACGT","CGTA","TAGA","CCGT"};
    public final static String MUTANT = "MUTANT";
    public final static String HUMAN = "HUMAN";
    public final static String MESSAGE_TEST = "Message test";

    public final static RequestDto REQUEST_DTO_EXIST = RequestDto.builder().dna(DNAEXIST).build();
    public final static RequestDto REQUEST_DTO_NOTSQUARE = RequestDto.builder().dna(DNANOTSQUARE).build();
    public final static RequestDto REQUEST_DTO_NOTVALID = RequestDto.builder().dna(DNANOTVALID).build();
    public final static RequestDto REQUEST_DTO_NOTVALIDCHARACTERS = RequestDto.builder().dna(DNANOTVALIDCHARACTERS).build();
    public final static RequestDto REQUEST_DTO_MUTANTX = RequestDto.builder().dna(DNAMUTANTX).build();
    public final static RequestDto REQUEST_DTO_MUTANTY = RequestDto.builder().dna(DNAMUTANTY).build();
    public final static RequestDto REQUEST_DTO_MUTANTZ = RequestDto.builder().dna(DNAMUTANTZ).build();
    public final static RequestDto REQUEST_DTO_MUTANTXX = RequestDto.builder().dna(DNAMUTANTXX).build();
    public final static RequestDto REQUEST_DTO_HUMAN = RequestDto.builder().dna(DNAHUMAN).build();
    public final static DNAEntity DNAEntity = com.mutant.entity.DNAEntity.builder().dna(JSONDNA).type(HUMAN).build();
    public final static List<DNAEntity> LIST_DNA = List.of(DNAEntity);




}
