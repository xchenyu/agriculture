package com.example.agriculture.controller;

import com.example.agriculture.common.ReturnCodeUtil;
import com.example.agriculture.entity.User;
import com.example.agriculture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restful/sale")
public class SaleController {

    @Autowired
    private UserService userService;
}
