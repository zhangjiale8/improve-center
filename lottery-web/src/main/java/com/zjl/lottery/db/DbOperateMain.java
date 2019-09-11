package com.zjl.lottery.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.mutitest.LotteryHaveNoMaster;
import com.zjl.lottery.util.JDBCPatchUtil;
import com.zjl.lottery.util.JDBCUtil;
import com.zjl.tools.ArrayTool;
import com.zjl.tools.TimeTools;

public class DbOperateMain {
	public static void main(String[] args) {
		ArrayList<DoubleBallDTO> list = new ArrayList<DoubleBallDTO>();
		String ticketPath = "data/doubleball.txt";
		URL url = LotteryHaveNoMaster.class.getClassLoader().getResource(ticketPath);
		File file = new File(url.getFile());
		if(null != file && file.exists()) {
			//构造一个BufferedReader类来读取文件
			try {
				int index = 0;
				BufferedReader br = new BufferedReader(new FileReader(file));
				String line = null;
				DoubleBallDTO doubleballdto = null;
				while((StringUtils.isNotEmpty(line = br.readLine()))){//使用readLine方法，一次读一行
					index++;
					if(index % 2 == 0){
						if(null != doubleballdto){
							String temp = line.replaceAll(" ", ",");
			                String [] codeArr = temp.split(",");
			                String redcodeVal = "";
			                String[] redArr = Arrays.copyOfRange(codeArr, 0, 6);
			                for (int i = 0; i < redArr.length; i++) {
			                	redcodeVal += (redArr[i] +",").replaceAll(" ","");
							}
			                redcodeVal = redcodeVal.substring(0, redcodeVal.length()-1);
							String bluecodeVal = codeArr[6];
							doubleballdto.setRedcodeVal(redcodeVal);
							doubleballdto.setBluecodeVal(bluecodeVal);
							list.add(doubleballdto);
						}
					}else{
						String [] issueArr = line.split("@");
						String drawId = issueArr[0];
						Date drawDtm = TimeTools.DateFormate(issueArr[1], TimeTools.Y_M_D_H_M_S);
						Date createDtm = new Date();
						String year = drawId.substring(0, 4);
						String issueNum = drawId.substring(4, drawId.length());
						doubleballdto = new DoubleBallDTO(drawId,drawDtm,createDtm,year,issueNum,null,null);
					}
	               
	            }
				if(null != list && list.size() > 0){
					 JDBCPatchUtil.insertDrawBatch(list);
				}
	            br.close(); 
	            
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	
    }
	
}
