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


//    /**
//     * Given a string timestamp, parse the timestamp accordingly and returns it as an object
//     *
//     * @param timeStampStr The string timestamp that needs to be parsed (ex: 1:25.26)
//     * @return a Timestamp object
//     */
//    public Timestamp parseTimestamp(String timeStampStr) {
//        // local variables that we will use
//        String[] timeElements = new String[0];
//        Timestamp myTimestamp = new Timestamp.Builder().build();
//
//        // parse the element
//        try {
//            // check if it has a period
//            if (timeStampStr.contains(".") && !timeStampStr.contains(":")) {
//                timeElements = timeStampStr.split(".");
//
//                // check that both are valid ints
//                boolean isValid = isValidInt(timeElements);
//
//                // length of the array needs to be 2
//                if (timeElements.length != 2 && !isValid) {
//                    throw new IllegalArgumentException("Not a valid timestamp");
//                } else {
//                    myTimestamp = new Timestamp.Builder()
//                            .setMinute(Integer.parseInt(timeElements[0]))
//                            .setSeconds(Integer.parseInt(timeElements[1]))
//                            .setMilliseconds(Integer.parseInt(timeElements[2]))
//                            .build();
//                }
//
//            } else if (!timeStampStr.contains(".") && timeStampStr.contains(":")) {
//                timeElements = timeStampStr.split(":");
//
//                // check that both are valid ints
//                boolean isValid = isValidInt(timeElements);
//
//                // length of the array needs to be 2
//                if (timeElements.length != 2 && !isValid) {
//                    throw new IllegalArgumentException("Not a valid timestamp");
//                } else {
//                    myTimestamp = new Timestamp.Builder()
//                            .setMinute(Integer.parseInt(timeElements[0]))
//                            .setSeconds(Integer.parseInt(timeElements[1]))
//                            .build();
//                }
//            } else if (timeStampStr.contains(".") && timeStampStr.contains(":")) {
//                timeElements = timeStampStr.split("[:.]");
//
//                // check that both are valid ints
//                boolean isValid = isValidInt(timeElements);
//
//                // length of the array needs to be 3
//                if (timeElements.length != 3 && !isValid) {
//                    throw new IllegalArgumentException("Not a valid timestamp");
//                } else {
//                    myTimestamp = new Timestamp.Builder()
//                            .setMinute(Integer.parseInt(timeElements[0]))
//                            .setSeconds(Integer.parseInt(timeElements[1]))
//                            .setMilliseconds(Integer.parseInt(timeElements[2]))
//                            .build();
//                }
//            } else {
//                throw new IllegalArgumentException("not a valid timestamp");
//            }
//        } catch (IllegalArgumentException re) {
//            System.out.println("Not a valid timestamp");
//        }
//        return myTimestamp;
//    }
//
//    // helper function to see if it's a valid int once parsed
//    private boolean isValidInt(String[] str) {
//        boolean flag = true;
//        for (String s : str) {
//            try {
//                Integer.parseInt(s);
//                flag = true;
//            } catch (NumberFormatException e) {
//                System.out.println("Not a valid Integer");
//                flag = false;
//            }
//        }
//        return flag;
//    }

    // @FIXME need to implement

    /**
     * Given a string timestamp, parases the timestamp accordingly and returns it in DateFormatter format
     *
     * @param timeStampStr
     * @return a properly formatted String
     */
    public String formatTimeToStandard(String timeStampStr) {
        return null;
    }

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
