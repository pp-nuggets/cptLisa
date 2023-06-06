
import arc.*;

public class cpt{
	public static void main(String[] args){
		Console con = new Console("Online Poker", 1280,720);
		
		int intCount = 52;
		int intDeck[][];
		intDeck = deckArray(intCount);

		String strDeck[][];
		String strSortedDeck[][];
		
		strDeck = loadDeck(intCount);
		strSortedDeck = sortDeck(strDeck, intCount);
		printDeck(strSortedDeck, intCount, con);
		
	}
		
	public static int[][] deckArray(int intCount){
		
		// Making deck
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
		for(intRow = 0; intRow < intCount; intRow+=13){
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
		intCount = 51;
		for(intRow = 0; intRow < intCount; intRow++){
			//txtText.print((intRow+1) +" : ");
			txtText.print(intDeck[intRow][2]);
			txtText.print(" - ");
			txtText.print(intDeck[intRow][0]);
			txtText.print(" - ");
			txtText.print(intDeck[intRow][1]);
			txtText.println(" ");
		}
		
		return intDeck;
	}
		
	
	public static String[][] loadDeck(int intCount){
		String strDeck[][];
		strDeck = new String[intCount][2];
		TextInputFile txtText = new TextInputFile("text.txt");
		int intRow;
		for(intRow = 0; intRow < 51; intRow++){
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
		int intCards = 51;
		
		for(intCount = 0; intCount < 51; intCount++){
			txtSorted.print(strDeck[intCount][0] + " - ");
		}
	}

}
