package com.github.jdussouillez.enumtoolkit;

import java.util.Optional;

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
}
