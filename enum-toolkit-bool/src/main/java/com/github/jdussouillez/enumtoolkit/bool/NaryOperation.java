package com.github.jdussouillez.enumtoolkit.bool;

import java.util.Arrays;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * N-ary operation
 *
 * @param <E> Enum type
 */
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public abstract class NaryOperation<E extends Enum<E>> extends Operation<E> {

    /**
     * Expressions
     */
    @Getter
    @EqualsAndHashCode.Include
    protected final Expression<E>[] exprs;

    /**
     * Constructor
     *
     * @param operator Operator
     * @param exprs Expressions
     */
    @SafeVarargs
    protected NaryOperation(final Operator operator, final Expression<E>... exprs) {
        super(operator);
        this.exprs = exprs;
    }

    @Override
    public String toString() {
        return Arrays.stream(exprs)
            .map(expr -> {
                String s = expr.toString();
                if (expr instanceof Operation) {
                    s = String.format("(%s)", s);
                }
                return s;
            })
            .collect(Collectors.joining(String.format(" %s ", operator.symbol())));
    }

    /**
     * Checks the number of parameters
     *
     * @param min Minimum parameter number
     * @param max Maximum parameter number. -1 for no limit.
     * @throws IllegalArgumentException If the number of parameters is different from the number expected
     */
    protected void checkExprParams(final int min, final int max) {
        if (exprs.length < min || max != -1 && exprs.length > max) {
            throw new IllegalArgumentException(
                String.format("Invalid number of expr parameters (min: %d, max: %s)", min, max == -1 ? "-" : max)
            );
        }
    }

    /**
     * Checks the number of parameters
     *
     * @param min Minimum parameter number
     * @throws IllegalArgumentException If the number of parameters is different from the number expected
     * @see #checkExprParams(int, int)
     */
    protected void checkExprParams(final int min) {
        checkExprParams(min, -1);
    }
}
