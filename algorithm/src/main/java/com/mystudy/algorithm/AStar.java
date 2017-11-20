package com.mystudy.algorithm;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import org.apache.commons.io.FileUtils;

public class AStar {
	private static float INFINITY =	10000000;
	public static void main(String[] args) {
//		CPoint city1 = new CPoint(1.0f, 2.0f, "bj");
//		CPoint city2 = new CPoint(4.0f, 6.0f, "sh");
//		System.out.println(CPoint.distance(city1, city2));
		String fileName = System.getProperty("user.dir") + File.separator + "config" + File.separator + "AStar_data.txt";
		Vector<CPoint> points = new Vector<>();
		float x,y;
		String str;
		try {
			List<String> list = FileUtils.readLines(new File(fileName));
			CPoint cPoint = null;
			for (String string : list) {
//				System.out.println(string);
				String[] strings = string.split("	");
				x = Float.parseFloat(strings[0]);
				y = Float.parseFloat(strings[1]);
				str = strings[2];
				cPoint = new CPoint(x/1000, y/1000, str);
				points.add(cPoint);
			}
			
			int N = points.size();
			Vector<Vector<Float>> graph = new Vector<>();
			int i,j;
			for(i=0;i<N;i++){
				Vector<Float> vector = new Vector<>();
				for(j=i;j<N;j++){
					vector.add(CPoint.distance(points.get(i), points.get(j)));
					if (graph.get(i).get(j) < 300) {
						
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void aStar(Vector<Vector<Float>> graph, int start, int end, Vector<CPoint> p){
		int N = graph.size();
		int[] type = new int[N];//0:新点, 1:边点, 2:内点
		float[] f = new float[N];//经过f[i]的start到end的估计值
		float[] g = new float[N];//从start到g[i]的精确值
		float[] h = new float[N];//从h[i]到end的估计值
		int[] pre = new int[N];//pre[i]:i的前驱
		//初始化
		int k;
		for(k=0;k<N;k++){
			g[k] = graph.get(start).get(k);//到点距离
			h[k] = CPoint.distance(p.get(k), p.get(end));//离点距离
			f[k] = g[k] + h[k];//总距离
			pre[k] = -1;
			type[k] = 0;
		}
		
		//start加入边点集合
		type[start] = 1;
		g[start] = 0;
		f[start] = h[start];
		
		float d = 0;
		int j = start;
		while(j!=end){//尚未到达end
			//选择边点集合中f[i]最小的
			j = -1;
			for(k=0;k<N;k++){
				if (type[k] != 1) {//k必须是边点
					continue;
				}
				if (j==-1 || d>f[k]) {
					d = f[k];
					j = k;
				}
			}
			
			for(k=0;k<N;k++){
				if (graph.get(j).get(k) >= INFINITY) {
					continue;
				}
				if (type[k] == 0) {
					if (g[k] > g[j] + graph.get(j).get(k)) {
						g[k] = g[j] + graph.get(j).get(k);
						f[k] = g[k] + h[k];
					}
					type[k] = 1;
					pre[k] = j;
				}else if (type[k] == 2) {//i是内点
					if (g[k] > g[j] + graph.get(j).get(k)) {
						g[k] = g[j] + graph.get(j).get(k);
						f[k] = g[k] + h[k];
						type[k] = 1;
						pre[k] = j;
					}
				}else if (type[k] == 1) {
					if (g[k]>g[j] + graph.get(j).get(k)) {
						g[k] = g[j] + graph.get(j).get(k);
						f[k] = g[k] + h[k];
						pre[k] = j;
					}
				}
				
			}
			type[j] = 2;//边点为成内点
		}
		//恢复路径
		Vector<Integer> path = new Vector<>();
		path.add(end);
		while(pre[end] != -1){
			end = pre[end];
			path.add(end);
		}
		//交换首尾元素
		int first = path.firstElement();
		path.set(0, path.lastElement());
		path.set(path.size()-1, first);
		
		float m = 0;//输出路径的结点
		for(k = 0; k<path.size();k++){
			System.out.println(p.get(path.get(k)).getName());
			if (k!=0) {
				m += graph.get(path.get(k-1)).get(path.get(k));
			}
			
		}
		System.out.println(m);
	}
}

class CPoint{
	private float x;
	private float y;
	private String name;
	
	public CPoint(float x, float y, String name){
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public static float distance(CPoint city1, CPoint city2){
		float x = city1.x - city2.x;
		float y = city1.y - city2.y;
		float s = x*x + y*y;
		return (float)Math.sqrt(s);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}