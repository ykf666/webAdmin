package com.test.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.model.ProgramExt;
import com.test.app.service.ProgramExtService;

@Controller("/")
public class IndexAction {
	
	@Autowired
	private ProgramExtService programExtService;
	
	@RequestMapping
	public String index(Model model){
		List<ProgramExt> list = programExtService.findProgramExt(0, 10);
		model.addAttribute("programList", list);
		return "index";
	}
}
