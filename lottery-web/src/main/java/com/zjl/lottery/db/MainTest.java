package com.zjl.lottery.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zjl.lottery.util.JDBCPatchUtil;
import com.zjl.lottery.util.JDBCUtil;
import com.zjl.tools.TimeTools;

public class MainTest {
	public static void main(String[] args) {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
           
            DoubleBallDTO doubleballdto = new DoubleBallDTO("2019065", TimeTools.DateFormate("2019-06-06 21:15:00", TimeTools.Y_M_D_H_M_S), new Date(), "2019", "065", "6,9,11,15,20,26", "10");
            doubleballdto.insertDrawRecord();
            /*ArrayList<DoubleBallDTO> list = new ArrayList<DoubleBallDTO>();
            list.add(doubleballdto);
            list.add(doubleballdto);
            list.add(doubleballdto);
            list.add(doubleballdto);
            list.add(doubleballdto);
            list.add(doubleballdto);
            JDBCPatchUtil.insertDrawBatch(list);*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.close(rs, ps, conn);
        }
    }
	
}
