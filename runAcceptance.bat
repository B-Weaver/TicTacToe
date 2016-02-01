cd acceptance

javac -cp .;..\build\classes\main TicTacToeKeywords.java
java -cp .;..\build\libs\TicTacToe-1.0.jar;C:\RobotFramework\robotframework-2.9.jar;C:\SwingLibrary\swinglibrary-1.9.5.jar org.robotframework.RobotFramework TicTacToeGuiTests.txt
pause