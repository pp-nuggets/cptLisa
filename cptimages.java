//images load

import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class cptimages{
	public static void main(String[] args){
		Console con = new Console();
	
	}
	
	public static void images(int intCardSuite, int intCard, Console con){
		//con.setDrawColor(Color.WHITE);
		//con.fillRect(700,100,350,450);
		
		BufferedImage img1h = con.loadImage("1h.jpg");
		BufferedImage img1s = con.loadImage("1s.jpg");
		BufferedImage img1c = con.loadImage("1c.jpg");
		BufferedImage img1d = con.loadImage("1d.jpg");
		
		BufferedImage img2h = con.loadImage("2h.jpg");
		BufferedImage img2s = con.loadImage("2s.jpg");
		BufferedImage img2c = con.loadImage("2c.jpg");
		BufferedImage img2d = con.loadImage("2d.jpg");
		
		BufferedImage img3h = con.loadImage("3h.jpg");
		BufferedImage img3s = con.loadImage("3s.jpg");
		BufferedImage img3c = con.loadImage("3c.jpg");
		BufferedImage img3d = con.loadImage("3d.jpg");
		
		BufferedImage img4h = con.loadImage("4h.jpg");
		BufferedImage img4s = con.loadImage("4s.jpg");
		BufferedImage img4c = con.loadImage("4c.jpg");
		BufferedImage img4d = con.loadImage("4d.jpg");
		
		BufferedImage img5h = con.loadImage("5h.jpg");
		BufferedImage img5s = con.loadImage("5s.jpg");
		BufferedImage img5c = con.loadImage("5c.jpg");
		BufferedImage img5d = con.loadImage("5d.jpg");
		
		BufferedImage img6h = con.loadImage("6h.jpg");
		BufferedImage img6s = con.loadImage("6s.jpg");
		BufferedImage img6c = con.loadImage("6c.jpg");
		BufferedImage img6d = con.loadImage("6d.jpg");
		
		BufferedImage img7h = con.loadImage("7h.jpg");
		BufferedImage img7s = con.loadImage("7s.jpg");
		BufferedImage img7c = con.loadImage("7c.jpg");
		BufferedImage img7d = con.loadImage("7d.jpg");
		
		BufferedImage img8h = con.loadImage("8h.jpg");
		BufferedImage img8s = con.loadImage("8s.jpg");
		BufferedImage img8c = con.loadImage("8c.jpg");
		BufferedImage img8d = con.loadImage("8d.jpg");
		
		BufferedImage img9h = con.loadImage("9h.jpg");
		BufferedImage img9s = con.loadImage("9s.jpg");
		BufferedImage img9c = con.loadImage("9c.jpg");
		BufferedImage img9d = con.loadImage("9d.jpg");
		
		BufferedImage img10h = con.loadImage("10h.jpg");
		BufferedImage img10s = con.loadImage("10s.jpg");
		BufferedImage img10c = con.loadImage("10c.jpg");
		BufferedImage img10d = con.loadImage("10d.jpg");
		
		BufferedImage img11h = con.loadImage("11h.jpg");
		BufferedImage img11s = con.loadImage("11s.jpg");
		BufferedImage img11c = con.loadImage("11c.jpg");
		BufferedImage img11d = con.loadImage("11d.jpg");
		
		BufferedImage img12h = con.loadImage("12h.jpg");
		BufferedImage img12s = con.loadImage("12s.jpg");
		BufferedImage img12c = con.loadImage("12c.jpg");
		BufferedImage img12d = con.loadImage("12d.jpg");
		
		BufferedImage img13h = con.loadImage("13h.jpg");
		BufferedImage img13s = con.loadImage("13s.jpg");
		BufferedImage img13c = con.loadImage("13c.jpg");
		BufferedImage img13d = con.loadImage("13d.jpg");
		
		int intX = 740;
		int intY = 200;
		
		if(intCardSuite == 0){
			if(intCard == 1){
				//con.println("Ace of diamonds");
				con.drawImage(img1d,intX,intY);
			}else if(intCard == 2){
				//con.println("Two of diamonds");
				con.drawImage(img2d,intX,intY);
			}else if(intCard == 3){
				//con.println("Three of diamonds");
				con.drawImage(img3d,intX,intY);
			}else if(intCard == 4){
				//con.println("Four of diamonds");
				con.drawImage(img4d,intX,intY);
			}else if(intCard == 5){
				//con.println("Five of diamonds");
				con.drawImage(img5d,intX,intY);
			}else if(intCard == 6){
				//con.println("Six of diamonds");
				con.drawImage(img6d,intX,intY);
			}else if(intCard == 7){
				//con.println("Seven of diamonds");
				con.drawImage(img7d,intX,intY);
			}else if(intCard == 8){
				//con.println("Eight of diamonds");
				con.drawImage(img8d,intX,intY);
			}else if(intCard == 9){
				//con.println("Nine of diamonds");
				con.drawImage(img9d,intX,intY);
			}else if(intCard == 10){
				//con.println("Ten of diamonds");
				con.drawImage(img10d,intX,intY);
			}else if(intCard == 11){
				//con.println("Jack of diamonds");
				con.drawImage(img11d,intX,intY);
			}else if(intCard == 12){
				//con.println("Queen of diamonds");
				con.drawImage(img12d,intX,intY);
			}else if(intCard == 13){
				//con.println("King of diamonds");
				con.drawImage(img13d,intX,intY);
			}
			
		}else if(intCardSuite == 1){
			if(intCard == 1){
				con.drawImage(img1c,intX,intY);
				//con.loadImage
			}else if(intCard == 2){
				con.drawImage(img2c,intX,intY);
			}else if(intCard == 3){
				con.drawImage(img3c,intX,intY);
			}else if(intCard == 4){
				con.drawImage(img4c,intX,intY);
			}else if(intCard == 5){
				con.drawImage(img5c,intX,intY);
			}else if(intCard == 6){
				con.drawImage(img6c,intX,intY);
			}else if(intCard == 7){
				con.drawImage(img7c,intX,intY);
			}else if(intCard == 8){
				con.drawImage(img8c,intX,intY);
			}else if(intCard == 9){
				con.drawImage(img9c,intX,intY);
			}else if(intCard == 10){
				con.drawImage(img10c,intX,intY);
			}else if(intCard == 11){
				con.drawImage(img11c,intX,intY);
			}else if(intCard == 12){
				con.drawImage(img12c,intX,intY);
			}else if(intCard == 13){
				con.drawImage(img13c,intX,intY);
			}
			
		}else if(intCardSuite == 2){
			if(intCard == 1){
				con.drawImage(img1h,intX,intY);
				//con.loadImage
			}else if(intCard == 2){
				con.drawImage(img2h,intX,intY);
			}else if(intCard == 3){
				con.drawImage(img3h,intX,intY);
			}else if(intCard == 4){
				con.drawImage(img4h,intX,intY);
			}else if(intCard == 5){
				con.drawImage(img5h,intX,intY);
			}else if(intCard == 6){
				con.drawImage(img6h,intX,intY);
			}else if(intCard == 7){
				con.drawImage(img7h,intX,intY);
			}else if(intCard == 8){
				con.drawImage(img8h,intX,intY);
			}else if(intCard == 9){
				con.drawImage(img9h,intX,intY);
			}else if(intCard == 10){
				con.drawImage(img10h,intX,intY);
			}else if(intCard == 11){
				con.drawImage(img11h,intX,intY);
			}else if(intCard == 12){
				con.drawImage(img12h,intX,intY);
			}else if(intCard == 13){
				con.drawImage(img13h,intX,intY);
			}
			
		}else if(intCardSuite == 3){
			if(intCard == 1){
				con.drawImage(img1s,intX,intY);
				//con.loadImage
			}else if(intCard == 2){
				con.drawImage(img2s,intX,intY);
			}else if(intCard == 3){
				con.drawImage(img3s,intX,intY);
			}else if(intCard == 4){
				con.drawImage(img4s,intX,intY);
			}else if(intCard == 5){
				con.drawImage(img5s,intX,intY);
			}else if(intCard == 6){
				con.drawImage(img6s,intX,intY);
			}else if(intCard == 7){
				con.drawImage(img7s,intX,intY);
			}else if(intCard == 8){
				con.drawImage(img8s,intX,intY);
			}else if(intCard == 9){
				con.drawImage(img9s,intX,intY);
			}else if(intCard == 10){
				con.drawImage(img10s,intX,intY);
			}else if(intCard == 11){
				con.drawImage(img11s,intX,intY);
			}else if(intCard == 12){
				con.drawImage(img12s,intX,intY);
			}else if(intCard == 13){
				con.drawImage(img13s,intX,intY);
			}
			
		}
		
		int intCount = 1;
		while(intCount < 100){
			intCount = intCount+1;
			con.sleep(30);
		}
		
	}
}
