#!/bin/bash

# Usage: ./run.sh inputFile outputFile

INPUT_FILE=${1:-src/test/resources/maps/map}
OUTPUT_FILE=${2:-output.txt}

./gradlew runSimulation -PinputFile="$INPUT_FILE" -PoutputFile="$OUTPUT_FILE"
