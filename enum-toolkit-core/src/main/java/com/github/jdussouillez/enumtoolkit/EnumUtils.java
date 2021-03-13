package com.github.jdussouillez.enumtoolkit;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Enum utils
 *
 * <p>
 * Contains various methods and tools to simplify enum usage
 * </p>
 */
public class EnumUtils {

    /**
     * Constructor
     */
    private EnumUtils() {
        // Private constructor to prevent instance creation
    }

    /**
     * Retrieve the enum value from its name
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
     * Retrieve the enum value from its name (case insensitive)
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
        if (caseSensitive) {
            return of(clazz, name);
        }
        return Stream.of(clazz.getEnumConstants())
            .filter(e -> name.equalsIgnoreCase(e.name()))
            .findFirst();
    }
}
