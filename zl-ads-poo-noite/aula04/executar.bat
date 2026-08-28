rm bin -r

javac -s src -d bin ./src/edu/fatec/poo/*.java ./src/com/biscoito/waffer/*.java
java -cp .;./bin com.biscoito.waffer.FolhaPagamento