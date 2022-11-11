package com.github.jdussouillez.enumtoolkit.bool;

import lombok.EqualsAndHashCode;

/**
 * Unary operation
 *
 * @param <E> Enum type
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public abstract class UnaryOperation<E extends Enum<E>> extends NaryOperation<E> {

    /**
     * Constructor
     *
     * @param operator Operator
     * @param expr Expression
     */
    protected UnaryOperation(final Operator operator, final Expression<E> expr) {
        super(operator, expr);
    }

    /**
     * Returns the expression value
     *
     * @return The expression value of this unary operation
     */
    public Expression<E> expr() {
        return exprs[0];
    }

    @Override
    public String toString() {
        String s = expr().toString();
        if (expr() instanceof Operation) {
            s = String.format("(%s)", s);
        }
        return operator.symbol() + s;
    }
}
