package airlines;
import java.util.*;

public class FlightNet extends HashSet<Airport>
{

	//Returns false if the FlightNet contains the target name by deep equality
	public boolean nameIsAvailable(String name)
	{
		for (Airport current: this)
		{
			//deep equals matters here
			if (current.getName().equals(name))
			{
				//false because the name is in use
				return false;
			}
		}
		return true;
	}
	
	//Connects a1 to a2
	//Connects a2 to a1
	public void connect(Airport a1, Airport a2)
	{
		a1.connectTo(a2);
		a2.connectTo(a1);
	}
	 
	//Disconnects a1 from a2
	//Disconnects a2 from a1
	public void disconnect(Airport a1, Airport a2)
	{
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);
		
	}
	
	
	
	//Removes the input from the FlightNet
	//Disconnects the input from any airports in the FlightNet
	public void removeAndDisconnect(Airport removeMe)
	{
		this.remove(removeMe);
		for (Airport current: this)
		{
			if (current.equals(removeMe))
			{
				disconnect(current, removeMe);
			}
		}
	}
	
	
	//Checks all the airports in the FlightNet 
	//Returns the airport whose location is within the input maximumDistance
	public Airport getAirportNearXY(int x, int y, int maximumDistance)
	{
		
		int comparedRange = (int)Math.hypot(x, y);
		
		for (Airport current: this)
		{
			int currentRange = (int)Math.hypot(current.getX(), current.getY());
			if (Math.abs(comparedRange - currentRange) <= maximumDistance)
			{
				return current;
			}
		}
		return null;
	}
	
	
	
}
