package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.bool.visitor.VisitableElement;

/**
 * Boolean expression for enums
 *
 * <p>
 * Can be a primitive or an operation (OR, AND, etc).
 * </p>
 * <p>
 * This class also contains static methods to easily create expressions easily.
 * </p>
 *
 * @param <E> Enum type
 */
public abstract class Expression<E extends Enum<E>> implements VisitableElement<E> {

    /**
     * Constructor
     */
    protected Expression() {
    }

    /**
     * Creates a primitive expression
     *
     * @param <E> Enum type
     * @param value Value
     * @return The created primitive
     */
    public static <E extends Enum<E>> Primitive<E> primitive(final E value) {
        return new Primitive<>(value);
    }

    /**
     * Creates a primitive NOT expression
     *
     * @param <E> Enum type
     * @param expr Expression
     * @return The created expression
     */
    public static <E extends Enum<E>> NotOperation<E> not(final Expression<E> expr) {
        return new NotOperation<>(expr);
    }

    /**
     * Creates a primitive NOT expression
     *
     * @param <E> Enum type
     * @param value Value
     * @return The created expression
     */
    public static <E extends Enum<E>> NotOperation<E> not(final E value) {
        return not(primitive(value));
    }
}
