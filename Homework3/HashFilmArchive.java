package movies;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;

public class HashFilmArchive extends HashSet<Movie> implements FilmArchive
{

	public ArrayList<Movie> getSorted()
	{
		TreeSet<Movie> sorter = new TreeSet<Movie>(this);
		return  new ArrayList<Movie>(sorter);
		
	}
}
