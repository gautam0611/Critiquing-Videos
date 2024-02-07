# Critiquing-Videos

## <ins> Objective </ins> : Create a program which allows users to effectively critique videos, in a legible and concise manner, by providing a well-formatted word document containing various critiques that contain screenshots used as a reference point for each critique. 

### <ins> Use Cases </ins>:
1. **Captains critiquing dancers**
- Given a video of the dancer, a captain can use the tool to supplement their critiques with a screenshot that provides a visual to each critique  
2. **Judges critiquing teams**
- Given a video of the team’s performance, judges can use the tool to help point out segments in the set and comment accordingly  
3. **Coaches Analyzing Game Film**
- Given a video of the team’s game, a coach can use the tool to break the film down into quarters (or other segments) and make note of where mistakes occurred
- Ex: if a play broke down, the coach could trim the original video into a clip of just that play and grab various screenshots to add to their notes in order to visualize where the mistakes occurred  
4. **Students Taking Notes on a Video** 
- Given a video that a student wants to take notes on, a student could grab screenshots from the video to supplement their notes with

### <ins> Problems Solved </ins>:
1. Prevents struggle of having to read unorganized notes 
2. Avoids having to scroll back through video to see what the critique refers to
3. Organizes critiques by segment 
4. Allows person critiquing to refer to a frame that happens during a millisecond

### Functionalities: 
1. Separate Video by Segment - Takes a video to be critiqued and separates it by specified segments (songs in most raas use cases)
 
<ins> Arguments </ins> : 
* Video filename
* list of timestamp ranges OR dictionary of timestamp ranges mapped to segment name
* List of timestamp ranges: ex: [00:00-00:20, 00:21-00:40, etc.] 
* Dictionary of timestamp ranges: ex: {song1: 00:00-00:20, song2: 00:21-00:40, etc.}

<ins> Returns </ins>:
* Downloaded videos according to timestamps in a folder
* If a dictionary provided with names, videos will be named accordingly

2. Take Screenshots of Video - Takes a video and returns screenshots of the specified timestamp/duration in a folder, labeling each screenshot with the timestamp to use as reference
<ins> Arguments </ins> : 
* Video filename
* List of timestamps
  * Ex: [1:21, 1:23, 1:10-1:20]
* If provided a range (like the one above), it’ll give a screenshot of every second including the start and end time in that range 

<ins> Returns </ins>:
* Download screenshots to a folder which contains screenshots named by the timestamp 


3. Get Millisecond Frames - If a user is searching for a movement (or several) that occurs during 1 second (ex: 1:26-1:27), but doesn’t know where the movement(s) occurred, they can specify the time range as well as an optional interval value (ex. 0.2 milliseconds) so that they can grab all the frames in that range. For instance, if user inputs range as 1:26-1:27 and interval as 0.2, the function would grab frames from 1:26:00, 1:26:20, 1:26:40, 1:26:60, 1:26:80, 1:27:00
<ins> Arguments </ins> : 
* Duration (ex: 1:26-1:27)
* Interval (optional)
Ex: 0.20 ms
Returns:
Download screenshots to a folder which contains screenshots named by the timestamp 
4. Create Critiques Document - Creates a word document with the timestamps mapped to critiques, with each critique containing a screenshot from the video 
<ins> Arguments </ins> :  
* Word document containing critiques listed line by line
* Folder of screenshots 
<ins> Returns </ins>:  
* A new file of critiques w/ screenshots mapped to critiques in a table format
* The three columns of the table will be “Timestamp”, “Critique”, and “Screenshot” respectively 

5. Compile Critique Documents - Combines all of the critiques from all the specified critique documents combined into a new nicely formatted word document 
<ins> Arguments </ins> : 
* List of word documents containing critiques
* Folder of separated songs
<ins> Returns </ins>:
* A word doc containing all of the critiques for each video mapped to the song in a compressed folder containing the following:
* Folder of screenshots 
* Folder of trimmed videos 
* Folder of formatted docs 
* Compiled Doc   

### Improvements for Later:
1. Annotating/Resizing Screenshot
- Being able to maximize screenshot to a full screen view
- Being able to annotate on the screenshots via some painting/editing tool in case user wants to draw arrows or highlight certain areas in the picture and save
2. Data visualization 
a bar chart (or another chart) that visualizes key words in the critiques to indicate what shows up more frequently in the critiques/notes 
Ex: in a dancer’s use case,  “heads”, “higher knees”, “dropped elbows” could be key words that the user specifies, and a bar chart would be created to visualize the number of occurrences in the critiques 
- Perhaps we can train it to identify key words without manual input (might be AI related but maybe not)
- Linear Regression or another model that can predict where you will make errors by predicting what key words are likely to show up in the next set of critiques 
3. Creating a web-application 
- Develop a frontend with various different GUIs (will have to think about how to design the webpage and what elements to implement) 
4. AI/Machine Learning
- Train the program to recognize certain movements so that it can eventually critique on its own 
- Be able to recognize change of song (if raas) or a change some other type of segment once it is trained 
