package fence_painting;

import java.util.*;
import java.io.*;

public class paint {
	public static void main(String args[]) throws IOException{
		Scanner infile = new Scanner(new File("paint.in"));
		int[] farmer = new int[2];
		int[] cow = new int[2];
		
		farmer[0] = infile.nextInt();
		farmer[1] = infile.nextInt();
		cow[0] = infile.nextInt();
		cow[1] = infile.nextInt();
		
		int fencePainted = (farmer[1] - farmer[0]) + (cow[1] - cow[0]) - findOverlap(farmer, cow);
		
		infile.close();
		PrintWriter outfile = new PrintWriter("paint.out");
		outfile.println(fencePainted);
		outfile.close();
		
	}
	
	public static int findOverlap(int[] f, int[] c) {
		boolean farmerStart = true;
		boolean farmerEnd = false;
		if (f[0] > c[0]) {
			farmerStart = false;
		}
		if (c[1] < f[1]) {
			farmerEnd = true;
		}
		
		if (farmerStart && farmerEnd) {
			return c[1] - c[0];
		}
		if (!farmerStart && !farmerEnd) {
			return f[1] - f[0];
		}
		
		if (farmerStart && !farmerEnd) {
			if (f[1] < c[0]) {
				return 0;
			} else {
				return f[1] - c[0];
			}
		}
		if (!farmerStart && farmerEnd) {
			if (c[1] < f[0]) {
				return 0;
			} else {
				return c[1] - f[0];
			}
		}
		return 0;
	}

}
