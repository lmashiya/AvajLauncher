find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java launcher.simulator.Runner scenario.txt
