package com.candidate.verification.controller;

import com.candidate.verification.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get-all-users")
    @Operation(summary = "Get all users", description = "Retrieve a list of users")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    public List<Map<String, Object>> getAllUsers() {
        return userService.aggregateUserData();
    }

}

