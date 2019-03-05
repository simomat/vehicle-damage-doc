package de.infonautika.vdd.vehicledamagedoc.security;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_ENCRYPTION_SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
}
