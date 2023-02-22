/** 
  * @author	 	 Noah Jackson
  * @id          noah.jackson@betheluniversity.edu
  * @course      CSC 321: Programming 3
  * @assignment  Reversi Project
  * @related     ReversiBoard, ReversiPiece
  */
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;

public class Gui extends JFrame{
    private JButton[][] buttons;
    private JButton reset,quit, save, load;
    private JLabel player1, player2;
    private Listener myListener;    
    private Color black;
    private Color green;
    private Color white;
    private ReversiBoard game;
    
    
    public Gui(ReversiBoard game) {
    	buttons = new JButton[Board.DEFAULTSIZE][Board.DEFAULTSIZE];
    	myListener = new Listener();
    	black = new Color(0,0,0);
    	green = new Color(31,83,18);
    	white = new Color(253, 255, 242);
    	this.game = game;
    	
    	//Initializes an array of buttons
    	for(int i=0; i < Board.DEFAULTSIZE; i++)
    		for(int j=0; j < Board.DEFAULTSIZE; j++) {
    			buttons[i][j] = new JButton(" ");
    			buttons[i][j].setBackground(green);
    			buttons[i][j].addActionListener(myListener);
    	        buttons[i][j].setEnabled(true);
    	        buttons[i][j].setSize(1000, 1000);
    		}
    	updateGraphics();
        setGraphics();
    }
    
    //Synchronizes the buttons color with the current game status
    public void updateGraphics() {
    	int team;
    	team = -1;
    	//Checks each Piece and sets the corresponding button color
    	for(int i=0; i < Board.DEFAULTSIZE; i++)
    		for(int j=0; j < Board.DEFAULTSIZE; j++) {
    			team = game.getPiece(i, j).getType();
    		
    			if(team == Piece.BLANK) 
    				buttons[i][j].setBackground(green);
    			if(team == ReversiPiece.WHITE) 
    				buttons[i][j].setBackground(white);
    			if(team == ReversiPiece.BLACK) 
    				buttons[i][j].setBackground(black);
    		}
    }

    //Creates the Graphics
    public void setGraphics() {
        JPanel gamePanel, infoPanel;
        Container myPane;
        
        //Creates the pane
        myPane = getContentPane();
        myPane.setLayout(new GridLayout(2,1));
        
        //Creates the game board
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(8,8));
        myPane.add(gamePanel);
        
        //Creates information panel
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(1,8));
        myPane.add(infoPanel);
        
        //Adds array of buttons to the gamePanel
        for(int i=0; i < Board.DEFAULTSIZE; i++)
    		for(int j=0; j < Board.DEFAULTSIZE; j++)
    			gamePanel.add(buttons[i][j]); 
    		
        //adds information to the infoPanel
        player1 = new JLabel();
        player1.setText("Player 1: "+ game.getScore(ReversiPiece.WHITE) +""); 
        player1.setFont(new Font("Serif", Font.BOLD, 30));
        infoPanel.add(player1);
        player2 = new JLabel();
        player2.setText("Player 2: "+ game.getScore(ReversiPiece.BLACK) +"");
        player2.setFont(new Font("Serif", Font.BOLD, 30));
        infoPanel.add(player2);
        
        //creates and adds the reset buttons
        reset = new JButton("Reset");
        reset.addActionListener(myListener);
        reset.setEnabled(true);
        reset.setSize(1000, 1000);
        infoPanel.add(reset);
        
      //creates and adds the quit buttons
        quit = new JButton("Quit");
        quit.addActionListener(myListener);
        quit.setEnabled(true);
        quit.setSize(1000, 1000);
        infoPanel.add(quit);
        
      //creates and adds the save buttons
        save = new JButton("Save Game");
        save.addActionListener(myListener);
        save.setEnabled(true);
        save.setSize(1000, 1000);
        infoPanel.add(save);
        
      //creates and adds the load Game buttons
        load = new JButton("Load Game");
        load.addActionListener(myListener);
        load.setEnabled(true);
        load.setSize(1000, 1000);
        infoPanel.add(load);
        
        //configures the swing window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        setVisible(true);
    }

    //Determines what the buttons do when pressed
    public class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	
        	//checks if the rest button was pressed, and resets the board
        	if(e.getSource()==reset) {
        		game.setGame();
        		updateGraphics();
        	}
        	//if quit is pressed, window is terminated
        	if(e.getSource()==quit) {
        		System.exit(ABORT);
        	}
        	//Checks if any of the game buttons have been pressed
        	for(int i=0; i < Board.DEFAULTSIZE; i++)
        		for(int j=0; j < Board.DEFAULTSIZE; j++) 
        			if(e.getSource()==buttons[i][j]) { 
        				
        				//PlaceHolder Code until GUI functions with ReversiBoard
        				if(buttons[i][j].getBackground()== black) {
                			buttons[i][j].setBackground(white);
                		} else { 
                			buttons[i][j].setBackground(black);
                		}
        			}
        } 
    }
}