package com.zjl.lottery.db.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.zjl.lottery.db.DoubleBallDTO;
import com.zjl.tools.TimeTools;

public class JDBCPatchUtil {

	public static void insertDrawBatch(ArrayList<DoubleBallDTO> list) {
		if(null != list && list.size() > 0){
			Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	        	conn = JDBCUtil.getMysqlConn();
	            String insertSql = "insert into PRELOTTERYDRAW (DRAW_ID,DRAW_DTM,CREATE_DTM,YEAR,ISSUE_NUM,REDCODE_VAl,BLUECODE_VAl) values(?,?,?,?,?,?,?)";
	            ps = conn.prepareStatement(insertSql);
	            for (int i = 0; i < list.size(); i++) {
	            	DoubleBallDTO param = list.get(i);
	            	ps.setString(1,param.getDrawId());
		            ps.setTimestamp(2,TimeTools.DbTypeTranse(TimeTools.DateFormate(TimeTools.DateStr(param.getDrawDtm(),TimeTools.Y_M_D) + " 21:15:00", TimeTools.Y_M_D_H_M_S)));
		            ps.setTimestamp(3,TimeTools.DbTypeTranse(param.getCreateDtm()));
		            ps.setString(4, param.getYear());
		            ps.setString(5,param.getIssueNum());
		            ps.setString(6, param.getRedcodeVal());
		            ps.setString(7, param.getBluecodeVal());
		            ps.addBatch();//添加到批次
				}
	            ps.executeBatch();//提交批处理

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally{
	            JDBCUtil.close(rs, ps, conn);
	        }
			
		}
		
	}

}
