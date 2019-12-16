package com.zjl.lottery.file;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.zjl.lottery.doubleball.util.HistoryUtil;
import com.zjl.lottery.util.MapDataUtil;
import com.zjl.tools.FileTools;
import com.zjl.tools.poi.ExcelUtils;

public class copyFileTest {
	public static void main(String[] args) {
		try {

			for (int i = 51; i < 145; i++) {
				String basepath = "E:" + File.separator + "screen" + File.separator+ "46144" + File.separator;
				String filename = "双色球预测汇总数据 ("+(i-46)+").xls";
				String copyfilename = "";
				if(i < 100){
					copyfilename += "20190"+i+"双色球预测汇总数据.xls";
				}else{
					copyfilename += "2019"+i+"双色球预测汇总数据.xls";
				}
				FileTools.copyfile(basepath,filename,copyfilename);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
