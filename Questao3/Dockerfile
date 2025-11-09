
FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
    apt-get install -y mysql-server && \
    rm -rf /var/lib/apt/lists/*

RUN mkdir -p /var/lib/mysql

COPY init-db.sh /docker-entrypoint-initdb.d/

EXPOSE 3306

CMD ["mysqld_safe"]