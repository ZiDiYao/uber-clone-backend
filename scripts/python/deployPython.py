#!/usr/bin/env python3
# deploy.py - Upload JAR to remote server and restart the application

import os
import subprocess
import sys
from pathlib import Path

# === Configuration ===
REMOTE_USER = "your-username"
REMOTE_HOST = "your-server.com"
REMOTE_DIR = "/home/app"
SERVICE_NAME = "app.service"
JAR_NAME = "uber-backend.jar"  # Must match the JAR filename

# === Move to root directory ===
script_dir = Path(__file__).resolve().parent
project_root = script_dir.parent
os.chdir(project_root)

# === Build the project ===
print("🛠️ Building the project...")
build_result = subprocess.run(["mvn", "clean", "install", "-Dmaven.test.skip=true"])
if build_result.returncode != 0:
    print("Build failed. Deployment aborted.", file=sys.stderr)
    sys.exit(2)

# === Find the JAR file ===
print(f"🔍 Searching for {JAR_NAME}...")
found_jars = list(project_root.rglob(JAR_NAME))
if not found_jars:
    print(f"JAR file not found: {JAR_NAME}", file=sys.stderr)
    sys.exit(3)

jar_path = found_jars[0]  # use first match
print(f"✅ Found JAR: {jar_path}")

# === Upload JAR ===
remote = f"{REMOTE_USER}@{REMOTE_HOST}:{REMOTE_DIR}/"
print(f"🚚 Uploading to {remote}...")
scp_result = subprocess.run(["scp", str(jar_path), remote])
if scp_result.returncode != 0:
    print(" Failed to upload JAR.", file=sys.stderr)
    sys.exit(4)

# === Restart service ===
print(f"🔁 Restarting {SERVICE_NAME} on remote server...")
ssh_command = f"sudo systemctl restart {SERVICE_NAME}"
ssh_result = subprocess.run(["ssh", f"{REMOTE_USER}@{REMOTE_HOST}", ssh_command])
if ssh_result.returncode != 0:
    print("Failed to restart remote service.", file=sys.stderr)
    sys.exit(5)

# === Done ===
print("Deployment completed successfully!")
