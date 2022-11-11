package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.TestEnums.ProgramOption;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.and;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.not;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.or;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.primitive;
import static com.github.jdussouillez.enumtoolkit.bool.Expression.xor;
import java.util.EnumSet;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests of {@link com.github.jdussouillez.enumtoolkit.bool.BooleanProcessor}
 */
public class BooleanProcessorTest {

    /**
     * Processor with no options
     */
    private BooleanProcessor<ProgramOption> emptyProcessor;

    /**
     * Processor with options verbose
     */
    private BooleanProcessor<ProgramOption> verboseProcessor;

    /**
     * Processor with options quiet and verbose
     */
    private BooleanProcessor<ProgramOption> quietVerboseProcessor;

    /**
     * Processor with options dry, verbose and JSON options
     */
    private BooleanProcessor<ProgramOption> dryVerboseJsonProcessor;

    @BeforeEach
    public void setUp() {
        emptyProcessor = new BooleanProcessor<>(EnumSet.noneOf(ProgramOption.class));
        verboseProcessor = new BooleanProcessor<>(EnumSet.of(ProgramOption.VERBOSE));
        quietVerboseProcessor = new BooleanProcessor<>(EnumSet.of(ProgramOption.QUIET, ProgramOption.VERBOSE));
        dryVerboseJsonProcessor = new BooleanProcessor<>(
            EnumSet.of(ProgramOption.DRY, ProgramOption.VERBOSE, ProgramOption.OUTPUT_JSON)
        );
    }

    @Test
    public void testProcessPrimitiveExpr() {
        assertFalse(emptyProcessor.process(ProgramOption.OUTPUT_JSON));
        assertFalse(verboseProcessor.process(ProgramOption.OUTPUT_JSON));
        assertFalse(quietVerboseProcessor.process(ProgramOption.OUTPUT_JSON));
        assertTrue(dryVerboseJsonProcessor.process(ProgramOption.OUTPUT_JSON));
    }

    @Test
    public void testProcessNotExpr() {
        var expr = not(ProgramOption.DRY);
        assertTrue(emptyProcessor.process(expr));
        assertTrue(verboseProcessor.process(expr));
        assertTrue(quietVerboseProcessor.process(expr));
        assertFalse(dryVerboseJsonProcessor.process(expr));
    }

    @Test
    public void testProcessAndExpr() {
        var expr = and(primitive(ProgramOption.VERBOSE), primitive(ProgramOption.OUTPUT_JSON));
        assertFalse(emptyProcessor.process(expr));
        assertFalse(verboseProcessor.process(expr));
        assertFalse(quietVerboseProcessor.process(expr));
        assertTrue(dryVerboseJsonProcessor.process(expr));
    }

    @Test
    public void testProcessOrExpr() {
        var expr = or(primitive(ProgramOption.DRY), primitive(ProgramOption.VERBOSE));
        assertFalse(emptyProcessor.process(expr));
        assertTrue(verboseProcessor.process(expr));
        assertTrue(quietVerboseProcessor.process(expr));
        assertTrue(dryVerboseJsonProcessor.process(expr));
    }

    @Test
    public void testProcessXorExpr() {
        var expr = xor(primitive(ProgramOption.QUIET), primitive(ProgramOption.VERBOSE));
        assertFalse(emptyProcessor.process(expr));
        assertTrue(verboseProcessor.process(expr));
        assertFalse(quietVerboseProcessor.process(expr));
        assertTrue(dryVerboseJsonProcessor.process(expr));
    }
}
