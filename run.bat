@echo off
REM Usage: run.bat inputFile outputFile

set INPUT_FILE=%1
if "%INPUT_FILE%"=="" set INPUT_FILE=src/test/resources/maps/map

set OUTPUT_FILE=%2
if "%OUTPUT_FILE%"=="" set OUTPUT_FILE=output.txt

gradlew runSimulation -PinputFile=%INPUT_FILE% -PoutputFile=%OUTPUT_FILE%
