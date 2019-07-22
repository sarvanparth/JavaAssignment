import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class CarSalesman 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> hm = new HashMap<> ();
		List<String> ans = new LinkedList<String> ();
		String ecount = sc.nextLine();
		int a = Integer.parseInt(ecount);
		while(a!=0)
		{
			String str = sc.nextLine();
			String values[] = str.split("\\s");
			hm.put(values[0], str);
			a--;
			
		}
		String ccount = sc.nextLine();
		int b = Integer.parseInt(ccount);
		while(b!=0)
		{
			String str = sc.nextLine();
			String values[] = str.split("\\s");
			Car c = null;
			if(values.length==4)
			{
				c = new Car(values[0], values[2], values[3]);
				
			}
			else if(values.length==2)
			{
				c = new Car(values[0],"n/a", "n/a");
			}
			else 
			{
				if(Character.isDigit(values[2].charAt(0))) 
				{
					c = new Car(values[0],values[2], "n/a");
				}
				else
				{
					c = new Car(values[0],"n/a", values[2]);
				}
			}
			c.setEngine(hm.get(values[1]));
			ans.add(c.printOutput());
			b--;	
		}
		for(String s:ans)
		{
			System.out.println(s);
		}
		sc.close();	
	}
}


class Engine
{
	
	private String model;
	private String power;
	private String displacement;
	private String efficiency;
	
	public Engine(){}
	
	public Engine(String model, String power, String displacement, String efficiency) 
	{
		this.model = model;
		this.power = power;
		this.displacement = displacement;
		this.efficiency = efficiency;
	}
	
	public String getModel() 
	{
		return model;
	}
	
	public String getPower() 
	{
		return power;
	}
	public String getDisplacement() 
	{
		return displacement;
	}
	public String getEfficiency() 
	{
		return efficiency;
	}
	
}

class Car
{
	
	public String model;
	public String weight;
	public String color;
	public Engine e;
	
	public Car() {}
	public Car(String model, String weight, String color)
	{	
		this.model = model;
		this.weight = weight;
		this.color = color;
	}

	public String printOutput()
	{
		return model+":"+"\n\t"+e.getModel()+":\n\t\tPower: "+e.getPower()+
				"\n\t\tDisplacement: "+e.getDisplacement()+"\n\t\tEfficiency: "+e.getEfficiency()+
				"\n\tWeight: "+this.weight+"\n\tColor: "+color;
	}
	
	
	public void setEngine(String str)
	{
		String values[] = str.split("\\s");
		Engine e;
		if(values.length == 3)
		{
			e = new Engine(values[0], values[1], values[2], "n/a");
		}
		else
		{
			e = new Engine(values[0], values[1], values[2], values[3]);
		}
		
		this.e = e;
	}
	
	public Engine getEngine() 
	{
		return this.e;
	}
}