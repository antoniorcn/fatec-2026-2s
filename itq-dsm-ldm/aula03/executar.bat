@echo off
call kotlinc -include-runtime "%1.kt" -d "%1.jar"
call java -jar "%1.jar"

