package com.inclusion.calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inclusion.calculator.controller.CalculatorController;
import com.inclusion.calculator.model.CalculatorResponse;
import com.inclusion.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
class CalculatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CalculatorService calculatorService;

	@Test
	void testCalculate() throws Exception {
		when(calculatorService.calculate(anyInt(), anyInt(), anyInt())).thenReturn(42);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/calculator/max-integer")
						.param("x", "7")
						.param("y", "5")
						.param("n", "12345"))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content().json(new ObjectMapper().writeValueAsString(new CalculatorResponse(12339))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/calculator/max-integer")
                .param("x", "5")
                .param("y", "0")
                .param("n", "4"))
            .andExpect(status().isOk())
            .andExpect((ResultMatcher) content().json(new ObjectMapper().writeValueAsString(new CalculatorResponse(0))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/calculator/max-integer")
                .param("x", "10")
                .param("y", "5")
                .param("n", "15"))
            .andExpect(status().isOk())
            .andExpect((ResultMatcher) content().json(new ObjectMapper().writeValueAsString(new CalculatorResponse(15))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/calculator/max-integer")
                .param("x", "17")
                .param("y", "8")
                .param("n", "54321"))
            .andExpect(status().isOk())
            .andExpect((ResultMatcher) content().json(new ObjectMapper().writeValueAsString(new CalculatorResponse(54306))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/calculator/max-integer")
                .param("x", "499999993")
                .param("y", "9")
                .param("n", "1000000000"))
            .andExpect(status().isOk())
            .andExpect((ResultMatcher) content().json(new ObjectMapper().writeValueAsString(new CalculatorResponse(999999995))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/calculator/max-integer")
                .param("x", "10")
                .param("y", "5")
                .param("n", "187"))
            .andExpect(status().isOk())
            .andExpect((ResultMatcher) content().json(new ObjectMapper().writeValueAsString(new CalculatorResponse(185))));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/calculator/max-integer")
                .param("x", "2")
                .param("y", "0")
                .param("n", "999999999"))
            .andExpect(status().isOk())
            .andExpect((ResultMatcher) content().json(new ObjectMapper().writeValueAsString(new CalculatorResponse(999999998))));
	}

}
