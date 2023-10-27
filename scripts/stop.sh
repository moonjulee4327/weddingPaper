#!/usr/bin/env bash

USER_PATH="/home/ec2-user"
PROJECT_NAME="weddingPaper"
JAR="$PROJECT_NAME-0.0.1-SNAPSHOT.jar"

LOG_PATH="$USER_PATH/$PROJECT_NAME/log"
STOP_LOG="$LOG_PATH/stop.log"

SERVICE_PID=$(pgrep -f $JAR)
if [ -z "$SERVICE_PID" ]; then
  echo "서비스를 찾을 수 없습니다." >> $STOP_LOG
else
  echo "서비스가 종료되었습니다." >> $STOP_LOG
  kill -15 "$SERVICE_PID"
fi