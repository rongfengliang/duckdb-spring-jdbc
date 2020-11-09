FROM openjdk:11-buster
LABEL AUTHOR="dalongrong"
ADD libstdc++.so.6.0.28 /usr/lib/x86_64-linux-gnu/libstdc++.so.6.0.28
RUN rm -rf /usr/lib/x86_64-linux-gnu/libstdc++.so.6
RUN ln -s  /usr/lib/x86_64-linux-gnu/libstdc++.so.6.0.28  /usr/lib/x86_64-linux-gnu/libstdc++.so.6
COPY target/duckdb-demo-0.0.1-SNAPSHOT.jar /opt/duckdb-demo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT  ["java","-jar","/opt/duckdb-demo-0.0.1-SNAPSHOT.jar"]