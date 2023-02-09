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
		
		board = new ReversiBoard();
		gui = new Gui(board);
		
		//prints game board
		for(int i=0; i<8;i++) {
			System.out.print("\n");
			for(int j=0; j<8;j++) {
				System.out.print(board.getPiece(i,j).toChar() + " ");
			}
		}
	}
}
