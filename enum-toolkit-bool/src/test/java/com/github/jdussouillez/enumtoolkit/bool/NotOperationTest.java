package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.TestEnums.ProgramOption;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests of {@link com.github.jdussouillez.enumtoolkit.bool.NotOperation}
 */
public class NotOperationTest {

    @Test
    public void testToString() {
        assertEquals("~VERBOSE", not(ProgramOption.VERBOSE).toString());
        assertEquals("~(~VERBOSE)", not(not(ProgramOption.VERBOSE)).toString());
    }
}
