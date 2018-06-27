find . -name "*.java" > src.txt
javac -sourcepath . @src.txt
java avajlauncher.simulator.Runner scenario.txt
find . -name "*.class" -delete
