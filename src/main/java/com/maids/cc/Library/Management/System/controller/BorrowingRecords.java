package com.maids.cc.Library.Management.System.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BorrowingRecords {

    @GetMapping("/")
    public String test() {
        return "test book controller";
    }
}
