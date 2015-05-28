import java.util.Scanner;
/**
 * Program that uses a 2D array to create a Tic Tac Toe game
 * @author Jesse G
 */
public class TicTacToe{
  
  static String[][] squares = new String[3][3];
  static String answer;
  static int pos;
  static String winner;
  static String xWinner = "x";
  static String oWinner = "o";
  Scanner keyboard;
  
  /**
   * Method that prints out the 3x3 grid for Tic Tac Toe
   */
  public static void printGrid(){
   
    System.out.println("  |"+ squares[0][0]+  "|"+squares[0][1]+  "|"+squares[0][2]+  "|");
    System.out.println("--------------------");
    System.out.println("  |"+ squares[1][0]+  "|"+squares[1][1]+  "|"+squares[1][2]+  "|");
    System.out.println("--------------------");
    System.out.println("  |"+ squares[2][0]+  "|"+squares[2][1]+  "|"+squares[2][2]+  "|");
    
  }
  
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
  
  
  //This method is causing a Null Pointer Exception COME BACK LATER
  public static boolean playerWon(){
   
   String test = String.valueOf(squares[0][0]);
   //if(String.valueOf(squares[0][0]).equals(answer))
    if(String.valueOf(squares[0][1]).equals(answer)){
      if(String.valueOf(squares[0][2]).equals(answer)){
        winner = answer;
        return true;
        }
    }
    
        
    if(String.valueOf(squares[1][0]).equals(answer))
      if(String.valueOf(squares[1][1]).equals(answer))
        if(String.valueOf(squares[1][2]).equals(answer)){
          winner = answer;
          return true;
         }
          
    if(String.valueOf(squares[2][0]).equals(answer))
      if(String.valueOf(squares[2][1]).equals(answer))
        if(String.valueOf(squares[2][2]).equals(answer)){
          winner = answer;
          return true;
        }
    return false;
  }
  
  
  public static void main(String[] args){
    
    while(!isFull() && !playerWon()){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("X or O ?");
    answer = keyboard.nextLine();
    
    System.out.println("In which position(row)?");
    pos = keyboard.nextInt();
    addAnswer();
    printGrid();
  
    }
    if(winner.equals(xWinner))
         System.out.println("Xs are the winner!!!");
    if(winner.equals(oWinner))
         System.out.println("Os are the winner!!!");
     else
         System.out.println("Game Over....");
  }
}
