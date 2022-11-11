package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.TestEnums;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests of {@link com.github.jdussouillez.enumtoolkit.bool.NotOperation}
 */
public class NotOperationTest {

    @Test
    public void testToString() {
        assertEquals("~GUEST", Expression.not(TestEnums.Role.GUEST).toString());
        assertEquals("~(~GUEST)", Expression.not(Expression.not(TestEnums.Role.GUEST)).toString());
    }
}
