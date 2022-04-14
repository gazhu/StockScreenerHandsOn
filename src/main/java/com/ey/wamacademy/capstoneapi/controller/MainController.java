package com.ey.wamacademy.capstoneapi.controller;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ey.wamacademy.capstoneapi.model.HistoricalPage;
import com.ey.wamacademy.capstoneapi.model.LandingPage;
import com.ey.wamacademy.capstoneapi.services.Services;

// Intercepts incoming get requests
@RestController
public class MainController {

	Logger controllerlogger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private Services service;

	/**
	 * handling get request for fetching all records in landing page table
	 *
	 * @return records of all security details present in the database
	 */
	@GetMapping("viewall")
	public List<LandingPage> viewAll() {

		controllerlogger.info("Inside View All Method");
		List<LandingPage> records = service.fetchAllData();

		// logging the trace if records are fetched successfully
		if (records.size() != 0) {
			controllerlogger.trace("All records fetched");
			return records;
		}

		// logging the error if records are not fetched
		controllerlogger.error("No records found");
		return records;
	}
	
	/**
	 * handling get request for fetching data according to drop-down multiple selections
	 *
	 * @return list of records falling under drop-down selects
	 */
	@GetMapping("/view/{instrumentName}/{country}/{exchange}")
	public List<LandingPage> findByParameters(@PathVariable String instrumentName, @PathVariable String country,
			@PathVariable String exchange) throws SQLException {

		controllerlogger.info("filtering with respect to parameters");
		if (instrumentName.equalsIgnoreCase("null") && country.equalsIgnoreCase("null")
				&& exchange.equalsIgnoreCase("null")) {
			System.out.println("this triggered");
			return service.fetchAllData();
		}

		return service.searchByParameters(instrumentName, country, exchange);

	}

	/**
	 * handling get request for fetching unique records of exchanges
	 *
	 * @return list of all unique exchange names
	 */
	@GetMapping("uniqueexchanges")
	public List<LandingPage> getUniqueExchanges() {
		return service.uniqueExchanges();
	}

	/**
	 * handling get request for fetching unique records of instruments
	 *
	 * @return list of all unique instruments values
	 */
	@GetMapping("uniqueinstruments")
	public List<LandingPage> getUniqueInstruments() {
		return service.uniqueInstruments();
	}

	/**
	 * handling get request for fetching unique records of countries
	 *
	 * @return list of all unique country names
	 */
	@GetMapping("uniquecountries")
	public List<LandingPage> getUniqueCountries() {
		return service.uniqueCountries();
	}
	
	@GetMapping("/historical/{stock_id}")
	public List<HistoricalPage> getHistoricalData(@PathVariable int stock_id) throws SQLException
	{
		return service.getByStockId(stock_id);
	}

}
