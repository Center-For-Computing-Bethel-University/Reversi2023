/** 
  * @author	 	 Noah Jackson
  * @id          noah.jackson@betheluniversity.edu
  * @course      CSC 321: Programming 3
  * @assignment  Reversi Project
  * @related     ReversiBoard, ReversiPiece, Gui
  */
public class Driver {
	public static void main(String[] args) {
		ReversiBoard board;
		Gui gui;
		ReversiPiece move;
		
		board = new ReversiBoard();
		//gui = new Gui(board);
		move = new ReversiPiece(1);
		
		//use to test out making moves on the game.
		board.makeMove(5,4,move);
		
		//prints game board
		System.out.print("  ");
		for(int i=0; i<8;i++) System.out.print(i + " ");
		
		for(int i=0; i<8;i++) {
			System.out.print("\n");
			System.out.print(i + " ");
			for(int j=0; j<8;j++) {
				System.out.print(board.getPiece(i,j).toChar() + " ");
			}
		}
	}
}
