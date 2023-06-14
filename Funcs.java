public class Funcs {

    public static int[][] computeDistance(String firstString, String secondString) {

        int row = firstString.length();
        int col = secondString.length();

        int[][] table = new int[row + 1][col + 1];

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                if (i == 0) {
                    table[i][j] = j * 2;  // fills 0 row with increasing values for better calculations
                }
                else if (j == 0) {
                    table[i][j] = i * 2;  // fills 0 col with increasing values for better calculations
                }
                else if (firstString.charAt(i - 1) == secondString.charAt(j - 1)) {  // If we have a match then we check the diagonal back
                    table[i][j] = table[i - 1][j - 1];  // we get diagonal with no cost
                }
                else {  // strings do not match
                    int mismatch = table[i - 1][j - 1] + 1;  // mismatch so we pay the +1 cost
                    int deletion = table[i - 1][j] + 2;  // deletion or (gap) needed so +2 cost
                    int insertion = table[i][j - 1] + 2;  // insertion or (gap) needed so +2 cost
                    table[i][j] = Math.min(mismatch, Math.min(deletion, insertion));  // we take the minimum of the three operations
                }
            }
        }

        System.out.println("Edit Distance = " + table[row][col]);  // Solution is always in the [row][col] position so we return that
        return table;  // We return the table to do traceback on

    }

    public static void traceback(String firstString, String secondString, int[][] table) {

        int i = firstString.length();
        int j = secondString.length();

        StringBuilder output = new StringBuilder();  // String builder used to build result output
        
        while(i > 0 && j > 0) {
            if (firstString.charAt(i - 1) == secondString.charAt(j - 1)) {  // strings match situation
                output.insert(0, firstString.charAt(i - 1) + " " + secondString.charAt(j - 1) + " 0\n");  // add the characters with 0 penalty
                i--;
                j--;
            }
            else if (table[i][j] == table[i - 1][j - 1] + 1) {  // mismatch situation
                output.insert(0, firstString.charAt(i - 1) + " " + secondString.charAt(j - 1) + " 1\n");  // add characters but with +1 penalty
                i--;
                j--;
            }
            else if (table[i][j] == table[i - 1][j] + 2) {  // delete or (gap) situation
                output.insert(0, firstString.charAt(i - 1) + " - 2\n");  // add characters but with +2 penalty for gap
                i--;
            }
            else if (table[i][j] == table[i][j - 1] + 2) {  // insetion or (gap) situation
                output.insert(0, "- " + secondString.charAt(j - 1) + " 2\n");  // add characters but with +2 penalty for gap
                j--;
            }
        }
        
        // we run these loops to add gaps if one string is longer than the other with +2 penalty for every gap
        while (i > 0) {
            output.insert(0, firstString.charAt(i - 1) + " - 2\n");
            i--;
        }
        while (j > 0) {
            output.insert(0, "- " + secondString.charAt(j - 1) + " 2\n");
            j--;
        }

        System.out.println(output.toString());  // we output the StringBuider

    }

}