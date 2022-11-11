package com.github.jdussouillez.enumtoolkit.bool;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * Boolean operation
 *
 * @param <E> Enum type
 */
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public abstract class Operation<E extends Enum<E>> extends Expression<E> {

    /**
     * Operator
     */
    @EqualsAndHashCode.Include
    protected final Operator operator;
}
