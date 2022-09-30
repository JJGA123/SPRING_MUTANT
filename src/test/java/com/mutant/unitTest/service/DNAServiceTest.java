package com.mutant.unitTest.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mutant.entity.DNAEntity;
import com.mutant.repository.DNARepository;
import com.mutant.util.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DNAServiceTest {

    @InjectMocks
    com.mutant.service.DNAServiceImpl DNAServiceImpl;

    @Mock
    DNARepository DNARepository;

    @Mock
    com.mutant.common.message.MessageProperties MessageProperties;

    @BeforeEach
    void setUp() {
    }

    /**
     * This method testing DNA exist
     * Validate that response is not null.
     */
    @Test
    void dnaExistTest() throws JsonProcessingException {
        when(DNARepository.findById(any()).orElse(null)).then(new Answer<Optional<DNAEntity>>() {
            @Override
            public Optional<DNAEntity> answer(InvocationOnMock invocation) throws Throwable {
                return Optional.ofNullable(DNAEntity.builder().dna(Data.JSONDNA).type(Data.MUTANT).build());
            }
        });
        when(MessageProperties.getMessage(any())).thenReturn(Data.MESSAGE_TEST);
        assertNotNull(DNAServiceImpl.isMutant(Data.REQUEST_DTO_EXIST));
    }

    /**
     * This method testing DNA isn't square
     * Validate that response is not null.
     */
    @Test
    void notSquareTest() throws JsonProcessingException {
        when(DNARepository.findById(any()).orElse(null)).then(new Answer<Optional<DNAEntity>>() {
            @Override
            public Optional<DNAEntity> answer(InvocationOnMock invocation) throws Throwable {
                return Optional.ofNullable(null);
            }
        });
        when(MessageProperties.getMessage(any())).thenReturn(String.valueOf(Data.MESSAGE_TEST));
        try {
            DNAServiceImpl.isMutant(Data.REQUEST_DTO_NOTSQUARE);
        } catch (Exception e) {
            assertEquals(Data.MESSAGE_TEST, e.getMessage());
        }
    }

    /**
     * This method testing DNA isn't a valid matrix
     * Validate that response is not null.
     */
    @Test
    void notValidMatrixTest() throws JsonProcessingException {
        when(DNARepository.findById(any()).orElse(null)).then(new Answer<Optional<DNAEntity>>() {
            @Override
            public Optional<DNAEntity> answer(InvocationOnMock invocation) throws Throwable {
                return Optional.ofNullable(null);
            }
        });
        when(MessageProperties.getMessage(any())).thenReturn(String.valueOf(Data.MESSAGE_TEST));
        try {
            DNAServiceImpl.isMutant(Data.REQUEST_DTO_NOTVALID);
        } catch (Exception e) {
            assertEquals(Data.MESSAGE_TEST, e.getMessage());
        }
    }

    /**
     * This method testing DNA hava only valid characters
     * Validate that response is not null.
     */
    @Test
    void notValidCharactersTest() throws JsonProcessingException {
        when(DNARepository.findById(any()).orElse(null)).then(new Answer<Optional<DNAEntity>>() {
            @Override
            public Optional<DNAEntity> answer(InvocationOnMock invocation) throws Throwable {
                return Optional.ofNullable(null);
            }
        });
        when(MessageProperties.getMessage(any())).thenReturn(String.valueOf(Data.MESSAGE_TEST));
        try {
            DNAServiceImpl.isMutant(Data.REQUEST_DTO_NOTVALIDCHARACTERS);
        } catch (Exception e) {
            assertEquals(Data.MESSAGE_TEST, e.getMessage());
        }
    }

    /**
     * This method testing DNA is mutant in X axis
     * Validate that response is not null.
     */
    @Test
    void validateMutantXTest() throws JsonProcessingException {
        when(DNARepository.findById(any()).orElse(null)).then(new Answer<Optional<DNAEntity>>() {
            @Override
            public Optional<DNAEntity> answer(InvocationOnMock invocation) throws Throwable {
                return Optional.ofNullable(null);
            }
        });
        when(DNARepository.save(any())).then(new Answer<DNAEntity>() {
            @Override
            public DNAEntity answer(InvocationOnMock invocation) throws Throwable {
                return DNAEntity.builder().build();
            }
        });
        when(MessageProperties.getMessage(any())).thenReturn(Data.MESSAGE_TEST);
        assertNotNull(DNAServiceImpl.isMutant(Data.REQUEST_DTO_MUTANTX));
    }

    /**
     * This method testing DNA is mutant in Y axis
     * Validate that response is not null.
     */
    @Test
    void validateMutantYTest() throws JsonProcessingException {
        when(DNARepository.findById(any()).orElse(null)).then(new Answer<Optional<DNAEntity>>() {
            @Override
            public Optional<DNAEntity> answer(InvocationOnMock invocation) throws Throwable {
                return Optional.ofNullable(null);
            }
        });
        when(DNARepository.save(any())).then(new Answer<DNAEntity>() {
            @Override
            public DNAEntity answer(InvocationOnMock invocation) throws Throwable {
                return DNAEntity.builder().build();
            }
        });
        when(MessageProperties.getMessage(any())).thenReturn(Data.MESSAGE_TEST);
        assertNotNull(DNAServiceImpl.isMutant(Data.REQUEST_DTO_MUTANTY));
    }

    /**
     * This method testing DNA is mutant in Z axis
     * Validate that response is not null.
     */
    @Test
    void validateMutantZTest() throws JsonProcessingException {
        when(DNARepository.findById(any()).orElse(null)).then(new Answer<Optional<DNAEntity>>() {
            @Override
            public Optional<DNAEntity> answer(InvocationOnMock invocation) throws Throwable {
                return Optional.ofNullable(null);
            }
        });
        when(DNARepository.save(any())).then(new Answer<DNAEntity>() {
            @Override
            public DNAEntity answer(InvocationOnMock invocation) throws Throwable {
                return DNAEntity.builder().build();
            }
        });
        when(MessageProperties.getMessage(any())).thenReturn(Data.MESSAGE_TEST);
        assertNotNull(DNAServiceImpl.isMutant(Data.REQUEST_DTO_MUTANTZ));
    }

    /**
     * This method testing DNA is mutant in X axis in the same Y position
     * Validate that response is not null.
     */
    @Test
    void validateMutantXXTest() throws JsonProcessingException {
        when(DNARepository.findById(any()).orElse(null)).then(new Answer<Optional<DNAEntity>>() {
            @Override
            public Optional<DNAEntity> answer(InvocationOnMock invocation) throws Throwable {
                return Optional.ofNullable(null);
            }
        });
        when(DNARepository.save(any())).then(new Answer<DNAEntity>() {
            @Override
            public DNAEntity answer(InvocationOnMock invocation) throws Throwable {
                return DNAEntity.builder().build();
            }
        });
        when(MessageProperties.getMessage(any())).thenReturn(Data.MESSAGE_TEST);
        assertNotNull(DNAServiceImpl.isMutant(Data.REQUEST_DTO_MUTANTXX));
    }

    /**
     * This method testing DNA is human
     * Validate that response is not null.
     */
    @Test
    void validateHumanTest() throws JsonProcessingException {
        when(DNARepository.findById(any()).orElse(null)).then(new Answer<Optional<DNAEntity>>() {
            @Override
            public Optional<DNAEntity> answer(InvocationOnMock invocation) throws Throwable {
                return Optional.ofNullable(null);
            }
        });
        when(DNARepository.save(any())).then(new Answer<DNAEntity>() {
            @Override
            public DNAEntity answer(InvocationOnMock invocation) throws Throwable {
                return DNAEntity.builder().build();
            }
        });
        when(MessageProperties.getMessage(any())).thenReturn(Data.MESSAGE_TEST);
        assertNotNull(DNAServiceImpl.isMutant(Data.REQUEST_DTO_HUMAN));
    }

    /**
     * This method testing DNA statistics
     * Validate that response is not null.
     */
    @Test
    void statisticsDNATest() throws JsonProcessingException {
        when(DNARepository.findAll()).then(new Answer<List<DNAEntity>>() {
            @Override
            public List<DNAEntity> answer(InvocationOnMock invocation) throws Throwable {
                return Data.LIST_DNA;
            }
        });
        when(MessageProperties.getMessage(any())).thenReturn(Data.MESSAGE_TEST);
        assertNotNull(DNAServiceImpl.statisticsDNA());
    }

}
