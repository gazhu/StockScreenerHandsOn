package com.ey.wamacademy.capstoneapi.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ey.wamacademy.capstoneapi.model.HistoricalPage;

// HistoricalPageDao includes the methods that perform business logics and return data to HistoricalPageService class 
@Component
public class HistoricalPageDao {

	private Logger daologger = LoggerFactory.getLogger(LandingPageDao.class);
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	// select query
	private static String selectQuery = "select *,"
			+ "(select r.return_price from return_details r where r.stock_id=s.stock_id and r.return_type=\"D\" and r.Price_Effective_Date=p.Price_Effective_Date) as \"daily_returns\","
			+ "(select r.return_price from return_details r where r.stock_id=s.stock_id and r.return_type=\"W\" and r.Price_Effective_Date=p.Price_Effective_Date) as \"1_week_return\","
			+ "(select r.return_price from return_details r where r.stock_id=s.stock_id and r.return_type=\"M\" and r.Price_Effective_Date=p.Price_Effective_Date) as \"1_month_return\", "
			+ "(select r.return_price from return_details r where r.stock_id=s.stock_id and r.return_type=\"Y\" and r.Price_Effective_Date=p.Price_Effective_Date) as \"1_year_return\" "
			+ "from stock_details s join price_details p on s.stock_id=p.stock_id "
			+ "join country_details co on s.country_id=co.country_id "
			+ "join currency_details c on s.currency_id=c.currency_id "
			+ "join industry_details i on s.industry_id=i.industry_id "
			+ "join instrument_details ins on s.instrument_id=ins.instrument_id "
			+ "join exchange_details e on s.exchange_id=e.exchange_id "
			+ "join sector_details sec on s.sector_id=sec.sector_id ";

	/**
	 * finds a stock using stock_id and returns its historical data
	 *
	 * @return List of records with specific stock_id for each day expect current
	 *         day
	 */
	public List<HistoricalPage> historicalRecordByID(int stock_id) {

		List<HistoricalPage> list = new ArrayList<HistoricalPage>();
		// return null object if id is less than equal to zero
		if (stock_id <= 0) {
			HistoricalPage emptyHistoricalPageObject = new HistoricalPage();
			list.add(emptyHistoricalPageObject);
			return list;
		}
		try {
			preparedStatement = DbConnection.getObject().getConnection()
					.prepareStatement(selectQuery + " where s.stock_id=? and p.price_effective_date!=\"2022-03-30\"");
			preparedStatement.setInt(1, stock_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				HistoricalPage historicalPage = new HistoricalPage();
				historicalPage.setStock_id(resultSet.getInt("stock_id"));
				historicalPage.setDate(resultSet.getString("price_effective_date"));
				historicalPage.setClosePrice(resultSet.getDouble("close_price"));
				historicalPage.setDailyTradedVolumne(resultSet.getInt("daily_traded_volumes"));
				historicalPage.setHighPrice(resultSet.getDouble("high_price"));
				historicalPage.setLowPrice(resultSet.getDouble("low_price"));
				historicalPage.setOpenPrice(resultSet.getDouble("open_price"));
				historicalPage.setMonthReturn(resultSet.getDouble("1_month_return"));
				historicalPage.setWeekReturn(resultSet.getDouble("1_week_return"));
				historicalPage.setYearReturn(resultSet.getDouble("1_year_return"));
				historicalPage.setDailyReturns(resultSet.getDouble("daily_returns"));
				list.add(historicalPage);
			}
		} catch (Exception e) {
			daologger.debug("Error occured in historicalRecordByID Function" + e);
		}
		return list;
	}

}
