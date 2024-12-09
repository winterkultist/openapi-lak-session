package at.twinformatics.openapilaksession.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ShipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greetingShouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    void getShipShouldReturnAShip() throws Exception {
        this.mockMvc.perform(get("/ship/123"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("123")));
    }

    @Test
    void getShipWithInvalidIdShouldThrow400() throws Exception {
        this.mockMvc.perform(get("/ship/abc"))
                .andExpect(status().is4xxClientError());
    }
}
