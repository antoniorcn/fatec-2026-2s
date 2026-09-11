rmdir bin /s /q 

javac -s src -d bin ./src/edu/curso/crud/*.java

java -cp .;./bin edu.curso.crud.GestaoAlunos