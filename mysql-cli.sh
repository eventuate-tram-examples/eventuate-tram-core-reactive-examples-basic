#! /bin/bash -e

docker run $*  \
   --network eventuate-tram-core-reactive-examples-basic_default \
   --name mysqlterm  --rm mysql/mysql-server:8.0.27-1.2.6-server \
   sh -c 'exec mysql -hmysql -P3306 -uroot -prootpassword eventuate'
