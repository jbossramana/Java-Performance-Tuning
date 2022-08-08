package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OutOfMemoryGCLimitExceed {
	
    public static void main(String[] arg) {
        Map<Integer, String> dataMap = new HashMap<>();
        Random r = new Random();
        while (true) {
            dataMap.put(r.nextInt(), String.valueOf(r.nextInt()));
        }
    }
}