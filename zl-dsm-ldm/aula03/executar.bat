call kotlinc -include-runtime "%~1.kt" -d "%~1.jar"
java -jar "%~1.jar"