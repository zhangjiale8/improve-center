package com.zjl.lottery.db.test.vo;

public class CombineVo {
	private int combineNo;
	private String redcodeVal;
	private String bluecodeVal;
	public int getCombineNo() {
		return combineNo;
	}
	public void setCombineNo(int combineNo) {
		this.combineNo = combineNo;
	}
	public String getRedcodeVal() {
		return redcodeVal;
	}
	public void setRedcodeVal(String redcodeVal) {
		this.redcodeVal = redcodeVal;
	}
	public String getBluecodeVal() {
		return bluecodeVal;
	}
	public void setBluecodeVal(String bluecodeVal) {
		this.bluecodeVal = bluecodeVal;
	}
	
	public CombineVo(String redcodeVal, String bluecodeVal) {
		super();
		this.redcodeVal = redcodeVal;
		this.bluecodeVal = bluecodeVal;
	}
	
}
