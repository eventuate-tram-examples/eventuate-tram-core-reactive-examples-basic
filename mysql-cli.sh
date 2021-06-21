#! /bin/bash -e

docker run $* \
   --name mysqlterm --rm \
   -e MYSQL_PORT_3306_TCP_ADDR=$DOCKER_HOST_IP \
   mysql:5.7.13  \
   sh -c 'exec mysql -h"$MYSQL_PORT_3306_TCP_ADDR" -P3306 -uroot -prootpassword -o eventuate'
