import java.util.InputMismatchException;
import java.util.Scanner;

public class DiceRolling {

	public static void main(String[] args) {
		
		//Introduction
		System.out.println("Welcome to the Grand Circus Casino!");
		
		//declare variables
		int die1;
		int die2;
		int count = 1;
		boolean cont = true;
		
		//Loop if they say yes
		do{
			int sides = checkingInt();
			die1 = rollingDie(sides);
			die2 = rollingDie(sides);
			
			printingOutcome(die1, die2, count);
			
			checkingForSpecial(die1,die2);
			
			char response = checkingForYesOrNo();
			
			cont = rollingAgain(response);
			if (cont == false){
				System.out.println(	"Goodbye!");
			}
			
			//keeps total of how many times rolled
			count++;
		}
		while(cont);
	}
	
	//Method to make sure of a valid int
	public static int checkingInt(){
		Scanner sc = new Scanner(System.in);
		int sides;
		while(true){
			try {
				System.out.print("Enter a positive number for number of sides to your die: ");
				 sides = sc.nextInt();
				 if (sides <= 0){
					 System.out.print("Enter a positive number for number of sides to your die:");
					 sides = sc.nextInt();
					 if (sides >= 0){
						 break;
					 }
				 }else{				
					 break;
				 }
			} catch (InputMismatchException e) {
				System.out.print("Try again! Enter a valid number: ");
				sc.next();
			}
		}
		return sides;
	}
	
	//method to find random roll
	public static int rollingDie (int sides){
		return (int)(Math.random()*sides) + 1;
	}
	
	//testing for roll again
	public static boolean rollingAgain(char response){
		if (response == 'y'){
			return true;
		} else{
			return false;
		}
	}
	//Checking if the roll has a special meaning
	public static void checkingForSpecial(int die1,int die2){
		
		int total = die1 + die2;
		
		if (die1 == 1 && die2 == 1){
			System.out.println("You rolled Snake Eyes!");
		}else if (die1 == 6 && die2 == 6){
			System.out.println("You rolled Box Cars");
		}else if ( total == 7){
			System.out.println("Yeah! Lucky 7");
		}
	}
	
	//method to print outcome
	public static void printingOutcome(int die1, int die2, int count){
		System.out.printf("Roll %d: ", count);
		System.out.println("\n"+die1);
		System.out.println(die2);
	}
	public static char checkingForYesOrNo(){
		Scanner sc = new Scanner(System.in);
		String response = "";
		boolean cont = true;
		System.out.print("Roll again? (y/n): ");
		response = sc.next();
		while(cont){
			
			if (response.charAt(0) != 'y' && response.charAt(0) != 'n'){
				System.out.print("Roll again? Enter only y or n: ");
				response = sc.next();}
			else{
				break;
			}
		}
		return response.charAt(0);
	}
}
