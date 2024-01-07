package Critiquing;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * This class will represent any operations we want to perform involving Timestamps
 *
 * While it'll mainly be used as a "helper" class to create a Timestamp object, we will need it for various operations.
 */
public final class Timestamp {
    // define instance variables
    private int minute;
    private int seconds;
    private long milliseconds;

    // constructor
    public Timestamp (int minute, int seconds) {
        this.minute = minute;
        this.seconds = seconds;
    }

    public Timestamp (int minute, int seconds, long milliseconds) {
        this(minute, seconds);
        this.milliseconds = milliseconds;
    }

    /**
     *
     * @return the minute from the timestamp
     */
    public int getMinute() {
        return this.minute;
    }

    /**
     *
     * @return the seconds from the timestamp
     */
    public int getSeconds() {
        return this.seconds;
    }

    /**
     *
     * @return the milliseconds (if specified) from the timestamp
     */
    public long getMilliseconds() {
        return this.milliseconds;
    }

//    /**
//     *
//     * @param timestampStr
//     * @return
//     */
//    public Timestamp parseTimestamp(String timestampStr) {
//        Timestamp myTimestamp = null;
//        switch (timestampStr) {
//            case "mm:ss":
//                myTimestamp = new Timestamp(this.getMinute(), this.getSeconds());
//                break;
//            case "mm:ss.SS":
//                myTimestamp = new Timestamp(this.getMinute(), this.getSeconds(), this.getMilliseconds());
//                break;
//            default:
//                throw new RuntimeException("not a valid timestamp");
//        }
//        return myTimestamp;
//    }
//
//    // converts the timestamp to the actual format
//    private SimpleDateFormat convertTimestampToOfficialFormat(String timeStampStr) {
//        SimpleDateFormat sdf1 = new SimpleDateFormat("mm:ss");
////        SimpleDateFormat sdf2 = new SimpleDateFormat("mm:ss.SSS");
//        SimpleDateFormat myFormat;
//
//        try {
//           myFormat = sdf1.format(timeStampStr);
//        } catch (RuntimeException re) {
//            System.out.println("Not a valid format");
//        }
//
//    }

    public static void main(String[] args) {
        Timestamp ts = new Timestamp(2, 30);
//        System.out.println(ts.convertTimestampToOfficialFormat("1:28.33"));
    }



}
