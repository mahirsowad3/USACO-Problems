package not_last;

import java.util.*;
import java.io.*;

public class notlast {
	public static void main(String[] args) throws IOException {
		BufferedReader infile = new BufferedReader(new FileReader("notlast.in"));
		
		int N = Integer.parseInt(infile.readLine());
		String[] cows = {"Bessie", "Elsie", "Daisy", "Gertie", "Maggie", "Annabelle", "Henrietta"};
		Integer[] milk = new Integer[7];
		
		for (int i = 0; i < 7; i++) {
			milk[i] = 0;
		}
		
		for (int i = 0; i < N; i++) {
			String s = infile.readLine();
			Integer newValue = milk[Arrays.asList(cows).indexOf(s.split(" ")[0])] + Integer.parseInt(s.split(" ")[1]);
			milk[Arrays.asList(cows).indexOf(s.split(" ")[0])] = newValue;
		}
		
		System.out.println(Collections.min(Arrays.asList(milk)));
		System.out.println(Arrays.asList(milk).indexOf(7));
	}
	
	public static void secondSmallest(int[] arr) {
		//
	}

}
