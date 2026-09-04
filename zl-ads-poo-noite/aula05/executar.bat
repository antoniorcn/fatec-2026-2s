@echo off
cls
rm bin -r

javac -s src -d bin ./src/edu/curso/*.java
java -cp .;./bin edu.curso.Teste