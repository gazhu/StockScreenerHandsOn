package com.ey.wamacademy.capstoneapi.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.ey.wamacademy.capstoneapi.model.LandingPage;
import com.ey.wamacademy.capstoneapi.services.LandingPageService;

// Class for testing LandingPageDao class

@SpringBootTest
class LandingPageDaoTests {

	// Creating records for testing viewAll method of LandingPageDao class
	@SuppressWarnings("serial")
	List<LandingPage> records = new ArrayList<LandingPage>() {
		{
			add(new LandingPage(1, "30 March 2022", "/BAM", "Brookfield Asset Management Ord Shs Class A", "USD",
					"CA1125851040", "2092555", "BAM", 57.86, 57.61, 58.35, 57.38, 859012, 3.857941229, 5.435578331,
					31.64220584, 94368982323L, 1.294516689, 16023304.64, 2.3963, 23.87484459,
					"United States of America", "NYSE", "Financials", "Capital Markets", "Ordinary Shares", 1.2));
			add(new LandingPage(2, "31 March 2022", "/CAN", "Brookfield Asset Management Ord Shs Class A", "USD",
					"CA1125851040", "2092666", "BAM", 57.86, 57.61, 58.35, 57.38, 859012, 3.857941229, 5.435578331,
					31.64220584, 94368982323L, 1.294516689, 16023304.64, 2.3963, 23.87484459,
					"United States of America", "NYSE", "Financials", "Capital Markets", "Ordinary Shares", 1.2));
		}
	};

	// Creating lists for testing getUniqueCountryNames ,getUniqueExchangeNames,
	// getUniqueInstrumentNames
	@SuppressWarnings("serial")
	List<String> uniqueExchanges = new ArrayList<String>() {
		{
			add("NYSE");
			add("TSX");
			add("NASDAQ");
			add("SSE");
		}
	};

	@SuppressWarnings("serial")
	List<String> uniqueCountries = new ArrayList<String>() {
		{
			add("United States of America");
			add("Belgium");
			add("Australia");
			add("Canada");
		}
	};

	@SuppressWarnings("serial")
	List<String> uniqueIdustries = new ArrayList<String>() {
		{
			add("Brookfield Asset Management Ord Shs Class A");
			add("CME Group Ord Shs Class A");
			add("UBS Group Ord Shs");
			add("Moody's Ord Shs");
		}
	};

	@Autowired
	private LandingPageService landingPageService;

	// Mock object of LandingPageDao class
	@MockBean
	private LandingPageDao landingPageDao;

	/**
	 * Method for testing that empty result is not returned by viewAll method
	 */
	@Test
	void viewAllTest() {
		when(landingPageDao.viewAll()).thenReturn(records);
		assertThat(landingPageService.fetchAllData().size()).isGreaterThan(0);
	}


	/**
	 * Method for verifying right record is returned when searching by ISIN using
	 * searchByID method
	 */
	@Test
	void searchByIdTest() {
		LandingPage actualValue = new LandingPage(1, "30 March 2022", "/BAM",
				"Brookfield Asset Management Ord Shs Class A", "USD", "CA1125851040", "2092555", "BAM", 57.86, 57.61,
				58.35, 57.38, 859012, 3.857941229, 5.435578331, 31.64220584, 94368982323L, 1.294516689, 16023304.64,
				2.3963, 23.87484459, "United States of America", "NYSE", "Financials", "Capital Markets",
				"Ordinary Shares", 1.2);
		when(landingPageDao.searchById(1)).thenReturn(actualValue);
		LandingPage expectedValue = landingPageDao.searchById(1);
		assertThat(actualValue).usingRecursiveComparison().isEqualTo(expectedValue);
	}

	/**
	 * Method for verifying number of records fetched when viewAll method is called
	 */
	@Test
	void viewAllTestCount() {

		when(landingPageDao.viewAll()).thenReturn(records);
		assertEquals(2, landingPageService.fetchAllData().size());
	}

	/**
	 * Method for verifying unique country values returned by
	 * getUniqueCountryNames() method
	 */
	@Test
	void getUniqueCountryNamesTest() {
		when(landingPageDao.getUniqueCountryNames()).thenReturn(uniqueCountries);
		List<String> actual = landingPageService.uniqueCountries();
		List<String> expected = Arrays.asList("United States of America", "Belgium", "Australia", "Canada");
		assertTrue(actual.size() == expected.size() && actual.containsAll(expected) && expected.containsAll(actual));
	}

	/**
	 * Method for verifying unique exchange values returned by
	 * getUniqueExchangeNames() method
	 */
	@Test
	void getUniqueExchangeNamesTest() {
		when(landingPageDao.getUniqueExchangeNames()).thenReturn(uniqueExchanges);
		List<String> actual = landingPageService.uniqueExchanges();
		List<String> expected = Arrays.asList("NYSE", "TSX", "NASDAQ", "SSE");
		assertTrue(actual.size() == expected.size() && actual.containsAll(expected) && expected.containsAll(actual));
	}

	/**
	 * Method for verifying unique industry values returned by
	 * getUniqueIndustryNames() method
	 */
	@Test
	void getUniqueIndustryNamesTest() {
		when(landingPageDao.getUniqueInstrumentNames()).thenReturn(uniqueIdustries);
		List<String> actual = landingPageService.uniqueInstruments();
		List<String> expected = Arrays.asList("Brookfield Asset Management Ord Shs Class A",
				"CME Group Ord Shs Class A", "UBS Group Ord Shs", "Moody's Ord Shs");
		assertTrue(actual.size() == expected.size() && actual.containsAll(expected) && expected.containsAll(actual));
	}
	
	/**
	 * Method for verifying the number of records returned by filter search 
	 */
	@Test
	void findByParamteresTest() throws SQLException {
		when(landingPageDao.filterByParameters("null", "null", "NYSE")).thenReturn(records);
		assertEquals(2, landingPageService.searchByParameters("null", "null", "NYSE").size());
	}

}
