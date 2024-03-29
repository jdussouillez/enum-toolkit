package com.github.jdussouillez.enumtoolkit.bool.visitor;

import com.github.jdussouillez.enumtoolkit.bool.AndOperation;
import com.github.jdussouillez.enumtoolkit.bool.Expression;
import com.github.jdussouillez.enumtoolkit.bool.NotOperation;
import com.github.jdussouillez.enumtoolkit.bool.Operation;
import com.github.jdussouillez.enumtoolkit.bool.OrOperation;
import com.github.jdussouillez.enumtoolkit.bool.Primitive;
import com.github.jdussouillez.enumtoolkit.bool.XorOperation;

/**
 * Enum expression visitor
 *
 * @param <E> Enum type
 * @param <R> Result type
 */
public interface ExpressionVisitor<E extends Enum<E>, R> {

    /**
     * Visits an expression
     *
     * @param expr Expression
     * @return The result after the visit
     */
    R visit(Expression<E> expr);

    /**
     * Visits a primitive
     *
     * @param primitive Primitive
     * @return The result after the visit
     */
    R visit(Primitive<E> primitive);

    /**
     * Visits an operation
     *
     * @param operation Operation
     * @return The result after the visit
     */
    R visit(Operation<E> operation);

    /**
     * Visits a "NOT" operation
     *
     * @param operation Operation
     * @return The result after the visit
     */
    R visit(NotOperation<E> operation);

    /**
     * Visits a "AND" operation
     *
     * @param operation Operation
     * @return The result after the visit
     */
    R visit(AndOperation<E> operation);

    /**
     * Visits a "AND" operation
     *
     * @param operation Operation
     * @return The result after the visit
     */
    R visit(OrOperation<E> operation);

    /**
     * Visits a "AND" operation
     *
     * @param operation Operation
     * @return The result after the visit
     */
    R visit(XorOperation<E> operation);
}
