import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class OpinionPoll {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	HashMap<String,Integer> hm = new HashMap<> ();
	Scanner sc = new Scanner(System.in);
	String s = sc.nextLine();
	int a = Integer.parseInt(s);
	while(a!=0)
	{
		String str = sc.nextLine();
		String values[] = str.split("\\s");
		person obj = new person();
		obj.setName(values[0]);
		obj.setAge(Integer.parseInt(values[1]));
		hm.put(obj.getName(), obj.getAge());
		a--;	
	}
	ArrayList<String> sortedKeys = new ArrayList<String>(hm.keySet());
	Collections.sort(sortedKeys);
	for (String x : sortedKeys) 
	{
		if(hm.get(x)>30)
		{
			System.out.println(x+" - "+hm.get(x));
		}	 
	}
	sc.close();
	}
}

class person
{
	private String name;
	private int age;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public String getName()
	{
		return name; 
	}
	
	public int getAge()
	{
		return age;
	}
}