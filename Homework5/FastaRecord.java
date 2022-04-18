package dna;


public class FastaRecord implements DNARecord 
{	
	private String defline; 
	private String sequence; 
	
	
	// Add a precondition check: throw RecordGFormatException if the 1st char of the defline is 
	// not '>'. You will have to change the ctor declaration to say that it throws
	// the exception. The exception should contain a useful informative message.
	//
	public FastaRecord(String defline, String sequence) throws RecordFormatException
	{
		if (!defline.substring(0,1).equals(">"))
		{
			throw new RecordFormatException("Bad first char in sequence. Saw: " + defline.substring(0,1) + ". Expected: >");
		}
		this.defline = defline;
		this.sequence = sequence;
		
	}
	
	
	// Initialize defline and sequence from the input record. The defline should be the
	// defline of the fastq record, but with a '>' in the first position rather than a '@'.
	// If you’re not sure how to do this, look up the substring method on the String API page.
	public FastaRecord(FastqRecord fastqRec)
	{
		String oldDefline = fastqRec.getDefline();
		String newDefline = ">" + oldDefline.substring(1);
		
		defline = newDefline; 
		sequence = fastqRec.getSequence();

	}
	
	

	public String getDefline()
	{
		return defline;
	}
	
	public String getSequence()
	{
		return sequence;
	}

	
	
	//
	// Provide an equals() method. 
	//
	public boolean equals(Object x)
	{
		FastaRecord that = (FastaRecord)x;
		return this.defline.equals(that.defline) && this.sequence.equals(that.sequence);
	}
	

	//
	// Provide a hashCode() method that returns the sum of the hashcodes of 
	// defline and sequence.
	//
	public int hashCode()
	{
		return defline.hashCode() + sequence.hashCode();
	}
}
