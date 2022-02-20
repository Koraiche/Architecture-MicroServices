package org.sid.secservice.sec;

public class JWTUtile {
    public static final String SECRET = "mySecret1234";
    public static final String AUTH_HEADER = "Authorization";
    public static final String PREFIXE = "Bearer ";
    public static final long EXPIRE_ACCESS_TOKEN = 120000;//2minutes = 2 * 60 * 1000
    public static final long EXPIRE_REFRESH_TOKEN = 600000;//2minutes = 10 * 60 * 1000
}
