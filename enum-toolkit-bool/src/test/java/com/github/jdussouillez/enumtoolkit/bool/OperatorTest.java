package com.github.jdussouillez.enumtoolkit.bool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests of {@link com.github.jdussouillez.enumtoolkit.bool.Operator}
 */
public class OperatorTest {

    @Test
    public void testToString() {
        assertEquals("NOT", Operator.NOT.toString());
    }
}
