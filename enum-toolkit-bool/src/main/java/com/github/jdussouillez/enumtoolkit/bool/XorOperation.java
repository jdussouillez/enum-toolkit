package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.bool.visitor.ExpressionVisitor;

/**
 * XOR operation
 *
 * @param <E> Enum type
 */
public class XorOperation<E extends Enum<E>> extends NaryOperation<E> {

    /**
     * Constructor
     *
     * @param exprs Expressions
     */
    @SafeVarargs
    public XorOperation(final Expression<E>... exprs) {
        super(Operator.XOR, exprs);
        checkExprParams(2);
    }

    @Override
    public Object accept(final ExpressionVisitor<E, ?> visitor) {
        return visitor.visit(this);
    }
}
