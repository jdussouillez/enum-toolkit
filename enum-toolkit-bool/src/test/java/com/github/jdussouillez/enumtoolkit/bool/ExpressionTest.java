package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.TestEnums.ProgramOption;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.and;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.or;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.primitive;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.xor;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Tests of {@link com.github.jdussouillez.enumtoolkit.bool.Expression}
 */
public class ExpressionTest {

    @Test
    public void testAndFromIterable() {
        assertEquals(
            and(primitive(ProgramOption.DRY), primitive(ProgramOption.VERBOSE)),
            and(List.of(primitive(ProgramOption.DRY), primitive(ProgramOption.VERBOSE)))
        );
    }

    @Test
    public void testOrFromIterable() {
        assertEquals(
            or(primitive(ProgramOption.DRY), primitive(ProgramOption.VERBOSE)),
            or(List.of(primitive(ProgramOption.DRY), primitive(ProgramOption.VERBOSE)))
        );
    }

    @Test
    public void testXorFromIterable() {
        assertEquals(
            xor(primitive(ProgramOption.DRY), primitive(ProgramOption.VERBOSE)),
            xor(List.of(primitive(ProgramOption.DRY), primitive(ProgramOption.VERBOSE)))
        );
    }
}
