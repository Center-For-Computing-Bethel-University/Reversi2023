/** 
  * @author	 	 Noah Jackson
  * @id          noah.jackson@betheluniversity.edu
  * @course      CSC 321: Programming 3
  * @assignment  Reversi Project
  * @related     ReversiPiece, Board
  */
public class ReversiBoard extends Board {
	//Fields
	private ReversiPiece[][] pieces;
	private boolean up, upR, right, downR, down, downL, left, upL;
	
	//Constructor
	public ReversiBoard() {
		size = DEFAULTSIZE;
        pieces = new ReversiPiece[size][size];
        up = false;
        upR = false;
        right = false;
        downR = false;
        down = false;
        downL = false;
        left = false;
        upL = false;
		setGame();
	}
	
	//Accessors
	public ReversiPiece getPiece(int row, int column) {
        return pieces[row][column];
    }
	
	//Class methods
	public void setGame() {
        for (int row = 0; row < size; row++)
            for (int column = 0; column < size; column++)
                pieces[row][column] = new ReversiPiece(Piece.BLANK);
        getPiece(3,3).setType(2);
		getPiece(3,4).setType(1);
		getPiece(4,3).setType(1);
		getPiece(4,4).setType(2);
    }	
	
	public void makeMove(int row, int col, ReversiPiece piece) {
		int team, rowStep, colStep;
		team = piece.getType();
		rowStep = row;
		colStep = col;
		
		if(isValid(row, col, piece)) {
			pieces[row][col] = piece;
			//flip over the effected pieces
			
			if(up) { //Up direction
				rowStep--;
				while(getPiece(rowStep,col).getType() == piece.getOpp(team)) {
					getPiece(rowStep,col).setType(team);
					rowStep--;
				}
				rowStep = row;
			}
			//_______________________________________________________________
			if(upR) { //Up-Right direction
				rowStep--;
				colStep++;
				while(getPiece(rowStep,colStep).getType() == piece.getOpp(team)) { 
					getPiece(rowStep,colStep).setType(team);
					rowStep--;
					colStep++;
				}
				rowStep = row;
				colStep = col;
			}
			//_______________________________________________________________
			if(right) { //Right direction
				colStep++;
				while(getPiece(row,colStep).getType() == piece.getOpp(team)) { 
					getPiece(row,colStep).setType(team);
					colStep++;
				}
				colStep = col;
			}
			//_______________________________________________________________
			if(downR) { //down-Right direction
				rowStep++;
				colStep++;
				while(getPiece(rowStep,colStep).getType() == piece.getOpp(team)) {
					getPiece(rowStep,colStep).setType(team);
					rowStep++;
					colStep++;
				}
				rowStep = row;
				colStep = col;
			}
			//_______________________________________________________________
			if(down) { //down direction
				rowStep++;
				while(getPiece(rowStep,col).getType() == piece.getOpp(team)) { 
					getPiece(rowStep,col).setType(team);
					rowStep++;
				}
				rowStep = row;
			}
			//_______________________________________________________________
			if(downL) { //down-left direction
				rowStep++;
				colStep--;
				while(getPiece(rowStep,colStep).getType() == piece.getOpp(team)) { 
					getPiece(rowStep,colStep).setType(team);
					rowStep++;
					colStep--;
				}
				rowStep = row;
				colStep = col;
			}
			//_______________________________________________________________
			if(left) { //left direction
				colStep--;
				while(getPiece(row,colStep).getType() == piece.getOpp(team)) { 
					getPiece(row,colStep).setType(team);
					colStep--;
				}
				colStep = col;
			}
			//_______________________________________________________________
			if(upL) { //Up-left direction
				rowStep--;
				colStep--;
				while(getPiece(rowStep,colStep).getType() == piece.getOpp(team)) { 
					getPiece(rowStep,colStep).setType(team);
					rowStep--;
					colStep--;
				}
				rowStep = row;
				colStep = col;
			}
		}
	}
	
	public boolean isValid(int row, int col, ReversiPiece piece) { 
		int team, rowStep, colStep;
		team = piece.getType();
		rowStep = row;
		colStep = col;
		
		if(row > size || col > size) return false;
		if (pieces[row][col].getType() == Piece.BLANK) { //check for blank type
			
			if(row != 0) { //Up direction
				rowStep--;
				while(getPiece(rowStep,col).getType() == piece.getOpp(team)) { 
					rowStep--;
				}
				if(getPiece(row-1,col).getType() != team)
					if(getPiece(rowStep,col).getType() == team) {up = true; return true;}
				rowStep = row;
			}
			//_____________________________________________________________________________
			if(row != 0 || col != size) { //Up-Right direction
				rowStep--;
				colStep++;
				while(getPiece(rowStep,colStep).getType() == piece.getOpp(team)) { 
					rowStep--;
					colStep++;
				}
				if(getPiece(row-1,col+1).getType() != team)
					if(getPiece(rowStep,colStep).getType() == team) {upR = true; return true;}
				rowStep = row;
				colStep = col;
			}
			//_____________________________________________________________________________
			if(col != size) { //Right direction
				colStep++;
				while(getPiece(row,colStep).getType() == piece.getOpp(team)) { 
					colStep++;
				}
				if(getPiece(row,col+1).getType() != team)
					if(getPiece(row,colStep).getType() == team) {right = true; return true;}
				colStep = col;
			}
			//_____________________________________________________________________________
			if(row != size || col != size) { //down-Right direction
				rowStep++;
				colStep++;
				while(getPiece(rowStep,colStep).getType() == piece.getOpp(team)) { 
					rowStep++;
					colStep++;
				}
				if(getPiece(row+1,col+1).getType() != team)
					if(getPiece(rowStep,colStep).getType() == team) {downR = true; return true;}
				rowStep = row;
				colStep = col;
			}
			//_____________________________________________________________________________
			if(row != size) { //down direction
				rowStep++;
				while(getPiece(rowStep,col).getType() == piece.getOpp(team)) { 
					rowStep++;
				}
				if(getPiece(row+1,col).getType() != team)
					if(getPiece(rowStep,col).getType() == team) {down = true; return true;}
				rowStep = row;
			}
			//_____________________________________________________________________________
			if(row != size || col != 0) { //down-left direction
				rowStep++;
				colStep--;
				while(getPiece(rowStep,colStep).getType() == piece.getOpp(team)) { 
					rowStep++;
					colStep--;
				}
				if(getPiece(row+1,col-1).getType() != team)
					if(getPiece(rowStep,colStep).getType() == team) {downL = true; return true;}
				rowStep = row;
				colStep = col;
			}
			//_____________________________________________________________________________
			if(col != 0) { //left direction
				colStep--;
				while(getPiece(row,colStep).getType() == piece.getOpp(team)) { 
					colStep--;
				}
				if(getPiece(row,col-1).getType() != team)
					if(getPiece(row,colStep).getType() == team) {left = true; return true;}
				colStep = col;
			}
			//_____________________________________________________________________________
			if(row != 0 || col != 0) { //Up-left direction
				rowStep--;
				colStep--;
				while(getPiece(rowStep,colStep).getType() == piece.getOpp(team)) { 
					rowStep--;
					colStep--;
				}
				if(getPiece(row-1,col-1).getType() != team)
					if(getPiece(rowStep,colStep).getType() == team) {upL = true; return true;}
				rowStep = row;
				colStep = col;
			}
		}
		return false;
	}
	
	//Returns the score of a given player
	public int getScore(int team) {
		int counter;
		counter = 0;
		for(int i=0; i<8;i++) 
			for(int j=0; j<8;j++) 
				if(getPiece(i,j).getType() == team) {
					counter++;
				}	
		return counter;
	}
	
	//Checks for possible moves by either team
	public boolean gameOver() {
		ReversiPiece tester = new ReversiPiece(Piece.BLANK);
		
		for(int team=1; team <= 2; team++) {
			tester.setType(team);
			for(int i=0; i<8;i++) 
				for(int j=0; j<8;j++) {
					if(isValid(i,j,tester)) return true;
				}
		}
		return false;
	}
}
