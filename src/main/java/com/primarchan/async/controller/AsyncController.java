package com.primarchan.async.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AsyncController {

    @GetMapping("/1")
    public String asyncCall_1() {

        return "success";
    }

    @GetMapping("/2")
    public String asyncCall_2() {

        return "success";
    }

    @GetMapping("/3")
    public String asyncCall_3() {

        return "success";
    }

}
