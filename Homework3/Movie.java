package movies;

public class Movie implements Comparable<Movie>
{
	
	private String title;  
	private int year;
	
	public Movie(String title, int year)
	{
		this.title = title;
		this.year = year;
	}
	
	public int compareTo(Movie that)
	{
		int cmp = this.title.compareTo(that.title);
		if (cmp != 0)
		{
			return cmp;
		}
		else
		{
			return this.year - that.year;
		}
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String toString()
	{
		return "Movie " + title + " (" + year + ")";
	}
	
	public int hashCode()
	{
		return title.hashCode() + year;
	}
	
	public boolean equals(Object x)
	{
		Movie that = (Movie)x;
		return this.compareTo(that) == 0;
	}
	
	public static Movie[] getTestMovies()
	{
		Movie[] testMovies = new Movie[10];
		
		// Same title, different years.
		int n = 0;
		testMovies[n++] = new Movie("The Thomas Crown Affair", 1968);
		testMovies[n++] = new Movie("The Thomas Crown Affair", 1999);
		
		// Different titles, same year.
		testMovies[n++] = new Movie("The Martian", 2015);
		testMovies[n++] = new Movie("Bridge of Spies", 2015);
		
		// Deeply equal: same title and year.
		testMovies[n++] = new Movie("Guardians of the Galaxy", 2014);
		testMovies[n++] = new Movie("Guardians of the Galaxy", 2014);

		// These can be anything.
		testMovies[n++] = new Movie("Out of Africa", 1985);
		testMovies[n++] = new Movie("Casablanca", 1942);
		testMovies[n++] = new Movie("A Man For All Seasons", 1966);
		testMovies[n++] = new Movie("Thunderball", 1965);
		
		return testMovies;

		
	}

}
