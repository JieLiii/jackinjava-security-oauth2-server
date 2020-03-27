package com.jackinjava.security.oauth2.server.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author lijie
 * @date 2020/3/11 14:51
 */
@JsonSerialize(using = PlatformOAuthExceptionJacksonSerializer.class)
public class PlatformOAuth2Exception extends OAuth2Exception {
    public PlatformOAuth2Exception(String msg, Throwable t) {
        super(msg, t);
    }

    public PlatformOAuth2Exception(String msg) {
        super(msg);
    }
}
