package Critiquing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class will represent any operations we want to perform involving screenshots
 * <p>
 * Our main functionalities to implement in this class will involve getting screenshots from a video in either milliseconds
 * or seconds.
 */
public final class Screenshot extends Media<Screenshot> {
    // initialize instance variables
    private final String screenshotName;

    // constructor
    public Screenshot(String screenshotName) {
        this.screenshotName = screenshotName;
    }


    @Override
    public void convertTo(String inputFilePath, String outputFilePath) {
        String ffmpegCmd = "ffmpeg -i " + inputFilePath + " " + outputFilePath;
        try {
            Process process = Runtime.getRuntime().exec(ffmpegCmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Image conversion successful.");
            } else {
                System.out.println("Image conversion failed with error code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void cutAndDownload(String media, String inputPath, String outputPath, String startTime, String endTime) throws IOException, InterruptedException {
        // the start time
        Timestamp Tstart = this.parseTimestamp(startTime);

        // FFmpeg command to trim video
        String[] command = {
                "ffmpeg",
                "-i", inputPath,
                "-ss", String.valueOf(), // capture time in seconds
                "vframes", "1",
                "q:v", "2",
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
