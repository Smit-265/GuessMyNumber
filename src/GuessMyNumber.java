import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessMyNumber {
	static int max_num, min_num=1;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws InterruptedException
	{
		//Get user input
		System.out.print("Hello!, What is your name : ");
		String name = scan.nextLine().toUpperCase().strip();
		//Calling final method that covers all other methods
		difficulty(name);
	}
	
	//Method covers all other user defined methods
	public static void difficulty(String name) throws InterruptedException
	{
		//Get user input to choose difficulty
		System.out.println("\nChoose difficulty:");
		System.out.println("\t-(1) Easy\n\t-(2) Medium\n\t-(3) Hard\n\t-(4) Expert");
		System.out.print("\nChoose difficulty (1),(2),(3),(4) : ");
		String choose_difficulty = scan.nextLine();

    	if (choose_difficulty.equals("1"))
		{
			max_num = easy();
			guessingNumber(name, min_num, max_num);
		}
		else if (choose_difficulty.equals("2"))
		{
			max_num = medium();
			guessingNumber(name, min_num, max_num);
		}
		else if (choose_difficulty.equals("3"))
		{
			max_num = hard();
			guessingNumber(name, min_num, max_num);
		}
		else if (choose_difficulty.equals("4"))
		{
			max_num = expert();
			guessingNumber(name, min_num, max_num);
		}
    	//If user did not choose difficulty from 1 to 4 then this method will call itself recursively
		else
		{
			difficulty(name);
		}
	}
	
	//Method for guessing number game
	public static void guessingNumber(String name, int min_num, int max_num) throws InterruptedException
	{
		int random_number;
		//Guessing random integer 
		System.out.println("\nWell " + name + ", I am thinking of a number between " + min_num + " and " + max_num + "...");
		random_number = ThreadLocalRandom.current().nextInt(min_num , max_num);
		Thread.sleep(3000);
		System.out.println("\nLet's Go...You have only 10 chance to guess my number!");

		//Guess the number 10 times
		for(int i=1; i<=10; i++)
		{
			System.out.print("\nTake a guess " + "(" + i + ") : ");
			int guess_num = scan.nextInt();

			if(guess_num < random_number)
			{
				System.out.println("Your guess is too low.");
			}
			else if(guess_num > random_number)
			{
				System.out.println("Your guess is too high.");
			}
			//Condition for winning
			else if(guess_num == random_number)
			{
				System.out.println("\nGood job " + name + "!  You guessed my number in " + i + " guesses.");
				break;
			}
			//Condition for loosing
			if(i == 10)
			{
				System.out.println("\nGame Over..!  The number I was thinking of was " + random_number + ".");
			}
		}
	}

	//Method for easy difficulty
	public static int easy() 
	{
		max_num = 80;
		return max_num;
	}
	
	//Method for medium difficulty
	public static int medium() 
	{
		max_num = 150;
		return max_num;
	}
	
	//Method for hard difficulty 
	public static int hard() 
	{
		max_num = 300;
		return max_num;
	}
	
	//Method for expert difficulty 
	public static int expert() 
	{
		max_num = 500;
		return max_num;
	}
}
