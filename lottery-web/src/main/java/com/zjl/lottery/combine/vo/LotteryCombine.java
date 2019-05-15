package com.zjl.lottery.combine.vo;

public class LotteryCombine {
	private int index;//从第几个开始选择
	private int [] redArr;//红球数组
	private int redtotal;//红球总数
	private int redscreennum;//红选择数
	private int [] blueArr;//篮球数组
	private int bluetotal;//篮球总数
	private int bluescreennum;//篮选择数
	private LotteryTypEnum lotterytyp;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int[] getRedArr() {
		return redArr;
	}
	public void setRedArr(int[] redArr) {
		this.redArr = redArr;
	}
	public int getRedtotal() {
		return redtotal;
	}
	public void setRedtotal(int redtotal) {
		this.redtotal = redtotal;
	}
	public int getRedscreennum() {
		return redscreennum;
	}
	public void setRedscreennum(int redscreennum) {
		this.redscreennum = redscreennum;
	}
	public int[] getBlueArr() {
		return blueArr;
	}
	public void setBlueArr(int[] blueArr) {
		this.blueArr = blueArr;
	}
	public int getBluetotal() {
		return bluetotal;
	}
	public void setBluetotal(int bluetotal) {
		this.bluetotal = bluetotal;
	}
	public int getBluescreennum() {
		return bluescreennum;
	}
	public void setBluescreennum(int bluescreennum) {
		this.bluescreennum = bluescreennum;
	}
	public LotteryTypEnum getLotterytyp() {
		return lotterytyp;
	}
	public void setLotterytyp(LotteryTypEnum lotterytyp) {
		this.lotterytyp = lotterytyp;
	}
}
