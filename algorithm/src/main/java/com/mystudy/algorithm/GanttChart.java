package com.mystudy.algorithm;
/**
 * 迷离傍地走算法
 * 为庆祝强汉文盛世暨废除和亲七百周年，武后决定拜孙武和王翦对春夏秋冬四官细君、昭君、探春、文成做军事训练
 * 孙武和王翦分别负责四官的站军姿和踢正步科目。根据军训要求，只有在学会站军姿之后才能进行踢正步训练。由于四官天资差别，学习时间如下表
 * 				细君		昭君		探春		文成
 * 站军姿(孙武)	8小时	6小时	2小时	4小时
 * 踢正步(王翦)	3小时	1小时	3小时	12小时
 * 
 * 问: 应该如何安排四官的学习时间,能够使得所有人学会这两项技能的时间最短?
 * 策略: 所有事件中的最短时间是昭君踢正步(1小时),由于该事件是第二阶段,则将其最后执行;此短时间是探春站军姿(2小时),由于该事件是第一阶段,
 * 则将其优先执行;以此类推.
 * 
 */
public class GanttChart {
	public void ganttChart(int[] a, int[] b, int[] c, int size){
		int i;
		int s2 = 2*size;
		TagsItem[] tagsItems = new TagsItem[s2];
		for(i=0;i<size;i++){
			tagsItems[i] = new TagsItem();
			tagsItems[i].setT(a[i]);
			tagsItems[i].setnIndex(i);
			tagsItems[i].setbFirst(true);
			
			tagsItems[size+i] = new TagsItem();
			tagsItems[size+i].setT(b[i]);
			tagsItems[size+i].setnIndex(i);
			tagsItems[size+i].setbFirst(false);
		}
		
		for (TagsItem tagsItem : tagsItems) {
			System.out.println(tagsItem);
		}
	}
	public static void main(String[] args) {
		GanttChart ganttChart = new GanttChart();
		int a[] = {8,6,2,4};
		int b[] = {3,1,3,12};
		ganttChart.ganttChart(a, b, null, a.length);
	}
}

class TagsItem{
	private int t;//元素值
	private int nIndex;//元素索引
	private boolean bFirst;//是否是先执行
	public int getT() {
		return t;
	}
	public void setT(int t) {
		this.t = t;
	}
	public int getnIndex() {
		return nIndex;
	}
	public void setnIndex(int nIndex) {
		this.nIndex = nIndex;
	}
	public boolean isbFirst() {
		return bFirst;
	}
	public void setbFirst(boolean bFirst) {
		this.bFirst = bFirst;
	}
	@Override
	public String toString() {
		return "TagsItem [t=" + t + ", nIndex=" + nIndex + ", bFirst=" + bFirst + "]";
	}
	
	
	
}