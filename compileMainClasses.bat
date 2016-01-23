cd src
cd main
cd java

javac -d . edu\jsu\mcis\*.java
cd..
cd..
cd..

javac -d build\classes\main src\main\java\edu\jsu\mcis\*.java

pause