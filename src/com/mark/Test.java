package com.mark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	static ArrayList<String> readLines(String file) throws Exception{
		ArrayList<String> lines = new ArrayList<>();
		File f = new File(file);
		
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String line=null;
		while ((line=reader.readLine()) != null){
			lines.add(line);
		}
		return lines;
	}
	
	
	static Map <String, AnswerKey> createAsnwerKeyMap(List<String> lines) throws Exception{
		
		Map <String, AnswerKey> keyMap = new HashMap<>();
		for (String line : lines){
			String [] vals = line.split(",");
			AnswerKey obj = new AnswerKey(vals[0],vals[1], Integer.parseInt(  vals[2]));
			keyMap.put(obj.getQno(), obj);
		}
		return keyMap;
	}
	
	static Map <String, String> createAsnwerSheetMap(List<String> lines) throws Exception{
		
		Map <String, String> sheetMap = new HashMap<>();
		for (String line : lines){
			String [] vals = line.split(",");
			sheetMap.put(vals[0], vals[1]);
		}
		return sheetMap;
	}
	
	static int processMark ( Map <String, AnswerKey>  akMap,  Map <String, String>  asMap ){
		int totalmark =0;
		
		for (Map.Entry <String, String> entry   : asMap.entrySet()){
			String qno = entry.getKey();
			String ans= entry.getValue();
			AnswerKey correctAns = akMap.get(qno);
			if (correctAns.getAnswer().equals(ans)){
				totalmark= totalmark+ correctAns.getMark();
			}
		}
		
		return totalmark;
		
	}
	
	
	public static void main(String[] args)throws Exception {
		
		
		ArrayList<String> aklines = readLines ("/home/expertzlab/marksheet/aswerkey.txt");
		System.out.println(aklines);
		
		ArrayList<String> aslines = readLines ("/home/expertzlab/marksheet/aswersheet.txt");
		System.out.println(aslines); 
		
		 Map <String, AnswerKey>  akMap= createAsnwerKeyMap (aklines);
		 Map <String, String>  asMap= createAsnwerSheetMap (aslines);
		 
		 int mark = processMark(akMap,asMap );
		 System.out.println(mark);
		
	}

}
