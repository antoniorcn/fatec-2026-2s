rmdir bin /s /q 

javac -s src -d bin ./src/com/apex/exp/*.java

java -cp .;./bin com.apex.exp.FolhaPagamento