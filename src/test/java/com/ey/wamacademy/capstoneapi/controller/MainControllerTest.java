package com.ey.wamacademy.capstoneapi.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ey.wamacademy.capstoneapi.model.LandingPage;

@SpringBootTest
class MainControllerTest {

	@Autowired
	private MainController con;

	@Test
	void viewAllTest() {

		List<LandingPage> list = con.viewAll();
		assertEquals(49, list.size());
	
	}
	
	
}
