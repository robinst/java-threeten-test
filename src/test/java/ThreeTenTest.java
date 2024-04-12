import org.junit.jupiter.api.Test;
import org.threeten.extra.scale.TaiInstant;
import org.threeten.extra.scale.UtcInstant;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeTenTest {

    @Test
    void testPart1() {
        var dt1 = UtcInstant.parse("2015-06-30T23:59:59Z");
        var tai1 = TaiInstant.of(dt1);

        var dt2 = UtcInstant.parse("2015-07-01T00:00:00Z");
        var tai2 = TaiInstant.of(dt2);

        assertEquals(1, Duration.between(dt1.toInstant(), dt2.toInstant()).toSeconds());
        assertEquals(1998, Duration.between(dt1.toInstant(), dt2.toInstant()).toMillis());
        assertEquals(2, tai1.durationUntil(tai2).toSeconds());
    }

    @Test
    void testPart2() {
        var dt = UtcInstant.parse("2015-06-30T23:59:60Z");

        assertEquals("2015-06-30T23:59:59.001Z", dt.toInstant().toString());

        var tai = TaiInstant.of(dt);
        assertEquals(tai.toUtcInstant(), dt);
    }
}
