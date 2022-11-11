package com.github.jdussouillez.enumtoolkit.bool;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Operator
 *
 * @see <a href="https://en.wikipedia.org/wiki/Boolean_algebra#Basic_operations">Wikipedia - Algèbre de Boole
 * (opérations)</a>
 * @see <a href="https://en.wikipedia.org/wiki/Bitwise_operations_in_C#Bitwise_operators">Wikipedia - C bitwise
 * operators</a>
 */
@RequiredArgsConstructor
public enum Operator {

    /**
     * NOT operator
     */
    NOT("~"),
    /**
     * AND operator
     */
    AND("&"),
    /**
     * OR operator
     */
    OR("|"),
    /**
     * XOR operator
     */
    XOR("^");

    /**
     * Symbol
     */
    @Getter
    private final String symbol;

    @Override
    public String toString() {
        return name();
    }
}
