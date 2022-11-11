package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.bool.visitor.ExpressionVisitor;

/**
 * NOT operation
 *
 * @param <E> Enum type
 */
public class NotOperation<E extends Enum<E>> extends UnaryOperation<E> {

    /**
     * Constructor
     *
     * @param expr Expression
     */
    public NotOperation(final Expression<E> expr) {
        super(Operator.NOT, expr);
    }

    @Override
    public Object accept(final ExpressionVisitor<E, ?> visitor) {
        return visitor.visit(this);
    }
}
