import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PokemonTrainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Trainer> hs = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			String info = sc.nextLine();
			String values[] = info.split("\\s");
			if(values[0].equals("Tournament"))
			{
				break;
			}
			else
			{
				Pokemon p = new Pokemon();
				p.name = values[1];
				p.element = values[2];
				p.health = Integer.parseInt(values[3]);
				List<Pokemon> poke = new ArrayList<Pokemon> ();
				poke.add(p);
				Trainer t = new Trainer(values[0],0,poke);
				if(hs.size()==0)
				{
					hs.add(t);
				}
				else
				{
					int flag = 0;
					for(int i=0;i<hs.size();i++)
					{
						Trainer t2 = hs.get(i);
						if(t2.name.equals(values[0]))
						{
							List<Pokemon> p2 = t2.p;
							p2.add(p);
							t2.p = p2;
							hs.remove(i);
							hs.add(i, t2);
							flag = 1;
							break;
						}
					}
					if(flag == 0)
					{
						hs.add(t);
					}
						
				}
			}
		}
		while(true)
		{
			String info2 = sc.nextLine();
			if(info2.equals("End"))
			{
				break;
			}
			else
			{
				for(int i=0;i<hs.size();i++)
				{
					Trainer t = hs.get(i);
					List<Pokemon> p = t.p;
					int flag2 = 0;
					for(int j=0; j<p.size();j++)
					{
						
						Pokemon poke = p.get(j);
						
						if(poke.element.equals(info2))
						{
							t.badges++;
							flag2 = 1;
						}
						
					}
					if(flag2!=1)
					{
						for(int j=0; j<p.size();j++)
						{
							Pokemon poke = p.get(j);
							poke.health = poke.health - 10;
							if(poke.health <= 0)
							{
								p.remove(j);
							}
						}	
					}
				}
			}
		}
		for(int i=0; i<hs.size();i++)
		{
			Trainer t = hs.get(i);
			List<Pokemon> p = t.p;
			int count = p.size();
			System.out.println(t.name+" "+t.badges+" "+count);
		}
		sc.close();
	}

}

class Trainer
{
	public String name;
	public int badges;
	List<Pokemon> p = new ArrayList<Pokemon> ();
	
	public Trainer(String name, int b, List<Pokemon> p)
	{
		this.name = name;
		this.badges = b;
		this.p = p;
	}
}

class Pokemon
{
	public String name;
	public String element;
	public int health;
}