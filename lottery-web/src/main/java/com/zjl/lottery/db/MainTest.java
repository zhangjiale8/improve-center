package com.zjl.lottery.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zjl.lottery.db.util.JDBCPatchUtil;
import com.zjl.lottery.db.util.JDBCUtil;
import com.zjl.tools.TimeTools;

public class MainTest {
	public static void main(String[] args) {
		Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
           
            DoubleBallDTO doubleballdto = new DoubleBallDTO("2019059", new Date(), new Date(), "2019", "059", "1,2,3,5,8", "5");
            //doubleballdto.insertDrawRecord();
            ArrayList<DoubleBallDTO> list = new ArrayList<DoubleBallDTO>();
            list.add(doubleballdto);
            list.add(doubleballdto);
            list.add(doubleballdto);
            list.add(doubleballdto);
            list.add(doubleballdto);
            list.add(doubleballdto);
            JDBCPatchUtil.insertDrawBatch(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.close(rs, ps, conn);
        }
    }
	
}
