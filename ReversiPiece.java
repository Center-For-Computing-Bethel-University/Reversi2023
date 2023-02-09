/** 
  * @author	 	 Noah Jackson
  * @id          noah.jackson@betheluniversity.edu
  * @course      CSC 321: Programming 3
  * @assignment  Reversi Project
  * @related     Piece
  */
public class ReversiPiece extends Piece {
	public static final int WHITE = 1;
	public static final int BLACK = 2;
	
	public ReversiPiece(int inType) {
		super(inType);
	}
	
	public void setType(int newType) {
		type = newType;
	}
	
	public int getOpp(int inType) {
		if (inType <= MIN || inType > MAX) return -1;
		if (inType == WHITE) return BLACK;
		else return WHITE;
	}
	
	public char toChar() {
        if (type == WHITE) return 'W'; //White
        if (type == BLACK) return 'B'; //Black
        else return '-'; 		   //Blank
    }
}
