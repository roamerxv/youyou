CATALINA_OPTS="-Djava.library.path=/usr/local/apr/lib"
#add java opts
#JAVA_OPTS="-Xms3072m -Xmx4096m -Xmn1g -Xss100m -XX:NewRatio=4 -XX:SurvivorRatio=4 -XX:PermSize=1024m -XX:MaxPermSize=1024m -XX:MaxTenuringThreshold=0 -XX:+UseParallelGC -XX:ParallelGCThreads=20 -XX:+UseParallelOldGC -XX:+UseAdaptiveSizePolicy"
JAVA_OPTS="-server -Xms4g -Xmx4g -Xmn4g -Xss1024k -XX:+AggressiveOpts -XX:+UseBiasedLocking -XX:+DisableExplicitGC -XX:MaxTenuringThreshold=10 -XX:+UseConcMarkSweepGC -XX:+UseParNewGC  -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:LargePageSizeInBytes=128m  -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -Djava.awt.headless=true -Duser.timezone=GMT+08 -Djava.security.egd=file:/dev/./urandom"
