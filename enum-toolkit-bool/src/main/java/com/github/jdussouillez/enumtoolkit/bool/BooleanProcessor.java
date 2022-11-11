package com.github.jdussouillez.enumtoolkit.bool;

import static com.github.jdussouillez.enumtoolkit.bool.Expression.primitive;
import com.github.jdussouillez.enumtoolkit.bool.visitor.BoolProcessorExpressionVisitor;
import com.github.jdussouillez.enumtoolkit.bool.visitor.ExpressionVisitor;
import java.util.EnumSet;

/**
 * Boolean processor
 *
 * @param <E> Enum type
 */
public class BooleanProcessor<E extends Enum<E>> {

    /**
     * Visitor
     */
    private final BoolProcessorExpressionVisitor<E> visitor;

    /**
     * Constructor
     *
     * @param values Values to test
     */
    public BooleanProcessor(final EnumSet<E> values) {
        visitor = new BoolProcessorExpressionVisitor<>(values);
    }

    /**
     * Processes the boolean expression
     *
     * @param <E> Enum type
     * @param expr Expression
     * @return The boolean result after processing the expression
     */
    @SuppressWarnings("unchecked")
    public <E extends Enum<E>> boolean process(final Expression<E> expr) {
        return (boolean) expr.accept((ExpressionVisitor<E, Boolean>) visitor);
    }

    /**
     * Processes the boolean expression
     *
     * @param <E> Enum type
     * @param value Value
     * @return The boolean result after processing the expression
     */
    public <E extends Enum<E>> boolean process(final E value) {
        return process(primitive(value));
    }
}
