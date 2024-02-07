package Critiquing;

/**
 * This class will represent any operations we want to perform involving Timestamps
 * <p>
 * While it'll mainly be used as a "helper" class to create a Timestamp object, we will need it for various operations.
 */
public final class Timestamp {
    // define instance variables
    private final int minute;
    private final int seconds;
    private final long milliseconds;

    // Create a builder class
    public static class Builder {
        private int minute;
        private int seconds;
        private int milliseconds;

        public Builder() {

        }

        // set the minute
        public Builder setMinute(int val) {
            minute = val;
            return this;
        }

        // set the seconds
        public Builder setSeconds(int val) {
            seconds = val;
            return this;
        }

        // set the milliseconds
        public Builder setMilliseconds(int val) {
            milliseconds = val;
            return this;
        }

        // est the builder
        public Timestamp build() {
            return new Timestamp(this);
        }
    }

    // make constructor private
    private Timestamp(Builder builder) {
        this.minute = builder.minute;
        this.seconds = builder.seconds;
        this.milliseconds = builder.milliseconds;
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

    // @FIXME need to implement

//    /**
//     * Given a string timestamp, parases the timestamp accordingly and returns it in DateFormatter format
//     *
//     * @param timeStampStr
//     * @return a properly formatted String
//     */
//    public String formatTimeToStandard(String timeStampStr) {
//        return null;
//    }

// @FIXME need to implement

//    /**
//     * Given a timestamp range (ex: 1:26-1:27) and an optional interval (ex: 0.2ms) the method returns every timestamp in that range
//     *
//     * @param start, end, interval: The first two arguments must be valid timestamps and the optional third argument must be a value less than 1.
//     * @return a list of all the timestamps in the given range
//     */
//    public List<Timestamp> grabEveryTimestampInRange(Timestamp start, Timestamp end, double... interval) {
//        return;
//    }
}
