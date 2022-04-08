package com.ey.wamacademy.capstoneapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ey.wamacademy.capstoneapi.model.LandingPage;
import com.ey.wamacademy.capstoneapi.services.LandingPageService;

@SpringBootTest
class MainControllerTest {

	@Autowired
	private MainController con;

	@MockBean
	private LandingPageService landingPageService;

	@SuppressWarnings("serial")
	List<LandingPage> records = new ArrayList<LandingPage>() {
		{
			add(new LandingPage("30 March 2022", "/BAM", "Brookfield Asset Management Ord Shs Class A", "USD",
					"CA1125851040", "2092555", "BAM", 57.86, 57.61, 58.35, 57.38, 859012, 3.857941229, 5.435578331,
					31.64220584, 94368982323L, 1.294516689, 16023304.64, 2.3963, 23.87484459,
					"United States of America", "NYSE", "Financials", "Capital Markets", "Ordinary Shares"));
			add(new LandingPage("31 March 2022", "/CAN", "Brookfield Asset Management Ord Shs Class A", "USD",
					"CA1125851040", "2092666", "BAM", 57.86, 57.61, 58.35, 57.38, 859012, 3.857941229, 5.435578331,
					31.64220584, 94368982323L, 1.294516689, 16023304.64, 2.3963, 23.87484459,
					"United States of America", "NYSE", "Financials", "Capital Markets", "Ordinary Shares"));
		}
	};

	@Test
	void viewAllTest() {

		when(landingPageService.fetchAllData()).thenReturn(records);
		assertEquals(2, con.viewAll().size());

	}

}
