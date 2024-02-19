package Critiquing;

import java.io.IOException;

/**
 * This class will represent any operations we want to perform involving screenshots
 * <p>
 * Our main functionalities to implement in this class will involve getting screenshots from a video in either milliseconds
 * or seconds.
 */
public final class Screenshot extends Media<Screenshot> {
    // initialize instance variables
    private final Timestamp start;
    private final Timestamp end;
    private final String screenshotName;

    // constructor
    public Screenshot(Timestamp start, Timestamp end, String screenshotName) {
        this.start = start;
        this.end = end;
        this.screenshotName = screenshotName;
    }


    @Override
    public Screenshot convertTo(String extension) {
        return null;
    }

    @Override
    public void cutAndDownload(String media, String inputPath, String outputPath) throws IOException, InterruptedException {
        // the start time

        // FFmpeg command to trim video
        String[] command = {
                "ffmpeg",
                "-i", inputPath,
                "-ss", formatTimetoStandard(start),// need to insert this value // the startTime
                "-to", formatTimetoStandard(end), // need to insert this value, // the duration
                "-c", "copy",
                outputPath
        };

        // create process builder
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();
        int exitCode = process.waitFor();

        // return a successful response if the exit code is 0
        if (exitCode == 0) {
            System.out.println("Video trimmed successfully.");
        } else {
            System.err.println("Error trimming video. Exit code: " + exitCode);
        }
    }
}
