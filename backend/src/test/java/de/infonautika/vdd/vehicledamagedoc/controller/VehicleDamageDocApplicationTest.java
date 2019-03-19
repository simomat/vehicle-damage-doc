package de.infonautika.vdd.vehicledamagedoc.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static de.infonautika.vdd.vehicledamagedoc.controller.MockMvcTools.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringJUnitWebConfig
public class VehicleDamageDocApplicationTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = forController(VehicleController.class);
    }

    @Test
    public void postDoku() throws Exception {

        String doku = object()
                .appendField("erstzulassung", "1981-08-18")
                .appendField("typvarianteversion", object()
                        .appendField("typ", "7yp")
                        .appendField("variante", "v4r1an73")
                        .appendField("version", "v3r510n"))
                .toJSONString();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/doku")
                .content(doku)
                .contentType(APPLICATION_JSON_CHARSET_UTF_8)
                .accept(APPLICATION_JSON_CHARSET_UTF_8))
                .andExpect(status().isOk());
    }


}
