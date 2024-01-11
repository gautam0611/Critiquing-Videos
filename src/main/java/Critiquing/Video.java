package Critiquing;

/**
 * This class will represent any operations we want to perform involving videos
 * <p>
 * Our main functionality to implement in this class will involve trimming a video into numerous other videos.
 */
public final class Video implements Media<Video> {

    @Override
    public Video convertTo(String extension) {
        return null;
    }

    @Override
    public void cutAndDownload(String media, String inputPath, String outputPath, int... time) {

    }
}
