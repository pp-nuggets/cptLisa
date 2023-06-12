
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
		int intSortedHand[][];
		String strDeck[][];
		String strSortedDeck[][];
		
		intDeck = deckArray(intCount);
		strDeck = loadDeck(intCount);
		strSortedDeck = sortDeck(strDeck, intCount);
		printDeck(strSortedDeck, intCount, con);
		
		
		intHand = hand(strSortedDeck);
		intSortedHand = sortHand(intHand,intCount);
		printSortedhand(intSortedHand, con);
		
		//
		
		// User interface
		char chrChoice;
		BufferedImage imgMenu = con.loadImage("menu.png");
		String strName;
		
		con.println("Enter name:");
		strName = con.readLine();
		
		con.drawImage(imgMenu,320,150);
		con.println("Select an Option:");
		chrChoice = con.readChar();
		
		int intCount1 = 1;
		
		if(chrChoice == 'p' || chrChoice == 'P'){
			con.println("play");
			while(intCount1 < 60){
				intCount = intCount+1;
				con.sleep(30);
			}
			play(intHand, con);
		}else if(chrChoice == 'h' || chrChoice == 'P'){
			con.println("highscores");
		}else if(chrChoice == 'q' || chrChoice == 'Q'){
			con.println("quit");
		}else if(chrChoice == 'h' || chrChoice == 'H'){
			con.println("help");
		}else{
			con.println("Enter p or h or q or e to make option.");
		}
		
		int intSwitch;
		int intSwitch2;
		int intSwitch3;
		int intSwitch4;
		int intSwitch5;
		String strChoice = "y";
		con.clear();
		while(strChoice.equals("y")){
			//con.println("Enter 00 for null");
			con.println("Choose card to switch");
			intSwitch = con.readInt();
			intHand = switchCards(intHand, intSwitch, strSortedDeck);
			con.println("Choose another card? (y/n)");
			strChoice = con.readLine();
		}
		
		play(intHand, con);
		
		
		
	}

	// Player hand
	public static void play(int intHand[][], Console con){
		con.clear();
		con.setDrawColor(Color.BLACK);
		con.fillRect(0,0,1280,720);
		int intRow;
		TextOutputFile txtHand = new TextOutputFile("playerhand.txt",false);
		
		con.println("Here are your cards:");
		
		for(intRow = 0; intRow < 5; intRow++){ 
			txtHand.println(intHand[intRow][0]);
			txtHand.println(intHand[intRow][1]);
			//con.println("");
			if(intHand[intRow][0] == 1){
				con.print("Ace ");
			}else if(intHand[intRow][0] == 2){
				con.print("Two ");
			}else if(intHand[intRow][0] == 3){
				con.print("Three ");
			}else if(intHand[intRow][0] == 4){
				con.print("Four ");
			}else if(intHand[intRow][0] == 5){
				con.print("Five ");
			}else if(intHand[intRow][0] == 6){
				con.print("Six ");
			}else if(intHand[intRow][0] == 7){
				con.print("Seven ");
			}else if(intHand[intRow][0] == 8){
				con.print("Eight ");
			}else if(intHand[intRow][0] == 9){
				con.print("Nine ");
			}else if(intHand[intRow][0] == 10){
				con.print("Ten ");
			}else if(intHand[intRow][0] == 11){
				con.print("Jack ");
			}else if(intHand[intRow][0] == 12){
				con.print("Queen ");
			}else if(intHand[intRow][0] == 13){
				con.print("King ");
			}
			
			if(intHand[intRow][1] == 0){
				con.println("of Diamonds");
			}else if(intHand[intRow][1] == 1){
				con.println("of Clubs");
			}else if(intHand[intRow][1] == 2){
				con.println("of Hearts");
			}else if(intHand[intRow][1] == 3){
				con.println("of Spades");
			}
			loadCards(intHand[intRow][0], intHand[intRow][1], con);
		}
		
		
	}
	
	public static void loadCards(int intCard, int intCardSuite, Console con){
		con.println("Cards Loaded here");
		con.setDrawColor(Color.WHITE);
		con.fillRect(0,400,1280,350);
		
		// load all 52 iamge cards
		
		if(intCardSuite == 0){
			if(intCard == 1){
				con.println("Ace of diamonds");
				//con.loadImage
			}else if(intCard == 2){
				con.println("Two of diamonds");
			}else if(intCard == 3){
				con.println("Three of diamonds");
			}else if(intCard == 4){
				con.println("Four of diamonds");
			}else if(intCard == 5){
				con.println("Five of diamonds");
			}else if(intCard == 6){
				con.println("Six of diamonds");
			}else if(intCard == 7){
				con.println("Seven of diamonds");
			}else if(intCard == 8){
				con.println("Eight of diamonds");
			}else if(intCard == 9){
				con.println("Nine of diamonds");
			}else if(intCard == 10){
				con.println("Ten of diamonds");
			}else if(intCard == 11){
				con.println("Jack of diamonds");
			}else if(intCard == 12){
				con.println("Queen of diamonds");
			}else if(intCard == 13){
				con.println("King of diamonds");
			}
			
		}else if(intCardSuite == 1){
			if(intCard == 1){
				con.println("Ace of clubs");
				//con.loadImage
			}else if(intCard == 2){
				con.println("Two of clubs");
			}else if(intCard == 3){
				con.println("Three of clubs");
			}else if(intCard == 4){
				con.println("Four of clubs");
			}else if(intCard == 5){
				con.println("Five of clubs");
			}else if(intCard == 6){
				con.println("Six of clubs");
			}else if(intCard == 7){
				con.println("Seven of clubs");
			}else if(intCard == 8){
				con.println("Eight of clubs");
			}else if(intCard == 9){
				con.println("Nine of clubs");
			}else if(intCard == 10){
				con.println("Ten of clubs");
			}else if(intCard == 11){
				con.println("Jack of clubs");
			}else if(intCard == 12){
				con.println("Queen of clubs");
			}else if(intCard == 13){
				con.println("King of clubs");
			}
			
		}else if(intCardSuite == 2){
			if(intCard == 1){
				con.println("Ace of hearts");
				//con.loadImage
			}else if(intCard == 2){
				con.println("Two of hearts");
			}else if(intCard == 3){
				con.println("Three of hearts");
			}else if(intCard == 4){
				con.println("Four of hearts");
			}else if(intCard == 5){
				con.println("Five of hearts");
			}else if(intCard == 6){
				con.println("Six of hearts");
			}else if(intCard == 7){
				con.println("Seven of hearts");
			}else if(intCard == 8){
				con.println("Eight of hearts");
			}else if(intCard == 9){
				con.println("Nine of hearts");
			}else if(intCard == 10){
				con.println("Ten of hearts");
			}else if(intCard == 11){
				con.println("Jack of hearts");
			}else if(intCard == 12){
				con.println("Queen of hearts");
			}else if(intCard == 13){
				con.println("King of hearts");
			}
			
		}else if(intCardSuite == 3){
			if(intCard == 1){
				con.println("Ace of spades");
				//con.loadImage
			}else if(intCard == 2){
				con.println("Two of spades");
			}else if(intCard == 3){
				con.println("Three of spades");
			}else if(intCard == 4){
				con.println("Four of spades");
			}else if(intCard == 5){
				con.println("Five of spades");
			}else if(intCard == 6){
				con.println("Six of spades");
			}else if(intCard == 7){
				con.println("Seven of spades");
			}else if(intCard == 8){
				con.println("Eight of spades");
			}else if(intCard == 9){
				con.println("Nine of spades");
			}else if(intCard == 10){
				con.println("Ten of spades");
			}else if(intCard == 11){
				con.println("Jack of spades");
			}else if(intCard == 12){
				con.println("Queen of spades");
			}else if(intCard == 13){
				con.println("King of spades");
			}
			
		}
		int intCount = 1;
		while(intCount < 60){
			intCount = intCount+1;
			con.sleep(30);
		}
	}
	
	public static int[][] switchCards(int intHand[][], int intSwitch, String strSortedDeck[][]){
		
		if(intSwitch == 0){
			intHand[0][0] = Integer.valueOf(strSortedDeck[5][0]);
			intHand[0][1] = Integer.valueOf(strSortedDeck[5][1]);
		}
		if(intSwitch == 1){
			intHand[1][0] = Integer.valueOf(strSortedDeck[6][0]);
			intHand[1][1] = Integer.valueOf(strSortedDeck[6][1]);
		}
		if(intSwitch == 2){
			intHand[2][0] = Integer.valueOf(strSortedDeck[7][0]);
			intHand[2][1] = Integer.valueOf(strSortedDeck[7][1]);
		}
		if(intSwitch == 3){
			intHand[3][0] = Integer.valueOf(strSortedDeck[8][0]);
			intHand[3][1] = Integer.valueOf(strSortedDeck[8][1]);
		}
		if(intSwitch == 4){
			intHand[4][0] = Integer.valueOf(strSortedDeck[9][0]);
			intHand[4][1] = Integer.valueOf(strSortedDeck[9][1]);
		}
		if(intSwitch == 5){
			intHand[5][0] = Integer.valueOf(strSortedDeck[10][0]);
			intHand[5][1] = Integer.valueOf(strSortedDeck[10][1]);
		}
		return intHand;
		
	}
	
	public static String checkHand(int intHand[][]){
	
	return "nothing";
	
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
			System.out.println(intDeck[intRow][0]);
			
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
	
	// sorting player hand to check for wins
	public static int[][] sortHand(int intHand[][], int intCount){
		int intTemp;
		int intCurrent;
		int intBelow;
		int intCounter;
		int intCounter2;
		int intSortedHand[][];
		intSortedHand = new int[5][2];
		
		for(intCounter2 = 0; intCounter2 < intCount -1; intCounter2++){
			for(intCounter = 0; intCounter < intCount - 1; intCounter++){
				intCurrent = intHand[intCounter][2];
				intBelow = intHand[intCounter+1][2];
				if(intCurrent < intBelow){
					intTemp = intHand[intCounter][2];
					intHand[intCounter][2] = intHand[intCounter+1][2];
					intHand[intCounter+1][2] = intTemp;
					intTemp = intHand[intCounter][1];
					intHand[intCounter][1] = intHand[intCounter+1][1];
					intHand[intCounter+1][1] = intTemp;
					intTemp = intHand[intCounter][0];
					intHand[intCounter][0] = intHand[intCounter+1][0];
					intHand[intCounter+1][0] = intTemp;
				}
			}
		}
		return intSortedHand;
	}
	public static void printSorteddeck(String strDeck[][], int intCount, Console con){
		TextOutputFile txtSorted = new TextOutputFile("sorteddeck.txt");
		int intCards = 52;
		
		for(intCount = 0; intCount < 52; intCount++){
			txtSorted.print(strDeck[intCount][0] + " - ");
			txtSorted.print(strDeck[intCount][1] + " - ");
			txtSorted.print(strDeck[intCount][2]);
			txtSorted.println(" ");
		}
	}
	
	public static void printSortedhand(int intSortedHand[][], Console con){
		TextOutputFile txtSortedHand = new TextOutputFile("sortedhand.txt");
		int intCount;
		
		for(intCount = 0; intCount < 5; intCount++){
			txtSortedHand.print(intSortedHand[intCount][0] + " - ");
			txtSortedHand.print(intSortedHand[intCount][1] + " - ");
			//txtSortedhand.print(strSortedhand[intCount][2]);
			txtSortedHand.println(" ");
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
