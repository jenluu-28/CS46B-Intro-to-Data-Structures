package movies;

import java.util.ArrayList;
import java.util.TreeSet;

//extends FIRST, then implements
public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive
{
	
	@Override
	public boolean add(Movie addMe)
	{
		for (Movie current: this)
		{
			if (current.equals(addMe))
			{
				return false;
			}
		}
	
		super.add(addMe);
		return true;
	}
	
	@Override
	public ArrayList<Movie> getSorted()
	{
		TreeSet<Movie> sorter = new TreeSet<Movie>(this);
		return  new ArrayList<Movie>(sorter);
		
	}
	
	public static void main(String[] args) 
		{
		ListFilmArchive archive = new ListFilmArchive(); for (Movie m: Movie.getTestMovies())
		archive.add(m); for (Movie m: archive)
		System.out.println(m); System.out.println("**************"); for (Movie m: archive.getSorted())
		System.out.println(m);
		}

}
