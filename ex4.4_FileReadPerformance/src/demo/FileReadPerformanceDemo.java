package demo;

import java.io.*;
import java.nio.file.*;
import java.util.Random;

public class FileReadPerformanceDemo {

    private static final String FILE_NAME = "large-file.txt";
    private static final int FILE_SIZE_MB = 5;

    public static void main(String[] args) throws Exception {

        createLargeFileIfNotExists();

        System.out.println("\n========================================");
        System.out.println("FILE READ PERFORMANCE TEST");
        System.out.println("========================================");

        testUnbufferedRead();
        testBufferedRead8KB();
        testBufferedRead64KB();
        testFilesReadAllBytes();

        System.out.println("\n========================================");
        System.out.println("TEST COMPLETED");
        System.out.println("========================================");
    }

    // ------------------------------------------------------------
    // CREATE LARGE FILE
    // ------------------------------------------------------------
    private static void createLargeFileIfNotExists() throws Exception {

        File file = new File(FILE_NAME);

        if (file.exists()) {
            System.out.println("File already exists: " + FILE_NAME);
            return;
        }

        System.out.println("Creating test file (" + FILE_SIZE_MB + " MB)...");

        Random random = new Random();

        try (BufferedOutputStream bos =
                     new BufferedOutputStream(
                             new FileOutputStream(file))) {

            byte[] buffer = new byte[1024 * 1024]; // 1 MB

            for (int i = 0; i < FILE_SIZE_MB; i++) {

                random.nextBytes(buffer);

                bos.write(buffer);

                System.out.println("Written: " + (i + 1) + " MB");
            }
        }

        System.out.println("File creation completed.\n");
    }

    // ------------------------------------------------------------
    // UNBUFFERED READ
    // ------------------------------------------------------------
    private static void testUnbufferedRead() throws Exception {

        System.out.println("\n1. UNBUFFERED FILE INPUT STREAM");
        System.out.println("--------------------------------");

        Runtime runtime = Runtime.getRuntime();

        long memoryBefore = usedMemory(runtime);

        long start = System.nanoTime();

        long totalBytes = 0;

        try (FileInputStream fis =
                     new FileInputStream(FILE_NAME)) {

            int data;

            while ((data = fis.read()) != -1) {
                totalBytes++;
            }
        }

        long end = System.nanoTime();

        long memoryAfter = usedMemory(runtime);

        printStats(totalBytes,
                start,
                end,
                memoryBefore,
                memoryAfter);
    }

    // ------------------------------------------------------------
    // BUFFERED READ 8 KB
    // ------------------------------------------------------------
    private static void testBufferedRead8KB() throws Exception {

        System.out.println("\n2. BUFFERED READ (8 KB)");
        System.out.println("--------------------------------");

        Runtime runtime = Runtime.getRuntime();

        long memoryBefore = usedMemory(runtime);

        long start = System.nanoTime();

        long totalBytes = 0;

        try (BufferedInputStream bis =
                     new BufferedInputStream(
                             new FileInputStream(FILE_NAME),
                             8 * 1024)) {

            byte[] buffer = new byte[8 * 1024];

            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                totalBytes += bytesRead;
            }
        }

        long end = System.nanoTime();

        long memoryAfter = usedMemory(runtime);

        printStats(totalBytes,
                start,
                end,
                memoryBefore,
                memoryAfter);
    }

    // ------------------------------------------------------------
    // BUFFERED READ 64 KB
    // ------------------------------------------------------------
    private static void testBufferedRead64KB() throws Exception {

        System.out.println("\n3. BUFFERED READ (64 KB)");
        System.out.println("--------------------------------");

        Runtime runtime = Runtime.getRuntime();

        long memoryBefore = usedMemory(runtime);

        long start = System.nanoTime();

        long totalBytes = 0;

        try (BufferedInputStream bis =
                     new BufferedInputStream(
                             new FileInputStream(FILE_NAME),
                             64 * 1024)) {

            byte[] buffer = new byte[64 * 1024];

            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                totalBytes += bytesRead;
            }
        }

        long end = System.nanoTime();

        long memoryAfter = usedMemory(runtime);

        printStats(totalBytes,
                start,
                end,
                memoryBefore,
                memoryAfter);
    }

    // ------------------------------------------------------------
    // READ ALL BYTES
    // ------------------------------------------------------------
    private static void testFilesReadAllBytes() throws Exception {

        System.out.println("\n4. FILES.READALLBYTES()");
        System.out.println("--------------------------------");

        Runtime runtime = Runtime.getRuntime();

        System.gc();
        Thread.sleep(1000);

        long memoryBefore = usedMemory(runtime);

        long start = System.nanoTime();

        byte[] data = Files.readAllBytes(Paths.get(FILE_NAME));

        long totalBytes = data.length;

        long end = System.nanoTime();

        long memoryAfter = usedMemory(runtime);

        printStats(totalBytes,
                start,
                end,
                memoryBefore,
                memoryAfter);
    }

    // ------------------------------------------------------------
    // MEMORY
    // ------------------------------------------------------------
    private static long usedMemory(Runtime runtime) {
        return runtime.totalMemory() - runtime.freeMemory();
    }

    // ------------------------------------------------------------
    // PRINT STATS
    // ------------------------------------------------------------
    private static void printStats(long totalBytes,
                                   long start,
                                   long end,
                                   long memoryBefore,
                                   long memoryAfter) {

        double timeMs = (end - start) / 1_000_000.0;

        double throughput =
                (totalBytes / 1024.0 / 1024.0) /
                        (timeMs / 1000.0);

        System.out.println("Total Bytes Read : "
                + totalBytes);

        System.out.println("Time Taken       : "
                + String.format("%.2f ms", timeMs));

        System.out.println("Throughput       : "
                + String.format("%.2f MB/sec", throughput));

        System.out.println("Memory Before    : "
                + formatMemory(memoryBefore));

        System.out.println("Memory After     : "
                + formatMemory(memoryAfter));

        System.out.println("Memory Used      : "
                + formatMemory(memoryAfter - memoryBefore));
    }

    // ------------------------------------------------------------
    // FORMAT MEMORY
    // ------------------------------------------------------------
    private static String formatMemory(long bytes) {

        double mb = bytes / 1024.0 / 1024.0;

        return String.format("%.2f MB", mb);
    }
}
