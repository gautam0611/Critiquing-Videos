package Critiquing;

import java.io.IOException;

/**
 * Represents an abstract class containing methods for any class involving manipulating media.
 *
 * @param <T> our Media type which will be either a screenshot or a video.
 */
public abstract class Media<T> {

    /**
     * A method used to convert a specified type to a specific extension
     *
     * @param extension the extension that we want to convert our media type to
     * @return The specified media type with the specified extension.
     */
    public abstract T convertTo(String extension);

    /**
     * A method used to download videos or screenshots to a specific location
     *
     * @param media      will be "FFmepg" if we are performing actions regarding videos
     * @param inputPath  the input file path that we want to get the file from
     * @param outputPath the output file path that we want to download to
     */
    public abstract void cutAndDownload(String media, String inputPath, String outputPath) throws IOException, InterruptedException;

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
}
