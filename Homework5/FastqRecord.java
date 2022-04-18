package dna;

//
// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//


public class FastqRecord implements DNARecord 
{
	private String defline; 
	private String sequence; 
	private String quality;
	
	
	// Add a precondition check: throw RecordFormatException if the 1st char of the defline is 
	// not '@'. You will have to change the ctor declaration to say that it throws
	// the exception. The exception should contain a useful informative message
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException
	{
		if (!defline.substring(0,1).equals("@"))
		{
			throw new RecordFormatException("Bad first char in defline. Saw " + defline.substring(0,1) + ". Expected @");
		}
		
		//initialize instance variables
		this.defline = defline; 
		this.sequence = sequence; 
		this.quality = quality;
		
	}
	
	
	// Provide the 2 methods that satisfy the interface.
	public String getDefline()
	{
		return defline;
	}
	
	public String getSequence()
	{
		return sequence;
	}

	
	// Provide an equals() method that checks for deep equality of all 3 instance variables. 
	public boolean equals(Object x)
	{
		FastqRecord that = (FastqRecord)x;
		return defline.equals(that.defline) && sequence.equals(that.sequence) && quality.equals(that.quality);
	}
	
	
	
	// Complete this. Return true if quality contains at least one '!' char
	// or at least one ‘#’ char.
	public boolean qualityIsLow()
	{
		return quality.contains("!") || quality.contains("#");

	}
	
	

	// Complete this. Return the sum of the hash codes of defline, sequence, and quality.
	public int hashCode()
	{
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();
	}
}
