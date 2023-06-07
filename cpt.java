
import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class cpt{
	public static void main(String[] args){
		Console con = new Console("Online Poker", 1280,720);
		
		// Deck stuff
		int intCount = 52;
		int intRow;
		int intDeck[][];
		int intHand[][];
		String strDeck[][];
		String strSortedDeck[][];
		
		intDeck = deckArray(intCount);
		strDeck = loadDeck(intCount);
		strSortedDeck = sortDeck(strDeck, intCount);
		printDeck(strSortedDeck, intCount, con);
		
		TextOutputFile txtHand = new TextOutputFile("playerhand.txt",false);
		intHand = hand(strSortedDeck);
		for(intRow = 1; intRow < 5; intRow++){ 
			txtHand.println(intHand[intRow][0]);
		}
		//
		
		// User interface
		String strChoice;
		char chrChoice;
		BufferedImage imgMenu = con.loadImage("menu.png");
		String strName;
		
		con.println("Enter name:");
		strName = con.readLine();
		
		con.drawImage(imgMenu,320,150);
		con.println("Select an Option:");
		//strChoice = con.readLine();
		chrChoice = con.readChar();
		menu(chrChoice,con);
		
		
	}
	
	public static void menu(char chrChoice,Console con){
		int intCount = 1;
		
		if(chrChoice == 'p' || chrChoice == 'P'){
			con.println("play");
			while(intCount  < 60){
				intCount = intCount+1;
				con.sleep(30);
			}
			play(con);
		}else if(chrChoice == 'h' || chrChoice == 'P'){
			con.println("highscores");
		}else if(chrChoice == 'q' || chrChoice == 'Q'){
			con.println("quit");
		}else if(chrChoice == 'h' || chrChoice == 'H'){
			con.println("help");
		}else{
			con.println("Enter p or h or q or e to make option.");
		}
	
		
	}
	
	public static void play(Console con){
		con.clear();
		
		con.println("Here are your cards");
		
		
	}
	
	// deck array
	public static int[][] deckArray(int intCount){
		TextOutputFile txtText = new TextOutputFile("text.txt",false);
		
		int intDeck[][];
		intDeck = new int[52][3];

		int intRow;
		int intRand;
		int intCounter;

		for(intRow = 0; intRow < intCount; intRow+=13){
						
			intDeck[intRow][0] = 1;
			intDeck[intRow+1][0] = 2;
			intDeck[intRow+2][0] = 3;
			intDeck[intRow+3][0] = 4;
			intDeck[intRow+4][0] = 5;
			intDeck[intRow+5][0] = 6;
			intDeck[intRow+6][0] = 7;
			intDeck[intRow+7][0] = 8;
			intDeck[intRow+8][0] = 9;
			intDeck[intRow+9][0] = 10;
			intDeck[intRow+10][0] = 11;
			intDeck[intRow+11][0] = 12;
			intDeck[intRow+12][0] = 13;
			//txtText.println(intDeck[intRow][0]);
			
		}
		
		for(intRow =0; intRow < intCount; intRow++){
			intRand = (int)(Math.random()*900+100);
			
			intDeck[intRow][2] = intRand;
		}
		
		intCount = 0;
		for(intRow = 0; intRow < 52; intRow+=13){
			intDeck[intRow][1] = intCount;
			intDeck[intRow+1][1] = intCount;
			intDeck[intRow+2][1] = intCount;
			intDeck[intRow+3][1] = intCount;
			intDeck[intRow+4][1] = intCount;
			intDeck[intRow+5][1] = intCount;
			intDeck[intRow+6][1] = intCount;
			intDeck[intRow+7][1] = intCount;
			intDeck[intRow+8][1] = intCount;
			intDeck[intRow+9][1] = intCount;
			intDeck[intRow+10][1] = intCount;
			intDeck[intRow+11][1] = intCount;
			intDeck[intRow+12][1] = intCount;
			//con.println(intRow);
			intCount = intCount+1;
		}
		intCount = 52;
		for(intRow = 0; intRow < intCount; intRow++){
			txtText.println(intDeck[intRow][0]);
			txtText.println(intDeck[intRow][1]);
			txtText.println(intDeck[intRow][2]);
		}
		
		return intDeck;
	}
		
	
	public static String[][] loadDeck(int intCount){
		String strDeck[][];
		strDeck = new String[intCount][3];
		TextInputFile txtText = new TextInputFile("text.txt");
		int intRow;
		for(intRow = 0; intRow < intCount; intRow++){
			strDeck[intRow][0] = txtText.readLine();
			strDeck[intRow][1] = txtText.readLine();
			strDeck[intRow][2] = txtText.readLine();
		}
		txtText.close();
		return strDeck;
	}
	
	public static String[][] sortDeck(String strDeck[][], int intCount){
		String strTemp;
		int intCurrent;
		int intBelow;
		int intCounter;
		int intCounter2;
		
		for(intCounter2 = 0; intCounter2 < intCount -1; intCounter2++){
			for(intCounter = 0; intCounter < intCount - 1; intCounter++){
				intCurrent = Integer.parseInt(strDeck[intCounter][2]);
				intBelow = Integer.parseInt(strDeck[intCounter+1][2]);
				if(intCurrent < intBelow){
					strTemp = strDeck[intCounter][2];
					strDeck[intCounter][2] = strDeck[intCounter+1][2];
					strDeck[intCounter+1][2] = strTemp;
					strTemp = strDeck[intCounter][1];
					strDeck[intCounter][1] = strDeck[intCounter+1][1];
					strDeck[intCounter+1][1] = strTemp;
					strTemp = strDeck[intCounter][0];
					strDeck[intCounter][0] = strDeck[intCounter+1][0];
					strDeck[intCounter+1][0] = strTemp;
				}
			}
		}
		return strDeck;
	}
	public static void printDeck(String strDeck[][], int intCount, Console con){
		TextOutputFile txtSorted = new TextOutputFile("sorteddeck.txt");
		int intCards = 52;
		
		for(intCount = 0; intCount < 52; intCount++){
			txtSorted.print(strDeck[intCount][0] + " - ");
			txtSorted.print(strDeck[intCount][1] + " - ");
			txtSorted.print(strDeck[intCount][2]);
			txtSorted.println(" ");
		}
	}
	
	public static int[][] hand(String strDeck[][]){
		int intHand[][];
		int intCount;
		intHand = new int[5][3];
				
		for(intCount = 0; intCount < 5; intCount++){
			intHand[intCount][0] = Integer.valueOf(strDeck[intCount][0]);
			intHand[intCount][1] = Integer.valueOf(strDeck[intCount][1]);
		}
		
	return intHand;
	}

}
