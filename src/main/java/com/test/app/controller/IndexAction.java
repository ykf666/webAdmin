package com.test.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class IndexAction {
	
	@RequestMapping
	public String index(){
		return "index";
	}
}
