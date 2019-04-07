package bucket_list;
import java.io.*;
import java.util.Arrays;

public class blist {
	public static void main(String[] args) throws IOException {
		BufferedReader infile = new BufferedReader(new FileReader("blist.in"));
		int N = Integer.parseInt(infile.readLine());
		int buckets = 0;
		int[][] info = new int[N][3];
		for (int i = 0; i < N; i++) {
			String line = infile.readLine();
			for (int j = 0; j < 3; j++) {
				info[i][j] = Integer.parseInt(line.split(" ")[j]);
			}
		}
		System.out.println(Arrays.toString(info[2]));
	}
}
