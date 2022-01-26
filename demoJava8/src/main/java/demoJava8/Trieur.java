package demoJava8;

public class Trieur {

	public static int trier(String s1,String s2) {
		if(s2.equalsIgnoreCase("olivier")) return 1;
		return s1.compareToIgnoreCase(s2);
	}
}
