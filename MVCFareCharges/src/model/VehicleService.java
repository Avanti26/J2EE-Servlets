package model;

public class VehicleService 
{
	public double calculateFare(String vehicletype,double km)
	{
		double totalAmount=0.0;
		
		switch(vehicletype)
		{
			case "auto": totalAmount=km*6;
						 break;
						 
			case "mini": totalAmount=km*8;
						 break;
						 
			case "prime": totalAmount=km*10;
						  break;
		}
		return totalAmount;
	}
	
	public int calculateWaitingCharges(int minutes)
	{
		int totalwaitingcharges=minutes*2;
		
		return totalwaitingcharges;
	}
}
