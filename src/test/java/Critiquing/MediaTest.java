package Critiquing;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MediaTest {

//    @Test
//    void parseTimestampHasIncorrectValues() {
//        Timestamp ts1 = new Timestamp.Builder().build();
////        Timestamp ts2 = ts1.parseTimestamp("abc");
//        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
//            ts1.parseTimestamp("abcd");
//        }, "Not a valid timestamp");
//
//        System.out.println(thrown.getMessage());
//
//        assertEquals("Not a valid timestamp", thrown.getMessage());
//    }

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
        String captureTime = "0:25";
        Media<Screenshot> m1 = new Screenshot("0.20.jpg", captureTime);
        Timestamp parseTs = m1.parseTimestamp("0:20");
        assertEquals(0, parseTs.getMinute());
        assertEquals(20, parseTs.getSeconds());
    }

    @Test
    void printOutEveryTimestampInRange() {
        Media<Video> v1 = new Video("1:25", "1:26");
        Timestamp startTime = new Timestamp.Builder().setMinute(1).setSeconds(25).build();
        Timestamp endTime = new Timestamp.Builder().setMinute(1).setSeconds(26).build();
        List<Timestamp> tsList = v1.grabEveryTimestampInRange(startTime, endTime, 0.2);
        assertEquals(tsList.get(1).getMinute(), 1);
        assertEquals(tsList.get(1).getSeconds(), 25);
        assertEquals(tsList.get(1).getMilliseconds(), 20);
    }

    @Test
    void formattingTimetoStandard() {
        
    }

    /*
    @FIXME fix the rest of the tests from here
     */
//    @Test
//    void parseTimestampJustMinute() {
//        Timestamp ts1 = new Timestamp.Builder().build();
//        Timestamp ts2 = ts1.parseTimestamp("1:00");
//        assertEquals(1, ts2.getMinute());
//        assertEquals(0, ts2.getSeconds());
//    }
//
//    @Test
//    void parseTimestampJustMilliseconds() {
//        Timestamp ts1 = new Timestamp.Builder().build();
//        Timestamp ts2 = ts1.parseTimestamp("0.20");
//        assertEquals(0, ts2.getSeconds());
//        assertEquals(20, ts2.getMilliseconds());
//    }
//
//    @Test
//    void parseTimestampMinuteAndSeconds() {
//        Timestamp ts1 = new Timestamp.Builder().build();
//        Timestamp ts2 = ts1.parseTimestamp("1:25");
//        assertEquals(1, ts2.getMinute());
//        assertEquals(25, ts2.getSeconds());
//    }
//
//    @Test
//    void parseTimestampSecondsAndMilliseconds() {
//        Timestamp ts1 = new Timestamp.Builder().build();
//        Timestamp ts2 = ts1.parseTimestamp("0:25.26");
//        assertEquals(25, ts2.getSeconds());
//        assertEquals(26, ts2.getMilliseconds());
//    }
//
//    @Test
//    void parseTimestampMinuteAndMilliseconds() {
//        Timestamp ts1 = new Timestamp.Builder().build();
//        Timestamp ts2 = ts1.parseTimestamp("1:00.26");
//        assertEquals(1, ts2.getMinute());
//        assertEquals(0, ts2.getSeconds());
//        assertEquals(26, ts2.getMilliseconds());
//    }

    @Test
    void calculateDuration() {
        Timestamp ts1 = new Timestamp.Builder().build();
        Media<Video> v1 = new Video("1:26", "1:30");
        Timestamp start = v1.parseTimestamp("1:26");
        Timestamp end = v1.parseTimestamp("1:30");
        assertEquals(4, v1.calculateDuration(start, end));
    }

}
