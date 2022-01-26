package demoJava8;

import java.util.Arrays;
import java.util.Collections;

public class App {

	public static void main(String[] args) {
		lambdas();
	}
	
	private static void programmationFonctionnelle() {
		String [] tab= {"olivier","Paul","Victor","clement"};
		Arrays.sort(tab,Trieur::trier);
		for(String s:tab) {
			System.out.println(s);
		}
	}
	
	private static void lambdas() {
		String [] tab= {"olivier","Paul","Victor","clement"};
		//Arrays.sort(tab,(s1,s2)->s1.compareToIgnoreCase(s2));
		Arrays.sort(tab,(s1,s2)->{
			if(s2.equalsIgnoreCase("olivier")) return 1;
			return s1.compareToIgnoreCase(s2);
		});
		for(String s:tab) {
			System.out.println(s);
		}
	}
	
	private static void collection() {
		
	}

}
