package com.ey.wamacademy.capstoneapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.wamacademy.capstoneapi.dao.LandingPageDao;
import com.ey.wamacademy.capstoneapi.model.LandingPage;

@Service
public class LandingPageService {
	
	@Autowired
	private LandingPageDao landingPageDao;
	
	public List<LandingPage> fetchAllData()
	{
		return landingPageDao.viewAll();
	}

}
