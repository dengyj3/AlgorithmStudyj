package com.mystudy.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class WordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wordCount = 0;
		Map<String, Integer> map = new HashMap<>();
		String sentence = "hello,my name is Tom,what is your name?he said:\"my name is John\"";
		StringTokenizer tokenizer = new StringTokenizer(sentence);//这个类会将字符串分解成一个个的标记
		while(tokenizer.hasMoreTokens()){
			wordCount++;
			String word = tokenizer.nextToken(", ?.!:\"\"\"\n");
			//括号里的字符的含义是按照,空格?.:"" " \n去分割，如果这里没有明确要求，即括号里为空，则默认按照空格，制表符，新行符和回车符分割
			if(map.containsKey(word)){
				int count = map.get(word);
				map.put(word, count+1);
			}else{
				map.put(word, 1);
			}
		}
		System.out.println("总共单词数: " + wordCount);
		sort(map);
	}

	private static void sort(Map<String, Integer> map) {
		List<Map.Entry<String, Integer>> infoIds = new ArrayList<>(map.entrySet());
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
				return (arg1.getValue()-arg0.getValue());
			}
			
		});
		for(int i=0;i<infoIds.size();i++){
			Entry<String, Integer> id = infoIds.get(i);
			System.out.println(id.getKey() + ":" + id.getValue());
		}
	}

}
