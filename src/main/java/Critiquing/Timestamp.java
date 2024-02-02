package Critiquing;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * This class will represent any operations we want to perform involving Timestamps
 * <p>
 * While it'll mainly be used as a "helper" class to create a Timestamp object, we will need it for various operations.
 */
public final class Timestamp {
    // define instance variables
    private final int minute;
    private final int seconds;
    private final int milliseconds;

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
    public int getMilliseconds() {
        return this.milliseconds;
    }


    /**
     * Given a string timestamp, parse the timestamp accordingly and returns it as an object
     *
     * @param timeStampStr The string timestamp that needs to be parsed (ex: 1:25.26)
     * @return a Timestamp object
     */
    public Timestamp parseTimestamp(String timeStampStr) {
        // local variables that we will use
        String[] timeElements = new String[0];
        Timestamp myTimestamp = new Timestamp.Builder().build();

        // parse the element
        try {
            // check if it has a period
            if (timeStampStr.contains(".") && !timeStampStr.contains(":")) {
                timeElements = timeStampStr.split(".");

                // check that both are valid ints
                boolean isValid = isValidInt(timeElements);

                // length of the array needs to be 2
                if (timeElements.length != 2 && !isValid) {
                    throw new IllegalArgumentException("Not a valid timestamp");
                } else {
                    myTimestamp = new Timestamp.Builder()
                            .setMinute(Integer.parseInt(timeElements[0]))
                            .setSeconds(Integer.parseInt(timeElements[1]))
                            .setMilliseconds(Integer.parseInt(timeElements[2]))
                            .build();
                }

            } else if (!timeStampStr.contains(".") && timeStampStr.contains(":")) {
                timeElements = timeStampStr.split(":");

                // check that both are valid ints
                boolean isValid = isValidInt(timeElements);

                // length of the array needs to be 2
                if (timeElements.length != 2 && !isValid) {
                    throw new IllegalArgumentException("Not a valid timestamp");
                } else {
                    myTimestamp = new Timestamp.Builder()
                            .setMinute(Integer.parseInt(timeElements[0]))
                            .setSeconds(Integer.parseInt(timeElements[1]))
                            .build();
                }
            } else if (timeStampStr.contains(".") && timeStampStr.contains(":")) {
                timeElements = timeStampStr.split("[:.]");

                // check that both are valid ints
                boolean isValid = isValidInt(timeElements);

                // length of the array needs to be 3
                if (timeElements.length != 3 && !isValid) {
                    throw new IllegalArgumentException("Not a valid timestamp");
                } else {
                    myTimestamp = new Timestamp.Builder()
                            .setMinute(Integer.parseInt(timeElements[0]))
                            .setSeconds(Integer.parseInt(timeElements[1]))
                            .setMilliseconds(Integer.parseInt(timeElements[2]))
                            .build();
                }
            } else {
                throw new IllegalArgumentException("not a valid timestamp");
            }
        } catch (IllegalArgumentException re) {
            System.out.println("Not a valid timestamp");
        }
        return myTimestamp;
    }

    // helper function to see if it's a valid int once parsed
    private boolean isValidInt(String[] str) {
        boolean flag = true;
        for (String s : str) {
            try {
                Integer.parseInt(s);
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println("Not a valid Integer");
                flag = false;
            }
        }
        return flag;
    }

    /**
     * Given a string timestamp, parses the timestamp accordingly and returns it in LocalTime format
     *
     * @param timeStampStr
     * @return a properly formatted String
     */
    public String formatTimetoStandard(Timestamp t1) {

        // Parse the input string timestamp into a LocalTime object
        LocalTime localTime = LocalTime.of(0, t1.getMinute(), t1.getSeconds(), t1.getMilliseconds() * 1_000_000);

        // Create a DateTimeFormatter for the official timestamp format
        DateTimeFormatter officialFormatter = DateTimeFormatter.ofPattern("mm:ss.SSS");

        // Format the LocalTime object using the DateTimeFormatter
        String myTime = localTime.format(officialFormatter);

        return myTime;
    }

    /**
     * Calculates the duration within the given range of timestamps
     *
     * @param start the start Timestamp in the range
     * @param end   the end Timestamp in the range
     * @return the calculated duration in seconds
     */
    public long calculateDuration(Timestamp start, Timestamp end) {
        // convert everything to seconds
        long startMin = (long) start.getMinute() * 60;
        long startSeconds = (long) start.getSeconds();
        long startMilliseconds = start.getMilliseconds() / 100;
        long endMin = (long) end.getMinute() * 60;
        long endSeconds = (long) end.getSeconds();
        long endMilliseconds = end.getMilliseconds() / 100;

        // sum up everything
        long startTotalInSeconds = startMin + startSeconds + startMilliseconds;
        long endTotalInSeconds = endMin + endSeconds + endMilliseconds;

        return endTotalInSeconds - startTotalInSeconds;
    }

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
