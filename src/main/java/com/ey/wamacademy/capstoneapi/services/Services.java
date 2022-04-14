package com.ey.wamacademy.capstoneapi.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.wamacademy.capstoneapi.dao.HistoricalPageDao;
import com.ey.wamacademy.capstoneapi.dao.LandingPageDao;
import com.ey.wamacademy.capstoneapi.model.HistoricalPage;
import com.ey.wamacademy.capstoneapi.model.LandingPage;

// Service class for calling LandingPageDao methods and returning results to controller
@Service
public class Services {

	@Autowired
	private LandingPageDao landingPageDao;

	@Autowired
	private HistoricalPageDao historicalPageDao;

	/**
	 * method for fetching all records by calling LandingPageDao's method
	 *
	 * @return all the security records fetched from database
	 */
	public List<LandingPage> fetchAllData() {
		return landingPageDao.viewAll();
	}

	/**
	 * method for fetching all records using filtering by parameters
	 *
	 * @return list of records based on multiple parameters
	 */
	public List<LandingPage> searchByParameters(String instrumentName, String country, String exchange)
			throws SQLException {
		List<LandingPage> list = new ArrayList<LandingPage>();
		instrumentName = instrumentName.replace("\"", "");
		country = country.replace("\"", "");
		exchange = exchange.replace("\"", "");

		list = landingPageDao.filterByParameters(instrumentName, country, exchange);

		return list;
	}

	/**
	 * Returns unique exchange names in database
	 *
	 * @return list of unique exchange names
	 */
	public List<LandingPage> uniqueExchanges() {
		return landingPageDao.getUniqueExchangeNames();
	}

	/**
	 * Returns unique industry names in database
	 *
	 * @return list of unique industry names
	 */
	public List<LandingPage> uniqueInstruments() {
		return landingPageDao.getUniqueInstrumentNames();
	}

	/**
	 * Returns unique country names in database
	 *
	 * @return list of unique country names
	 */
	public List<LandingPage> uniqueCountries() {
		return landingPageDao.getUniqueCountryNames();
	}

	public List<HistoricalPage> getByStockId(int stock_id) {
		return historicalPageDao.historicalRecordByID(stock_id);
	}

}
