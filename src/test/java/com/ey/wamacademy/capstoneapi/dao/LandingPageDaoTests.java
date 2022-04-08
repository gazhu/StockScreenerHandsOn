package com.ey.wamacademy.capstoneapi.dao;

import static org.assertj.core.api.Assertions.assertThat;
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
class LandingPageDaoTests {

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

	@Autowired
	private LandingPageService landingPageService;

	@MockBean
	private LandingPageDao landingPageDao;

	@Test
	void viewAllTest() {
		when(landingPageDao.viewAll()).thenReturn(records);
		assertThat(landingPageService.fetchAllData().size()).isGreaterThan(0);
	}

	@Test
	void columnCountTest() {
		when(landingPageDao.getColumnCount()).thenReturn(25);
		assertEquals(25, landingPageDao.getColumnCount());
	}

	@Test
	void searchByIdTest() {
		LandingPage actualValue = new LandingPage("30 March 2022", "/BAM",
				"Brookfield Asset Management Ord Shs Class A", "USD", "CA1125851040", "2092555", "BAM", 57.86, 57.61,
				58.35, 57.38, 859012, 3.857941229, 5.435578331, 31.64220584, 94368982323L, 1.294516689, 16023304.64,
				2.3963, 23.87484459, "United States of America", "NYSE", "Financials", "Capital Markets",
				"Ordinary Shares");
		when(landingPageDao.searchById("CA1125851040")).thenReturn(actualValue);
		LandingPage expectedValue = landingPageDao.searchById("CA1125851040");
		assertThat(actualValue).usingRecursiveComparison().isEqualTo(expectedValue);
	}

	@Test
	void viewAllTestCount() {

		when(landingPageDao.viewAll()).thenReturn(records);
		assertEquals(2,landingPageService.fetchAllData().size());
	}

}
