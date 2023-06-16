
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
		
		
		//String strName;
		
		//con.println("Enter name:");
		//strName = con.readLine();
		
		menu(1000, con);
		 
		 
		 
	}
	
	//menu method
	public static void menu(int intScore,Console con){
		con.clear();
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
			//con.println("play");
			con.clear();
			con.drawImage(imgBG,1,1);
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
			highscores(con);
		}else if(chrChoice == 'q' || chrChoice == 'Q'){
			//con.println("quit");
			quit(con);
		}else if(chrChoice == 'e' || chrChoice == 'E'){
			//con.println("help");
			help(con);
		}else if(chrChoice == 's' || chrChoice == 'S'){
			con.println("Why did the bike fall over?");
			con.readLine();
			con.println("Because it was too tired.");
			int intCounter = 1;
			while(intCounter == 1){
				con.sleep(30);
			}
		}else{
			con.println("Enter p or h or q or e to make option.");
		}
		
		intSortedHand = sortHand(intHand,5);
		printSortedhand(intSortedHand,con);
		
		int intSwitch = 0;
		String strChoice = "y";
		TextInputFile txtBetIn = new TextInputFile("bet.txt");
		//con.clear();
		//con.println("0 = " + 
		while(strChoice.equals("y")){
			con.println("Enter -1 for no cards");
			con.println("Choose card to switch");
			if(intSwitch >= 0 && intSwitch <= 4){
				intSwitch = con.readInt();
				//enter 00 for no cards switch
				intHand = switchCards(intHand, intSwitch, strSortedDeck);
				con.println("Choose another card? (y/n)");
				strChoice = con.readLine();
			}else if(intSwitch == -1){
				strChoice = "n";
			}else if(intSwitch > 4){
				con.println("Can't change card value over 4");
				strChoice = "n";
			}
			
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
		
		if(intScore <= 0){
			con.println("You have no more money");
			con.println("You have: "+intScore);
			int intCounts = 1;
			while(intCounts == 1){
				con.sleep(30);
			}
		}
		
		BufferedImage imgBG = con.loadImage("bg1.jpg");
		con.drawImage(imgBG,1,1);
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
	
//highscores method
	public static void highscores(Console con){
		con.clear();
		con.println("Highscores");
		TextInputFile txtSortedHS = new TextInputFile("sortedhighscores.txt");
		String strScores;
		
		BufferedImage imgBG = con.loadImage("bg1.jpg");
		con.drawImage(imgBG,1,1);
		
		while(txtSortedHS.eof() == false){
			strScores = txtSortedHS.readLine();
			System.out.println("Scores: " +strScores);
			con.println(strScores);
		}
		
		int intCount =1;
		while(intCount ==1){
			con.sleep(30);
		}
	}

//help method
	public static void help(Console con){
		con.clear();
		BufferedImage imgBG = con.loadImage("bg1.jpg");
		con.drawImage(imgBG,1,1);
		con.println("How to play poker");
		con.println("Enter a bet to start playing");
		con.println("You will be shown 5 cards, this is your hand");
		con.println("Enter the card number to change the card or -1 to not change any cards");
		con.println("After new hand is shown, your hand will be checked and your money will be calculated");
		
		int intCount =1;
		while(intCount == 1){
			con.sleep(30);
		}
		
	}
	
//quit method
	public static void quit(Console con){
		int intCount =1;
		con.clear();
		BufferedImage imgBG = con.loadImage("bg1.jpg");
		con.drawImage(imgBG,1,1);
		con.println("End of Game");
		while(intCount == 1){
			con.sleep(30);
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
		int intCount;
		
		for(intCount = 13; intCount > 0; intCount--){
		//check for flush
			if(intSortedHand[0][0] == intCount && intSortedHand[1][0] == intCount -1 && intSortedHand[2][0] == intCount -2 && intSortedHand[3][0] == intCount -3 && intSortedHand[4][0] == intCount-4){
				con.println("Flush");
				return 10;
			}
		}
		for(intCount = 1; intCount <= 1; intCount++){
			//check for straught
			if(intSortedHand[0][1] == 0 && intSortedHand[1][1] == 0 && intSortedHand[2][1] == 0 && intSortedHand[3][1] == 0 && intSortedHand[4][1] == 0){
				con.println("Straight diamond");
				return 15;
			}else if(intSortedHand[0][1] == 1 && intSortedHand[1][1] == 1 && intSortedHand[2][1] == 1 && intSortedHand[3][1] == 1 && intSortedHand[4][1] == 1){
				con.println("Straight clubs");
				return 15;
			}else if(intSortedHand[0][1] == 2 && intSortedHand[1][1] == 2 && intSortedHand[2][1] == 2 && intSortedHand[3][1] == 2 && intSortedHand[4][1] == 2){
				con.println("Straight hearts");
				return 15;
			}else if(intSortedHand[0][1] == 3 && intSortedHand[1][1] == 3 && intSortedHand[2][1] == 3 && intSortedHand[3][1] == 3 && intSortedHand[4][1] == 3){
				con.println("Straight spades");
				return 15;
			}
		}
		for(intRow = 0; intRow < 2; intRow++){
			//check for quadruple
			if(intSortedHand[intRow][0] == 11 && intSortedHand[intRow+1][0] == 11 && intSortedHand[intRow+2][0] == 11 && intSortedHand[intRow+3][0] == 11){
				con.println("quadruple jacks");
				return 4;
			}else if(intSortedHand[intRow][0] == 12 && intSortedHand[intRow+1][0] == 12 && intSortedHand[intRow+2][0] == 12 && intSortedHand[intRow+3][0] == 12){
				con.println("quadruple queens");
				return 4;
			}else if(intSortedHand[intRow][0] == 13 && intSortedHand[intRow+1][0] == 13 && intSortedHand[intRow+2][0] == 13 && intSortedHand[intRow+3][0] == 13){
				con.println("quadruple kings");
				return 4;
			}else if(intSortedHand[intRow][0] == 1 && intSortedHand[intRow+1][0] == 1 && intSortedHand[intRow+2][0] == 1 && intSortedHand[intRow+3][0] == 1){
				con.println("quadruple aces");
				return 4;
			}else if(intSortedHand[intRow][0] == 2 && intSortedHand[intRow+1][0] == 2 && intSortedHand[intRow+2][0] == 2 && intSortedHand[intRow+3][0] == 2){
				con.println("quadruple twos");
				return 4;
			}else if(intSortedHand[intRow][0] == 3 && intSortedHand[intRow+1][0] == 3 && intSortedHand[intRow+2][0] == 3 && intSortedHand[intRow+3][0] == 3){
				con.println("quadruple threes");
				return 4;
			}else if(intSortedHand[intRow][0] == 4 && intSortedHand[intRow+1][0] == 4 && intSortedHand[intRow+2][0] == 4 && intSortedHand[intRow+3][0] == 4){
				con.println("quadruple fours");
				return 4;
			}else if(intSortedHand[intRow][0] == 5 && intSortedHand[intRow+1][0] == 5 && intSortedHand[intRow+2][0] == 5 && intSortedHand[intRow+3][0] == 5){
				con.println("quadruple fives");
				return 4;
			}else if(intSortedHand[intRow][0] == 6 && intSortedHand[intRow+1][0] == 6 && intSortedHand[intRow+2][0] == 6 && intSortedHand[intRow+3][0] == 6){
				con.println("quadruple sixes");
				return 4;
			}else if(intSortedHand[intRow][0] == 7 && intSortedHand[intRow+1][0] == 7 && intSortedHand[intRow+2][0] == 7 && intSortedHand[intRow+3][0] == 7){
				con.println("quadruple sevens");
				return 4;
			}else if(intSortedHand[intRow][0] == 8 && intSortedHand[intRow+1][0] == 8 && intSortedHand[intRow+2][0] == 8 && intSortedHand[intRow+3][0] == 8){
				con.println("quadruple eights");
				return 4;
			}else if(intSortedHand[intRow][0] == 9 && intSortedHand[intRow+1][0] == 9 && intSortedHand[intRow+2][0] == 9 && intSortedHand[intRow+3][0] == 9){
				con.println("quadruple nines");
				return 4;
			}
			
		}
		
		for(intRow = 0; intRow < 3; intRow++){
			//check for triple
			if(intSortedHand[intRow][0] == 11 && intSortedHand[intRow+1][0] == 11 && intSortedHand[intRow+2][0] == 11){
				con.println("triple jacks");
				return 3;
			}else if(intSortedHand[intRow][0] == 12 && intSortedHand[intRow+1][0] == 12 && intSortedHand[intRow+2][0] == 12){
				con.println("triple queens");
				return 3;
			}else if(intSortedHand[intRow][0] == 13 && intSortedHand[intRow+1][0] == 13 && intSortedHand[intRow+2][0] == 13){
				con.println("triple kings");
				return 3;
			}else if(intSortedHand[intRow][0] == 1 && intSortedHand[intRow+1][0] == 1 && intSortedHand[intRow+2][0] == 1){
				con.println("triple aces");
				return 3;
			}else if(intSortedHand[intRow][0] == 2 && intSortedHand[intRow+1][0] == 2 && intSortedHand[intRow+2][0] == 2){
				con.println("triple twos");
				return 3;
			}else if(intSortedHand[intRow][0] == 3 && intSortedHand[intRow+1][0] == 3 && intSortedHand[intRow+2][0] == 3){
				con.println("triple threes");
				return 3;
			}else if(intSortedHand[intRow][0] == 4 && intSortedHand[intRow+1][0] == 4 && intSortedHand[intRow+2][0] == 4){
				con.println("triple fours");
				return 3;
			}else if(intSortedHand[intRow][0] == 5 && intSortedHand[intRow+1][0] == 5 && intSortedHand[intRow+2][0] == 5){
				con.println("triple fives");
				return 3;
			}else if(intSortedHand[intRow][0] == 6 && intSortedHand[intRow+1][0] == 6 && intSortedHand[intRow+2][0] == 6){
				con.println("triple sixes");
				return 3;
			}else if(intSortedHand[intRow][0] == 7 && intSortedHand[intRow+1][0] == 7 && intSortedHand[intRow+2][0] == 7){
				con.println("triple sevens");
				return 3;
			}else if(intSortedHand[intRow][0] == 8 && intSortedHand[intRow+1][0] == 8 && intSortedHand[intRow+2][0] == 8){
				con.println("triple eights");
				return 3;
			}else if(intSortedHand[intRow][0] == 9 && intSortedHand[intRow+1][0] == 9 && intSortedHand[intRow+2][0] == 9){
				con.println("triple nines");
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
		
		return 0;
	}
	
//win method
	public static void win(int intBet, int intTimes, Console con){
		con.clear();
		BufferedImage imgWin = con.loadImage("win.png");
		BufferedImage imgBG = con.loadImage("bg1.jpg");
		
		con.drawImage(imgBG,1,1);
		con.drawImage(imgWin,370,100);
		
		int intScore;
		TextInputFile txtScoreIn = new TextInputFile("score.txt");
		TextOutputFile txtHighscores = new TextOutputFile("highscores.txt");
		intScore = txtScoreIn.readInt();
		txtScoreIn.close();
		TextOutputFile txtScoreOut = new TextOutputFile("score.txt");
		//load win graphic
		
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
			con.clear();
			menu(intScore,con);
		}else if(strChoice.equals("n")){
			con.clear();
			con.println("End of game");
			printScore(con);
			con.println("Your score: "+intScore);
		}
	}
	
//lose method
	public static void lose(int intBet, Console con){
		int intScore;
		
		//load lose graphic
		BufferedImage imgLose = con.loadImage("lose.png");
		BufferedImage imgBG = con.loadImage("bg1.jpg");
		
		con.drawImage(imgBG,1,1);
		con.drawImage(imgLose,370,100);
		
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

		String strChoice;
		con.println("Do you want to play again? (y/n)");
		strChoice = con.readLine();
		
		if(strChoice.equals("y")){
			menu(intScore,con);
		}else if(strChoice.equals("n")){
			con.clear();
			con.println("End of Game");
			printScore(con);
			con.println("Your score is: "+intScore);
		}
		
		
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
	public static void printScore(Console con){
		TextOutputFile txtHighscore = new TextOutputFile("highscores.txt",true);
		TextInputFile txtScore = new TextInputFile("score.txt");
				
		String strName;
		con.println("Enter name:");
		strName = con.readLine();
		int intScore;
		intScore = txtScore.readInt();
		
		System.out.println(strName);
		System.out.println(intScore);
		txtHighscore.println(strName);
		txtHighscore.println(intScore);
		
		txtHighscore.close();
		
		sortScores(con);

	}
	
	//sorting leaderbooard based on score
	public static void sortScores(Console con){
		String strLeaderboard[][];
		strLeaderboard = new String[10][2];
		TextInputFile txtHighscores = new TextInputFile("highscores.txt");
		int intRow = 0;
		int intCount = 0;
		
		while(txtHighscores.eof() == false){
			strLeaderboard[intRow][0] = txtHighscores.readLine();
			strLeaderboard[intRow][1] = txtHighscores.readLine();
			intRow = intRow + 1;
			intCount = intCount + 1;
			System.out.println("count: "+intCount);
			System.out.println("Row: "+intRow);
			
		}
		
		String strTemp;
		int intCurrent;
		int intBelow;
		int intCounter;
		int intCounter2;
		
		for(intCounter2 = 0; intCounter2 < intCount -1; intCounter2++){
			for(intCounter = 0; intCounter < intCount - 1; intCounter++){
				intCurrent = Integer.parseInt(strLeaderboard[intCounter][1]);
				intBelow = Integer.parseInt(strLeaderboard[intCounter+1][1]);
				System.out.println("intCurrent: "+intCurrent);
				System.out.println("intBelow: "+intBelow);
				if(intCurrent < intBelow){
					strTemp = strLeaderboard[intCounter][1];
					strLeaderboard[intCounter][1] = strLeaderboard[intCounter+1][1];
					strLeaderboard[intCounter+1][1] = strTemp;
					//strTemp = strLeaderboard[intCounter][1];
					//strLeaderboard[intCounter][1] = strLeaderboard[intCounter+1][1];
					//strLeaderboard[intCounter+1][1] = strTemp;
					strTemp = strLeaderboard[intCounter][0];
					strLeaderboard[intCounter][0] = strLeaderboard[intCounter+1][0];
					strLeaderboard[intCounter+1][0] = strTemp;
				}
			}
		}
		txtHighscores.close();
		
		TextOutputFile txtSortedHS = new TextOutputFile("sortedhighscores.txt",false);
		
		int intCount2 = 0;
		for(intCount2 = 0; intCount2 < intCount; intCount2++){
			txtSortedHS.print(((strLeaderboard[intCount2][0]) + "                  ").substring(0,15));
			txtSortedHS.println(strLeaderboard[intCount2][1]);
		}
	}

}
