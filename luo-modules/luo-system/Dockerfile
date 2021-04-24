FROM openjdk:8-jre-alpine
MAINTAINER lsay

ARG PROFILES_ACTIVE
ARG JAR_FILE
#ARG PROJECT_ARTIFACTID

ENV TZ Asia/Shanghai
ENV JVM_OPTS "-Xms256m -Xmx512m -XX:+UseG1GC -XX:MaxGCPauseMillis=200"
#ENV profiles_active=${PROFILES_ACTIVE}
#ENV project_artifactId=${PROJECT_ARTIFACTID}

# 日志文件位置有待商榷
VOLUME /work/logs/user-center/:/work/user-center/app-log

COPY ${JAR_FILE} /usr/share/user-center/service.jar

ENTRYPOINT exec /usr/bin/java ${JVM_OPTS} -jar /usr/share/user-center/service.jar

CMD ["--spring.profiles.active=${PROFILES_ACTIVE}"]

#EXPOSE 8900



