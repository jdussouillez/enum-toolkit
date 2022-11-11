package com.github.jdussouillez.enumtoolkit;

import com.github.jdussouillez.enumtoolkit.TestEnums.Role;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Unit tests of {@link com.github.jdussouillez.enumtoolkit.EnumUtils}
 */
public class EnumUtilsTest {

    /*
     * of
     */
    @Test
    public void testOf() {
        // OK
        assertEquals(Role.ADMIN, EnumUtils.of(Role.class, "ADMIN").get());
        assertEquals(Role.MOD, EnumUtils.of(Role.class, "MOD").get());
        assertEquals(Role.USER, EnumUtils.of(Role.class, "USER").get());
        assertEquals(Role.GUEST, EnumUtils.of(Role.class, "GUEST").get());
    }

    @Test
    public void testOfWrongCase() {
        // KO, case issue
        assertFalse(EnumUtils.of(Role.class, "Admin").isPresent());
        assertFalse(EnumUtils.of(Role.class, "admin").isPresent());
    }

    @Test
    public void testOfNotInEnum() {
        // KO, not in enum
        assertFalse(EnumUtils.of(Role.class, "FOO").isPresent());
    }

    @Test
    public void testOfEmptyName() {
        // KO, empty name
        assertFalse(EnumUtils.of(Role.class, "").isPresent());
    }

    @Test
    public void testOfNullName() {
        // KO, null name
        assertThrows(
            NullPointerException.class,
            () -> EnumUtils.of(Role.class, null).isPresent()
        );
    }

    /*
     * of (with custom case mode)
     */
    @Test
    public void testOfCaseMode() {
        // OK (case sensitive)
        assertEquals(Role.ADMIN, EnumUtils.of(Role.class, "ADMIN", true).get());
        assertEquals(Role.MOD, EnumUtils.of(Role.class, "MOD", true).get());
        assertEquals(Role.USER, EnumUtils.of(Role.class, "USER", true).get());
        assertEquals(Role.GUEST, EnumUtils.of(Role.class, "GUEST", true).get());

        // OK (case insensitive)
        assertEquals(Role.ADMIN, EnumUtils.of(Role.class, "Admin", false).get());
        assertEquals(Role.MOD, EnumUtils.of(Role.class, "mod", false).get());
        assertEquals(Role.USER, EnumUtils.of(Role.class, "usEr", false).get());
    }

    @Test
    public void testOfCaseNotInEnum() {
        // KO, not in enum
        assertFalse(EnumUtils.of(Role.class, "FOO", true).isPresent());
        assertFalse(EnumUtils.of(Role.class, "FOO", false).isPresent());
        assertFalse(EnumUtils.of(Role.class, "foo", true).isPresent());
        assertFalse(EnumUtils.of(Role.class, "foo", false).isPresent());
    }

    @Test
    public void testOfCaseEmptyName() {
        // KO, empty name
        assertFalse(EnumUtils.of(Role.class, "", true).isPresent());
        assertFalse(EnumUtils.of(Role.class, "", false).isPresent());
    }

    @Test
    public void testOfNullCaseName() {
        // KO, null name
        assertThrows(
            NullPointerException.class,
            () -> EnumUtils.of(Role.class, null, true).isPresent()
        );
        assertThrows(
            NullPointerException.class,
            () -> EnumUtils.of(Role.class, null, false).isPresent()
        );
    }
}
