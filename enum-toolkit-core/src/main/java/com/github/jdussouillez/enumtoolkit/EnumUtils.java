package com.github.jdussouillez.enumtoolkit;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Enum utils
 *
 * <p>
 * Contains various methods and tools to simplify enum usage
 * </p>
 */
public final class EnumUtils {

    /**
     * Constructor
     */
    private EnumUtils() {
    }

    /**
     * Returns the enum value from its name
     *
     * @param <E> Enum type
     * @param clazz Enum class
     * @param name Name of the enum value
     * @return The enum value retrieved from its name
     */
    public static <E extends Enum<E>> Optional<E> of(final Class<E> clazz, final String name) {
        try {
            return Optional.of(Enum.valueOf(clazz, name));
        } catch (IllegalArgumentException ex) {
            return Optional.empty();
        }
    }

    /**
     * Returns the enum value from its name (case insensitive)
     *
     * <p>
     * Please know that using caseSensitive with "false" is much slower than the case sensitive execution. Why ? Because
     * the case insensitive mode loop through the enum to compare the names using reflection, but the sensitive mode use
     * the internal JDK API.
     * </p>
     *
     * @param <E> Enum type
     * @param clazz Enum class
     * @param name Name of the enum value
     * @param caseSensitive Case sensitive (default is true)
     * @return The enum value retrieved from its name
     */
    public static <E extends Enum<E>> Optional<E> of(final Class<E> clazz, final String name,
        final boolean caseSensitive) {
        return caseSensitive
            ? of(clazz, name)
            : of(clazz, name.toLowerCase(), e -> e.name().toLowerCase());
    }

    /**
     * Returns the enum value from a value
     *
     * @param <E> Enum type
     * @param <V> Value type
     * @param clazz Enum class
     * @param value Enum value
     * @param valueGenerator Value generator
     * @return The enum value retrieved from the value
     */
    public static <E extends Enum<E>, V> Optional<E> of(final Class<E> clazz, final V value,
        final Function<E, V> valueGenerator) {
        return Stream.of(clazz.getEnumConstants())
            .filter(e -> valueGenerator.apply(e).equals(value))
            .findFirst();
    }
}
