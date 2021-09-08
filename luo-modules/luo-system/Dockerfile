FROM openjdk:8-jre-alpine

MAINTAINER lsay

ARG JAR_FILE

ENV TZ Asia/Shanghai
ENV JVM_OPTS "-Xms256m -Xmx512m -XX:+UseG1GC -XX:MaxGCPauseMillis=200"

# 日志文件位置有待商榷
# VOLUME /work/logs/user-center/:/work/user-center/app-log

COPY ${JAR_FILE} /usr/luo/luo-modules/service.jar

ENTRYPOINT exec /usr/bin/java ${JVM_OPTS} -jar /usr/luo/luo-modules/service.jar

EXPOSE 9201



