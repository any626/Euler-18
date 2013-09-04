import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Euler18 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String directory = "C:\\Users\\alanderos\\Desktop\\triangle.txt";

		int[][] triangleArray = readFile(directory);
		System.out.println(bigSum(triangleArray));

	}
	
	public static int bigSum(int[][] array){
		for(int i = array.length-1;i >= 1; i --){
			for(int j = i; j >=1;j--){
				if(array[i][j] > array[i][j-1])
					array[i-1][j-1] += array[i][j];
				else
					array[i-1][j-1] += array[i][j-1];
			}
		}
		
		return array[0][0];
	}

	public static int[][] readFile(String directory) {
		int[][] triangle = new int[15][15];
		try {
			BufferedReader file = new BufferedReader(new FileReader(directory));
			String s;
			String[] line;
			int[] newRow;
			int i = 0;
			while ((s = file.readLine()) != null) {
				line = s.split(" ");
				newRow = new int[line.length];
				for (int j = 0; j < line.length; j++) {
					newRow[j] = Integer.parseInt(line[j]);
				}
				triangle[i] = newRow;
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return triangle;
	}

}
