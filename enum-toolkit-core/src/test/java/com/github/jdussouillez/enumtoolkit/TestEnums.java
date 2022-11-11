package com.github.jdussouillez.enumtoolkit;

/**
 * Tests enum to use in the unit tests
 */
public class TestEnums {

    /**
     * Simple enum to represent a user role
     */
    public static enum Role {
        /**
         * Administrator
         */
        ADMIN,
        /**
         * Moderator
         */
        MOD,
        /**
         * User
         */
        USER,
        /**
         * Guest
         */
        GUEST
    }

    /**
     * Simple enum to represent program options
     */
    public static enum ProgramOption {
        /**
         * Verbose
         */
        VERBOSE,
        /**
         * Quiet
         */
        QUIET,
        /**
         * Dry mode
         */
        DRY,
        /**
         * Enable regular expression
         */
        REGEXP,
        /**
         * Output as JSON
         */
        OUTPUT_JSON,
        /**
         * Output as YAML
         */
        OUTPUT_YAML
    }
}
