rmdir bin /s /q 

javac -s src -d bin ./src/edu/curso/*.java

java -cp .;./bin edu.curso.Zoo