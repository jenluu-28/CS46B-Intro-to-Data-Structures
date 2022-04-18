package func;

public class ComplexSquaredNormFunction implements DoubleFunctionOfTwoInts
{
	public double fOfXY(int x, int y)
	{
		Complex c1 = new Complex(x, y);
		Complex c2 = new Complex(x, y);
		
		double real = c1.getReal()*c2.getReal() - c1.getImaginary()*c2.getImaginary();
		double imaginary = c1.getReal()*c2.getImaginary() + c1.getImaginary()*c2.getReal();
		
		return Math.sqrt(real*real + imaginary*imaginary);
			
		
	}
	
	public String getName()
	{
		return "ComplexSquaredNormFunction";
	}

}
