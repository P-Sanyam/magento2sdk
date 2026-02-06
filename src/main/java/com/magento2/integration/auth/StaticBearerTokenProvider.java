package com.magento2.integration.auth;

public class StaticBearerTokenProvider implements BearerTokenProvider {
    private final String token;

    public StaticBearerTokenProvider(String token) {
        this.token = token;
    }

    @Override
    public String getToken() {
        return token;
    }
}
