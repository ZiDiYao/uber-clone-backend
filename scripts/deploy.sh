#!/bin/bash
# deploy.sh - Upload JAR file to remote server and restart the application

# === Configuration ===
REMOTE_USER="your-username"
REMOTE_HOST="your-server.com"
REMOTE_DIR="/home/app"
SERVICE_NAME="app.service"
JAR_NAME="uber-backend.jar"  # You can change this to match your actual JAR name

# === Move to root directory ===
cd "$(dirname "$0")"/.. || exit 1

# === Build the project first ===
echo "🛠️ Building the project..."
mvn clean install -Dmaven.test.skip=true

# === Check if build succeeded ===
if [ $? -ne 0 ]; then
    echo "Build failed. Deployment aborted." >&2
    exit 2
fi

# === Find the built JAR file ===
JAR_PATH=$(find . -name "$JAR_NAME" | head -n 1)

if [ ! -f "$JAR_PATH" ]; then
    echo " JAR file not found: $JAR_NAME" >&2
    exit 3
fi

# === Upload to remote server ===
echo "🚚 Uploading $JAR_PATH to $REMOTE_USER@$REMOTE_HOST:$REMOTE_DIR..."
scp "$JAR_PATH" "$REMOTE_USER@$REMOTE_HOST:$REMOTE_DIR/"

# === Restart the service on the remote server ===
echo " Restarting $SERVICE_NAME on remote server..."
ssh "$REMOTE_USER@$REMOTE_HOST" "sudo systemctl restart $SERVICE_NAME"

# === Done ===
echo "Deployment completed!"
