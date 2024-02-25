package Critiquing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class will represent any operations we want to perform involving videos
 * <p>
 * Our main functionality to implement in this class will involve trimming a video into numerous other videos.
 */
public final class Video extends Media<Video> {

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
                System.out.println("Video conversion successful.");
            } else {
                System.out.println("Video conversion failed with error code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cutAndDownload(String media, String inputPath, String outputPath, String startTime, String endTime)
            throws IOException, InterruptedException {

        // converting the passed in startTimes to timestamp objects
        // we will convert these objects to the appropriate string format
        Timestamp Tstart = this.parseTimestamp(startTime);
        Timestamp Tend = this.parseTimestamp(endTime);

        // our string command
        String[] command = {
                "ffmpeg",
                "-i", inputPath,
                "-ss", this.formatTimetoStandard(Tstart),// // the startTime
                "-to", this.formatTimetoStandard(Tend), // // the duration
                "-c", "copy",
                outputPath
        };

        // processing the string command
        try {
            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
