package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.bool.visitor.ExpressionVisitor;

/**
 * OR operation
 *
 * @param <E> Enum type
 */
public class OrOperation<E extends Enum<E>> extends NaryOperation<E> {

    /**
     * Constructor
     *
     * @param exprs Expressions
     */
    @SafeVarargs
    public OrOperation(final Expression<E>... exprs) {
        super(Operator.OR, exprs);
        checkExprParams(2);
    }

    @Override
    public Object accept(final ExpressionVisitor<E, ?> visitor) {
        return visitor.visit(this);
    }
}
