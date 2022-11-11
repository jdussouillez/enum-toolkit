package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.TestEnums.ProgramOption;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.not;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.or;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.primitive;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Tests of {@link com.github.jdussouillez.enumtoolkit.bool.OrOperation}
 */
public class OrOperationTest {

    /*
     * Constructors
     */
    @Test
    public void testConstructorMissingParameters() {
        var ex = assertThrows(IllegalArgumentException.class, () -> new OrOperation<>(primitive(ProgramOption.DRY)));
        assertEquals("Invalid number of expr parameters (min: 2, max: -)", ex.getMessage());
    }

    /*
     * toString
     */
    @Test
    public void testToString() {
        assertEquals("REGEXP | DRY", or(primitive(ProgramOption.REGEXP), primitive(ProgramOption.DRY)).toString());
        assertEquals("REGEXP | (~DRY)", or(primitive(ProgramOption.REGEXP), not(ProgramOption.DRY)).toString());
    }
}
