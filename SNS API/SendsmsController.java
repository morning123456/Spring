package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.util.Sendsms;

@Controller
@RequestMapping("sens")
public class SendsmsController {


	@RequestMapping("form")
	public String form() {
		String url = "form";
		return url;
	}
	@RequestMapping("send")
	public String sends(String num) {
		Sendsms sendsms = new Sendsms();
		String url = "success";
		
		sendsms.sendSMS(num);
		
		return url;
		
	}
	
}
