
GC Algorithms Benchmarking:

-Xms200m -Xmx200m -Xloggc:gc_parallel.log  -XX:+UseParallelGC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:ParallelGCThreads=4



-Xms200m -Xmx200m -Xloggc:gc_parallel2g.log  -XX:+UseParallelGC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps


-Xms1g -Xmx1g -Xloggc:gc_parallel1g.log  -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps

-Xms4g -Xmx4g -Xloggc:gc_parallel4g.log  -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps



-Xms200m -Xmx200m -Xloggc:gc_cms.log  -XX:+UseConcMarkSweepGC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps

-Xms4g -Xmx4g -Xloggc:gc_cms4g.log  -XX:+UseConcMarkSweepGC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps


-Xms200m -Xmx200m   -Xloggc:gc_g1gc2g.log  -XX:+UseG1GC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:ParallelGCThreads=2


-Xms200m -Xmx200m -Xloggc:gc_g1gc4g.log  -XX:+UseG1GC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps



G1 GC With Pause time goal:

-XX:MaxGCPauseMillis=200 

To get Heap Dump:
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=abc

Enable Logging with the JVM Unified Logging Framework:

 %p represents the process ID of the Java process. %t prints the timestamp for when the log was created. Maximum file size is 50 MB, and file rollover happens after 10 files:

-Xlog:gc*,gc+ref=debug,gc+heap=debug,gc+age=trace:file=gc-%p-%t.log:tags,uptime,time,level:filecount=10,filesize=50m

-Xlog:gc:file=gc.log:utctime,pid,level,tags:filecount=3,filesize=100M

-Xlog:gc*:file=gc.log:utctime,pid,level,tags:filecount=3,filesize=100M -XX:+UseParallelGC -XX:ParallelGCThreads=4
