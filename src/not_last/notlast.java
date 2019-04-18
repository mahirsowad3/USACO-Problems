package not_last;

import java.util.*;
import java.io.*;

public class notlast {
	public static void main(String[] args) throws IOException {
		BufferedReader infile = new BufferedReader(new FileReader("notlast.in"));
		
		int N = Integer.parseInt(infile.readLine());
		HashMap <String, Integer> logs = new HashMap<String, Integer>();
		
		logs.put("Bessie", 0); 
		logs.put("Elsie", 0);
		logs.put("Daisy", 0); 
		logs.put("Gertie", 0);
		logs.put("Annabelle", 0); 
		logs.put("Maggie", 0);
		logs.put("Henrietta", 0); 
		
		for (int i = 0; i < N; i++) {
			String s = infile.readLine();
			Integer newValue = logs.get(s.split(" ")[0]) + Integer.parseInt(s.split(" ")[1]);
			logs.put(s.split(" ")[0], newValue);
		}
	}

}
