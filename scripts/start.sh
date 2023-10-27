#!/usr/bin/env bash

USER_PATH="/home/ec2-user"
PROJECT_NAME="weddingPaper"
PROJECT_DIR="$USER_PATH/$PROJECT_NAME/zip"
JAR="$PROJECT_DIR/build/lib/$PROJECT_NAME-0.0.1-SNAPSHOT.jar"
APPLICATION_DIR="$USER_PATH/$PROJECT_NAME/app"

LOG_PATH="$USER_PATH/$PROJECT_NAME/log"
APP_LOG="$LOG_PATH/application.log"
ERROR_LOG="$LOG_PATH/error.log"
START_LOG="$LOG_PATH/start.log"

NOW=$(date +%c)

echo "[$NOW] $JAR 복사" >> $START_LOG
cp $JAR $APPLICATION_DIR

echo "[$NOW] service 실행" >> $START_LOG
nohup java -jar $APPLICATION_DIR/$PROJECT_NAME-0.0.1-SNAPSHOT.jar > $APP_LOG 2> $ERROR_LOG &

SERVICE_PID=$(pgrep -f $PROJECT_NAME)
echo "[$NOW] > 서비스 PID: $SERVICE_PID" >> $START_LOG
