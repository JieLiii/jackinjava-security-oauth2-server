package com.jackinjava.security.oauth2.server.service;

import com.jackinjava.security.oauth2.server.exception.PlatformOAuth2Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * 网页响应异常转换器
 *
 * @author lijie
 * @date 2020/3/11 14:11
 */
@Component
public class PlatformOAuth2WebResponseExceptionTranslator implements WebResponseExceptionTranslator<OAuth2Exception> {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
        return ResponseEntity
                .status(oAuth2Exception.getHttpErrorCode())
                .body(new PlatformOAuth2Exception(oAuth2Exception.getMessage()));
    }
}
