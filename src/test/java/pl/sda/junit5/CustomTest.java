package pl.sda.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static pl.sda.junit5.CustomAssert.assertThat;
import static pl.sda.junit5.CustomAssertions.assertRange;

public class CustomTest {

    @Test
    public void shouldSuccessWhenValueIsInRange() {
        assertRange(1, 100, 10);
        assertThat(10).isInRange(1, 100);
    }

    @Disabled
    @Test
    public void shouldFailWhenValueIsNotInRange() {
        assertRange(1, 10, 100);
        assertThat(100).isInRange(1, 10);
    }

}
