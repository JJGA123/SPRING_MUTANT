package com.mutant.unitTest.exception;

import com.mutant.common.exception.InvalidCharacters;
import com.mutant.common.exception.NotSquare;
import com.mutant.common.exception.NotValidMatrix;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GlobalHandlerTest {

    @InjectMocks
    com.mutant.common.exception.GlobalHandler GlobalHandler;

    /**
     * This method testing exception NotSquare
     * Validate that response is not null.
     */
    @Test
    void notSquareTest() {
        assertNotNull(GlobalHandler.notSquare(new NotSquare("EXCEPTION TEST")));
    }

    /**
     * This method testing exception InvalidCharacters
     * Validate that response is not null.
     */
    @Test
    void invalidCharactersTest() {
        assertNotNull(GlobalHandler.invalidCharacters(new InvalidCharacters("EXCEPTION TEST")));
    }

    /**
     * This method testing exception NotValidMatrix
     * Validate that response is not null.
     */
    @Test
    void notValidMatrixTest() {
        assertNotNull(GlobalHandler.notValidMatrix(new NotValidMatrix("EXCEPTION TEST")));
    }

}
