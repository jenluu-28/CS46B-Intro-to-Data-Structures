package func;

public class Complex 
{
	private double			real;
	private double			imaginary;
	
	
	// Constructs an instance, given its real and imaginary components.
	// Complete this constructor, then remove this comment line.
	public Complex(double real, double imaginary)
	{
		this.real = real; 
		this.imaginary = imaginary;
		
	}
	
	
	// Constructs an instance that duplicates source.
	// Complete this constructor, then remove this comment line.
	public Complex(Complex source)
	{
		Complex duplicate = source;
	}
	
	
	// Getter method.
	public double getReal()
	{
		return real;
	}
	

	// Getter method.
	public double getImaginary()
	{
		return imaginary;
	}
	
	
	//
	// Constructs and returns a new instance of Complex that represents the sum of its inputs,
	// according to the following formula:
	//
	// (a+bi) plus (c+di) = (a+c) + (b+d)i
	// 	
	// Complete this method, then remove this comment line.
	// 
	public static Complex add(Complex c1, Complex c2)
	{
		double realNumbers = c1.getReal() + c2.getReal();
		double imaginaryNumbers = c1.getImaginary() + c2.getImaginary();
		
		return new Complex(realNumbers, imaginaryNumbers);
	}
	
	
	//
	// Constructs and returns a new instance of Complex that represents the product of its inputs,
	// according to the following formula:
	//
	// (a+bi) times (c+di) = a*c + a*di + bi*c + bi*di = ac + (ad+bc)i + bd*ii
	// Since ii is -1 by definition, the last term is -bd ==> the result is ac-bd + (ad+bc)i
	//
	// Complete this method, then remove this comment line.
	//
	public static Complex multiply(Complex c1, Complex c2)
	{

		double realNumbers = c1.getReal()*c2.getReal() - c1.getImaginary()*c2.getImaginary();
		double imaginaryNumbers = c1.getReal()*c2.getImaginary() + c1.getImaginary()*c2.getReal();
		
		return new Complex(realNumbers, imaginaryNumbers);
	}
	
	
	//
	// The "norm" of complex number a+bi is the square root of (a^2 + b^2).
	// Complete this method, then remove this comment line.
	//
	public double norm()
	{
		return Math.sqrt(real*real + imaginary*imaginary);
	}
}
