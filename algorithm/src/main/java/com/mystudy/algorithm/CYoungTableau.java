package com.mystudy.algorithm;

import java.util.Random;

/**
 * 杨氏矩阵,行列都是有序的
 * @author 
 *
 */
public class CYoungTableau {
	
	private static int INFINITY = 100000;
	
	private int m_nRow;
	private int m_nCol;
	private int a[][];
	
	public CYoungTableau(int row, int col) {
		init(row, col);
	}
	
	public void init(int row, int col){
		this.m_nRow = row;
		this.m_nCol = col;
		a = new int[row][col];
		for(int i=0;i<m_nRow;i++){
			for(int j=0;j<m_nCol;j++){
				a[i][j] = INFINITY;
			}
		}
	}
	public boolean isBig(int a, int b){
		if (new Random().nextInt() % 2 == 0) {
			return a>=b;
		}
		return a>b;
	}
	public boolean insert(int x){
		int row = m_nRow-1;
		int col = m_nCol-1;
		if (a[row][col] < INFINITY) {//相当于矩阵的最右下角的元素都被占据，所以此时杨氏矩阵已满，不能再继续插入值
			return false;
		}
		a[row][col] = x;
		int r = row;
		int c = col;//行和列初始化,放在矩阵的最右下角
		while(row>0 || col>0){
			if (row>=1 && a[row-1][col]>a[r][c]) {//向上移
				r = row-1;
				c = col;
			}
//			if (col>=1 && a[row][col-1]>a[r][c]) {//向左移,这个生成的矩阵都在上半部分
			if (col>=1 && isBig(a[row][col-1], a[r][c])) {//如果当前元素的左边的值比上边元素的值大,则往左移,这样处理生成的矩阵在左半部分
				r = row;
				c = col - 1;
			}
			if (r == row && c == col) {//找到位置
				break;
			}
			//交换位置
			int temp = a[row][col];
			a[row][col] = a[r][c];
			a[r][c] = temp;
			row = r;
			col = c;
		}
		return true;
	}
	
	public void printArray() {
		for(int i=0;i<m_nRow;i++){
			for(int j=0;j<m_nCol;j++){
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean find(int x, int row, int col){
		row = 0;
		col = m_nCol - 1;
		while(row<m_nRow && col>0){
			if (a[row][col] == x) {
				return true;
			}
			if (x>a[row][col]) {
				row++;
			}else {
				col--;
			}
		}
		return false;
	}
	
	
	public void delete(int row, int col){
		int r = row;
		int c = col;
		while(row<m_nRow && col<m_nCol){
			if (a[row][col] == INFINITY) {
				break;
			}
			if (row+1 < m_nRow) {//还未到最后一行,则往下走
				r = row+1;
				c = col;
			}
			if (col+1<m_nCol && a[row][col+1]<a[r][c]) {//还未到最后一列
				r = row;
				c = col + 1;
			}
			if (row == r && col == c) {
				break;
			}
			a[row][col] = a[r][c];
			row = r;
			col = c;
		}
		a[m_nRow-1][m_nCol-1] = INFINITY;
	}
	
	public static void main(String[] args) {
		CYoungTableau cYoungTableau = new CYoungTableau(5, 4);//将类实例化为对象cy，构造5行4列的矩阵
		System.out.println("before insert is : ");
		cYoungTableau.printArray();
//		int a[] = {50,20,15,3,25,70,40,18,55,10};
		int a[] = {41,67,34,0,69,24,78,58,62};
		for(int i=0;i<a.length;i++){
			System.out.println("第"+i+"次插入:");
			cYoungTableau.insert(a[i]);//将数组的元素依次插入到矩阵中
			cYoungTableau.printArray();//每次插入元素后都打印出相应的杨氏矩阵
		}
		System.out.println(cYoungTableau.find(62, 5, 4));
		System.out.println("before delete: ");
		cYoungTableau.printArray();
		cYoungTableau.delete(1, 1);
		System.out.println("after delete : ");
		cYoungTableau.printArray();
	}
	
}
