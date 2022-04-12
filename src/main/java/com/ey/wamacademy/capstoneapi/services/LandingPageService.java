package com.ey.wamacademy.capstoneapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ey.wamacademy.capstoneapi.dao.LandingPageDao;
import com.ey.wamacademy.capstoneapi.model.LandingPage;

// Service class for calling LandingPageDao methods and returning results to controller
@Service
public class LandingPageService {

	@Autowired
	private LandingPageDao landingPageDao;

	/**
	 * method for fetching all records by calling LandingPageDao's method
	 *
	 * @return all the security records fetched from database
	 */
	public List<LandingPage> fetchAllData() {
		return landingPageDao.viewAll();
	}

}
