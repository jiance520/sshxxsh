package com.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import ognl.DefaultTypeConverter;

//ʱ��ת����
public class DateConverter extends DefaultTypeConverter{
	
	private static final DateFormat[] ACCEPT_DATE_FORMATS = {
		new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"),
		new SimpleDateFormat("yyyy-MM-dd"),
		new SimpleDateFormat("yyyy/MM/dd hh:mm:ss"),
		new SimpleDateFormat("yyyy/MM/dd")
		};  //֧��ת�������ڸ�ʽ
	
	public Object convertValue(Map context, Object value, Class toType) {
		if (toType == Date.class) {  //�������������ύʱ������String to Date��ת��
			Date date = null;
			String dateString = null;
			String[] params = (String[])value;
			System.out.println(" convertValue params = "+Arrays.toString(params));
			dateString = params[0];//��ȡ���ڵ��ַ���
			for (DateFormat format : ACCEPT_DATE_FORMATS) {
				try {
					return format.parse(dateString);//��������֧�ָ�ʽ������ת��
				} catch(Exception e) {
					continue;
				}
			}
			return null;
		}else if (toType == String.class) {//����������������ʱ(ognl���ʽ)������Date to String������ת��
			Date date = (Date)value;
			return new SimpleDateFormat("yyyy-MM-dd").format(date);//����ĸ�ʽ��yyyy-MM-dd
		}
			return null;
	}
}
