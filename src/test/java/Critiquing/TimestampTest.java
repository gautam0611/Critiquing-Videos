package Critiquing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimestampTest {

    @Test
    void getMinute() {
    }

    @Test
    void getSeconds() {
    }

    @Test
    void getMilliseconds() {
    }

    @Test
    void parseTimestamp() {

    }

    @Test
    void parseTimestampHasIncorrectValues() {
        Timestamp ts1 = new Timestamp.Builder().build();
//        Timestamp ts2 = ts1.parseTimestamp("abc");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            ts1.parseTimestamp("abcd");
        }, "Not a valid timestamp");

        System.out.println(thrown.getMessage());

        assertEquals("Not a valid timestamp", thrown.getMessage());
    }

    @Test
    void parseTimestampSplitStringHasInvalidValues() {

    }

    @Test
    void parseTimestampContainsPeriodButInvalidValues() {

    }

    @Test
    void parseTimestampContainsColonButInvalidValues() {

    }

    @Test
    void parseTimestampContainsColonAndPeriodButInvalidValues() {

    }


    @Test
    void parseTimestampJustSeconds() {
        Timestamp ts1 = new Timestamp.Builder().build();
        Timestamp ts2 = ts1.parseTimestamp("0:20");
        assertEquals(0, ts2.getMinute());
        assertEquals(20, ts2.getSeconds());
    }

    @Test
    void parseTimestampJustMinute() {
        Timestamp ts1 = new Timestamp.Builder().build();
        Timestamp ts2 = ts1.parseTimestamp("1:00");
        assertEquals(1, ts2.getMinute());
        assertEquals(0, ts2.getSeconds());
    }

    @Test
    void parseTimestampJustMilliseconds() {
        Timestamp ts1 = new Timestamp.Builder().build();
        Timestamp ts2 = ts1.parseTimestamp("0.20");
        assertEquals(0, ts2.getSeconds());
        assertEquals(20, ts2.getMilliseconds());
    }

    @Test
    void parseTimestampMinuteAndSeconds() {
        Timestamp ts1 = new Timestamp.Builder().build();
        Timestamp ts2 = ts1.parseTimestamp("1:25");
        assertEquals(1, ts2.getMinute());
        assertEquals(25, ts2.getSeconds());
    }

    @Test
    void parseTimestampSecondsAndMilliseconds() {
        Timestamp ts1 = new Timestamp.Builder().build();
        Timestamp ts2 = ts1.parseTimestamp("0:25.26");
        assertEquals(25, ts2.getSeconds());
        assertEquals(26, ts2.getMilliseconds());
    }

    @Test
    void parseTimestampMinuteAndMilliseconds() {
        Timestamp ts1 = new Timestamp.Builder().build();
        Timestamp ts2 = ts1.parseTimestamp("1:00.26");
        assertEquals(1, ts2.getMinute());
        assertEquals(0, ts2.getSeconds());
        assertEquals(26, ts2.getMilliseconds());
    }

    @Test
    void calculateDuration() {
        Timestamp ts1 = new Timestamp.Builder().build();
        Timestamp start = ts1.parseTimestamp("1:26");
        Timestamp end = ts1.parseTimestamp("1:30");
        assertEquals(4, ts1.calculateDuration(start, end));
    }
}