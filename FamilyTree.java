import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FamilyTree 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		HashMap<String, HashSet<String>> parentChild = new HashMap<>();
		HashMap<String, String> self1 = new HashMap<String, String>();
		HashMap<String, String> self2 = new HashMap<String, String>();
		HashMap<String, HashSet<String>> childParent = new HashMap<>();
		String mainPart1 = "";
		String mainPart2 = "";
		
		int flag = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("End"))
			{
				break;
			}
			else if(flag == 0)
			{
				mainPart1 = str;
				flag = 1;
			}
			else if(str.contains("-"))
			{
				String temp[]=str.split("\\s-\\s");
				
				// getting the hashset of children
				HashSet<String> children = parentChild.getOrDefault(temp[0], new HashSet<>());
				children.add(temp[1]);
				parentChild.put(temp[0], children);
				
				// getting the hashset of parents
				HashSet<String> parents = childParent.getOrDefault(temp[1],new HashSet<>());
				parents.add(temp[0]);
				childParent.put(temp[1], parents);
			}
			else
			{
				int p = str.lastIndexOf(" ");
				String temp[] = new String[2];
				temp[0]=str.substring(0, p);
				temp[1]=str.substring(p+1);
				self1.put(temp[0], temp[1]);
				self2.put(temp[1], temp[0]);
				
			}
		}
		
		if(mainPart1.contains("/")) // Suppose first Line is a date 
		{
			mainPart2 = self2.get(mainPart1); // Self 2 contain date as key and name as value - Hence Name is Fetched
			System.out.println(mainPart2+  " "+mainPart1);
		}
		else // Suppose First Line is a Name
		{
			mainPart2 = self1.get(mainPart1);// Self 1 contains name as kay and date as value - Hence Date is Fetched
			System.out.println(mainPart1+  " "+mainPart2);
			
		}
		
		//find parent of mainpart
		System.out.println("Parents:");
		HashSet<String> parent1 = childParent.getOrDefault(mainPart1, new HashSet<>()); // mainpart1 can be date or name - Used child parent so that key is child and value is parent
		HashSet<String>parent2 = childParent.getOrDefault(mainPart2, new HashSet<>()); // mainpart2 can be date or name - Used child parent so that key is child and value is parent
		HashSet<String> mainPartParents = new HashSet<>();
		for(String s : parent1)
		{
			if(s.contains("/"))
			{
				s = self2.get(s); // key is date and value is name
			}
			if(!mainPartParents.contains(s))// if a parent name or date is already present then it wont add it again
			{
				mainPartParents.add(s);
				System.out.println(s+  " "+self1.get(s)); // s is name and self 1 contains date as value.
			}
			
		}
		for(String s: parent2)
		{
			if(s.contains("/"))
			{
				s = self2.get(s); // key is date and value is name
			}
			if(!mainPartParents.contains(s)) // if a parent name or date is already present then it wont add it again
			{
				mainPartParents.add(s);
				System.out.println(s+  " "+self1.get(s)); // s is name and self 1 contains date as value.
			}
		}
		
		// find children mainpart
		System.out.println("Children:");
				HashSet<String> child1 = parentChild.getOrDefault(mainPart1, new HashSet<>());
				HashSet<String> child2 = parentChild.getOrDefault(mainPart2, new HashSet<>());
				HashSet<String> mainPartChildren = new HashSet<>();
				for(String s : child1)
				{
					if(s.contains("/"))
					{
						s = self2.get(s);
					}
					if(!mainPartChildren.contains(s))
					{
						mainPartChildren.add(s);
						System.out.println(s+  " "+self1.get(s));
					}
				}
				for(String s: child2)
				{
					if(s.contains("/"))
					{
						s = self2.get(s);
					}
					if(!mainPartChildren.contains(s))
					{
						mainPartChildren.add(s);
						System.out.println(s+  " "+self1.get(s));
					}
				}
		
		sc.close();
		
	}

}
