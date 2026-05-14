package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserSessionLeak {

    // Simulating application session cache
    private static final Map<String, UserSession> sessions =
            new HashMap<>();

    public static void main(String[] args) throws Exception {

        while (true) {

            String sessionId = UUID.randomUUID().toString();

            // New user session added
            sessions.put(sessionId,
                    new UserSession(sessionId));

            System.out.println(
                    "Active Sessions : " + sessions.size());

            Thread.sleep(100);
        }
    }
}

