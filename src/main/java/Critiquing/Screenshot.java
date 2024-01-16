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
    private Timestamp start, end;
    private long duration;
    private String name;

    // constructor
    public Screenshot(Timestamp start, Timestamp end, String name) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.duration = calculateDuration(this.start, this.end);
    }


    @Override
    public Screenshot convertTo(String extension) {
        return null;
    }

    @Override
    public void cutAndDownload(String media, String inputPath, String outputPath, int... time) throws IOException, InterruptedException {
        // FFmpeg command to trim video
        String[] command = {
                "ffmpeg",
                "-i", inputPath,
                "-ss", String.valueOf(time[0]), // the startTime
                "-t", String.valueOf(time[1]), // the duration
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
