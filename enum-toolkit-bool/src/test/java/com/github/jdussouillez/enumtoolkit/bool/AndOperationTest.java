package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.TestEnums.Role;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.and;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.not;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.primitive;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Tests of {@link com.github.jdussouillez.enumtoolkit.bool.AndOperation}
 */
public class AndOperationTest {

    /*
     * Constructors
     */
    @Test
    public void testConstructorMissingParameters() {
        var ex = assertThrows(IllegalArgumentException.class, () -> new AndOperation<>(primitive(Role.MOD)));
        assertEquals("Invalid number of expr parameters (min: 2, max: -)", ex.getMessage());
    }

    /*
     * toString
     */
    @Test
    public void testToString() {
        assertEquals("MOD & ADMIN", and(primitive(Role.MOD), primitive(Role.ADMIN)).toString());
        assertEquals("MOD & (~ADMIN)", and(primitive(Role.MOD), not(Role.ADMIN)).toString());
    }
}
