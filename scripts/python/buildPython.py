#!/usr/bin/env python3
# build.py - Build the entire Uber Clone backend project (skip tests)

import os
import subprocess
import sys

# Move to project root directory
script_dir = os.path.dirname(os.path.abspath(__file__))
project_root = os.path.abspath(os.path.join(script_dir, ".."))
os.chdir(project_root)

print("🛠️ Starting build for uber-clone-backend...")

# Run Maven command
result = subprocess.run(["mvn", "clean", "install", "-Dmaven.test.skip=true"])

# Check result
if result.returncode == 0:
    print("Build completed successfully!")
else:
    print(" Build failed. Please check the error messages above.", file=sys.stderr)
    sys.exit(2)
