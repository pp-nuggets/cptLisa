
import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class cpt{
	public static void main(String[] args){
		Console con = new Console("Online Poker", 1280,720);
		
		BufferedImage imgBG = con.loadImage("bg1.jpg");
		
		con.drawImage(imgBG,1,1);
	
		TextOutputFile txtScore = new TextOutputFile("score.txt",false);
		txtScore.println("1000");
		txtScore.close();
		
		
		String strName;
		
		con.println("Enter name:");
		strName = con.readLine();
		
		menu(1000, con);
		 
		 
		 
	}
	
	//menu method
	public static void menu(int intScore,Console con){
		// Deck stuff
		int intCount = 52;
		int intRow;
		int intDeck[][];
		int intHand[][];
		int intSortedHand[][];
		String strDeck[][];
		String strSortedDeck[][];
		TextInputFile txtScore = new TextInputFile("score.txt");
		BufferedImage imgBG = con.loadImage("bg1.jpg");
		
		//intScore = txtScore.readInt();
		txtScore.close();
		
		intDeck = deckArray(intCount);
		strDeck = loadDeck(intCount);
		strSortedDeck = sortDeck(strDeck, intCount);
		printDeck(strSortedDeck, intCount, con);
		
		intHand = hand(strSortedDeck);
		
		
		
		//

		
		// User interface
		char chrChoice;
		int intBet;
		BufferedImage imgMenu = con.loadImage("menu.png");
		TextOutputFile txtBetOut = new TextOutputFile("bet.txt");
		
		
		con.drawImage(imgMenu,320,150);
		con.println("Select an Option:");
		chrChoice = con.readChar();
		
		
		
		if(chrChoice == 'p' || chrChoice == 'P'){
			con.println("play");
			int intCount1 = 1;
			while(intCount1 < 60){
				intCount1 = intCount1 + 1;
				//System.out.println(intCount);
				con.sleep(30);
				
			}
			con.println("You have "+intScore);
			con.println("Enter your bet");
			intBet = con.readInt();
			//write in text folder for bet
			txtBetOut.println(intBet);
			txtBetOut.close();
			con.drawImage(imgBG,1,1);
			play(intHand,intScore, con);
		}else if(chrChoice == 'h' || chrChoice == 'H'){
			con.println("highscores");
		}else if(chrChoice == 'q' || chrChoice == 'Q'){
			con.println("quit");
		}else if(chrChoice == 'h' || chrChoice == 'H'){
			con.println("help");
		}else{
			con.println("Enter p or h or q or e to make option.");
		}
		
		intSortedHand = sortHand(intHand,5);
		printSortedhand(intSortedHand,con);
		
		int intSwitch;
		int intSwitch2;
		int intSwitch3;
		int intSwitch4;
		int intSwitch5;
		String strChoice = "y";
		TextInputFile txtBetIn = new TextInputFile("bet.txt");
		//con.clear();
		//con.println("0 = " + 
		while(strChoice.equals("y")){
			//con.println("Enter 00 for null");
			con.println("Choose card to switch");
			intSwitch = con.readInt();
			//enter 00 for no cards switch
			intHand = switchCards(intHand, intSwitch, strSortedDeck);
			con.println("Choose another card? (y/n)");
			strChoice = con.readLine();
		}
		
		play(intHand, intScore, con);
		intSortedHand = sortHand(intHand,5);
		printSortedhand(intSortedHand,con);
		con.println("checking hand");
		int intTimes;
		intTimes = checkHand(intSortedHand, con);
		//win or lose if statement
		//read bet textfolder for bet
		intBet = txtBetIn.readInt();
		if(intTimes > 0){	
			win(intBet, intTimes, con);
		}else if(intTimes == 0){
			lose(intBet, con);
		}
	}

	// Play method
	public static void play(int intHand[][], int intScore, Console con){
		con.clear();
		//con.setDrawColor(Color.BLACK);
		//con.fillRect(0,0,1280,720);
		int intRow;
		TextOutputFile txtHand = new TextOutputFile("playerhand.txt",false);
		TextOutputFile txtScoreOut = new TextOutputFile("scores.txt");
		
		
		txtScoreOut.println(intScore);
		txtScoreOut.close();
		TextInputFile txtScoreIn = new TextInputFile("scores.txt");
		intScore = txtScoreIn.readInt();
		//System.out.println(intScore);
		
		con.println("Here are your cards:");
		
		for(intRow = 0; intRow < 5; intRow++){ 
			txtHand.println(intHand[intRow][0]);
			txtHand.println(intHand[intRow][1]);
			txtHand.println(intHand[intRow][2]);
			con.print(intRow +": ");
			loadHand(intHand[intRow][0], intHand[intRow][1], con);
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
			
		}
		
		
	}
	
	// loading images into game
	public static void loadHand(int intCard, int intCardSuite, Console con){
		
		// load all 52 iamge cards
		cptimages.images(intCardSuite, intCard, con);

	}
	
	// Player inputs the card array value they want to change, new cards come from deck
	public static int[][] switchCards(int intHand[][], int intSwitch, String strSortedDeck[][]){
		
		System.out.println("intSwitch is: "+intSwitch);
		
		if(intSwitch == 0){
			intHand[0][0] = Integer.valueOf(strSortedDeck[5][0]);
			intHand[0][1] = Integer.valueOf(strSortedDeck[5][1]);
			return intHand;
		}
		if(intSwitch == 1){
			intHand[1][0] = Integer.valueOf(strSortedDeck[6][0]);
			intHand[1][1] = Integer.valueOf(strSortedDeck[6][1]);
			return intHand;
		}
		if(intSwitch == 2){
			intHand[2][0] = Integer.valueOf(strSortedDeck[7][0]);
			intHand[2][1] = Integer.valueOf(strSortedDeck[7][1]);
			return intHand;
		}
		if(intSwitch == 3){
			intHand[3][0] = Integer.valueOf(strSortedDeck[8][0]);
			intHand[3][1] = Integer.valueOf(strSortedDeck[8][1]);
			return intHand;
		}
		if(intSwitch == 4){
			intHand[4][0] = Integer.valueOf(strSortedDeck[9][0]);
			intHand[4][1] = Integer.valueOf(strSortedDeck[9][1]);
			return intHand;
		}
		
		return intHand;
	}
	
	// checking plays hand for wins
	public static int checkHand(int intSortedHand[][], Console con){
		int intRow = 0;
		
		for(intRow = 0; intRow < 3; intRow++){
			//check for triple
			if(intSortedHand[intRow][0] == 11 && intSortedHand[intRow+1][0] == 11 && intSortedHand[intRow+2][0] == 11){
				//triple jacks
				con.println("triple jacks");
				return 3;
			}else if(intSortedHand[intRow][0] == 12 && intSortedHand[intRow+1][0] == 12 && intSortedHand[intRow+2][0] == 12){
				//double queens
				con.println("triple queens");
				return 3;
			}else if(intSortedHand[intRow][0] == 13 && intSortedHand[intRow+1][0] == 13 && intSortedHand[intRow+2][0] == 13){
				//double king
				con.println("triple kings");
				return 3;
			}else if(intSortedHand[intRow][0] == 1 && intSortedHand[intRow+1][0] == 1 && intSortedHand[intRow+2][0] == 1){
				//double aces
				con.println("double aces");
				return 3;
			}
		}
		
		for(intRow = 0; intRow < 4; intRow++){
			
			//check for doubles
			if(intSortedHand[intRow][0] == 11 && intSortedHand[intRow+1][0] == 11){
				//double jacks
				con.println("double jacks");
				return 1;
			}else if(intSortedHand[intRow][0] == 12 && intSortedHand[intRow+1][0] == 12){
				//double queens
				con.println("double queens");
				return 1;
			}else if(intSortedHand[intRow][0] == 13 && intSortedHand[intRow+1][0] == 13){
				//double king
				con.println("double kings");
				return 1;
			}else if(intSortedHand[intRow][0] == 1 && intSortedHand[intRow+1][0] == 1){
				//double aces
				con.println("double aces");
				return 1;
			}
			
			
		}
		
		
		con.println("lose win thing");
		return 0;
	}
	
	//win method
	public static void win(int intBet, int intTimes, Console con){
		int intScore;
		TextInputFile txtScoreIn = new TextInputFile("score.txt");
		TextOutputFile txtHighscores = new TextOutputFile("highscores.txt");
		intScore = txtScoreIn.readInt();
		txtScoreIn.close();
		TextOutputFile txtScoreOut = new TextOutputFile("score.txt");
		
		intScore = (intBet*intTimes) + intScore;
		txtScoreOut.println(intScore);
		txtScoreOut.close();
		con.println("Your score is: " +intScore);
		int intCount = 0;
		while(intCount < 60){
			intCount = intCount +1;
			con.sleep(30);
		}
		String strChoice;
		con.println("Play again? (y/n)");
		strChoice = con.readLine();
		if(strChoice.equals("y")){
			menu(intScore,con);
		}else if(strChoice.equals("n")){
			con.clear();
			con.println("End of game");
		}
	}
	
	//lose method
	public static void lose(int intBet, Console con){
		int intScore;
		
		con.println("You lose");
		
		TextInputFile txtBet = new TextInputFile("bet.txt");
		intBet = txtBet.readInt();
		txtBet.close();
		
		TextInputFile txtScoreIn = new TextInputFile("score.txt");
		intScore = txtScoreIn.readInt();
		txtScoreIn.close();
		
		intScore = intScore - intBet;
		
		TextOutputFile txtScoreOut = new TextOutputFile("score.txt");
		txtScoreOut.println(intScore);
		txtScoreOut.close();
		
		
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
			//System.out.println(intDeck[intRow][0]);
			
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
		
	//loading the deck from a file
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
	
	//sorted deck to randomize
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
	
	//printing deck into file
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
	
	// sorting player hand to check for wins
	public static int[][] sortHand(int intHand[][], int intCount){
		int intTemp;
		int intCurrent;
		int intBelow;
		int intCounter;
		int intCounter2;
		int intSortedHand[][];
		//intSortedHand = new int[5][3];
		
		for(intCounter2 = 0; intCounter2 < intCount -1; intCounter2++){
			for(intCounter = 0; intCounter < intCount - 1; intCounter++){
				intCurrent = intHand[intCounter][0];
				intBelow = intHand[intCounter+1][0];
				System.out.println("Cureent is: "+intCurrent);
				System.out.println("below is "+intBelow);
				if(intCurrent < intBelow){
					intTemp = intHand[intCounter][0];
					intHand[intCounter][0] = intHand[intCounter+1][0];
					intHand[intCounter+1][0] = intTemp;
					intTemp = intHand[intCounter][0];
					intHand[intCounter][0] = intHand[intCounter+1][0];
					intHand[intCounter+1][0] = intTemp;
					intTemp = intHand[intCounter][0];
					intHand[intCounter][0] = intHand[intCounter+1][0];
					intHand[intCounter+1][0] = intTemp;
				}
			}
		}
		return intHand;
	}
	
	// printing sorted deck into file
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
	
	//printing sorted hand into file
	public static void printSortedhand(int intSortedHand[][], Console con){
		TextOutputFile txtSortedHand = new TextOutputFile("sortedhand.txt");
		int intCount;
		
		for(intCount = 0; intCount < 5; intCount++){
			//System.out.println("intCount is: "+ intCount);
			txtSortedHand.print(intSortedHand[intCount][0] + " - ");
			//System.out.println(intSortedHand[intCount][0]);
			txtSortedHand.print(intSortedHand[intCount][1] + " - ");
			//System.out.println(intSortedHand[intCount][0]);
			txtSortedHand.print(intSortedHand[intCount][2]);
			txtSortedHand.println(" ");
		}
	}
	
	//creating hand array from deck array
	public static int[][] hand(String strDeck[][]){
		int intHand[][];
		int intCount;
		intHand = new int[5][3];
				
		for(intCount = 0; intCount < 5; intCount++){
			intHand[intCount][0] = Integer.valueOf(strDeck[intCount][0]);
			intHand[intCount][1] = Integer.valueOf(strDeck[intCount][1]);
			intHand[intCount][2] = Integer.valueOf(strDeck[intCount][2]);
		}
		
	return intHand;
	}
	
	//printing score into highscore file
	public static void printScore(String strName, int intBet, Console con){
	TextOutputFile txtHighscore = new TextOutputFile("highscore.txt");
	TextInputFile txtScore = new TextInputFile("score.txt");
	int intScore;
	intScore = txtScore.readInt();
		
	txtHighscore.println(strName);
	txtHighscore.println(intScore);

	}
	

}
