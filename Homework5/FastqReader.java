package dna;

import java.io.*;


//
// Reads lines from a BufferedReader and builds a FastqRecord.
//


public class FastqReader 
{
	
	private BufferedReader theBufferedReader;
	
	//Ctor
	public FastqReader(BufferedReader theBufferedReader)
	{
		this.theBufferedReader = theBufferedReader;
	}
	
	
	
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		// Read the defline from the BufferedReader. Return null if you read null, 
		// indicating end of file.
		
		String defline = theBufferedReader.readLine();
		if (defline == null)
		{
			return null;
		}
		String sequence = theBufferedReader.readLine();
		theBufferedReader.readLine();
		String quality = theBufferedReader.readLine();
		
		return new FastqRecord(defline, sequence, quality);
		
	}
}
