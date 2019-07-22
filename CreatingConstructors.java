import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class CreatingConstructors {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		Class personClass = Person.class;
		
		Constructor emptyCtor = personClass.getDeclaredConstructor();
		Constructor ageCtor = personClass.getDeclaredConstructor(int.class);
		Constructor nameAgeCtor = personClass.getDeclaredConstructor(String.class, int.class);
		
		String name = reader.readLine();
		int age = Integer.parseInt(reader.readLine());
		
		Person basePerson = (Person) emptyCtor.newInstance();
		Person personWithAge = (Person) ageCtor.newInstance(age);
		Person personFull = (Person) nameAgeCtor.newInstance(name, age);
		
		System.out.println(basePerson.getName()+" "+basePerson.getAge());
		System.out.println(personWithAge.getName()+" "+personWithAge.getAge());
		System.out.println(personFull.getName()+" "+personFull.getAge());
	}

}

class Person
{
	private String name;
	private int age;
	
	Person()
	{
		this.name = "No Name";
		this.age = 1;
	}
	
	Person(int a)
	{
		this.name = "No Name";
		this.age = a;
	}
	
	Person(String s, int a)
	{
		this.name = s;
		this.age = a;
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