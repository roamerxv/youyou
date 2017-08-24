FROM tomcat:8.0.36-jre8
MAINTAINER "roamer <roamerxv@gmail.com>"
#自定义的配置文件，以替换原有image中的配置文件
COPY server.xml /usr/local/tomcat/conf/
COPY setenv.sh   /usr/local/tomcat/bin/
#COPY tomcat-users.xml /usr/local/tomcat/conf/
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime

#ADD probe.war /usr/local/tomcat/webapps/
#ADD ./lib/*.jar /usr/local/tomcat/lib/


#RUN apt-get update && apt-get install vim -y
