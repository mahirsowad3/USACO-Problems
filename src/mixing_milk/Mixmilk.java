package mixing_milk;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Mixmilk {
	public static void main(String[] args) throws IOException {
		BufferedReader infile = new BufferedReader(new FileReader("mixmilk.in"));
		BufferedWriter out = new BufferedWriter(new FileWriter("mixmilk.out"));
		String test = infile.readLine();
		String test2 = infile.readLine();
		String test3 = infile.readLine();
		infile.close();
		out.write(test);
		out.newLine();
		out.write(test2);
		out.newLine();
		out.write(test3);
		out.close();
	}
}
