package Critiquing;

import java.util.List;

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
     * Gets the correct minute from the specified timestamp
     *
     * @return the minute from the timestamp
     */
    public int getMinute() {
        return this.minute;
    }

    /**
     * Gets the correct second from the specified timestamp
     *
     * @return the seconds from the timestamp
     */
    public int getSeconds() {
        return this.seconds;
    }

    /**
     * Gets the correct millisecond from the specified timestamp
     *
     * @return the milliseconds (if specified) from the timestamp
     */
    public long getMilliseconds() {
        return this.milliseconds;
    }

    // a helper function which converts the given timestamp to seconds
    private double convertTimestampToSeconds(Timestamp ts) {

    }

    /**
     * Given a string timestamp, parse the timestamp accordingly and returns it as an object
     *
     * @param timeStampStr
     * @return a Timestamp object
     */
    public Timestamp parseTimestamp(String timeStampStr) {
        return;
    }


    // @FIXME discuss if we need to have a timestamp in a "standard" format because FFMpeg takes in strings
//    /**
//     * Given a string timestamp, parases the timestamp accordingly and returns it in DateFormatter format
//     * @param timeStampStr
//     * @return a properly formatted String
//     */
//    public String formatTimetoStandard(String timeStampStr) {
//        return;
//    }

    /**
     * Calculates the duration within the given range of timestamps
     *
     * @param start
     * @param end
     * @return the calculated duration in seconds
     */
    public long calculateDuration(Timestamp start, Timestamp end) {
        return;
    }

    /**
     * Given a timestamp range (ex: 1:26-1:27) and an optional interval (ex: 0.2ms) the method returns every timestamp in that range
     *
     * @param start, end, interval: The first two arguments must be valid timestamps and the optional third argument must be a value less than 1.
     * @return a list of all the timestamps in the given range
     */
    public List<Timestamp> grabEveryTimestampInRange(Timestamp start, Timestamp end, double... interval) {
        return;
    }



    public static void main(String[] args) {
        Timestamp ts = new Timestamp(2, 30);
//        System.out.println(ts.convertTimestampToOfficialFormat("1:28.33"));
    }



}
