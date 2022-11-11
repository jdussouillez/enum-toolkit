package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.bool.visitor.ExpressionVisitor;

/**
 * AND operation
 *
 * @param <E> Enum type
 */
public class AndOperation<E extends Enum<E>> extends NaryOperation<E> {

    /**
     * Constructor
     *
     * @param exprs Expressions
     */
    @SafeVarargs
    public AndOperation(final Expression<E>... exprs) {
        super(Operator.AND, exprs);
        checkExprParams(2);
    }

    @Override
    public Object accept(final ExpressionVisitor<E, ?> visitor) {
        return visitor.visit(this);
    }
}
