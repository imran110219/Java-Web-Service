package com.saddman.springservicedemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sadman
 */
@RestController
public class ItemController {

    @GetMapping("/item")
    public String getItem(){
        return "Item selected";
    }
}
