package com.ey.wamacademy.capstoneapi.controller;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ey.wamacademy.capstoneapi.model.LandingPage;
import com.ey.wamacademy.capstoneapi.services.LandingPageService;

// Intercepts incoming get requests
@RestController
public class MainController {

	Logger controllerlogger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private LandingPageService service;

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

	@GetMapping("/view/{industryName}/{country}/{exchange}")
	public List<LandingPage> findByParameters(@PathVariable String industryName, @PathVariable String country,
			@PathVariable String exchange) throws SQLException {

		controllerlogger.info("filtering with respect to parameters");
		if (industryName.equalsIgnoreCase("null") && country.equalsIgnoreCase("null")
				&& exchange.equalsIgnoreCase("null")) {
			System.out.println("this triggered");
			return service.fetchAllData();
		}

		return service.searchByParameters(industryName, country, exchange);

	}

	/**
	 * handling get request for fetching unique records of exchanges
	 *
	 * @return list of all unique exchange names
	 */
	@GetMapping("uniquexchanges")
	public List<String> getUniqueExchanges() {
		return service.uniqueExchanges();
	}

	/**
	 * handling get request for fetching unique records of instruments
	 *
	 * @return list of all unique instruments values
	 */
	@GetMapping("uniqueinstruments")
	public List<String> getUniqueInstruments() {
		return service.uniqueInstruments();
	}

	/**
	 * handling get request for fetching unique records of countries
	 *
	 * @return list of all unique country names
	 */
	@GetMapping("uniquecountries")
	public List<String> getUniqueCountries() {
		return service.uniqueCountries();
	}

}
