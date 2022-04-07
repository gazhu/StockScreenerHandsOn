package com.ey.wamacademy.capstoneapi.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ey.wamacademy.capstoneapi.model.LandingPage;

@SpringBootTest
class LandingPageDaoTests {

	@Autowired
	private LandingPageDao landingPageDao;
	
	@Test
	void viewAllTest() {
		List<LandingPage> list = landingPageDao.viewAll();
		assertThat(list.size()).isGreaterThan(0);
	}
	
	@Test
	void searchByIdTest() {
		LandingPage actualValue = new LandingPage("30 March 2022", "/BAM",
				"Brookfield Asset Management Ord Shs Class A", "USD", "CA1125851040", "2092555", "BAM", 57.86, 57.61,
				58.35, 57.38, 859012, 3.857941229, 5.435578331, 31.64220584, 94368982323L, 1.294516689, 16023304.64,
				2.3963, 23.87484459, "United States of America", "NYSE", "Financials", "Capital Markets",
				"Ordinary Shares");
		LandingPage expectedValue = landingPageDao.searchById("CA1125851040");
		assertThat(actualValue).usingRecursiveComparison().isEqualTo(expectedValue);
	}



	@Test
	void viewAllTestCount() {

		List<LandingPage> list = landingPageDao.viewAll();
		assertEquals(49, list.size());
	}
	@Test
	void columnCountTest() {
		assertEquals(25,landingPageDao.getColumnCount());
	}

}
