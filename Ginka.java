import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Ginka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Object> catMap = new HashMap<String, Object>();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String inputString = sc.next();
			if (inputString.equals("End"))
			{
				break;
			}
			String cName = sc.next();
			String unit = sc.next();
			switch(inputString)
			{
			case "Siamese":	Siamese sobj = new Siamese();
							sobj.breed = inputString;
							sobj.name = cName;
							sobj.earSize = Double.parseDouble(unit);
							catMap.put(sobj.name, sobj);
							break;
				
			case "Cymric":	Cymric cobj = new Cymric();
							cobj.breed = inputString;
							cobj.name = cName;
							cobj.furLength =  Double.parseDouble(unit);
							catMap.put(cobj.name, cobj);
							break;
				
			case "StreetExtraOrdinaire":StreetExtraOrdinaire seobj = new StreetExtraOrdinaire();
										seobj.breed = inputString;
										seobj.name = cName;
										seobj.meoingDecibels =  Double.parseDouble(unit);
										catMap.put(seobj.name, seobj);
										break;
				
			default:System.out.println("Wrong Cat Breed");
					break;
			}
		} 
		String printCat = sc.next();
		Object obj = catMap.get(printCat);
		System.out.println(obj.toString());
		sc.close();
	}
}

class Cat{
	String breed;
	String name;
	DecimalFormat df = new DecimalFormat("#.00");
	
}

class Siamese extends Cat{
	double earSize;
	@Override
	public String toString() {
		return String.format(breed+" "+name+" "+df.format(earSize));
	}	
}

class Cymric extends Cat{
	double furLength;
	
	@Override
	public String toString() {
		return String.format(breed+" "+name+" "+df.format(furLength));
	}
}

class StreetExtraOrdinaire extends Cat{
	double meoingDecibels;
	
	@Override
	public String toString() {
		return String.format(breed+" "+name+" "+df.format(meoingDecibels));
	}
}