package com.mystudy.algorithm;

/**
 * ���ַ�����ȫ���� �ݹ��˼�� 
 * ���� abcde �����abcd��ȫ����,Ȼ��e�ֱ����ȫ���е�5��λ�� 
 * a ȫ���� a 
 * ab ȫ���� ab ba 
 * abc ȫ���м��� cab acb abc cba bca bac
 * 
 * @author 
 *
 */
public class Permutation {
	public static void main(String[] args) {
		String string = "abc";
		String[] rStrings = getPermutaion(string);
		if (rStrings != null) {
			int count = 0;
			for(int i=0;i<rStrings.length;i++){
				if (rStrings[i]!=null) {
					System.out.println(rStrings[i]);
					count++;
				}
			}
			System.out.println("count is : " + count);
		}
	}

	/**
	 * ��һ���ַ�����ȫ����
	 * @param string
	 * @return
	 */
	private static String[] getPermutaion(String string) {
		String[] rStrings = new String[1000];
		if (string == null || string.isEmpty()) {
			return null;
		}
		int strLen = string.length();
		if (strLen == 1) {
			rStrings[0] = string;
		}else if (strLen == 2) {
			rStrings[0] = string;
			rStrings[1] = ""+string.charAt(1)+string.charAt(0);
		}else if (strLen>2) {
			char c = string.charAt(strLen-1);
			String strBefore = string.substring(0, strLen-1);
			String[] tmpRsArr = getPermutaion(strBefore);
			int count = 0;
			for(int i=0;i<tmpRsArr.length;i++){
				String tmpRs = tmpRsArr[i];
				if (tmpRs != null) {
					for(int k=0;k<tmpRs.length()+1;k++){
						rStrings[count++] = tmpRs.substring(0, k) + c + tmpRs.substring(k, tmpRs.length());
					}
				}
			}
		}
		return rStrings;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
