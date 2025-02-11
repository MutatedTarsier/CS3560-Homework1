import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {
    ValidParentheses test;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        test = new ValidParentheses();
    }

    @org.junit.jupiter.api.Test
    void checkParenthesesFalse() {
        String input = "(()";
        boolean result = test.check(input);
        assertFalse(result);
    }
    @org.junit.jupiter.api.Test
    void checkParenthesesTrue() {
        String input = "(())";
        boolean result = test.check(input);
        assertTrue(result);
    }
    @org.junit.jupiter.api.Test
    void checkSquareFalse() {
        String input = "[[]";
        boolean result = test.check(input);
        assertFalse(result);
    }
    @org.junit.jupiter.api.Test
    void checkSquareTrue() {
        String input = "[[]]";
        boolean result = test.check(input);
        assertTrue(result);
    }
    @org.junit.jupiter.api.Test
    void checkCurlyFalse() {
        String input = "{{}";
        boolean result = test.check(input);
        assertFalse(result);
    }
    @org.junit.jupiter.api.Test
    void checkCurlyTrue() {
        String input = "{{}}";
        boolean result = test.check(input);
        assertTrue(result);
    }
    @org.junit.jupiter.api.Test
    void checkMixedTrue() {
        String input = "{[()]}";
        boolean result = test.check(input);
        assertTrue(result);
    }
    @org.junit.jupiter.api.Test
    void checkMixedFalse() {
        String input = "{[(]";
        boolean result = test.check(input);
        assertFalse(result);
    }
    @org.junit.jupiter.api.Test
    void checkEmpty() {
        String input = "";
        boolean result = test.check(input);
        assertTrue(result);
    }
}
