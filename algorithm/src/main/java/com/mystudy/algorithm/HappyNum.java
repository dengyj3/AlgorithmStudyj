package com.mystudy.algorithm;

public class HappyNum {
	public static int isHappyNum(int num) {
		int res = 0;//���շ���ֵ
		if (num/100 > 9 || num == 0) {
			System.out.println("����������ʮ������λ��! ");
			return res;
		}
		int unitsDigit = num%100%10;//��λ��
		int tensDigit = num%100/10;//ʮλ��
		int hundredsDigit = num/100;//��λ��
		int sum = unitsDigit*unitsDigit + tensDigit*tensDigit + hundredsDigit*hundredsDigit;
		if (sum == 1) {
			res = 1;//ȷ���ǿ�����,����1
		}else if (sum == 4) {
			res = -1;//ȷ���Ƿǿ�����,����-1
		}else {
			return isHappyNum(sum);//δ�õ�ȷ�н��,���еݹ鴦��
		}
		return res;
	}
	
	public static void main(String[] args) {
//		System.out.println(isHappyNum(100));
//		System.out.println(isHappyNum(7));
//		System.out.println(isHappyNum(32));
//		System.out.println(isHappyNum(97));
		System.out.println(isHappyNum(0));
		System.out.println(isHappyNum(1000));
	}
}
