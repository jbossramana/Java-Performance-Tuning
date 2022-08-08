1. Select ConsumerHeap.java -> Run As -> Run configuration -> set vm args 

-XX:+HeapDumpOnOutOfMemoryError -Xms32m -Xmx32m

Error will be thrown :

java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid6664.hprof ...
Heap dump file created [1262470435 bytes in 5.784 secs]

Solution :

Analyse the error with "ECLIPSE MEMORY ANALYZER"

