package com.ey.wamacademy.capstoneapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ey.wamacademy.capstoneapi.dao.LandingPageDao;
import com.ey.wamacademy.capstoneapi.model.LandingPage;



@RestController
public class MainController {

	@Autowired
	private LandingPageDao dao;
	
	@GetMapping("viewall")
	public List<LandingPage> viewAll() {
		return dao.viewAll();
	}
	
}
