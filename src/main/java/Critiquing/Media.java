package Critiquing;

/**
 * Represents an interface containing methods for any class involving manipulating media.
 *
 * @param <T> our Media type which will be either a screenshot or a video.
 */
public interface Media<T> {

    /**
     * A method used to convert a specified type to a specific extension
     *
     * @param extension the extension that we want to convert our media type to
     * @return The specified media type with the specified extension.
     */
    public T convertTo(String extension);

    /**
     * A method used to download videos or screenshots to a specific location
     *
     * @param media      will be "FFmepg" if we are performing actions regarding videos
     * @param inputPath  the input file path that we want to get the file from
     * @param outputPath the output file path that we want to download to
     * @param time       a varag that
     */
    public void cutAndDownload(String media, String inputPath, String outputPath, int... time);


}
