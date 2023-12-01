package com.inclusion.calculator.controller;

import com.inclusion.calculator.model.CalculatorRequest;
import com.inclusion.calculator.model.CalculatorResponse;
import com.inclusion.calculator.service.CalculatorService;
import com.inclusion.calculator.service.impl.CalculatorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/calculator")
@Slf4j
public class CalculatorController {
    @Autowired
    private CalculatorService alculatorService;

    private static final String LOG_ERROR_MESSAGE_GET = "Error al procesar... {} {} {}";
    private static final String LOG_ERROR_MESSAGE_POST = "Error al procesar... {}";

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.alculatorService = calculatorService;
    }

    /**
     * GET /api/vi/calculator/max-integer
     * Calcular el maximo entero segun las reglas indicadas en el test dados 3 enteros X,Y, y N
     *
     * @param x (required)
     * @param y (required)
     * @param n (required)
     * @return OK (status code 200)             CalculatorResponse
     * or El servidor rechazo la peticion por un error en el formato o contenido de la peticion por parte del cliente.  (status code 400)
     * or El servidor no pudo procesar la peticion por un problema interno. (status code 500)
     */
    @Operation(
        operationId = "maxIntegerGet",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculatorResponse.class))),
            @ApiResponse(responseCode = "400", description = "El servidor rechazo la peticion por un error en el formato o contenido de la peticion por parte del cliente. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculatorResponse.class))),
            @ApiResponse(responseCode = "500", description = "El servidor no pudo procesar la peticion por un problema interno.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculatorResponse.class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/max-integer",
        produces = {"application/json"}
    )
    public ResponseEntity<CalculatorResponse> maxInteger(@RequestParam int x, @RequestParam int y, @RequestParam int n) {
        CalculatorResponse resp = new CalculatorResponse();
        try {
            resp.setMaxInteger(alculatorService.calculate(x, y, n));
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            log.error(LOG_ERROR_MESSAGE_GET, x, y, n, e);
            resp.setMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(resp);
        }
    }

    /**
     * POST /api/vi/calculator/max-integer
     * Calcular el maximo entero segun las reglas indicadas en el test dados 3 enteros X,Y, y N
     *
     * @param request (required)
     * @return OK (status code 200)             CalculatorResponse
     * or El servidor rechazo la peticion por un error en el formato o contenido de la peticion por parte del cliente.  (status code 400)
     * or El servidor no pudo procesar la peticion por un problema interno. (status code 500)
     */
    @Operation(
        operationId = "maxIntegerPost",
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculatorResponse.class))),
            @ApiResponse(responseCode = "400", description = "El servidor rechazo la peticion por un error en el formato o contenido de la peticion por parte del cliente. ", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculatorResponse.class))),
            @ApiResponse(responseCode = "500", description = "El servidor no pudo procesar la peticion por un problema interno.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CalculatorResponse.class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/max-integer",
        produces = {"application/json"},
        consumes = {"application/json"}
    )
    @PostMapping("/max-integer")
    public ResponseEntity<CalculatorResponse> maxInteger(@RequestBody CalculatorRequest request) {
        CalculatorResponse resp = new CalculatorResponse();
        try {
            resp.setMaxInteger(alculatorService.calculate(request.getX(), request.getY(), request.getN()));
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            log.error(LOG_ERROR_MESSAGE_POST, request, e);
            resp.setMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(resp);
        }
    }
}
