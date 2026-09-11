@echo off
cls
rm bin -r

javac -s src -d bin ./src/edu/crud/*.java
java -cp .;./bin edu.crud.GestaoAlunos