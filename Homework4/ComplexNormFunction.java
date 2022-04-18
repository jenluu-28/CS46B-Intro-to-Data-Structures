package func;

public class ComplexNormFunction implements DoubleFunctionOfTwoInts
{
	public double fOfXY(int x, int y)
	{
		Complex c = new Complex(x, y);
		return Math.sqrt(c.getReal()*c.getReal() + c.getImaginary()*c.getImaginary());
	}
	
	public String getName()
	{
		return "ComplexNormFunction";
	}

}
