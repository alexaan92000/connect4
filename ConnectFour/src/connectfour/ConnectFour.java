//Alexa Morales CSC 210.1
package connectfour;

import java.util.Scanner;

public class ConnectFour {
public static void main(String[] args) {

String[][] board = createEmptyBoard();
Scanner input = new Scanner(System.in);

boolean bl = true;
printPattern(board);

while (bl) {
int player1 = 1, player2 = 2, userInput;

System.out.println("Please drop a RED disk at the column between 0 and 6:");
userInput = input.nextInt();
dropDisk(board, userInput, player1);
printPattern(board);

System.out.println("Please drop a YELLOW disk at the column between 0 and 6:");
userInput = input.nextInt();
dropDisk(board, userInput, player2);
printPattern(board);
String win = checkWinner(board);

//code to announce if there is winner and end the game
if (win != null) {
if (win == "R") {
System.out.println("CONGRATULATIONS! Red won.");
} else if (win == "Y") {
System.out.println("CONGRATULATIONS! Yellow won.");
}

bl = false;
}
} 
} // end of main

public static String[][] createEmptyBoard() {
//method prints the empty pattern for the game 
String[][] f = new String[7][15];
for (int i = 0; i < f.length; i++) {
for (int j = 0; j < f[i].length; j++) {
if (j % 2 == 0)
f[i][j] = "|";
else
f[i][j] = " ";
if (i == 6)
f[i][j] = "-";
}
}
return f;
} // end of createEmptyBoard

public static void printPattern(String[][] brd) {
//code to print an updated pattern
for (int i = 0; i < brd.length; i++) {
for (int j = 0; j < brd[i].length; j++) {
System.out.print(brd[i][j]);
}
System.out.println();
}
} // end of printPattern

public static void dropDisk(String[][] brd, int positin, int player) {
//code to drop the disk at the position the user entered
if (player == 1) {
int c = 2 * positin + 1;
for (int i = 5; i >= 0; i--) {
if (brd[i][c] == " ") {
brd[i][c] = "R";
break;
}
}
} else {
int c = 2 * positin + 1;
for (int i = 5; i >= 0; i--) {
if (brd[i][c] == " ") {
brd[i][c] = "Y";
break;
}
}
}
} // end of dropDisk

public static String checkWinner(String[][] brd) {
//code to check if there is a winner, if yes return winner
for (int i = 0; i < 6; i++) {
for (int j = 0; j < 7; j += 2) {
if ((brd[i][j + 1] != " ") && (brd[i][j + 3] != " ") && (brd[i][j + 5] != " ") && (brd[i][j + 7] != " ")
&& ((brd[i][j + 1] == brd[i][j + 3]) && (brd[i][j + 3] == brd[i][j + 5])
&& (brd[i][j + 5] == brd[i][j + 7])))
return brd[i][j + 1];
}
}

for (int i = 1; i < 15; i += 2) {
for (int j = 0; j < 3; j++) {
if ((brd[j][i] != " ") && (brd[j + 1][i] != " ") && (brd[j + 2][i] != " ") && (brd[j + 3][i] != " ")
&& ((brd[j][i] == brd[j + 1][i]) && (brd[j + 1][i] == brd[j + 2][i])
&& (brd[j + 2][i] == brd[j + 3][i])))
return brd[j][i];
}
}

for (int i = 0; i < 3; i++) {
for (int j = 1; j < 9; j += 2) {
if ((brd[i][j] != " ") && (brd[i + 1][j + 2] != " ") && (brd[i + 2][j + 4] != " ")
&& (brd[i + 3][j + 6] != " ")
&& ((brd[i][j] == brd[i + 1][j + 2]) && (brd[i + 1][j + 2] == brd[i + 2][j + 4])
&& (brd[i + 2][j + 4] == brd[i + 3][j + 6])))
return brd[i][j];
}
}

for (int i = 0; i < 3; i++) {
for (int j = 7; j < 15; j += 2) {
if ((brd[i][j] != " ") && (brd[i + 1][j - 2] != " ") && (brd[i + 2][j - 4] != " ")
&& (brd[i + 3][j - 6] != " ")
&& ((brd[i][j] == brd[i + 1][j - 2]) && (brd[i + 1][j - 2] == brd[i + 2][j - 4])
&& (brd[i + 2][j - 4] == brd[i + 3][j - 6])))
return brd[i][j];
}
}
return null;
} // end of checkWinner

} 