package com.inclusion.calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inclusion.calculator.controller.CalculatorController;
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

}
