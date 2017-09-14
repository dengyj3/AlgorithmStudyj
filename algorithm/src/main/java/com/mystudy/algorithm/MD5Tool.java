package com.mystudy.algorithm;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Tool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "be9afde5b3e8567a1e26771f05884402";
		System.out.println(getMD5(""));
		//c11f23698b6d0c91762d684e38718174
	}
	/**
	 * ���ַ���md5����
	 *
	 * @param str
	 * @return
	 */
	public static String getMD5(String str) {
	    try {
	        // ����һ��MD5���ܼ���ժҪ
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        // ����md5����
	        md.update(str.getBytes());
	        // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
	        // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
	        return new BigInteger(1, md.digest()).toString(16);
	    } catch (Exception e) {
//	        throw new SpeedException("MD5���ܳ��ִ���");
	    	e.printStackTrace();
	    	return null;
	    }
	}
}
