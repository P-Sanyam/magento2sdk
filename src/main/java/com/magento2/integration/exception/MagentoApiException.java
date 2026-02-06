package com.magento2.integration.exception;

import org.springframework.http.HttpStatusCode;

public class MagentoApiException extends RuntimeException {
    private final HttpStatusCode status;
    private final String responseBody;

    public MagentoApiException(HttpStatusCode status, String responseBody) {
        super("Magento API error: " + status + " body=" + responseBody);
        this.status = status;
        this.responseBody = responseBody;
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
