package com.zjl.lottery.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.zjl.lottery.util.JDBCUtil;
import com.zjl.tools.TimeTools;

public class DoubleBallDTO {
	private int drawNo;
	private String drawId;
	private Date drawDtm;
	private Date createDtm;
	private String year;
	private String issueNum;
	private String redcodeVal;
	private String bluecodeVal;
	public int getDrawNo() {
		return drawNo;
	}
	public void setDrawNo(int drawNo) {
		this.drawNo = drawNo;
	}
	public String getDrawId() {
		return drawId;
	}
	public void setDrawId(String drawId) {
		this.drawId = drawId;
	}
	public Date getDrawDtm() {
		return drawDtm;
	}
	public void setDrawDtm(Date drawDtm) {
		this.drawDtm = drawDtm;
	}
	public Date getCreateDtm() {
		return createDtm;
	}
	public void setCreateDtm(Date createDtm) {
		this.createDtm = createDtm;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getIssueNum() {
		return issueNum;
	}
	public void setIssueNum(String issueNum) {
		this.issueNum = issueNum;
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
	
	public DoubleBallDTO(String drawId, Date drawDtm, Date createDtm, String year, String issueNum, String redcodeVal,
			String bluecodeVal) {
		super();
		this.drawId = drawId;
		this.drawDtm = drawDtm;
		this.createDtm = createDtm;
		this.year = year;
		this.issueNum = issueNum;
		this.redcodeVal = redcodeVal;
		this.bluecodeVal = bluecodeVal;
	}
	
	public DoubleBallDTO() {
		super();
	}
	/**
	 * 插入开奖记录
	 */
	public void insertDrawRecord() {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	conn = JDBCUtil.getMysqlConn();
            String insertSql = "insert into PRELOTTERYDRAW (DRAW_ID,DRAW_DTM,CREATE_DTM,YEAR,ISSUE_NUM,REDCODE_VAl,BLUECODE_VAl) values(?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(insertSql);
            ps.setString(1,this.drawId);
            ps.setTimestamp(2,TimeTools.DbTypeTranse(TimeTools.DateFormate(TimeTools.DateStr(this.drawDtm,TimeTools.Y_M_D) + " 21:15:00", TimeTools.Y_M_D_H_M_S)));
            ps.setTimestamp(3,TimeTools.DbTypeTranse(this.createDtm));
            ps.setString(4, this.year);
            ps.setString(5,this.issueNum);
            ps.setString(6, this.redcodeVal);
            ps.setString(7, this.bluecodeVal);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.close(rs, ps, conn);
        }
		
		
	}
	
	
}
