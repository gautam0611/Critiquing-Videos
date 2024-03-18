package Critiquing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimestampTest {

    @Test
    void getMinute() {
        Timestamp t1 = new Timestamp.Builder().setMinute(1).build();
        assertEquals(t1.getMinute(), 1);
    }

    @Test
    void getSeconds() {
        Timestamp t1 = new Timestamp.Builder().setSeconds(30).build();
        assertEquals(t1.getSeconds(), 30);
    }

    @Test
    void getMilliseconds() {
        Timestamp t1 = new Timestamp.Builder().setMilliseconds(0.15).build();
        assertEquals(t1.getMilliseconds(), 15);
    }

}