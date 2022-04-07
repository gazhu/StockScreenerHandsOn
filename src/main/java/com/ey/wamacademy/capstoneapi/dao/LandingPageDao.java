package com.ey.wamacademy.capstoneapi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ey.wamacademy.capstoneapi.model.LandingPage;

@Component
public class LandingPageDao {

	PreparedStatement pst;
	ResultSet rs;
	String selectQuery = "select * from landingtable";

	public List<LandingPage> viewAll() {

		List<LandingPage> list = new ArrayList<LandingPage>();

		try {
			pst = DbConnection.getObject().getConnection().prepareStatement(selectQuery);
			rs = pst.executeQuery();

			while (rs.next()) {

				LandingPage landingPage = new LandingPage();
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
				list.add(landingPage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getColumnCount() {
		int columnCount = 0;
		try {
			pst = DbConnection.getObject().getConnection().prepareStatement(selectQuery);
			rs = pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			columnCount = rsmd.getColumnCount();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return columnCount;

	}

	public LandingPage searchById(String isinCheck) {
		LandingPage landingPage = new LandingPage();
		try {
			pst = DbConnection.getObject().getConnection().prepareStatement("select * from landingtable where isin=?");
			pst.setString(1, isinCheck);
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
			e.printStackTrace();
		}
		return landingPage;
	}

}
