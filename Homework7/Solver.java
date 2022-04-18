package sudoku;

import java.util.*;


public class Solver 
{
	private Grid							problem;
	private ArrayList<Grid>				solutions;
	
	
	public Solver(Grid problem)
	{
		this.problem = problem;
	}
	
	
	public void solve()
	{
		solutions = new ArrayList<>();
		solveRecurse(problem);
	}
	
		
	
	// Standard backtracking recursive solver.
	private void solveRecurse(Grid grid)
	{		
		Evaluation eval = evaluate(grid);
		
		if (eval == Evaluation.ABANDON)
		{
			//Abandon evaluation of illegal board (do nothing)
		}
		else if (eval == Evaluation.ACCEPT)
		{
			solutions.add(grid);
		}
		else
		{
			//Generates all 9 possible next grids. Recursively 
			// calls solveRecurse() on those grids.
			ArrayList<Grid> nineGrids = grid.next9Grids();
			for (int i = 0; i < 9; i++)
			{
				solveRecurse(nineGrids.get(i));
			}
		
		}
	}
	

	// Returns Evaluation.ABANDON if the grid is illegal. 
	// Returns ACCEPT if the grid is legal and complete.
	// Returns CONTINUE if the grid is legal and incomplete.
	public Evaluation evaluate(Grid grid)
	{
	
		
		if (!grid.isLegal())
		{
			return Evaluation.ABANDON;
		}
		else if (grid.isLegal() && grid.isFull())
		{
			return Evaluation.ACCEPT;
		}
		else 
		{
			return Evaluation.CONTINUE;
		
		}
		

	}

	
	public ArrayList<Grid> getSolutions()
	{
		return solutions;
	}
	
	
	public static void main(String[] args)
	{
		Grid g = TestGridSupplier.getPuzzle1();		// or any other puzzle
		Solver solver = new Solver(g);
		System.out.println("Will solve\n" + g);
		solver.solve();
		// Print out your solution, or test if it equals() the solution in TestGridSupplier.
	}
}
