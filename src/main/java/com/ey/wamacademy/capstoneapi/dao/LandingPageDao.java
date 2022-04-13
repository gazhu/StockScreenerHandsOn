package com.ey.wamacademy.capstoneapi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.ey.wamacademy.capstoneapi.model.LandingPage;

// LandingPageDao includes the methods that perform business logics and return data to LandingPageService class 
@Component
public class LandingPageDao {

	private Logger daologger = LoggerFactory.getLogger(LandingPageDao.class);
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private static String selectQuery = "select *,"
			+ "(select r.return_price from return_details r where r.stock_id=s.stock_id and r.return_type=\"W\" and r.Price_Effective_Date=p.Price_Effective_Date) as \"1_week_return\","
			+ "(select r.return_price from return_details r where r.stock_id=s.stock_id and r.return_type=\"M\" and r.Price_Effective_Date=p.Price_Effective_Date) as \"1_month_return\", "
			+ "(select r.return_price from return_details r where r.stock_id=s.stock_id and r.return_type=\"Y\" and r.Price_Effective_Date=p.Price_Effective_Date) as \"1_year_return\" "
			+ "from stock_details s join price_details p on s.stock_id=p.stock_id "
			+ "join country_details co on s.country_id=co.country_id "
			+ "join currency_details c on s.currency_id=c.currency_id "
			+ "join industry_details i on s.industry_id=i.industry_id "
			+ "join instrument_details ins on s.instrument_id=ins.instrument_id "
			+ "join exchange_details e on s.exchange_id=e.exchange_id "
			+ "join sector_details sec on s.sector_id=sec.sector_id " + "where price_effective_date=\"2022-03-30\"";

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
			preparedStatement = DbConnection.getObject().getConnection()
					.prepareStatement(selectQuery + " order by s.stock_id");
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				LandingPage landingPage = new LandingPage();
				landingPage.setStockId(resultSet.getInt("stock_id"));
				landingPage.setDate(resultSet.getString("price_effective_date"));
				landingPage.setRic(resultSet.getString("ric"));
				landingPage.setInstrumentName(resultSet.getString("instrument_name"));
				landingPage.setCurrency(resultSet.getString("currency_code"));
				landingPage.setIsin(resultSet.getString("isin"));
				landingPage.setSedol(resultSet.getString("sedol"));
				landingPage.setTickerSymbol(resultSet.getString("ticker_symbol"));
				landingPage.setOpenPrice(resultSet.getDouble("open_price"));
				landingPage.setClosePrice(resultSet.getDouble("close_price"));
				landingPage.setHighPrice(resultSet.getDouble("high_price"));
				landingPage.setLowPrice(resultSet.getDouble("low_price"));
				landingPage.setDailyTradedVolumne(resultSet.getInt("daily_traded_volumes"));
				landingPage.setWeekReturn(resultSet.getDouble("1_week_return"));
				landingPage.setMonthReturn(resultSet.getDouble("1_month_return"));
				landingPage.setYearReturn(resultSet.getDouble("1_year_return"));
				landingPage.setCompanyMarketCapitalization(resultSet.getLong("company_market_capitalization"));
				landingPage.setBeta(resultSet.getDouble("beta"));
				landingPage.setRevenue(resultSet.getDouble("revenue"));
				landingPage.setEarningsPerShare(resultSet.getDouble("earnings_per_share"));
				landingPage.setPe(resultSet.getDouble("p_e"));
				landingPage.setCountryOfExchange(resultSet.getString("country_name"));
				landingPage.setExchangeName(resultSet.getString("Exchange_name"));
				landingPage.setSectorName(resultSet.getString("sector_name"));
				landingPage.setIndustryName(resultSet.getString("industry_name"));
				landingPage.setInstrumentType(resultSet.getString("instrument_types"));
				landingPage.setDailyReturns(resultSet.getDouble("daily_returns"));
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
			preparedStatement = DbConnection.getObject().getConnection().prepareStatement(selectQuery);
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
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
			preparedStatement = DbConnection.getObject().getConnection()
					.prepareStatement("select * from landing_table where stock_id=?");
			preparedStatement.setInt(1, stock_id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				landingPage.setDate(resultSet.getString(1));
				landingPage.setRic(resultSet.getString(2));
				landingPage.setInstrumentName(resultSet.getString(3));
				landingPage.setCurrency(resultSet.getString(4));
				landingPage.setIsin(resultSet.getString(5));
				landingPage.setSedol(resultSet.getString(6));
				landingPage.setTickerSymbol(resultSet.getString(7));
				landingPage.setOpenPrice(resultSet.getDouble(8));
				landingPage.setClosePrice(resultSet.getDouble(9));
				landingPage.setHighPrice(resultSet.getDouble(10));
				landingPage.setLowPrice(resultSet.getDouble(11));
				landingPage.setDailyTradedVolumne(resultSet.getInt(12));
				landingPage.setWeekReturn(resultSet.getDouble(13));
				landingPage.setMonthReturn(resultSet.getDouble(14));
				landingPage.setYearReturn(resultSet.getDouble(15));
				landingPage.setCompanyMarketCapitalization(resultSet.getLong(16));
				landingPage.setBeta(resultSet.getDouble(17));
				landingPage.setRevenue(resultSet.getDouble(18));
				landingPage.setEarningsPerShare(resultSet.getDouble(19));
				landingPage.setPe(resultSet.getDouble(20));
				landingPage.setCountryOfExchange(resultSet.getString(21));
				landingPage.setExchangeName(resultSet.getString(22));
				landingPage.setSectorName(resultSet.getString(23));
				landingPage.setIndustryName(resultSet.getString(24));
				landingPage.setInstrumentType(resultSet.getString(25));
			}
		} catch (SQLException e) {
			daologger.debug("Error occured in searchByID function " + e);
		}
		return landingPage;
	}

	// --------------------------------------Story 2
	// ------------------------------------

	// case 1 method when one parameter is selected
	private PreparedStatement searchByOneParameter(String parameter, String column) throws SQLException {

		String temp[] = parameter.split(",");
		StringBuilder queryBuilder = new StringBuilder(selectQuery);
		queryBuilder.append("and " + column + " in (");
		for (int i = 0; i < temp.length; i++) {
			queryBuilder.append("?");
			if (i < temp.length - 1) {
				queryBuilder.append(",");
			}
		}
		queryBuilder.append(")");

		try {
			preparedStatement = DbConnection.getObject().getConnection().prepareStatement(queryBuilder.toString());
		} catch (SQLException e) {

			e.printStackTrace();
		}
		for (int i = 0; i < temp.length; i++) {
			preparedStatement.setString(i + 1, temp[i]);
			System.out.println(temp[i]);
		}
		return preparedStatement;
	}

	// case 2 method when two parameters are selected
	private PreparedStatement searchByTwoParameter(String parameter1, String parameter2, String col1, String col2)
			throws SQLException {

		System.out.println(parameter1);
		System.out.println(parameter2);
		String temp1[] = parameter1.split(",");
		int len1 = temp1.length;
		String temp2[] = parameter2.split(",");
		int len2 = temp2.length;
		StringBuilder queryBuilder = new StringBuilder(selectQuery);
		queryBuilder.append("and " + col1 + " in (");

		for (int i = 0; i < len1; i++) {
			queryBuilder.append("?");
			if (i < len1 - 1)
				queryBuilder.append(",");
		}
		queryBuilder.append(") and " + col2 + " in (");
		for (int i = 0; i < len2; i++) {
			queryBuilder.append("?");
			if (i < len2 - 1)
				queryBuilder.append(",");
		}
		queryBuilder.append(")");

		preparedStatement = DbConnection.getObject().getConnection().prepareStatement(queryBuilder.toString());
		for (int i = 0; i < len1; i++) {
			preparedStatement.setString(i + 1, temp1[i]);
		}
		for (int i = 0; i < len2; i++) {
			preparedStatement.setString(i + len1 + 1, temp2[i]);
		}

		return preparedStatement;
	}

	// case 3 method when all parameters are selected
	private PreparedStatement searchByAllParameter(String parameter1, String parameter2, String parameter3, String col1,
			String col2, String col3) throws SQLException {
		System.out.println(parameter1);
		System.out.println(parameter2);
		System.out.println(parameter3);

		String temp1[] = parameter1.split(",");
		String temp2[] = parameter2.split(",");
		String temp3[] = parameter3.split(",");

		int len1 = temp1.length;
		int len2 = temp2.length;
		int len3 = temp3.length;

		StringBuilder queryBuilder = new StringBuilder(selectQuery);
		queryBuilder.append("and " + col1 + " in (");
		//
		for (int i = 0; i < len1; i++) {

			queryBuilder.append("?");
			if (i < len1 - 1)
				queryBuilder.append(",");

		}
		queryBuilder.append(") and " + col2 + " in (");
		for (int i = 0; i < len2; i++) {
			queryBuilder.append("?");
			if (i < len2 - 1)
				queryBuilder.append(",");
		}
		queryBuilder.append(") and " + col3 + " in (");
		for (int i = 0; i < len3; i++) {
			queryBuilder.append("?");
			if (i < len3 - 1)
				queryBuilder.append(",");
		}
		queryBuilder.append(")");

		preparedStatement = DbConnection.getObject().getConnection().prepareStatement(queryBuilder.toString());
		for (int i = 0; i < len1; i++) {
			preparedStatement.setString(i + 1, temp1[i]);
		}
		for (int i = 0; i < len2; i++) {
			preparedStatement.setString(i + len1 + 1, temp2[i]);
		}
		for (int i = 0; i < len3; i++) {
			preparedStatement.setString(i + len1 + len2 + 1, temp3[i]);
		}
		return preparedStatement;
	}

	// method to check parameters
	public List<LandingPage> filterByParameters(String industryName, String country, String exchange)
			throws SQLException {

		List<LandingPage> list = new ArrayList<LandingPage>();

		// case 1
		if (!industryName.equalsIgnoreCase("null") && country.equalsIgnoreCase("null")
				&& exchange.equalsIgnoreCase("null")) {

			preparedStatement = searchByOneParameter(industryName, "`INDUSTRY_NAME`");
			System.out.println("1st");

		}

		// case 2
		else if (industryName.equalsIgnoreCase("null") && !country.equalsIgnoreCase("null")
				&& exchange.equalsIgnoreCase("null")) {

			preparedStatement = searchByOneParameter(country, "`country_name`");
			System.out.println("2nd");

		}

		// case 3
		else if (industryName.equalsIgnoreCase("null") && country.equalsIgnoreCase("null")
				&& !exchange.equalsIgnoreCase("null")) {

			preparedStatement = searchByOneParameter(exchange, "`exchange_code`");
			System.out.println("3rd");

		}

		// case 4
		else if (!industryName.equalsIgnoreCase("null") && !country.equalsIgnoreCase("null")
				&& exchange.equalsIgnoreCase("null")) {

			preparedStatement = searchByTwoParameter(industryName, country, "`INDUSTRY_NAME`", "`country_name`");
			System.out.println("4th");

		}

		// case 5
		else if (!industryName.equalsIgnoreCase("null") && country.equalsIgnoreCase("null")
				&& !exchange.equalsIgnoreCase("null")) {

			preparedStatement = searchByTwoParameter(industryName, exchange, "`INDUSTRY_NAME`", "`exchange_code`");
			System.out.println("5th");

		}

		// case 6
		else if (industryName.equalsIgnoreCase("null") && !country.equalsIgnoreCase("null")
				&& !exchange.equalsIgnoreCase("null")) {

			preparedStatement = searchByTwoParameter(country, exchange, "`country_name`", "`exchange_code`");
			System.out.println("6th");

		}

		// case 7
		else if (!industryName.equalsIgnoreCase("null") && !country.equalsIgnoreCase("null")
				&& !exchange.equalsIgnoreCase("null")) {

			preparedStatement = searchByAllParameter(industryName, country, exchange, "`INDUSTRY_NAME`",
					"`country_name`", "`exchange_code`");
			System.out.println("7th");

		}

		// method to return the list
		list = viewList(preparedStatement);

		return list;

	}

	// method to return the list
	private List<LandingPage> viewList(PreparedStatement filterPreparedStatement) {
		List<LandingPage> list = new ArrayList<LandingPage>();
		try {
			resultSet = filterPreparedStatement.executeQuery();
			while (resultSet.next()) {
				LandingPage landingPage = new LandingPage();
				landingPage.setStockId(resultSet.getInt("stock_id"));
				landingPage.setDate(resultSet.getString("price_effective_date"));
				landingPage.setRic(resultSet.getString("ric"));
				landingPage.setInstrumentName(resultSet.getString("instrument_name"));
				landingPage.setCurrency(resultSet.getString("currency_code"));
				landingPage.setIsin(resultSet.getString("isin"));
				landingPage.setSedol(resultSet.getString("sedol"));
				landingPage.setTickerSymbol(resultSet.getString("ticker_symbol"));
				landingPage.setOpenPrice(resultSet.getDouble("open_price"));
				landingPage.setClosePrice(resultSet.getDouble("close_price"));
				landingPage.setHighPrice(resultSet.getDouble("high_price"));
				landingPage.setLowPrice(resultSet.getDouble("low_price"));
				landingPage.setDailyTradedVolumne(resultSet.getInt("daily_traded_volumes"));
				landingPage.setWeekReturn(resultSet.getDouble("1_week_return"));
				landingPage.setMonthReturn(resultSet.getDouble("1_month_return"));
				landingPage.setYearReturn(resultSet.getDouble("1_year_return"));
				landingPage.setCompanyMarketCapitalization(resultSet.getLong("company_market_capitalization"));
				landingPage.setBeta(resultSet.getDouble("beta"));
				landingPage.setRevenue(resultSet.getDouble("revenue"));
				landingPage.setEarningsPerShare(resultSet.getDouble("earnings_per_share"));
				landingPage.setPe(resultSet.getDouble("p_e"));
				landingPage.setCountryOfExchange(resultSet.getString("country_name"));
				landingPage.setExchangeName(resultSet.getString("exchange_code"));
				landingPage.setSectorName(resultSet.getString("sector_name"));
				landingPage.setIndustryName(resultSet.getString("industry_name"));
				landingPage.setInstrumentType(resultSet.getString("instrument_types"));
				landingPage.setDailyReturns(resultSet.getDouble("daily_returns"));
				list.add(landingPage);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	// -------------------------------------Story
	// 3-------------------------------------------
	public List<String> getUniqueInstrumentNames() {
		List<String> list = new ArrayList<String>();
		try {
			preparedStatement = DbConnection.getObject().getConnection().prepareStatement(
					"select distinct i.industry_name from stock_details s join industry_details i on s.industry_id=i.industry_id");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			daologger.debug("Error occured in getUniqueInstrumentNames function " + e);
		} finally {
		}
		return list;
	}

	public List<String> getUniqueExchangeNames() {
		List<String> list = new ArrayList<String>();
		String query = "select distinct e.exchange_code from stock_details s join exchange_details e on s.exchange_id=e.exchange_id";
		try {
			preparedStatement = DbConnection.getObject().getConnection().prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			daologger.debug("Error occured in getUniqueExchangeNames function " + e);
		}
		return list;
	}

	public List<String> getUniqueCountryNames() {
		List<String> list = new ArrayList<String>();
		try {
			preparedStatement = DbConnection.getObject().getConnection().prepareStatement(
					"select distinct co.country_name from stock_details s join country_details co on s.country_id=co.country_id");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				list.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			daologger.debug("Error occured in getUniqueCountryNames function " + e);
		}
		return list;
	}

}
