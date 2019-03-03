package de.infonautika.vdd.vehicledamagedoc.controller;

import net.minidev.json.JSONObject;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class MockMvcTools {

    public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";

    public static MockMvc forController(Class<?> controller) {
        return MockMvcBuilders
                .standaloneSetup(controller)
                .alwaysDo(debugOnException())
                .build();
    }

    public static ResultHandler debugOnException() {
        ResultHandler printResultHandler = MockMvcResultHandlers.print();
        return result -> {
            if (result.getResolvedException() != null) {
                printResultHandler.handle(result);
            }
        };
    }

    public static JSONObject object() {
        return new JSONObject();
    }
}
