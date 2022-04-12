package com.ey.wamacademy.capstoneapi.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
