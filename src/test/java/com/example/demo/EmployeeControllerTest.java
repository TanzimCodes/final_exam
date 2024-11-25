package com.example.demo;

import com.example.demo.controller.EmployeeController;
import com.example.demo.dto.request.EmployeeRequestDto;
import com.example.demo.dto.response.EmployeeResponseDto;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = EmployeeController.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeService employeeService;

    private EmployeeResponseDto employeeResponseDto;
    private EmployeeRequestDto employeeRequestDto;
    @BeforeEach
    public void init(){
        employeeResponseDto = new EmployeeResponseDto(
                1L,
                "@",
                "0",
                "1",
                LocalDate.now(),
                null
                );
    }

    @Test
    public void test_GetAll() throws Exception {

        Mockito.when(employeeService.getAllEmployees())
                .thenReturn(Arrays.asList(employeeResponseDto));

     mockMvc.perform(get("/api/v1/employees")).andExpect(status().isOk());
    }

}
