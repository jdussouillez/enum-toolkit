package com.github.jdussouillez.enumtoolkit.bool.visitor;

import com.github.jdussouillez.enumtoolkit.bool.AndOperation;
import com.github.jdussouillez.enumtoolkit.bool.Expression;
import com.github.jdussouillez.enumtoolkit.bool.NotOperation;
import com.github.jdussouillez.enumtoolkit.bool.Operation;
import com.github.jdussouillez.enumtoolkit.bool.OrOperation;
import com.github.jdussouillez.enumtoolkit.bool.Primitive;
import com.github.jdussouillez.enumtoolkit.bool.XorOperation;
import java.util.EnumSet;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

/**
 * Boolean processor expression visitor
 *
 * @param <E> Enum type
 */
@RequiredArgsConstructor
public class BoolProcessorExpressionVisitor<E extends Enum<E>> implements ExpressionVisitor<E, Boolean> {

    /**
     * Values to process
     */
    protected final EnumSet<E> values;

    @Override
    public Boolean visit(final Expression<E> expr) {
        throw new IllegalStateException("Cannot process Expression. Please implement the visitor on the sub classes");
    }

    @Override
    public Boolean visit(final Operation<E> operation) {
        throw new IllegalStateException("Cannot process Operation. Please implement the visitor on the sub classes");
    }

    @Override
    public Boolean visit(final Primitive<E> primitive) {
        return values.contains(primitive.value());
    }

    @Override
    public Boolean visit(final NotOperation<E> operation) {
        return !(boolean) operation.expr().accept(this);
    }

    @Override
    public Boolean visit(final AndOperation<E> operation) {
        return Stream.of(operation.exprs())
            .allMatch(expr -> (boolean) expr.accept(this));
    }

    @Override
    public Boolean visit(final OrOperation<E> operation) {
        return Stream.of(operation.exprs())
            .anyMatch(expr -> (boolean) expr.accept(this));
    }

    @Override
    public Boolean visit(final XorOperation<E> operation) {
        return Stream.of(operation.exprs())
            .filter(expr -> (boolean) expr.accept(this))
            .limit(2)
            .count() == 1;
    }
}
