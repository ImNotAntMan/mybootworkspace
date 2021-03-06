package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, 
		defaultValue="안녕하세요") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/hello")
	public String hello(Model model, @RequestParam(name="hello", required=false,
		defaultValue="잘되냐구?") String hello) {
		model.addAttribute("hello", hello);
		return "hello";
	}
}
