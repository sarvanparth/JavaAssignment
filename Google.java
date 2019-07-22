import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Google 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HashMap<String, HashMap<String, HashSet<String>>> hm = new HashMap<> ();

		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			String info = sc.nextLine();
			String arr[] = info.split("\\s",3);
			if(arr[0].equals("End"))
			{
				break;
			}
			else
			{
				if(!hm.containsKey(arr[0]))
				{
					HashMap<String, HashSet<String>> ohm = new HashMap<> ();
					HashSet<String> hs = new HashSet<> ();
					hs.add(arr[2]);
					ohm.put(arr[1], hs);
					hm.put(arr[0],ohm);
				}
				else
				{
					HashMap<String, HashSet<String>> ohm = hm.get(arr[0]);
					hm.remove(arr[0]);
					if(!ohm.containsKey(arr[1]))
					{
						HashSet<String> hs = new HashSet<> ();
						hs.add(arr[2]);
						ohm.put(arr[1], hs);
						hm.put(arr[0],ohm);
					}
					else
					{
						HashSet<String> hs = ohm.get(arr[1]);
						ohm.remove(arr[1]);
						hs.add(arr[2]);
						ohm.put(arr[1], hs);
						hm.put(arr[0],ohm);
					}
				}	
			}
		}
		
		String main1 = sc.nextLine();
		System.out.println(main1);
		HashMap<String, HashSet<String>> ohm = hm.get(main1);
		if(!ohm.containsKey("company")) 
		{
			HashSet<String> hs = new HashSet<> ();
			ohm.put("company", hs);
			
		}
		if(!ohm.containsKey("pokemon")) 
		{
			HashSet<String> hs = new HashSet<> ();
			ohm.put("pokemon", hs);
			
		}
		if(!ohm.containsKey("parents")) 
		{
			HashSet<String> hs = new HashSet<> ();
			ohm.put("parents", hs);
			
		}
		if(!ohm.containsKey("children")) 
		{
			HashSet<String> hs = new HashSet<> ();
			ohm.put("children", hs);
			
		}
		if(!ohm.containsKey("car")) 
		{
			HashSet<String> hs = new HashSet<> ();
			ohm.put("car", hs);
			
		}
		
        if(hm.containsKey(main1))
        {
            HashMap<String, HashSet<String>> ohm1 = hm.get(main1);
            for(String s:ohm1.keySet())
            {
            	System.out.println(s+":");
            	HashSet<String> hs = ohm.get(s);
            	for(String s2:hs) 
            	{
            		System.out.println(s2);
            	}
            }
        }
		sc.close();
	}
}