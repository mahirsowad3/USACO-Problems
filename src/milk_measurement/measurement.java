package milk_measurement;

import java.io.*;
import java.util.*;

public class measurement {
	public static void main(String[] args) throws IOException {
		BufferedReader infile = new BufferedReader(new FileReader("measurement.in"));
		int B = 7, E = 7, M = 7;
		int N = Integer.parseInt(infile.readLine());
		Integer[] days = new Integer[N];
		String[][] logs = new String[N][2];
		
		for (int i = 0; i < N; i++) {
			String s = infile.readLine();
			days[i] = Integer.parseInt(s.split(" ")[0]);
			logs[i][0] = s.split(" ")[1];
			logs[i][1] = s.split(" ")[2];
		}
		
		infile.close();
		
		Integer[] orderedDays = days;
		Arrays.sort(orderedDays);
		
		int changes = 0;
		String currCow = " ";
		for (int i = 0; i < N; i++) {
			if (logs[Arrays.asList(days).indexOf(orderedDays[i])][0].equals("Mildred")) {
				M = newValue(M, logs[i][1]);
				if (M == maxOfThree(B, E, M) && !currCow.equals('m')) {
					currCow = "m";
					changes += 1;
				}
			}
			else if (logs[Arrays.asList(days).indexOf(orderedDays[i])][0].equals("Elsie")) {
				E = newValue(E, logs[i][1]);
				if (E == maxOfThree(B, E, M) && !currCow.equals('e')) {
					currCow = "e";
					changes += 1;
				}
			}
			else if (logs[Arrays.asList(days).indexOf(orderedDays[i])][0].equals("Bessie")) {
				B = newValue(B, logs[i][1]);
				if (B == maxOfThree(B, E, M) && !currCow.equals('b')) {
					currCow = "b";
					changes += 1;
				}
			}
		}
		
		PrintWriter outfile = new PrintWriter("measurement.out");
		outfile.println(changes);
		outfile.close();
	}
	
	public static int newValue(int g, String s) {
		if (s.charAt(0) == '+') {
			g += Integer.parseInt(s.substring(1));
		} else {
			g -= Integer.parseInt(s.substring(1));
		}
		return g;
	}
	
	public static int maxOfThree(int a, int b, int c) {
		int max = 0;
		if (a == b && b == c) {
			return -1;
		}
		if (a > max) {
			max = a;
		}
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		return max;
	}
}
