# AvajLauncher
The first We Think Code Java Project

#First Step
- Undestand the UML model, here is a little tutorial to get you on Par with the UML Basics.. https://www.youtube.com/watch?v=UI6lqHOVHic

#Second Step
- Now that you understand the UML concept......lets get coding, the UML diagram for the Project is in your resources. Look at it understand it and make sure you now how our programme is going to be structered.

#Third Step
- Make the script to compile and run the programme ............so we can test the code as we move along simulating for our aircrafts......
1.In the root directory.....touch run.sh
2.open the run.sh using your favorite text editor
3.paste this in there...find . 
-name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java <directory of packages>.<directory which contains class with main method>.<name of class> scenario.txt
