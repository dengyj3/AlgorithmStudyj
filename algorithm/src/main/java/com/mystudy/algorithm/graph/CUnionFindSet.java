package com.mystudy.algorithm.graph;

public class CUnionFindSet {
	private int m_nN;
	private int[] m_pParent;
	
	public CUnionFindSet(int n) {
		// TODO Auto-generated constructor stub
		m_nN = n;
		m_pParent = new int[m_nN];
		for(int i=0;i<m_nN;i++){
			m_pParent[i] = i;
		}
	}
	
	public int find(int i){
		if (i<0 || i>=m_nN) {
			return -1;
		}
		int root = i;
		while(root != m_pParent[root]){//尚未到根节点
			root = m_pParent[root];
		}
		int t = i;
		int p;
		while(t!=root){
			p = m_pParent[t];//t2的原父节点
			m_pParent[t] = root;//t2的父节点直接赋值给根t
			t= p;//沿着原来的父节点继续向上查找
		}
		return root;
	}
	
	public void union(int i, int j){
		if (i<0 || i>=m_nN || j<0 || j>=m_nN) {
			return;
		}
		int ri = find(i);
		int rj = find(j);
		if (ri != rj) {
			m_pParent[ri] = rj;
		}
	}
	public static int calcComponet(){
		int N = 10;//岛屿数量
		CUnionFindSet cUnionFindSet = new CUnionFindSet(N);
		cUnionFindSet.union(2, 6);
		cUnionFindSet.union(5, 6);
		cUnionFindSet.union(1, 8);
		cUnionFindSet.union(2, 9);
		cUnionFindSet.union(5, 3);
		cUnionFindSet.union(4, 8);
		cUnionFindSet.union(4, 0);
		
		int[] component = new int[N];
		for(int i=0;i<N;i++){//计算每个岛屿的"首府"
			component[cUnionFindSet.find(i)]++;
		}
		int nComponent = 0;//统计"首府"的数目
		for(int i=0;i<N;i++){
			if (component[i] != 0) {
				nComponent++;
			}
		}
		return nComponent;
	}
	public static void main(String[] args) {
		int x = calcComponet();
		System.out.println(x);
	}
}
