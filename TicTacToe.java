/**
 * Program that uses a 2D array to create a Tic Tac Toe game
 * @author Jesse Gallarzo
 * @author Adrian Francisco Rodriguez
 */
import java.util.Scanner;

public class TicTacToe{

    static String[][] squares = new String[3][3];
    static String answer;
    static String rep;
    static int pos;
    static String winner = "blank";
    static boolean replay = true;
  
  /**
   * Method that prints out the 3x3 grid for Tic Tac Toe.
   */
  public static void printGrid(){
   
    System.out.println();
    System.out.println("     ||"+ squares[0][0]+  "||"+squares[0][1]+  "||"+squares[0][2]+  "||");
    System.out.println("====================");
    System.out.println("     ||"+ squares[1][0]+  "||"+squares[1][1]+  "||"+squares[1][2]+  "||");
    System.out.println("====================");
    System.out.println("     ||"+ squares[2][0]+  "||"+squares[2][1]+  "||"+squares[2][2]+  "||");
    System.out.println();
    
  }
  
    /**
   * Method that adds the user's answer to the Tic Tac Toe grid.
   */
  public static void addAnswer(){
   int count = 0;
     for(int row = 0; row < 3; row++){
      for(int col = 0; col < 3; col++){
       
        if(count == (pos-1)){
          squares[row][col] = answer;
        }
        count++;
      }
    }
  }
  
    /**
   * Method that checks if the grid is all full. 
   * @return True if the grid is full. False otherwise.
   */
  public static boolean isFull(){
    int count = 0; 
    for(int row = 0; row < 3; row++){
       for(int col = 0; col < 3; col++){
         if(squares[row][col] != null){
           count++;
         }
       }
    }
    if(count == 9){
      return true;
    }
   return false;
  }
  
    /**
   * Method that returns true if either player has met any of the possible win conditions.
   * @return True if one of the players triggers the win condition. False otherwise.
   */
  public static boolean playerWon(){
  
   //rows
   for(int a = 0; a < 3; a++){
     if(squares[a][0] != null && squares[a][1] != null && squares[a][2] != null){
       if(String.valueOf(squares[a][0]).compareTo(squares[a][1]) == 0 && String.valueOf(squares[a][0]).compareTo(squares[a][2]) == 0){
         winner = answer;
         return true;
       }
     }
   }
   
   //columns
   for(int b = 0; b < 3; b++){
     if(squares[0][b] != null && squares[1][b] != null && squares[2][b] != null){
       if(String.valueOf(squares[0][b]).compareTo(squares[1][b]) == 0 && String.valueOf(squares[0][b]).compareTo(squares[2][b]) == 0){
         winner = answer;
         return true;
       }
     }
   }
   
   //Left to Right Diagonal
   if(squares[0][0] != null && squares[1][1] != null && squares[2][2] != null){
     if(String.valueOf(squares[0][0]).compareTo(squares[1][1]) == 0 && String.valueOf(squares[0][0]).compareTo(squares[2][2]) == 0){
       winner = answer;
       return true;
     }
   }   
   
   //Right to Left Diagonal
    if(squares[0][2] != null && squares[1][1] != null && squares[2][0] != null){
     if(String.valueOf(squares[0][2]).compareTo(squares[1][1]) == 0 && String.valueOf(squares[0][2]).compareTo(squares[2][0]) == 0){
       winner = answer;
       return true;
     }
   } 
    //If none of the conditions are met
    return false;
  }

//    public boolean replay(String doReplay){
//        if(doReplay == "no")
//            return false;
//        return true;
//    }
  
   /**
   * Main method.
   */
  public static void main(String[] args) {
      while (replay) {
          //Give the user instructions on how to play.
          System.out.println("This let's you play Tic Tac Toe from the command line.");
          System.out.println("Each position(from 1 to 9,left to right,top to bottom) represents a position in the grid.");
          System.out.println("The player who fills up a row/column/diagonal line with either X's or O's wins.");
          System.out.println("Let's begin!");

          //Prints first grid to give users an idea of what the grid looks like.
          printGrid();

          //While loop that continues to loop until win/loss condition is met.
          while (!isFull() && !playerWon()) {
              Scanner keyboard = new Scanner(System.in);

              System.out.println("X or O ?");
              answer = keyboard.nextLine(); //Use a loop to make sure the proper 'letters' are being used.

              System.out.println("In which position(row)?");
              pos = keyboard.nextInt();
              addAnswer();
              printGrid();

          }
          //Once a condition is met...
          Scanner keyboard2 = new Scanner(System.in);
          if (isFull() && !winner.equals("x") && !winner.equals("o")){
              System.out.println("Game Over....play again?");
              rep = keyboard2.nextLine();
              if(rep.equals("no"))
                  replay = false;
          }
          if (winner.equals("x")){
              System.out.println("Xs are the winner!!! Play again?");
              rep = keyboard2.nextLine();
              if(rep.equals("no"))
                  replay = false;
          }
          if (winner.equals("o")) {
              System.out.println("Os are the winner!!! Play again?");
              rep = keyboard2.nextLine();
              if(rep.equals("no"))
                  replay = false;
          }
      }
  }
}
