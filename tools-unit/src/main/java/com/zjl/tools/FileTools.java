package com.zjl.tools;

import java.io.*;

/**
 * 文件读取工具类
 */
public class FileTools {

    /**
     * 读取文件内容，作为字符串返回
     */
    public static String readFileAsString(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } 

        if (file.length() > 1024 * 1024 * 1024) {
            throw new IOException("File is too large");
        } 

        StringBuilder sb = new StringBuilder((int) (file.length()));
        // 创建字节输入流  
        FileInputStream fis = new FileInputStream(filePath);  
        // 创建一个长度为10240的Buffer
        byte[] bbuf = new byte[10240];  
        // 用于保存实际读取的字节数  
        int hasRead = 0;  
        while ( (hasRead = fis.read(bbuf)) > 0 ) {  
            sb.append(new String(bbuf, 0, hasRead));  
        }  
        fis.close();  
        return sb.toString();
    }

    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }
    
    public static void main(String[] args) {
		String basepath = "E:" + File.separator + "screen" + File.separator+ "46144" + File.separator;
		String filename = "2019046双色球预测汇总数据.xls";
		String copyfilename = "2019046999双色球预测汇总数据.xls";
		try {
			FileTools.copyfile(basepath,filename,copyfilename);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    /**
     * 文件复制
     * @param basepath
     * @param filename
     * @param copyfilename
     * @throws Exception 
     */
	public static void copyfile(String basepath, String filename, String copyfilename) throws Exception {
		String filepath = basepath +filename;
		File file = new File(filepath);
		String copyfilepath = basepath+copyfilename;
        File copyfile = new File(copyfilepath);
        if(!copyfile.exists()){
            copyfile.createNewFile();
        }
      //复制内容到指定文件中
        copyFileContent(file,copyfile);
	}
    /**
     * 将文件fromFile 的内容复制到  toFile文件中
     * 复制的可以是Excel等多种格式
     * @param fromFile
     * @param toFile
     * @throws IOException
     */
    public static void copyFileContent(File fromFile, File toFile) throws IOException {
        FileInputStream ins = new FileInputStream(fromFile);
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n = 0;
        while ((n = ins.read(b)) != -1) {
            out.write(b, 0, n);
        }

        ins.close();
        out.close();
    }
		
}