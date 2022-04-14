
package com.ey.wamacademy.capstoneapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.ey.wamacademy.capstoneapi.model.LandingPage;
import com.ey.wamacademy.capstoneapi.services.Services;

@WebMvcTest(value = MainController.class)
class MainControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MainController mainController;

	@MockBean
	private Services mockServices;

	// Creating records for testing viewAll method of LandingPageService class
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

	@Test
	void testViewAll() throws Exception {
		List<LandingPage> mockLandingList = new ArrayList<LandingPage>();
		LandingPage land = new LandingPage();
		land.setClosePrice(4d);
		mockLandingList.add(land);
		Mockito.when(mockServices.fetchAllData()).thenReturn(mockLandingList);
		MvcResult mvcResult = this.mockMvc.perform(get("/viewall").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		assertTrue(mvcResult.getResponse().getContentAsString().contains("4.0"));
	}

	/**
	 * Testing viewAll by verifying the number of records fetched
	 */
	@Test
	void viewAllTest() {

		when(mockServices.fetchAllData()).thenReturn(records);
		assertEquals(2, mainController.viewAll().size());

	}
}
