package com.github.jdussouillez.enumtoolkit.bool.visitor;

/**
 * Visitable element
 *
 * @param <E> Enum type
 */
@FunctionalInterface
public interface VisitableElement<E extends Enum<E>> {

    /**
     * Accepts the visitor
     *
     * @param visitor Visitor
     * @return Result after visiting the element
     */
    Object accept(ExpressionVisitor<E, ?> visitor);
}
