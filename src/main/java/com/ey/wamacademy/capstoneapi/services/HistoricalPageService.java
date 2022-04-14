package com.ey.wamacademy.capstoneapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.wamacademy.capstoneapi.dao.HistoricalPageDao;
import com.ey.wamacademy.capstoneapi.model.HistoricalPage;

//Service class for calling HistoricalPageDao methods and returning results to controller
@Service
public class HistoricalPageService {

	@Autowired
	private HistoricalPageDao historicalPageDao;


	/**
	 * Function for fetching a record with specific stock_id
	 *
	 * @return List of records with specific stock_id for each day expect current day
	 */
	public List<HistoricalPage> getByStockId(int stock_id) {
		return historicalPageDao.historicalRecordByID(stock_id);
	}

}
