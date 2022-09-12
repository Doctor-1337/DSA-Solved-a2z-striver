package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.basics.pattern.Pattern1;

public class Driver {

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(
	            new InputStreamReader(System.in));
	 
	        // Reading data using readLine
	        String noOfLines = null;
			try {
				noOfLines = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int n = Integer.parseInt(noOfLines);
	 
	        // Printing the read line
			
			Pattern1.printPattern1(n);

			
			
	}

}
