#!/bin/bash
# build.sh - Build the entire Uber Clone backend project (skip tests)

# Move to the project root directory
cd "$(dirname "$0")"/.. || exit 1

echo "🛠️ Starting build for uber-clone-backend..."
mvn clean install -Dmaven.test.skip=true

# Check if Maven build was successful
if [ $? -eq 0 ]; then
    echo "Build completed successfully!"
else
    echo " Build failed. Please check the error messages above." >&2
    exit 2
fi
