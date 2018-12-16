package com.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.*;
import java.util.*;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

@Controller("downloadAction")
public class DownloadAction extends ActionSupport {
	private String fileName;
	private InputStream inputStream;
	private String contentType;
	private String inputPath;
	public String getInputPath() {
		return inputPath;
	}
	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public InputStream getInputStream() throws FileNotFoundException {
		// 生成输入流
		String path = ServletActionContext.getServletContext().getRealPath(inputPath);
		
		FileInputStream fin = new FileInputStream(path+"\\"+fileName);
		inputStream = new BufferedInputStream(fin);
		
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String execute() throws Exception {
		System.out.println(" fileName:"+fileName);
		System.out.println(" contentType:"+contentType);
		System.out.println(" inputPath:"+inputPath);	
		return SUCCESS;
	}
}
