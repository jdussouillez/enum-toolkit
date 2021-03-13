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
        // KO, null value
        NullPointerException ex = assertThrows(
            NullPointerException.class,
            () -> assertFalse(EnumUtils.of(TestEnums.Role.class, null).isPresent())
        );
        assertEquals("Name is null", ex.getMessage());
    }

    @Test
    public void testOfNullName() {
        // KO, null name
        NullPointerException ex = assertThrows(
            NullPointerException.class,
            () -> assertFalse(EnumUtils.of(TestEnums.Role.class, null).isPresent())
        );
        assertEquals("Name is null", ex.getMessage());
    }
}
