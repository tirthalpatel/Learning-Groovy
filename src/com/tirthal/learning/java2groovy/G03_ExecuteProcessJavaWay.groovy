package com.tirthal.learning.java2groovy

// Java code - using java.lang.Process to interact with a system-level process
public class G03_ExecuteProcessJavaWay {
	public static void main(String[] args) {
		try {
			Process proc = Runtime.getRuntime().exec("cmd /C dir" );
			
			BufferedReader result = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line;
			while((line = result.readLine()) != null) {
				System.out.println(line);
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
