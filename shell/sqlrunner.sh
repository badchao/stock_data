#!/bin/bash
source /etc/profile

############  example ##################
# sqlrunner -DjobId=xxx -DjobType=hive -Dday=2013-01-01 -Dtz=TZ_GMT+08
########################################

params=$@

defaultDay=`date "+%Y-%m-%d" --d="1 days ago"`
if [[ !("$params" =~ "-Dday") ]]; then  
	params="$params -Dday=${defaultDay}"
fi

cmd="java  -cp $ANA_HOME/target/offline_analyse.jar:$ANA_HOME $params -DspringConfigDir=classpath:/conf/spring/*.xml -DconfigDir=$ANA_HOME/conf/sqlrunner/offline  com.github.sqlrunner.datax.SqlRunnerMain"
echo '-----------------------------------'
echo $cmd
echo '-----------------------------------'

$cmd 2>&1

