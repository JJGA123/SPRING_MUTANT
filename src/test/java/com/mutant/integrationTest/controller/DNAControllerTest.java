package com.mutant.integrationTest.controller;

import com.mutant.MutantApplication;
import com.mutant.common.util.Util;
import com.mutant.util.Data;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = MutantApplication.class)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DNAControllerTest {

    @Autowired
    private WebApplicationContext WebApplicationContext;

    @Autowired
    private MockMvc MockMvc;

    @BeforeAll
    public void setUp() {
        this.MockMvc = MockMvcBuilders.webAppContextSetup(WebApplicationContext).build();
    }

    /**
     * This method testing end point mutant
     * Validate that response is not null.
     */
    @Test
    public void mutantTest() throws Exception {
        MockMvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON).content(Util.toJSon(Data.REQUEST_DTO_EXIST)))
                .andExpect(status().isOk());
    }

    /**
     * This method testing end point stats
     * Validate that response is not null.
     */
    @Test
    public void statsTest() throws Exception {
        MockMvc.perform(get("/stats"))
                .andExpect(status().isOk());
    }

}
