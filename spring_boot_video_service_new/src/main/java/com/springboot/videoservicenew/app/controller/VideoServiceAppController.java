package com.springboot.videoservicenew.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/") //ovo je dodato
public class VideoServiceAppController {

	@GetMapping("/")
	//@GetMapping
	public String showHome(){
		
		return "home";
	}

	// add request mapping for /leaders
	@GetMapping("/leaders")
	public String showLeaders(){

		return "leaders";
	}

	// add request mapping for /systems
	@GetMapping("/systems")
	public String showSystems(){

		return "systems";
	}
}
