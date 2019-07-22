import java.lang.reflect.Field;

public class Demo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Class Person = Person.class;
		Field[] fields = Person.getDeclaredFields();
		System.out.println(fields.length);

		
		Person obj = new Person();
		Field privateStringField1 = Person.class.getDeclaredField("name");
		Field privateStringField2 = Person.class.getDeclaredField("age");
		
		privateStringField1.setAccessible(true);
		privateStringField2.setAccessible(true);

		String fieldValue1 = (String) privateStringField1.get(obj);
		int fieldValue2 =  (int) privateStringField2.get(obj);
	
		System.out.println("fieldValue = " + fieldValue1);
		System.out.println("fieldValue = " + fieldValue2);
	}

}

class Person
{
	private String name = "Parth";
	private int age = 23;
}






