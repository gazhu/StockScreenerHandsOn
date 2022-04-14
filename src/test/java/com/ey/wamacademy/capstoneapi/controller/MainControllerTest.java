package com.ey.wamacademy.capstoneapi.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
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

import com.ey.wamacademy.capstoneapi.model.HistoricalPage;
import com.ey.wamacademy.capstoneapi.model.LandingPage;
import com.ey.wamacademy.capstoneapi.services.HistoricalPageService;
import com.ey.wamacademy.capstoneapi.services.LandingPageService;

@WebMvcTest(value = MainController.class)
class MainControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LandingPageService mockLandingservice;

	@MockBean
	private HistoricalPageService mockHistoricalService;

	/**
	 * Test for viewAll function in MainController
	 * 
	 * @throws Exception
	 */
	@Test
	void testViewAll() throws Exception {
		List<LandingPage> mockLandingList = new ArrayList<LandingPage>();
		LandingPage land = new LandingPage();
		land.setClosePrice(4d);
		mockLandingList.add(land);
		Mockito.when(mockLandingservice.fetchAllData()).thenReturn(mockLandingList);
		MvcResult mvcResult = this.mockMvc.perform(get("/viewall").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		assertTrue(mvcResult.getResponse().getContentAsString().contains("4.0"));
	}

	/**
	 * Test for GetUniqueExchanges function in MainController
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetUniqueExchanges() throws Exception {
		List<String> mockLandingList = new ArrayList<String>();
		mockLandingList.add("test_exchange");
		Mockito.when(mockLandingservice.uniqueExchanges()).thenReturn(mockLandingList);
		MvcResult mvcResult = this.mockMvc.perform(get("/uniqueexchanges").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		assertTrue(mvcResult.getResponse().getContentAsString().contains("test_exchange"));
	}

	/**
	 * Test for GetUniqueInstruments function in MainController
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetUniqueInstruments() throws Exception {
		List<String> mockLandingList = new ArrayList<String>();
		mockLandingList.add("test_instrument");
		Mockito.when(mockLandingservice.uniqueInstruments()).thenReturn(mockLandingList);
		MvcResult mvcResult = this.mockMvc.perform(get("/uniqueinstruments").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		assertTrue(mvcResult.getResponse().getContentAsString().contains("test_instrument"));
	}

	/**
	 * Test for GetUniqueCountries function in MainController
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetUniqueCountries() throws Exception {
		List<String> mockLandingList = new ArrayList<String>();
		mockLandingList.add("test_country");
		Mockito.when(mockLandingservice.uniqueCountries()).thenReturn(mockLandingList);
		MvcResult mvcResult = this.mockMvc.perform(get("/uniquecountries").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		assertTrue(mvcResult.getResponse().getContentAsString().contains("test_country"));
	}

	/**
	 * Test for FindByParameters function in MainController
	 * 
	 * @throws Exception
	 */
	@Test
	void testFindByParameters() throws Exception {
		List<LandingPage> mockLandingList = new ArrayList<LandingPage>();
		LandingPage land = new LandingPage();
		land.setInstrumentName("instrument");
		mockLandingList.add(land);
		Mockito.when(mockLandingservice.searchByParameters("instrument_names", "country_names", "exchange_names"))
				.thenReturn(mockLandingList);
		MvcResult mvcResult = this.mockMvc.perform(
				get("/view/instrument_names/country_names/exchange_names").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		assertTrue(mvcResult.getResponse().getContentAsString().contains("instrument"));
	}

	/**
	 * Test for GetHistoricalData function in MainController
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetHistoricalData() throws Exception {
		List<HistoricalPage> mockHistoricalList = new ArrayList<HistoricalPage>();
		HistoricalPage hist = new HistoricalPage();
		hist.setClosePrice(4d);
		mockHistoricalList.add(hist);
		Mockito.when(mockHistoricalService.getByStockId(1)).thenReturn(mockHistoricalList);
		MvcResult mvcResult = this.mockMvc.perform(get("/historical/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		assertTrue(mvcResult.getResponse().getContentAsString().contains("4.0"));
	}
}
