package shell_game;
import java.io.*;
import java.util.*;

public class shell {
	public static void main(String[] args) throws IOException {
		BufferedReader infile = new BufferedReader(new FileReader("shell.in"));
		int N = Integer.parseInt(infile.readLine());
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		ArrayList<Integer> g = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String line = infile.readLine();
			a.add(Integer.parseInt(line.split(" ")[0]));
			b.add(Integer.parseInt(line.split(" ")[1]));
			g.add(Integer.parseInt(line.split(" ")[2]));
		}
		
		infile.close();
		
		int highScore = 0;
		for (int i = 1; i <= 3; i++) {
			int currPos = i;
			int currScore = 0;
			for (int j = 0; j < N; j++) {
				if (a.get(j) == currPos) {
					currPos = b.get(j);
				}
				else if (b.get(j) == currPos) {
					currPos = a.get(j);
				}
				
				if (g.get(j) == currPos) {
					currScore += 1;
				}
			}
			
			if (currScore > highScore) {
				highScore = currScore;
			}
		}
		
		PrintWriter outfile = new PrintWriter("shell.out");
		outfile.println(highScore);
		outfile.close();
	}
}
