package com.example.escontrollerdocumentazioneswagger.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class NameController {

    @Operation(summary = "Shows the name", description = "When given the param name it gives the name back")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Name given correctly"),
            @ApiResponse(responseCode = "400", description = "The given name is incorrect")
    })
    @GetMapping("/Name")
    public String getName(@Parameter(name = "name", description = "The name given back") @RequestParam(name = "name") String name) {
        return name;
    }

    @Operation(summary = "Shows the name backwards", description = "When given the param name it gives the name back but written backwards")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Name given correctly"),
            @ApiResponse(responseCode = "400", description = "The given name is incorrect")
    })
    @PostMapping("/emaN")
    public String postName(@Parameter(name = "name", description = "The name getting reverted") @RequestParam(name = "name") String name) {
        StringBuilder nameString = new StringBuilder(name);
        return nameString.reverse().toString();
    }
}
