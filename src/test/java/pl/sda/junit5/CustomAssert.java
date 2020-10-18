package pl.sda.junit5;

import org.assertj.core.api.AbstractAssert;

public final class CustomAssert extends AbstractAssert<CustomAssert, Integer> {

    public static CustomAssert assertThat(Integer actual) {
        return new CustomAssert(actual);
    }

    public CustomAssert(Integer actual) {
        super(actual, CustomAssert.class);
    }

    public void isInRange(int expectedBegin, int expectedEnd) {
        if (expectedBegin > expectedEnd) {
            failWithMessage("expected begin can not be greater than expected end");
        }
        if ((actual < expectedBegin) || (actual > expectedEnd)) {
            failWithMessage("expected that actual will be in range <%d, %d>", expectedBegin, expectedEnd);
        }
    }

}
