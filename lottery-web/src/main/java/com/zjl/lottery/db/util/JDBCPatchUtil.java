package com.zjl.lottery.db.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.zjl.lottery.db.DoubleBallDTO;
import com.zjl.lottery.db.test.vo.CombineVo;
import com.zjl.tools.TimeTools;

public class JDBCPatchUtil {
	/**
	 * 插入开奖结果
	 * @param list
	 */
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
	/**
	 * 双色球插入所有组合
	 * @param list
	 */
	public static void insertDoubleBallCombineBatch(ArrayList<CombineVo> list) {

		if(null != list && list.size() > 0){
			Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	        	conn = JDBCUtil.getMysqlConn();
	        	conn.setAutoCommit(false);
	            String insertSql = "insert into DOUBLEBALLCOMBINE (REDCODE_VAl,BLUECODE_VAl) values(?,?)";
	            ps = conn.prepareStatement(insertSql);
	            for (int i = 0; i < list.size(); i++) {
	            	CombineVo param = list.get(i);
		            ps.setString(1, param.getRedcodeVal());
		            ps.setString(2, param.getBluecodeVal());
		            ps.addBatch();//添加到批次
		            // 每1000条记录插入一次
		            if (i % 1000 == 0){
		                ps.executeBatch();
		                conn.commit();
		                ps.clearBatch();
		            }

				}
	            // 剩余数量不足1000
	            ps.executeBatch();
	            conn.commit();
	            ps.clearBatch();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally{
	            JDBCUtil.close(rs, ps, conn);
	        }
			
		}
		
	}
	
	/**
	 * 初始化双色球筛选所有组合
	 * @param list
	 */
	public static void initDoubleBallScreenBatch(ArrayList<CombineVo> list) {

		if(null != list && list.size() > 0){
			Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        try {
	        	conn = JDBCUtil.getMysqlConn();
	        	conn.setAutoCommit(false);
	            String insertSql = "insert into DOUBLEBALLSCREENDATA (REDCODE_VAl,BLUECODE_VAl) values(?,?)";
	            ps = conn.prepareStatement(insertSql);
	            for (int i = 0; i < list.size(); i++) {
	            	CombineVo param = list.get(i);
		            ps.setString(1, param.getRedcodeVal());
		            ps.setString(2, param.getBluecodeVal());
		            ps.addBatch();//添加到批次
		            // 每1000条记录插入一次
		            if (i % 1000 == 0){
		                ps.executeBatch();
		                conn.commit();
		                ps.clearBatch();
		            }

				}
	            // 剩余数量不足1000
	            ps.executeBatch();
	            conn.commit();
	            ps.clearBatch();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally{
	            JDBCUtil.close(rs, ps, conn);
	        }
			
		}
		
	}
	
	/**
	 * 大乐透插入所有组合
	 * @param list
	 */
	public static void insertGreatLottoCombineBatch(ArrayList<CombineVo> list) {
		
		
	}

}
