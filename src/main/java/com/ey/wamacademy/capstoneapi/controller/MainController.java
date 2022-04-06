package com.ey.wamacademy.capstoneapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.wamacademy.capstoneapi.model.LandingPage;
import com.ey.wamacademy.capstoneapi.services.LandingPageService;



@RestController
public class MainController {

	@Autowired
	private LandingPageService service;
	
	@GetMapping("viewall")
	public List<LandingPage> viewAll() {
		return service.fetchAllData();
	}
	
}
