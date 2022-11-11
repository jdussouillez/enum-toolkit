package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.TestEnums.ProgramOption;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.primitive;
import com.github.jdussouillez.enumtoolkit.bool.visitor.ExpressionVisitor;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests of {@link com.github.jdussouillez.enumtoolkit.bool.NaryOperation}
 */
public class NaryOperationTest {

    /**
     * Operation
     */
    private NaryOperation<ProgramOption> op;

    @BeforeEach
    public void setUp() {
        op = new TriOperation(
            primitive(ProgramOption.DRY),
            primitive(ProgramOption.VERBOSE),
            primitive(ProgramOption.OUTPUT_JSON)
        );
    }

    @Test
    public void testCheckExprParamsMissingParams() {
        var ex = assertThrows(IllegalArgumentException.class, () -> op.checkExprParams(5));
        assertEquals("Invalid number of expr parameters (min: 5, max: -)", ex.getMessage());
    }

    @Test
    public void testCheckExprParamsTooManyParams() {
        var ex = assertThrows(IllegalArgumentException.class, () -> op.checkExprParams(1, 2));
        assertEquals("Invalid number of expr parameters (min: 1, max: 2)", ex.getMessage());
    }

    @Test
    public void testCheckExprParamsOk() {
        assertDoesNotThrow(() -> op.checkExprParams(1, 3));
        assertDoesNotThrow(() -> op.checkExprParams(2, 4));
        assertDoesNotThrow(() -> op.checkExprParams(3, 3));
        assertDoesNotThrow(() -> op.checkExprParams(3, 4));
    }

    /**
     * Operation with 3 parameters
     */
    private static class TriOperation extends NaryOperation<ProgramOption> {

        /**
         * Constructor
         *
         * @param exprs Expressions
         */
        @SafeVarargs
        public TriOperation(final Expression<ProgramOption>... exprs) {
            super(null, exprs);
        }

        @Override
        public Object accept(final ExpressionVisitor<ProgramOption, ?> visitor) {
            return null;
        }
    }
}
