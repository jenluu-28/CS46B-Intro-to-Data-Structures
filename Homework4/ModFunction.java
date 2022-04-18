package func;

public class ModFunction implements DoubleFunctionOfTwoInts
{
	public double fOfXY(int x, int y)
	{
		//Use == to check for shallow equality
		if (y == 0)
		{
			//Use = for assignment
			y = 1;
			return x % y;
		}
		return x % y;
		
	}
	
	public String getName()
	{
		return "ModFunction";
	}

}
