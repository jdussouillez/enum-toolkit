package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.bool.visitor.ExpressionVisitor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Primitive expression
 *
 * @param <E> Enum type
 */
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Primitive<E extends Enum<E>> extends Expression<E> {

    /**
     * Value
     */
    @Getter
    @EqualsAndHashCode.Include
    protected final E value;

    @Override
    public Object accept(final ExpressionVisitor<E, ?> visitor) {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return value.name();
    }
}
