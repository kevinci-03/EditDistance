import java.io.*;

public class EditDistance {

	public static void main(String[] args) {

	String path = "/home/k3p4/calpoly/csc_349/Asgn2-EditDistance/mytest.txt";
	try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
    	String firstString = reader.readLine();
		String secondString = reader.readLine();
		reader.close();
		int[][] table = Funcs.computeDistance(firstString, secondString);
		Funcs.traceback(firstString, secondString, table);
    }
    catch (IOException e) {
		System.out.println("File not found");
    }

  }

}