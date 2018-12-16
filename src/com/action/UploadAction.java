package com.action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

@Controller("uploadAction")
public class UploadAction extends ActionSupport implements ServletRequestAware{
	private String title;
	private HttpServletRequest request;	
	private String savePath;// �ļ�����·��
	private String webPath;// ������ʵ�·��	
    // Ҫ�����ļ������ 
	private File[] upfile; // �ļ�
    private String[] upfileContentType; // ����  : �ļ������ + ContentType
    private String[] upfileFileName; // ����  :  �ļ������ + FileName
	public void setWebPath(String webPath) {
		this.webPath = webPath;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public void setUpfile(File[] upfile) {
		this.upfile = upfile;
	}

	public void setUpfileContentType(String[] upfileContentType) {
		this.upfileContentType = upfileContentType;
	}
	public void setUpfileFileName(String[] upfileFileName) {
		this.upfileFileName = upfileFileName;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String execute() throws Exception {	
		System.out.println(" title = "+title);
		//savePath = request.getServletContext().getRealPath(savePath);
		System.out.println(" save path = "+savePath);
		System.out.println(" web path = "+webPath);
		System.out.println(" file = "+Arrays.toString(upfile));	
		System.out.println(" contenttype = "+Arrays.toString(upfileContentType));	
		System.out.println(" filename = "+Arrays.toString(upfileFileName));	
		// ѭ���ļ� copy
		if(upfile !=null){
			for(int i=0;i<upfile.length;i++){
				byte[] barr = new byte[1024];
				//������
				FileInputStream fin = new FileInputStream(upfile[i]);
				// �����
				FileOutputStream fout = new FileOutputStream(savePath+"\\"+upfileFileName[i]);
				
				int length = fin.read(barr); // length ʵ�ʶ�ȡ���ֽ���
				while(length !=-1){
					fout.write(barr, 0, length); // ���˶��پ�д����
					
					length = fin.read(barr);
				}
				fin.close();
				fout.flush();
				fout.close();
			}
		}		
		return SUCCESS;
	}
}
