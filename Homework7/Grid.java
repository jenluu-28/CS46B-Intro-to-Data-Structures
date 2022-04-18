package sudoku;

import java.util.*;


public class Grid 
{
	private int[][]						values;


	// Constructs a Grid instance from a string[] as provided by TestGridSupplier.
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	public Grid(String[] rows)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
		{
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i=0; i<9; i++)
			{
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}

	//
	// DON'T CHANGE THIS.
	//
	public String toString()
	{
		String s = "";
		for (int j=0; j<9; j++)
		{
			for (int i=0; i<9; i++)
			{
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char)('0' + n);
			}
			s += "\n";
		}
		return s;
	}


	
	Grid(Grid src)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
			for (int i=0; i<9; i++)
				values[j][i] = src.values[j][i];
	}

	// Finds an empty cell in the grid and creates 9 other grids with the numbers 1 through 9 in that empty cell.
	public ArrayList<Grid> next9Grids()
	{		
		int xOfNextEmptyCell = -1;
		int yOfNextEmptyCell = -1;

		if(isFull())
		{
			return null;
		}
		else
		{
			// Find x,y of an empty cell.
			for(int row = 0; row < values.length; row++)
			{
				for(int column = 0; column < values[row].length; column++)
				{
					
					//Identities an empty cell
					if(values[row][column] == 0)
					{
						xOfNextEmptyCell = column;
						yOfNextEmptyCell = row;
						break;

					}
				}
			}

			// Construct array list to contain 9 new grids.
			ArrayList<Grid> grids = new ArrayList<Grid>();

			// Creates 9 new arrays
			for(int i = 1; i <= 9; i++)
			{
				Grid newGrid = new Grid(this);
				newGrid.values[yOfNextEmptyCell][xOfNextEmptyCell] = i;
				grids.add(newGrid);
			}
			return grids;
		}
	}

	// Checks the board if there are any repeated numbers in the rows, columns, and 3x3.
	//Returns true if there are no duplicates and false otherwise
	public boolean isLegal()
	{
		int[] sudokuNums;

		// Checks every row. If an illegal row, return false.
		for(int row = 0; row < values.length; row++)
		{
			sudokuNums = new int[9];
			for(int column = 0; column < values[row].length; column++)
			{
				sudokuNums[column] = values[row][column];
				if(duplicate(sudokuNums))
				{
					return false;
				}
			}
		}

		// Checks every column. If an illegal column, return false.
		for(int row = 0; row < values.length; row++)
		{
			sudokuNums = new int[9];
			for(int column = 0; column < values[row].length; column++)
			{
				sudokuNums[column] = values[column][row];
				if(duplicate(sudokuNums))
				{
					return false;
				}
			}
		}
		
		// Check every block. If an illegal block, return false.
		for(int i = 0; i < values.length; i = i +3) 
		{
			sudokuNums = new int[9];
			for(int j = 0; j < values[i].length; j = j + 3) 
			{
				int placeholder = 0;
				for(int row = i;row < i + 3; row++) 
				{
					for(int col = j;col < j + 3;col++) 
					{
						sudokuNums[placeholder] = values[row][col];
						placeholder++;
					}
				}
				if(duplicate(sudokuNums)) 
				{
					return false;
				}
			}
		}

		// All rows/cols/blocks are legal.
		return true;
	}

	// Checks for any repeated number in the array.
	// Returns true if there are no duplicates and false otherwise
	public static boolean duplicate(int[] input)
	{
		for(int i = 0; i < 8; i++)
		{
			int placeholder = input[i];
			for(int j = i + 1; j <= 8; j++)
			{
				if(placeholder == input[j] && placeholder != 0)
				{
					return true;
				}
			}
		}
		return false;
	}

	// Checks if every space in the board has a number 1 through 9 and not 0.
	// Returns false if a cell member equals 0 and false otherwise
	public boolean isFull()
	{
		for(int row = 0; row < values.length; row++)
		{
			for(int col = 0; col < values[row].length; col++)
			{
				if(values[row][col] == 0)
				{
					return false;
				}
			}
		}
		return true;
	}

	// Checks if two boards are the equal to each or not.
	// Returns true if the boards are equal and false otherwise
	public boolean equals(Object x)
	{
		Grid that = (Grid)x;
		for(int row = 0; row < values.length; row++)
		{
			for(int column  = 0; column < values[row].length; column++)
			{
				if(this.values[row][column] != that.values[row][column])
				{
					return false;
				}
			}
		}
		return true;
	}
}