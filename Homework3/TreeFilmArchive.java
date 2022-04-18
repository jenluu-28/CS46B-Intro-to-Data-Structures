package movies;
import java.util.TreeSet;
import java.util.ArrayList;

public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive
{
	public ArrayList<Movie> getSorted()
	{
		return new ArrayList<Movie>(this);
	}

}
