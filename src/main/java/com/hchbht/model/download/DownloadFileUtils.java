package com.hchbht.model.download;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * 文件下载
 */
public class DownloadFileUtils {
	
	/**
	 * java 调用浏览器方法下载
	 */
	public static ResponseEntity<byte[]> downloadResource(String path, String filename, HttpServletRequest req, HttpServletResponse resp) throws IOException  {
	   //  接受的是UTF-8
	   req.setCharacterEncoding("utf-8");
	   //获取项目根目录

       //String path="D:\\HCHB\\uploadFiles\\test\\2018\\07\\02\\0E36BDDF7D294931AB18A798BC0979D5.txt";
       //获取文件名
       //String filename="工作日志.txt";
       File file = null;
       HttpHeaders headers =null;
       try {
    	   System.out.println(filename);//myfiles
    	   file =new File(path);
    	   //请求头
    	   headers =new HttpHeaders();
    	   String fileName1 =new String(filename.getBytes("UTF-8"),"iso-8859-1");//解决文件名乱码
    	   //通知浏览器以attachment（下载方式）打开图片
    	   headers.setContentDispositionFormData("attachment",fileName1);
    	   //application/octet-stream二进制流数据（最常见的文件下载）。
    	   headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       } catch (Exception e) {
    	   e.printStackTrace();
       }

       return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.OK);
	} 
}
