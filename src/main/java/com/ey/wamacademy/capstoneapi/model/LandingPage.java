package com.ey.wamacademy.capstoneapi.model;

// Model class for LandingPage
public class LandingPage {

	private int stockId;
	private String date;
	private String ric;
	private String instrumentName;
	private String currency;
	private String isin;
	private String sedol;
	private String tickerSymbol;
	private double openPrice;
	private double closePrice;
	private double highPrice;
	private double lowPrice;
	private int dailyTradedVolumne;
	private double weekReturn;
	private double monthReturn;
	private double yearReturn;
	private long companyMarketCapitalization;
	private double beta;
	private double revenue;
	private double earningsPerShare;
	private double pe;
	private String countryOfExchange;
	private String exchangeName;
	private String sectorName;
	private String industryName;
	private String instrumentType;
	private double dailyReturns;


	// Parameterized constructor
	public LandingPage(int stockId, String date, String ric, String instrumentName, String currency, String isin,
			String sedol, String tickerSymbol, double openPrice, double closePrice, double highPrice, double lowPrice,
			int dailyTradedVolumne, double weekReturn, double monthReturn, double yearReturn,
			long companyMarketCapitalization, double beta, double revenue, double earningsPerShare, double pe,
			String countryOfExchange, String exchangeName, String sectorName, String industryName,
			String instrumentType,double dailyReturns) {

		this.stockId = stockId;
		this.date = date;
		this.ric = ric;
		this.instrumentName = instrumentName;
		this.currency = currency;
		this.isin = isin;
		this.sedol = sedol;
		this.tickerSymbol = tickerSymbol;
		this.openPrice = openPrice;
		this.closePrice = closePrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.dailyTradedVolumne = dailyTradedVolumne;
		this.weekReturn = weekReturn;
		this.monthReturn = monthReturn;
		this.yearReturn = yearReturn;
		this.companyMarketCapitalization = companyMarketCapitalization;
		this.beta = beta;
		this.revenue = revenue;
		this.earningsPerShare = earningsPerShare;
		this.pe = pe;
		this.countryOfExchange = countryOfExchange;
		this.exchangeName = exchangeName;
		this.sectorName = sectorName;
		this.industryName = industryName;
		this.instrumentType = instrumentType;
		this.dailyReturns = dailyReturns;
	}

	// Unparameterized constructor
	public LandingPage() {

	}

	// Getters and Setters
	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRic() {
		return ric;
	}

	public void setRic(String ric) {
		this.ric = ric;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getSedol() {
		return sedol;
	}

	public void setSedol(String sedol) {
		this.sedol = sedol;
	}

	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public int getDailyTradedVolumne() {
		return dailyTradedVolumne;
	}

	public void setDailyTradedVolumne(int dailyTradedVolumne) {
		this.dailyTradedVolumne = dailyTradedVolumne;
	}

	public double getWeekReturn() {
		return weekReturn;
	}

	public void setWeekReturn(double weekReturn) {
		this.weekReturn = weekReturn;
	}

	public double getMonthReturn() {
		return monthReturn;
	}

	public void setMonthReturn(double monthReturn) {
		this.monthReturn = monthReturn;
	}

	public double getYearReturn() {
		return yearReturn;
	}

	public void setYearReturn(double yearReturn) {
		this.yearReturn = yearReturn;
	}

	public long getCompanyMarketCapitalization() {
		return companyMarketCapitalization;
	}

	public void setCompanyMarketCapitalization(long companyMarketCapitalization) {
		this.companyMarketCapitalization = companyMarketCapitalization;
	}

	public double getBeta() {
		return beta;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	public double getEarningsPerShare() {
		return earningsPerShare;
	}

	public void setEarningsPerShare(double earningsPerShare) {
		this.earningsPerShare = earningsPerShare;
	}

	public double getPe() {
		return pe;
	}

	public void setPe(double pe) {
		this.pe = pe;
	}

	public String getCountryOfExchange() {
		return countryOfExchange;
	}

	public void setCountryOfExchange(String countryOfExchange) {
		this.countryOfExchange = countryOfExchange;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}
	public double getDailyReturns() {
		return dailyReturns;
	}

	public void setDailyReturns(double dailyReturns) {
		this.dailyReturns = dailyReturns;
	}


}
