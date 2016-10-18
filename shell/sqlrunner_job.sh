#!/bin/bash

source /etc/profile

java -cp "/data/app/stock_data/stock_data-web-admin/WEB-INF/lib/*:/usr/local/tomcat/lib/*" com.github.stock_data.cron_job.SqlRunnerJob
 