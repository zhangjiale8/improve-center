package com.zjl.lottery.db.bin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.zjl.lottery.db.DoubleBallDTO;
import com.zjl.lottery.util.JDBCUtil;
import com.zjl.tools.TimeTools;

public class Test {
	public static void main(String[] args) {

		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	ArrayList<String[]> list = new ArrayList<String[]>();
        	conn = JDBCUtil.getMysqlConn();
            String getSql = "SELECT A.`REDCODE_VAl` FROM prelotterydraw A";
            ps = conn.prepareStatement(getSql);
            rs = ps.executeQuery();
            while (rs.next()) {
            	String param = rs.getString(1);
            	String[] paramArr = param.split(",");
            	list.add(paramArr);
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.close(rs, ps, conn);
        }
		
	
	}
}
