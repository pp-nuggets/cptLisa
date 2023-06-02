
import arc.*;

public class cpt{
	public static void main(String[] args){
		Console con = new Console("Online Poker", 1280,720);
		
		String strName;
		

		
		TextOutputFile txtText = new TextOutputFile("text.txt",false);
		
		//con.println("Enter your name: ");
		//strName = con.readLine();
		
		
		int intDeck[][];
		intDeck = new int[52][3];

		int intRow;
		int intRand;
		int intCount;
		
		for(intRow = 0; intRow < 52; intRow+=13){
		
			intRand = (int)(Math.random()*1000+1);
				
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
		
		for(intRow =0; intRow <52; intRow++){
			intRand = (int)(Math.random()*1000+1);
			
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
		
		for(intRow = 0; intRow < 52; intRow++){
			//txtText.print((intRow+1) +" : ");
			txtText.print(intDeck[intRow][2]);
			txtText.print(" - ");
			txtText.print(intDeck[intRow][0]);
			txtText.print(" - ");
			txtText.print(intDeck[intRow][1]);
			txtText.println(" ");
		}
		
	}

}
