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
     * @param time       a varag that
     */
    public abstract void cutAndDownload(String media, String inputPath, String outputPath, int... time) throws IOException, InterruptedException;

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


}
