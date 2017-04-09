package com.epam.trapeznikau.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public final class DataReader {
	
	final static Logger  logger = LogManager.getLogger(DataReader.class);
	
	public static ArrayList<String> readData(String file){
		BufferedReader br = null;
		String str = "";
		try {
			br = new BufferedReader(new FileReader(file));
			str = br.readLine();
		} catch (FileNotFoundException e) {
			logger.error("File not found");
		} catch (IOException e) {
			logger.error("Somthing wrong");
		}
		StringBuilder line = new StringBuilder();
		
		ArrayList<String> list = new ArrayList<>();
		while (str != null){
			list.add(str);	
			try {
				str = br.readLine();
			} catch (IOException e) {
				logger.error("Somthing wrong");
			}
		}
		return list;
				
		
	}
}
