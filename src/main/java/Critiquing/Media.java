package Critiquing;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an abstract class containing methods for any class involving manipulating media.
 *
 * @param <T> our Media type which will be either a screenshot or a video.
 */
public abstract class Media<T> {

    /**
     * A method used to convert a specified type to a specific extension
     *
     * @param inputFilePath  the input file path of our screenshot
     * @param outputFilePath the output file path of our screenshot
     * @return The specified media type with the specified extension.
     */
    public abstract void convertTo(String inputFilePath, String outputFilePath);

    /**
     * A method used to download videos or screenshots to a specific location
     *
     * @param media      will be "FFmepg" if we are performing actions regarding videos
     * @param inputPath  the input file path that we want to get the file from
     * @param outputPath the output file path that we want to download to
     */
    public abstract void cutAndDownload(String media, String inputPath, String outputPath, String startTime, String endTime) throws IOException, InterruptedException;

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
     * @param t1 the timestamp that we need to format to a string
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
     * Converts the timestamp objects to seconds
     *
     * @param t1 the first timestamp
     * @return the sum of the timestamps
     */
    public double convertToSeconds(Timestamp t1) {
        // convert everything to seconds
        double tMin = t1.getMinute() * 60;
        double tSeconds = t1.getSeconds();
        double tMilliseconds = t1.getMilliseconds();

        // sum up everything
        return tMin + tSeconds + tMilliseconds;
    }

    /**
     * @param d1 the seconds that we want to convert to a timestamp
     * @return A timestamp object that represents the given timestamp
     */
    public Timestamp secondsToTimestamp(double d1) {
        // find the minutes
        int minutes = (int) (d1 / 60.0);
        int seconds = (int) (d1 % 60.0);

        // grabbing just the decimal portion - milliseconds
        String doubleAsString = String.valueOf(d1);
        int indexOfDecimal = doubleAsString.indexOf(".");
        double milliseconds = Double.parseDouble(doubleAsString.substring(indexOfDecimal));

        return new Timestamp.Builder().setMinute(minutes).setSeconds(seconds).setMilliseconds((int) (milliseconds * 100.0)).build();
    }

    /**
     * Given a timestamp range (ex: 1:26-1:27) and an optional interval (ex: 0.2ms) the method returns every timestamp in that range
     *
     * @param start, end, interval: The first two arguments must be valid timestamps and the optional third argument must be a value less than 1.
     * @return a list of all the timestamps in the given range
     */
    public List<Timestamp> grabEveryTimestampInRange(Timestamp start, Timestamp end, double... interval) {
        // initialize a list
        List<Timestamp> tsList = new ArrayList<Timestamp>();

        // running timestamp value
        double runningTimestamp = 0;

        // timestamp interval
        int convertedInterval = (int) (interval[0] * 100.00);
        Timestamp tsInterval = new Timestamp.Builder().setMilliseconds(convertedInterval).build();

        // convert all to seconds
        double intervalInSeconds = convertToSeconds(tsInterval);
        double startTimeInSeconds = convertToSeconds(start);
        double endTimeInSeconds = convertToSeconds(end);

        // if the interval is not null we will perform the following actions
        if (interval != null) {
            runningTimestamp = startTimeInSeconds;

            while (runningTimestamp <= endTimeInSeconds) {
                // add to our list
                tsList.add(secondsToTimestamp((double) runningTimestamp));

                // increment runningTimestamp
                runningTimestamp += intervalInSeconds;
            }
        } else {
            // just add the start and end because there is no specified interval
            tsList.add(start);
            tsList.add(end);
        }

        return tsList;
    }
}
