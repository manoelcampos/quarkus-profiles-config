####
# This Dockerfile is used in order to build a container that runs the Quarkus application in native (no JVM) mode
#
# Before building the docker image run:
#
# mvn package -Pnative -Dnative-image.docker-build=true
#
# Then, build the image with:
#
# docker build -f src/main/docker/native.Dockerfile -t com.manoelcampos/rest-app-quarkus-native .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 com.manoelcampos/rest-app-quarkus-native
#
###

#FROM registry.access.redhat.com/ubi8/ubi-minimal
#FROM cescoffier/native-base:latest
#FROM scratch
FROM alpine:latest

WORKDIR /work/

#Using the cescoffier/native-base:latest, it builds a image with no specific distro.
#This way, trynig to run commands in the regular way, such as "target/*-runner /work/application"
#Won't work. In such case, we have to use [] and provide every command param separate.
#This format was already used for the RUN and CMD below.
COPY ["target/*-runner", "/work/application"]

#Using the no-distro cescoffier/native-base:latest image, there is no chmod
#RUN ["chmod", "775", "/work"]

EXPOSE 80
CMD ["echo", "Open your browser at http://localhost to access the application"]
CMD ["./application"]