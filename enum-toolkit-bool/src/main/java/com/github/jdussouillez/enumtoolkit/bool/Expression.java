package com.github.jdussouillez.enumtoolkit.bool;

import com.github.jdussouillez.enumtoolkit.bool.visitor.VisitableElement;
import java.util.ArrayList;

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
     * Creates a NOT expression
     *
     * @param <E> Enum type
     * @param expr Expression
     * @return The created expression
     */
    public static <E extends Enum<E>> NotOperation<E> not(final Expression<E> expr) {
        return new NotOperation<>(expr);
    }

    /**
     * Creates a NOT expression
     *
     * @param <E> Enum type
     * @param value Value
     * @return The created expression
     */
    public static <E extends Enum<E>> NotOperation<E> not(final E value) {
        return not(primitive(value));
    }

    /**
     * Creates a AND expression
     *
     * @param <E> Enum type
     * @param exprs Expressions
     * @return The created expression
     */
    @SafeVarargs
    public static <E extends Enum<E>> AndOperation<E> and(final Expression<E>... exprs) {
        return new AndOperation<>(exprs);
    }

    /**
     * Creates a AND expression
     *
     * @param <E> Enum type
     * @param exprs Expressions
     * @return The created expression
     */
    public static <E extends Enum<E>> AndOperation<E> and(final Iterable<Expression<E>> exprs) {
        return and(asArray(exprs));
    }

    /**
     * Creates a OR expression
     *
     * @param <E> Enum type
     * @param exprs Expressions
     * @return The created expression
     */
    @SafeVarargs
    public static <E extends Enum<E>> OrOperation<E> or(final Expression<E>... exprs) {
        return new OrOperation<>(exprs);
    }

    /**
     * Creates a OR expression
     *
     * @param <E> Enum type
     * @param exprs Expressions
     * @return The created expression
     */
    public static <E extends Enum<E>> OrOperation<E> or(final Iterable<Expression<E>> exprs) {
        return or(asArray(exprs));
    }

    /**
     * Creates a XOR expression
     *
     * @param <E> Enum type
     * @param exprs Expressions
     * @return The created expression
     */
    @SafeVarargs
    public static <E extends Enum<E>> XorOperation<E> xor(final Expression<E>... exprs) {
        return new XorOperation<>(exprs);
    }

    /**
     * Creates a XOR expression
     *
     * @param <E> Enum type
     * @param exprs Expressions
     * @return The created expression
     */
    public static <E extends Enum<E>> XorOperation<E> xor(final Iterable<Expression<E>> exprs) {
        return xor(asArray(exprs));
    }

    /**
     * Transforms the expression iterable to an array
     *
     * @param <E> Enum type
     * @param iterable Iterable to transform
     * @return An array of expressions
     */
    @SuppressWarnings("unchecked")
    private static <E extends Enum<E>> Expression<E>[] asArray(final Iterable<Expression<E>> iterable) {
        var list = new ArrayList<Expression<E>>();
        iterable.forEach(list::add);
        return list.toArray(Expression[]::new);
    }
}
