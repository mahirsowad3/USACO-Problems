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
		
		System.out.println(Arrays.deepToString(orderedLogs(days, logs)));
		logs = orderedLogs(days, logs);
		String currCow = " ";
		int changes = 0;
		for (int i = 0; i < N; i++) {
			if (logs[i][0].equals("Bessie")) {
				B = newValue(B, logs[i][1]);
				if (maxOfThree(B, E, M) == -1 && !currCow.equals("bem")) {
					currCow = "bem";
					changes += 1;
				}
				else if (maxOfThree(B, E, M) == -2 && !currCow.equals("be")) {
					currCow = "be";
					changes += 1;
				}
				else if (maxOfThree(B, E, M) == -3 && !currCow.equals("em")) {
					currCow = "em";
					changes += 1;
				}
				else if (maxOfThree(B, E, M) == -4 && !currCow.equals("bm")) {
					currCow = "bm";
					changes += 1;
				}
				else if (B == maxOfThree(B, E, M) && !currCow.equals("b")) {
					currCow = "b";
					changes += 1;
				} 
				else if (E == maxOfThree(B, E, M) && !currCow.equals("e")) {
					currCow = "e";
					changes += 1;
				}
				else if (M == maxOfThree(B, E, M) && !currCow.equals("m")) {
					currCow = "m";
					changes += 1;
				}
			}
			if (logs[i][0].equals("Elsie")) {
				E = newValue(E, logs[i][1]);
				if (maxOfThree(B, E, M) == -1 && !currCow.equals("bem")) {
					currCow = "bem";
					changes += 1;
				}
				else if (maxOfThree(B, E, M) == -2 && !currCow.equals("be")) {
					currCow = "be";
					changes += 1;
				}
				else if (maxOfThree(B, E, M) == -3 && !currCow.equals("em")) {
					currCow = "em";
					changes += 1;
				}
				else if (maxOfThree(B, E, M) == -4 && !currCow.equals("bm")) {
					currCow = "bm";
					changes += 1;
				}
				else if (E == maxOfThree(B, E, M) && !currCow.equals("e")) {
					currCow = "e";
					changes += 1;
				}
				else if (B == maxOfThree(B, E, M) && !currCow.equals("b")) {
					currCow = "b";
					changes += 1;
				} 
				else if (M == maxOfThree(B, E, M) && !currCow.equals("m")) {
					currCow = "m";
					changes += 1;
				}
			}
			if (logs[i][0].equals("Mildred")) {
				M = newValue(M, logs[i][1]);
				if (maxOfThree(B, E, M) == -1 && !currCow.equals("bem")) {
					currCow = "bem";
					changes += 1;
				}
				else if (maxOfThree(B, E, M) == -2 && !currCow.equals("be")) {
					currCow = "be";
					changes += 1;
				}
				else if (maxOfThree(B, E, M) == -3 && !currCow.equals("em")) {
					currCow = "em";
					changes += 1;
				}
				else if (maxOfThree(B, E, M) == -4 && !currCow.equals("bm")) {
					currCow = "bm";
					changes += 1;
				}
				else if (M == maxOfThree(B, E, M) && !currCow.equals("m")) {
					currCow = "m";
					changes += 1;
				}
				else if (B == maxOfThree(B, E, M) && !currCow.equals("b")) {
					currCow = "b";
					changes += 1;
				} 
				else if (E == maxOfThree(B, E, M) && !currCow.equals("e")) {
					currCow = "e";
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
			g += Integer.parseInt(s.substring(1, s.length()));
		} else {
			g -= Integer.parseInt(s.substring(1, s.length()));
		}
		return g;
	}
	
	public static int maxOfThree(int a, int b, int c) {
		int max = Math.max(Math.max(a,  b), c);
		if (a == b && b == c) {
			return -1;
		}
		else if (a == max && b == max && c != max) {
			return -2;
		}
		else if (a != max && b == max & c == max) {
			return -3;
		}
		else if(a == max && b != max && c == max) {
			return -4;
		}
		else {
			return max;
		}
	}
	
	public static String[][] orderedLogs(Integer[] days, String[][] logs) {
		String[][] newOrder = new String[days.length][2];
		int index = 0;
		for (int i = 0; i <= 100; i++) {
			for (int j: days) {
				if (i == j) {
					newOrder[index][0] = logs[Arrays.asList(days).indexOf(j)][0];
					newOrder[index][1] = logs[Arrays.asList(days).indexOf(j)][1];
					index ++;
				}
			}
		}
		return newOrder;
	}
}
