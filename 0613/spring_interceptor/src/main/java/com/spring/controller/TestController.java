package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	
	@RequestMapping(value="/target")
	public String test(@RequestParam(defaultValue="0")int num, Model model)throws Exception{
		String url = "test/main";
		
		if(num==0) {
			throw new Exception("from TestController");
		}
		
		model.addAttribute("message","To the victory!");
		
		return url;
	}
}
