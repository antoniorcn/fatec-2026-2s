@echo off
cls
rm bin -r

javac -s src -d bin ./src/edu/crud/*.java ./src/edu/*.java
java -cp .;./bin edu.crud.AlunoBoundary