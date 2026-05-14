package demo;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserSessionSolution {

    private static final Map<String, UserSession> sessions =
            new ConcurrentHashMap<>();

    private static final long SESSION_TIMEOUT =
            5000; // 5 seconds

    public static void main(String[] args) throws Exception {

        while (true) {

            String sessionId = UUID.randomUUID().toString();

            sessions.put(sessionId,
                    new UserSession(sessionId));

            removeExpiredSessions();

            System.out.println(
                    "Active Sessions : " + sessions.size());

            Thread.sleep(100);
        }
    }

    private static void removeExpiredSessions() {

        long currentTime = System.currentTimeMillis();

        Iterator<Map.Entry<String, UserSession>> iterator =
                sessions.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<String, UserSession> entry =
                    iterator.next();

            if (currentTime - entry.getValue().getLoginTime()
                    > SESSION_TIMEOUT) {

                iterator.remove();
            }
        }
    }
}

