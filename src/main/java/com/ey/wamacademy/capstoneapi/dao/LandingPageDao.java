package com.ey.wamacademy.capstoneapi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.ey.wamacademy.capstoneapi.model.LandingPage;

// LandingPageDao includes the methods that perform business logics and return data to LandingPageService class 
@Component
public class LandingPageDao {

	Logger daologger = LoggerFactory.getLogger(LandingPageDao.class);
	PreparedStatement pst;
	ResultSet rs;
	String selectQuery = "select * from stocks";

	/**
	 * Fetches all the records from the landing table and returns list to
	 * LandingPageService
	 *
	 * @return list of all records fetched from the database
	 */
	public List<LandingPage> viewAll() {

		List<LandingPage> list = new ArrayList<LandingPage>();

		try {
			// establishing MySql connections
			pst = DbConnection.getObject().getConnection().prepareStatement(selectQuery);
			rs = pst.executeQuery();

			while (rs.next()) {

				LandingPage landingPage = new LandingPage();

				landingPage.setDate(rs.getString(2));
				landingPage.setRic(rs.getString(3));
				landingPage.setInstrumentName(rs.getString(4));
				landingPage.setCurrency(rs.getString(5));
				landingPage.setIsin(rs.getString(6));
				landingPage.setSedol(rs.getString(7));
				landingPage.setTickerSymbol(rs.getString(8));
				landingPage.setOpenPrice(rs.getDouble(9));
				landingPage.setClosePrice(rs.getDouble(10));
				landingPage.setHighPrice(rs.getDouble(11));
				landingPage.setLowPrice(rs.getDouble(12));
				landingPage.setDailyTradedVolumne(rs.getInt(13));
				landingPage.setWeekReturn(rs.getDouble(14));
				landingPage.setMonthReturn(rs.getDouble(15));
				landingPage.setYearReturn(rs.getDouble(16));
				landingPage.setCompanyMarketCapitalization(rs.getLong(17));
				landingPage.setBeta(rs.getDouble(18));
				landingPage.setRevenue(rs.getDouble(19));
				landingPage.setEarningsPerShare(rs.getDouble(20));
				landingPage.setPe(rs.getDouble(21));
				landingPage.setCountryOfExchange(rs.getString(22));
				landingPage.setExchangeName(rs.getString(23));
				landingPage.setSectorName(rs.getString(24));
				landingPage.setIndustryName(rs.getString(25));
				landingPage.setInstrumentType(rs.getString(26));
				list.add(landingPage);
			}
		} catch (Exception e) {
			daologger.debug("Error occured in viewAll function " + e);
		}
		return list;
	}

	/**
	 * Returns column count of the fetched data
	 *
	 * @return number of columns present in the landing database
	 */
	public int getColumnCount() {
		int columnCount = 0;
		try {
			pst = DbConnection.getObject().getConnection().prepareStatement(selectQuery);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			columnCount = rsmd.getColumnCount();
		} catch (Exception e) {
			daologger.debug("Error occured in getColumnCount function " + e);
		}

		return columnCount;

	}

	/**
	 * Searches record by stock_id , was implemented for testing
	 *
	 * @param stock_id, id of the record which is to be searched
	 * @return record with given stock id
	 */
	public LandingPage searchById(int stock_id) {
		LandingPage landingPage = new LandingPage();
		try {
			pst = DbConnection.getObject().getConnection()
					.prepareStatement("select * from landingtable where stock_id=?");
			pst.setInt(1, stock_id);
			rs = pst.executeQuery();
			while (rs.next()) {

				landingPage.setDate(rs.getString(1));
				landingPage.setRic(rs.getString(2));
				landingPage.setInstrumentName(rs.getString(3));
				landingPage.setCurrency(rs.getString(4));
				landingPage.setIsin(rs.getString(5));
				landingPage.setSedol(rs.getString(6));
				landingPage.setTickerSymbol(rs.getString(7));
				landingPage.setOpenPrice(rs.getDouble(8));
				landingPage.setClosePrice(rs.getDouble(9));
				landingPage.setHighPrice(rs.getDouble(10));
				landingPage.setLowPrice(rs.getDouble(11));
				landingPage.setDailyTradedVolumne(rs.getInt(12));
				landingPage.setWeekReturn(rs.getDouble(13));
				landingPage.setMonthReturn(rs.getDouble(14));
				landingPage.setYearReturn(rs.getDouble(15));
				landingPage.setCompanyMarketCapitalization(rs.getLong(16));
				landingPage.setBeta(rs.getDouble(17));
				landingPage.setRevenue(rs.getDouble(18));
				landingPage.setEarningsPerShare(rs.getDouble(19));
				landingPage.setPe(rs.getDouble(20));
				landingPage.setCountryOfExchange(rs.getString(21));
				landingPage.setExchangeName(rs.getString(22));
				landingPage.setSectorName(rs.getString(23));
				landingPage.setIndustryName(rs.getString(24));
				landingPage.setInstrumentType(rs.getString(25));
			}
		} catch (Exception e) {
			daologger.debug("Error occured in searchByID function " + e);
		}
		return landingPage;
	}

}
