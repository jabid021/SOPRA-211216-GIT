package demoJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		collection();
	}

	private static void programmationFonctionnelle() {
		String[] tab = { "olivier", "Paul", "Victor", "clement" };
		Arrays.sort(tab, Trieur::trier);
		for (String s : tab) {
			System.out.println(s);
		}
	}

	private static void lambdas() {
		String[] tab = { "olivier", "Paul", "Victor", "clement" };
		// Arrays.sort(tab,(s1,s2)->s1.compareToIgnoreCase(s2));
		Arrays.sort(tab, (s1, s2) -> {
			if (s2.equalsIgnoreCase("olivier"))
				return 1;
			return s1.compareToIgnoreCase(s2);
		});
		for (String s : tab) {
			System.out.println(s);
		}
	}

	private static void collection() {
		// ensemble d'objet du meme type
		// fonction ajout, suppression
		// non indexe
		Collection<Point> maCollection = null;
		// collection avec index
		List<Point> maList = null;
		// collection sans doublon
		// utilise hashcode et equals
		Set<Point> uneSet = null;
		// set ordonnee sous reserve que les objets encapsulés implementent Comparable
		SortedSet<Point> uneSortedSet = null;

		// maList=new ArrayList<Point>();
//		maList=new LinkedList<Point>();
//		maList.add(new Point(1, 2));
//		maList.add(new Point(1, 2));
//		
//		for(int i=0;i<maList.size();i++) {
//			System.out.println(maList.get(i));
//		}

//		uneSet=new HashSet<Point>();
//		uneSet.add(new Point(1, 2));
//		uneSet.add(newoint(1, 2));
//		Point unPoint=new Point(1,2);
//		uneSet.add(unPoint);
//		uneSet.add(unPoint);

//		uneSortedSet = new TreeSet<Point>();
//		uneSortedSet.add(new Point());
//		uneSortedSet.add(new Point(1, 2));
//		uneSortedSet.add(new Point(1, 2));
//		uneSortedSet.add(new Point(0, 1));
//
//		for (Point p : uneSortedSet) {
//			System.out.println(p.getX() + " " + p.getY());
//		}
//		

//		methode();
//		methode("hello","world");
//		
//		methodeAvecCollection();
//		

		maList = Arrays.asList(new Point(3, 4), new Point(), new Point(2, 3), new Point(0, 1));

		maList.forEach(System.out::println);
		System.out.println("----------------");
		maList.stream().filter(point -> point.getX() == 0).forEach(System.out::println);

		for (Point p : maList) {
			if (p.getX() == 0) {
				System.out.println(p);
			}
		}

		System.out.println("----------------");
		maList.stream().map(point -> point.getY()).forEach(System.out::println);
		System.out.println("----------------");
		List<Double> lesY = maList.stream().map(point -> point.getY()).collect(Collectors.toList());
		System.out.println(lesY);
		System.out.println("----------------");
		Double sommeDesY = maList.stream().collect(Collectors.summingDouble(Point::getY));
		System.out.println(sommeDesY);

	}

	private static void methode(String... strings) {
		System.out.println("la methode");
		for (String s : strings) {
			System.out.println(s);
		}
	}

	private static void methodeAvecCollection(Collection<String> colleciton) {
		for (String s : colleciton) {
			System.out.println(s);
		}
	}

}
