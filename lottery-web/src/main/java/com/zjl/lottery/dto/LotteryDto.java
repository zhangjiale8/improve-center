package com.zjl.lottery.dto;

import java.util.Date;

public class LotteryDto {
	private String period;
	private String red;
	private String blue;
	private Date drawdtm;
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getRed() {
		return red;
	}
	public void setRed(String red) {
		this.red = red;
	}
	public String getBlue() {
		return blue;
	}
	public void setBlue(String blue) {
		this.blue = blue;
	}
	public Date getDrawdtm() {
		return drawdtm;
	}
	public void setDrawdtm(Date drawdtm) {
		this.drawdtm = drawdtm;
	}
	public LotteryDto(String period, String red, String blue, Date drawdtm) {
		super();
		this.period = period;
		this.red = red;
		this.blue = blue;
		this.drawdtm = drawdtm;
	}
	
}
