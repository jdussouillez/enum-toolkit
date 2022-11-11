package com.github.jdussouillez.enumtoolkit.bool.visitor;

import com.github.jdussouillez.enumtoolkit.TestEnums.ProgramOption;
import com.github.jdussouillez.enumtoolkit.bool.Expression;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.and;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.not;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.or;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.primitive;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.xor;
import com.github.jdussouillez.enumtoolkit.bool.Operation;
import java.util.EnumSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Tests of {@link com.github.jdussouillez.enumtoolkit.bool.visitor.BoolProcessorExpressionVisitor}
 */
public class BoolProcessorExpressionVisitorTest {

    /**
     * Visitor
     */
    private BoolProcessorExpressionVisitor<ProgramOption> visitor;

    @BeforeEach
    public void setUp() {
        visitor = new BoolProcessorExpressionVisitor<>(
            EnumSet.of(ProgramOption.DRY, ProgramOption.VERBOSE, ProgramOption.OUTPUT_JSON)
        );
    }

    @Test
    public void testVisitExpr() {
        @SuppressWarnings("unchecked")
        var ex = assertThrows(IllegalStateException.class, () -> visitor.visit(Mockito.mock(Expression.class)));
        assertEquals("Cannot process Expression. Please implement the visitor on the sub classes", ex.getMessage());
    }

    @Test
    public void testVisitOp() {
        @SuppressWarnings("unchecked")
        var ex = assertThrows(IllegalStateException.class, () -> visitor.visit(Mockito.mock(Operation.class)));
        assertEquals("Cannot process Operation. Please implement the visitor on the sub classes", ex.getMessage());
    }

    @Test
    public void testVisitPrimitive() {
        assertTrue(visitor.visit(primitive(ProgramOption.DRY)));
        assertTrue(visitor.visit(primitive(ProgramOption.VERBOSE)));
        assertFalse(visitor.visit(primitive(ProgramOption.REGEXP)));
    }

    @Test
    public void testVisitNotOperation() {
        assertFalse(visitor.visit(not(ProgramOption.DRY)));
        assertFalse(visitor.visit(not(ProgramOption.VERBOSE)));
        assertTrue(visitor.visit(not(ProgramOption.REGEXP)));
    }

    @Test
    public void testVisitAndOperation() {
        // VERBOSE & (JSON & ~DRY)
        var expr = and(
            primitive(ProgramOption.VERBOSE),
            and(primitive(ProgramOption.OUTPUT_JSON), not(ProgramOption.DRY))
        );
        assertFalse(visitor.visit(expr));
    }

    @Test
    public void testVisitOrOperation() {
        // VERBOSE | (JSON & ~DRY)
        var expr = or(
            primitive(ProgramOption.VERBOSE),
            and(primitive(ProgramOption.OUTPUT_JSON), not(ProgramOption.DRY))
        );
        assertTrue(visitor.visit(expr));
    }

    @Test
    public void testVisitXorOperation() {
        // VERBOSE ^ (JSON & ~DRY)
        var expr = xor(
            primitive(ProgramOption.VERBOSE),
            and(primitive(ProgramOption.OUTPUT_JSON), not(ProgramOption.DRY))
        );
        assertTrue(visitor.visit(expr));
    }
}
