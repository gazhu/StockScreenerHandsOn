package com.ey.wamacademy.capstoneapi.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ey.wamacademy.capstoneapi.model.LandingPage;

@SpringBootTest
class LandingPageDaoTests {

	@Autowired
	private LandingPageDao landingPageDao;

	@org.junit.jupiter.api.Test
	void viewAllTest() {

		List<LandingPage> list = landingPageDao.viewAll();
		assertEquals(49, list.size());
	}

}
