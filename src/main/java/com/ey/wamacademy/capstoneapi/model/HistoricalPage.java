
package com.ey.wamacademy.capstoneapi.model;

// Model class for historical page
public class HistoricalPage {
	private int stock_id;
	private String Date;
	private double openPrice;
	private double closePrice;
	private double highPrice;
	private double lowPrice;
	private int dailyTradedVolumne;
	private double weekReturn;
	private double monthReturn;
	private double yearReturn;
	private double dailyReturns;

	// Parameterized Constructor
	public HistoricalPage(int stock_id, String date, double openPrice, double closePrice, double highPrice,
			double lowPrice, int dailyTradedVolumne, double weekReturn, double monthReturn, double yearReturn,
			double dailyReturns) {
		this.Date = date;
		this.openPrice = openPrice;
		this.closePrice = closePrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.dailyTradedVolumne = dailyTradedVolumne;
		this.weekReturn = weekReturn;
		this.monthReturn = monthReturn;
		this.yearReturn = yearReturn;
		this.dailyReturns = dailyReturns;
	}

	// default constructor
	public HistoricalPage() {
	}

	// Getters and Setters
	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
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

	public double getDailyReturns() {
		return dailyReturns;
	}

	public void setDailyReturns(double dailyReturns) {
		this.dailyReturns = dailyReturns;
	}

}
