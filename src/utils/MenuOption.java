package utils;

/**
 * Any enum that wants to be used as a menu option must implement this interface.
 * This allows showOptions() and commandEvaluation() to work with ANY enum generically.
 */
public interface MenuOption {
    String getDisplayName();
    String getCommand();
}
