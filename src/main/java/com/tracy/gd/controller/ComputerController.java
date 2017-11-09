package com.tracy.gd.controller;

import com.tracy.gd.domain.Admin;
import com.tracy.gd.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tracy on 2017/11/9.
 */
@Controller
@RequestMapping("/Computer")
public class ComputerController {

    @Autowired
    IComputerService computerService;

    @RequestMapping(value = "/testcpt")
    public void print() {

    }

}
