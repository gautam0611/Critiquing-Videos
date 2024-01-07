package Critiquing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}