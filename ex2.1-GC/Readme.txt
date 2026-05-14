-Xms500m -Xmx500m -XX:+UseParallelGC -XX:ParallelGCThreads=4 -Xlog:gc*:file=gc_parallel.log:time,uptime,level,tags

-Xms500m -Xmx500m -XX:+UseG1GC -XX:ParallelGCThreads=2 -Xlog:gc*:file=gc_g1gc.log:time,uptime,level,tags

-Xms500m -Xmx500m -XX:+UseZGC -XX:ParallelGCThreads=2 -Xlog:gc*:file=gc_zgc.log:time,uptime,level,tags


