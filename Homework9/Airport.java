package airlines;

import java.util.*;


public class Airport implements Comparable<Airport>
{
	private String					name;
	private int						x;
	private int						y;
	private Set<Airport>			connections;	// all airports with a direct route to/from this airport
	
	
	public Airport(String name, int x, int y)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		connections = new TreeSet<>();
	}
	
	
	public String getName()
	{
		return name;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	
	public int getY()
	{
		return y;
	}
	
	
	public List<Airport> getConnections()
	{
		return new ArrayList<>(connections);
	}
	
	
	// Adds that airport to the list of connections. This is a one-way route, so
	// this airport is not connected to that's list of connections.
	public void connectTo(Airport that)
	{
		connections.add(that);
	}
	
	
	
	// Does nothing if this airport is not connected to that.
	public void disconnectFrom(Airport that)
	{
		if (!this.isConnectedTo(that))
		{
			return;
		}
	}
	
	
	//Returns true if the airports have the same name 
	public boolean equals(Object x)
	{
		Airport that = (Airport)x;
		return this.compareTo(that) == 0;
	}
	
	
	// That airport is compared to this airport by name
	public int compareTo(Airport that)
	{
	
		return this.name.compareTo(that.name);
	}
	
	
	//Goes through the connections of this airport
	//Returns true if that is in this connections
	public boolean isConnectedTo(Airport that)
	{
		
		
		for (Airport current: connections)
		{
			if (current.equals(that))
			{
				return true;
			}
		}
		return false;
		
		
	}
	
	
	//Returns an airport's string representation of its name and x, y location
	public String toString()
	{
		return "Airport " + name + " @(" + x + "," + y + ")";
	}
}
