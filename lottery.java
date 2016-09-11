import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

public class lottery {

	private static File myFile = new File("money.txt");
	private static DecimalFormat formatter = new DecimalFormat(".##");
	private static Scanner myScanner = new Scanner(System.in);
	private static boolean winChecker = false;
	private static boolean exceptionChecker = false;
	private static int winCounter = 0;
	private static int drawCounter = 0;
	private static int numberDrawn1;
 	private static int numberDrawn2;
 	private static int numberDrawn3;
 	private static int numberDrawn4;
 	private static int numberDrawn5;
 	private static double winnings;
	

	public static void main(String [] args) {
		System.out.println("Welcome to the Lottery Game! \nYou are given $100.00 to start your mission to see if \nthe lottery is right for you. You will be charged $10 for each time you play. Good luck!");
		System.out.println("Let's play the lottery! Pick 5 numbers to win up to $1,000,000!");
		System.out.println();
		System.out.println("Lottery numbers chosen will be between 1 and 100");
		System.out.println();
		System.out.println("3 matches wins $10k, 4 matches wins $100k, 5 matches wins $1M");
		System.out.println();

		while(exceptionChecker == false) {
			try {
			System.out.println("Enter your first pick");
			int pick1 = myScanner.nextInt();
			if(pick1 > 100 || pick1 < 1) {
				System.out.println();
				System.out.println("You can only pick numbers between 1 and 100!");
				main(null);
			}
			System.out.println("Enter your second pick");
			int pick2 = myScanner.nextInt();
			if(pick2 > 100 || pick2 < 1) {
				System.out.println();
				System.out.println("You can only pick numbers between 1 and 100!");
				main(null);
			}
			System.out.println("Enter your third pick");
			int pick3 = myScanner.nextInt();
			if(pick3 > 100 || pick3 < 1) {
				System.out.println();
				System.out.println("You can only pick numbers between 1 and 100!");
				main(null);
			}
			System.out.println("Enter your fourth pick");
			int pick4 = myScanner.nextInt();
			if(pick4 > 100 || pick4 < 1) {
				System.out.println();
				System.out.println("You can only pick numbers between 1 and 100!");
				main(null);
			}
			System.out.println("Enter your fifth pick");
			int pick5 = myScanner.nextInt();
			if(pick5 > 100 || pick5 < 1) {
				System.out.println();
				System.out.println("You can only pick numbers between 1 and 100!");
				main(null);
			}
			double winnings = lottery(pick1, pick2, pick3, pick4, pick5);

			exceptionChecker = true;
			} 
			catch(Exception e) {
			System.out.println("Invalid entry, enter your numbers again");
			}
		}

			try{
				Scanner winningScanner = new Scanner(myFile);
				Double balance = winningScanner.nextDouble();
				balance -= 10;
				PrintWriter winningOutput = new PrintWriter(myFile);
				winningOutput.println(winnings + balance);
				winningOutput.close();
				double totalReceipt = winnings + balance;
				System.out.println("Current balance total is: " + totalReceipt);
			} catch(Exception e) {
				System.out.printf("ERROR: %s\n", e);
			}

	
        

 	}

 	public static double lottery(double p1, double p2, double p3, double p4, double p5) {
 	
 		for(int i = 0; i < 5; i++) {
 		int draw = (int)((Math.random()*100) + 1);
 		if(drawCounter == 0) {
 			numberDrawn1 = draw;
 		} else if(drawCounter == 1) {
 			numberDrawn2 = draw;
 		} else if(drawCounter == 2) {
 			numberDrawn3 = draw;
 		} else if(drawCounter == 3) {
 			numberDrawn4 = draw;
 		} else if(drawCounter == 4) {
 			numberDrawn5 = draw;
 		}
 		drawCounter++;
 		

 		if(p1 == draw || p2 == draw || p3 == draw || p4 == draw || p5 == draw) {
 			winCounter++;
 			}
 		}
 		switch(winCounter) {
 			case 0:
 			System.out.println("You got no numbers correct, you win nothing!");
 			System.out.println();
 			System.out.println("The correct numbers were: " + numberDrawn1 + ", " + numberDrawn2 + ", " + numberDrawn3 + ", "
 				+ numberDrawn4 + ", " + numberDrawn5);
 			return 0.0;
 			case 1:
 			System.out.println("You got one number correct, you win nothing!");
 			System.out.println();
 			System.out.println("The correct numbers were: " + numberDrawn1 + ", " + numberDrawn2 + ", " + numberDrawn3 + ", "
 				+ numberDrawn4 + ", " + numberDrawn5);
 			return 0.0;
 			case 2:
 			System.out.println("You got two numbers correct, you win nothing!");
 			System.out.println();
 			System.out.println("The correct numbers were: " + numberDrawn1 + ", " + numberDrawn2 + ", " + numberDrawn3 + ", "
 				+ numberDrawn4 + ", " + numberDrawn5);
 			return 0.0;
 			case 3: 
 			System.out.println("You got three numbers correct, you win $10,000!");
 			System.out.println();
 			System.out.println("The correct numbers were: " + numberDrawn1 + ", " + numberDrawn2 + ", " + numberDrawn3 + ", "
 				+ numberDrawn4 + ", " + numberDrawn5);
 			return 10000.00;
 			case 4: 
 			System.out.println("You got four numbers correct, you win $100,000");
 			System.out.println();
 			System.out.println("The correct numbers were: " + numberDrawn1 + ", " + numberDrawn2 + ", " + numberDrawn3 + ", "
 				+ numberDrawn4 + ", " + numberDrawn5);
 			return 100000.00;
 			case 5: 
 			System.out.println("You got five numbers correct, you win $1,000,000!");
 			System.out.println();
 			System.out.println("The correct numbers were: " + numberDrawn1 + ", " + numberDrawn2 + ", " + numberDrawn3 + ", "
 				+ numberDrawn4 + ", " + numberDrawn5);
 			return 1000000.00;
 			default:
 			return 0;
 		}
 		

 		}

}