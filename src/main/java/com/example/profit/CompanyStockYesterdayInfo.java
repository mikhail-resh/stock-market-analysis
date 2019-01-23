package com.example.profit;

public class CompanyStockYesterdayInfo {
    
	private String symbol;
	private String date;
	private float open ;
	private float high;
	private float low;
	private float close;
	private long volume;
	private long unadjustedVolume;
	private float change;
	private float changePercent;
	private float vwap;
	
	public CompanyStockYesterdayInfo() {
		
	}
	
	public CompanyStockYesterdayInfo(String symbol, String date, float open, float high, float low, float close, long volume,
			long unadjustedVolume, float change, float changePercent, float vwap) {
		super();
		this.symbol = symbol;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.unadjustedVolume = unadjustedVolume;
		this.change = change;
		this.changePercent = changePercent;
		this.vwap = vwap;
	}
	
    public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getOpen() {
		return open;
	}
	public void setOpen(float open) {
		this.open = open;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public float getClose() {
		return close;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public long getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public long getUnadjustedVolume() {
		return unadjustedVolume;
	}
	public void setUnadjustedVolume(int unadjustedVolume) {
		this.unadjustedVolume = unadjustedVolume;
	}
	public float getChange() {
		return change;
	}
	public void setChange(float change) {
		this.change = change;
	}
	public float getChangePercent() {
		return changePercent;
	}
	public void setChangePercent(float changePercent) {
		this.changePercent = changePercent;
	}
	public float getVwap() {
		return vwap;
	}
	public void setVwap(float vwap) {
		this.vwap = vwap;
	}
	

}
