package com.github.jdussouillez.enumtoolkit;

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
        assertEquals(TestEnums.Role.ADMIN, EnumUtils.of(TestEnums.Role.class, "ADMIN").get());
        assertEquals(TestEnums.Role.MOD, EnumUtils.of(TestEnums.Role.class, "MOD").get());
        assertEquals(TestEnums.Role.USER, EnumUtils.of(TestEnums.Role.class, "USER").get());
        assertEquals(TestEnums.Role.GUEST, EnumUtils.of(TestEnums.Role.class, "GUEST").get());
    }

    @Test
    public void testOfWrongCase() {
        // KO, case issue
        assertFalse(EnumUtils.of(TestEnums.Role.class, "Admin").isPresent());
        assertFalse(EnumUtils.of(TestEnums.Role.class, "admin").isPresent());
    }

    @Test
    public void testOfNotInEnum() {
        // KO, not in enum
        assertFalse(EnumUtils.of(TestEnums.Role.class, "FOO").isPresent());
    }

    @Test
    public void testOfEmptyName() {
        // KO, empty name
        assertFalse(EnumUtils.of(TestEnums.Role.class, "").isPresent());
    }

    @Test
    public void testOfNullName() {
        // KO, null name
        assertThrows(
            NullPointerException.class,
            () -> EnumUtils.of(TestEnums.Role.class, null).isPresent()
        );
    }

    /*
     * of (with custom case mode)
     */
    @Test
    public void testOfCaseMode() {
        // OK (case sensitive)
        assertEquals(TestEnums.Role.ADMIN, EnumUtils.of(TestEnums.Role.class, "ADMIN", true).get());
        assertEquals(TestEnums.Role.MOD, EnumUtils.of(TestEnums.Role.class, "MOD", true).get());
        assertEquals(TestEnums.Role.USER, EnumUtils.of(TestEnums.Role.class, "USER", true).get());
        assertEquals(TestEnums.Role.GUEST, EnumUtils.of(TestEnums.Role.class, "GUEST", true).get());

        // OK (case insensitive)
        assertEquals(TestEnums.Role.ADMIN, EnumUtils.of(TestEnums.Role.class, "Admin", false).get());
        assertEquals(TestEnums.Role.MOD, EnumUtils.of(TestEnums.Role.class, "mod", false).get());
        assertEquals(TestEnums.Role.USER, EnumUtils.of(TestEnums.Role.class, "usEr", false).get());
    }

    @Test
    public void testOfCaseNotInEnum() {
        // KO, not in enum
        assertFalse(EnumUtils.of(TestEnums.Role.class, "FOO", true).isPresent());
        assertFalse(EnumUtils.of(TestEnums.Role.class, "FOO", false).isPresent());
        assertFalse(EnumUtils.of(TestEnums.Role.class, "foo", true).isPresent());
        assertFalse(EnumUtils.of(TestEnums.Role.class, "foo", false).isPresent());
    }

    @Test
    public void testOfCaseEmptyName() {
        // KO, empty name
        assertFalse(EnumUtils.of(TestEnums.Role.class, "", true).isPresent());
        assertFalse(EnumUtils.of(TestEnums.Role.class, "", false).isPresent());
    }

    @Test
    public void testOfNullCaseName() {
        // KO, null name
        assertThrows(
            NullPointerException.class,
            () -> EnumUtils.of(TestEnums.Role.class, null, true).isPresent()
        );
        assertThrows(
            NullPointerException.class,
            () -> EnumUtils.of(TestEnums.Role.class, null, false).isPresent()
        );
    }
}
