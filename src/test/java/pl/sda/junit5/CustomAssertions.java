package pl.sda.junit5;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public final class CustomAssertions {

    private CustomAssertions() {
    }

    public static void assertRange(int expectedBegin, int expectedEnd, int actual) {
        assertTrue(expectedBegin <= expectedEnd, "expected begin can not be greater than expected end");
        if ((actual < expectedBegin) || (actual > expectedEnd)) {
            fail("expected that actual will be in range <" + expectedBegin + ", " + expectedEnd + ">");
        }
    }

}
