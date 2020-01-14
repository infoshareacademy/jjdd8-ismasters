package com.isa.parser;

import com.isa.domain.api.EventApi;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ApiDataParserTest {
    public static final String FILENAME = "/home/robert/Pulpit/Projekt/newWebApp/jjdd8-ismasters/web/src/main/java/com/isa/mock/Json_example.json";

    @Test
    public void shouldParse() throws IOException {
        ApiDataParser apiDataParser = new ApiDataParser();
       List<EventApi> eventApis = (List<EventApi>) apiDataParser.parse(FILENAME, EventApi.class);
        System.out.println(eventApis);
    }
}
