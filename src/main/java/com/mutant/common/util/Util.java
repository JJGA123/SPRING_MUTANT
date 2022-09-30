package com.mutant.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class Util {

    private static final ObjectMapper JACKSON_MAPPER = new ObjectMapper();

    /**
     * This method return the json string of an object
     * @param object Object with information
     * @return String Json string
     */
    public static String toJSon(Object object) throws JsonProcessingException {
        return JACKSON_MAPPER.writeValueAsString(object);
    }
}