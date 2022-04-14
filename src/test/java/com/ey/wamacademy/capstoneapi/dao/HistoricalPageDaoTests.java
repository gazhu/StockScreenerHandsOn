package com.ey.wamacademy.capstoneapi.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ey.wamacademy.capstoneapi.model.HistoricalPage;
import com.ey.wamacademy.capstoneapi.services.HistoricalPageService;

//Class for testing HistoricalPageDao class
@SpringBootTest
class HistoricalPageDaoTests {

	@Autowired
	private HistoricalPageService mockHistoricalService;

	// Mock object of LandingPageDao class
	@MockBean
	private HistoricalPageDao mockHistoricalDao;

	// Creating records for testing viewAll method of HistoricalPageDao class
	@SuppressWarnings("serial")
	List<HistoricalPage> records = new ArrayList<HistoricalPage>() {
		{

			add(new HistoricalPage(1, "28-March-2022", 123.0, 212.0, 1233.0, 4.0, 5, 128.0, 127.0, 348.0, -1.7));
		}
	};

	/**
	 * Method for testing that empty result is not returned by viewAll method
	 */
	@Test
	void viewAllTest() {
		when(mockHistoricalDao.historicalRecordByID(1)).thenReturn(records);
		assertThat(mockHistoricalService.getByStockId(1).size()).isGreaterThan(0);
	}
}