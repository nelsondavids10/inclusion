package com.inclusion.calculator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inclusion.calculator.controller.CalculatorController;
import com.inclusion.calculator.model.CalculatorRequest;
import com.inclusion.calculator.model.CalculatorResponse;
import com.inclusion.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
class CalculatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CalculatorService calculatorService;
    @Autowired
    private ObjectMapper objectMapper;

	@Test
	void testCalculate() throws Exception {
		when(calculatorService.calculate(anyInt(), anyInt(), anyInt())).thenReturn(12339);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/vi/calculator/max-integer")
						.param("x", "7")
						.param("y", "5")
						.param("n", "12345"))
				.andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(new CalculatorResponse(12339))));

    }

    @Test
    void testMaxIntegerPost() throws Exception, JsonProcessingException {
        // Mocking the service response
        when(calculatorService.calculate(anyInt(), anyInt(), anyInt())).thenReturn(12339);

        // Creating a sample request
        CalculatorRequest request = new CalculatorRequest();
        request.setX(7);
        request.setY(5);
        request.setN(12345);

        // Performing the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/api/vi/calculator/max-integer")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(content().json(objectMapper.writeValueAsString(new CalculatorResponse(12339))));
    }

}
