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
	void testSumaYMultiplica() throws Exception {
		when(calculatorService.realizarOperacion(anyInt(), anyInt(), anyInt())).thenReturn(42);

		mockMvc.perform(MockMvcRequestBuilders.get("/calculadora/sumar-y-multiplicar")
						.param("x", "2")
						.param("y", "3")
						.param("n", "7"))
				.andExpect(status().isOk())
				.andExpect(content().json(new ObjectMapper().writeValueAsString(new CalculatorResponse(42))));
	}

}
