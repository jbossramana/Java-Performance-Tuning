package demo;

class UserSession {

    private final String sessionId;

    private final long loginTime =
            System.currentTimeMillis();

    private final byte[] userData =
            new byte[1024 * 512];

    public UserSession(String sessionId) {
        this.sessionId = sessionId;
    }

    public long getLoginTime() {
        return loginTime;
    }
}