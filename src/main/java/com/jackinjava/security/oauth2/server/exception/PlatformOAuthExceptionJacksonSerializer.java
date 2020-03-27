package com.jackinjava.security.oauth2.server.exception;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.jackinjava.security.oauth2.server.model.CodeMessage;

import java.io.IOException;
import java.util.Map;

/**
 * 自定义异常json序列化
 * @author lijie
 * @date 2020/3/11 15:00
 */
public class PlatformOAuthExceptionJacksonSerializer extends StdSerializer<PlatformOAuth2Exception> {
    public PlatformOAuthExceptionJacksonSerializer() {
        super(PlatformOAuth2Exception.class);
    }

    @Override
    public void serialize(PlatformOAuth2Exception value, JsonGenerator jgen, SerializerProvider serializerProvider) throws
            IOException {
        jgen.writeStartObject();
        jgen.writeObjectField("code", CodeMessage.LOGIN_FAILURE_CODE);
        jgen.writeStringField("msg", value.getMessage());
        if (value.getAdditionalInformation()!=null) {
            for (Map.Entry<String, String> entry : value.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                jgen.writeStringField(key, add);
            }
        }
        jgen.writeEndObject();
    }
}
