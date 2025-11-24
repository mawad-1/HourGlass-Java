package hourGlass;

import java.util.Scanner;

/*
 * The goal of this program is to simulate an hour glass that visually represents the passage of time. 
 * It accepts user commands to move time forward, backward, reset, or quit, updating the hour glass display accordingly.
 * Written by Marah Awad =)
 */

public class Hourglass {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		//ask the user for the outer and inner material
		System.out.print("Enter Outer Material: ");
		char outer = scan.next().charAt(0);
		System.out.print("Enter Inner Material: ");
		char inner = scan.next().charAt(0);
		scan.nextLine(); //clear newline
		
		int time = 0; //tracks how many hours have passed (0-12)
		
		//printing the initial hour glass
		printHourglass(outer, inner, time);
		
		//command loop
		while (true)
		{
			String command = scan.nextLine().trim(); //trim removes the extra spaces
			
			//equalsIgnoreCase so that its case insensitive
			if (command.equalsIgnoreCase("next")) //advances one hour
			{
				time++;
				if (time > 12)
				{
					time = 0; //resets after 12
				}
				printHourglass(outer, inner, time);
			}
			else if (command.equalsIgnoreCase("prev")) //go back one hour
			{
				time--;
				if (time < 0)
				{
					time = 12; //flips backwards
				}
				printHourglass(outer, inner, time);
			}
			else if (command.equalsIgnoreCase("nexus")) //resets to t=0
			{
				time = 0;
				printHourglass(outer, inner, time);
			}
			else if (command.equalsIgnoreCase("quit")) //exits the program
			{
				break;
			}
			else
			{
				System.out.println("Unknown command. Please try again!");
			}
		}
		scan.close(); //closing the scanner

	}
	
	
	//prints the hour glass shape
	public static void printHourglass(char outer, char inner, int time)
	{
		//prints the time
		System.out.println("t = " + time);
		//top border of hour glass
		for (int k = 0; k < 14 + 1; k++)

		{
			System.out.print(outer + " ");
		}
		System.out.println();
		
		
		//top chamber
		//13 rows, so each row indents more and shrinks
		for (int i = 1; i <= 13; i++)
		{
			printSpaces(i); //the indentation
			System.out.print(outer + " ");
			int innerCount = 13 - i + 1; //the number of inner slots
			
			//the top sand decreases as time increases-
			//so at time = 0: all the rows are filled
			//at time = 12: only the bottom row is filled
			if (i > time)
			{
				//filled row: print the inner
				for (int j = 0; j < innerCount; j++)
				{
					System.out.print(inner + " ");
				}
			}
			else
			{
				//emptied row: print blank (2 empty spaces per slot)
				for (int j = 0; j < innerCount; j++)
				{
					System.out.print("  ");
				}
			}
			
			System.out.println(outer);
		}
		
		//waist of the hour glass (or the two rows of the outer character)
		printSpaces(13 + 1);
		System.out.println(outer + " " + outer);
		
		
		//bottom chamber
		//each row indents less and grows wider further down the hour glass
		for (int b = 0; b <= 13; b++)
		{
			printSpaces(13 + 1 - b); //indentation 
			System.out.print(outer + " ");
			int innerCount = b; //the number of inner slots
			
			
			//the bottom sand increases as time increases-
			//so at time = 1: the first row is filled
			//at time = 12: the last row is filled
			if (b <= time)
			{
				//filled row: print the inner
				for (int j = 0; j < innerCount; j++)
				{
					System.out.print(inner + " ");
				}
			}
			else
			{
				//emptied row: print blank (2 empty spaces per slot)
				for (int j = 0; j < innerCount; j++)
				{
					System.out.print("  ");
				}
			}
			
			System.out.println(outer);
		}
		
		//bottom border
		for (int k = 0; k < 14 + 1; k++)
		{
			System.out.print(outer + " ");
		}
		System.out.println("\n");
		
	}
	
	
	//prints the spaces for indentation
	public static void printSpaces(int count)
	{
		for (int i = 0; i < count; i++)
		{
			System.out.print(" ");
		}
	}

}
