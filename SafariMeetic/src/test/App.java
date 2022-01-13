package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.DAOAnimal;
import dao.DAOCompte;
import dao.DAOFiche;
import dao.DAOMatch;
import model.Admin;
import model.Adresse;
import model.Animal;
import model.Chat;
import model.Chien;
import model.Client;
import model.Compte;
import model.Fiche;
import model.Match;
import model.Refuge;
import model.Vendeur;

public class App {


	static Compte connected = null;
	static DAOCompte daoC = new DAOCompte();
	static DAOFiche daoF = new DAOFiche();
	static DAOAnimal daoA = new DAOAnimal();
	static DAOMatch daoM = new DAOMatch();


	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}


	/*public static void matchForClient() {
	
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");
		
		PreparedStatement ps = conn.prepareStatement("SELECT * from fiche");
		
		ResultSet rs = ps.executeQuery();
		
		List<Fiche> fiches = new ArrayList();
		
		Fiche f = null;
		
		while(rs.next()) 
		{
			Animal a = AnimalfindById(rs.getInt("animal"));
			Vendeur v = (Vendeur) ComptefindById(rs.getInt("vendeur"));
			f = new Fiche(rs.getInt("id_fiche"),rs.getString("description"), LocalDate.parse(rs.getString("creation")), rs.getString("nom"), 
					rs.getString("sexe"), rs.getInt("age"), rs.getInt("puce"), rs.getDouble("poids"), rs.getString("couleur"),
					rs.getBoolean("sociable"), a,v);
			fiches.add(f);
		}
		
				
		for (Fiche f1 : fiches) {
			
							
				System.out.println(f1);
				String choix = saisieString("Voulez-vous matcher avec cet animal N/Y");
		
				if (choix .equals("Y")) {
					PreparedStatement ps1 = conn.prepareStatement("INSERT INTO matchs (fiche,client) VALUES (?,?)");
					ps1.setInt(1,f1.getId());
					ps1.setInt(2,connected.getId());
					ps1.executeUpdate();
				}
		
		}
		rs.close();
		ps.close();
		conn.close();
		
		
	
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		
	}
	}

*/

	public static void main(String[] args) {
		menuPrincipal();
	}

	public static void menuPrincipal() {

		System.out.println("Menu principal");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Inscription");
		System.out.println("3 - Fermer l'appli");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : connexion();break;
		case 2 : inscription();break;
		case 3 : System.exit(0);break;
		}
		menuPrincipal();
	}


	public static void connexion() {

		System.out.println("Connexion");
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		connected= daoC.seConnecter(login, password);

		if(connected instanceof Client) {menuClient();}
		else if(connected instanceof Vendeur) {menuVendeur();}
		else if(connected instanceof Admin) {menuAdmin();}
		else if(connected ==null) 
		{
			System.out.println("Identifiants invalides !");
		}
		menuPrincipal();


	}

	public static void menuAdmin() {

		System.out.println("Menu Admin");
		System.out.println("1 - Afficher toutes les fiches");
		System.out.println("2 - Afficher tous les comptes");
		System.out.println("3 - Afficher tous les animals");
		System.out.println("4 - Afficher tous les matchs");
		System.out.println("5 - Ajouter un animal");
		System.out.println("6 - Modifier un animal");
		System.out.println("7 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : showAllFiches();break;
		case 2 : showAllComptes();break;
		case 3 : showAllAnimaux();break;
		case 4 : showAllMatchs();break;
		case 5 : addAnimal();break;
		case 6 : updateAnimal();break;
		case 7 : connected=null;menuPrincipal();break;
		}

		menuAdmin();
	}





	public static void menuVendeur() {

		System.out.println("Menu Vendeur");
		System.out.println("1 - Consulter mes fiches");
		System.out.println("2 - Ajouter une nouvelle fiche");
		System.out.println("3 - Modifier une fiche");
		System.out.println("4-  Supprimer une fiche ");
		System.out.println("5 - Voir les matchs de mes fiches ");
		System.out.println("6-  Modifier mon profil ");
		System.out.println("7 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : showFichesVendeur();break;
		case 2 : addFiche();break;
		case 3 : updateFiche();break;
		case 4 : deleteFiche();break;
		case 5 : showMatchsVendeur();break;
		case 6 : modifierInfosVendeur();break;
		case 7 : connected=null;menuPrincipal();break;
		}

		menuVendeur();

	}



	public static void menuClient() {

		System.out.println("Menu Client");
		System.out.println("1 - Consulter les fiches");
		System.out.println("2 - Consulter mes match");
		System.out.println("3- Modifier mon profil");
		System.out.println("4 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : clientMatch();break;
		case 2 : showMatchsClient();break;
		case 3 : modifierInfosClient();break;
		case 4 : connected=null;menuPrincipal();break;
		}

		menuClient();
	}


	//GESTION DES COMPTES

	public static void inscription() {
		//choisir si on veut un compte client / vendeur
		//Si client, saisir login,password,mail,adresse,tel
		//Si vendeur, saisir login,password,mail,refuge,adresse
		

		
		System.out.println("1 - Client");
		System.out.println("2 - Vendeur");
		
		int choix = saisieInt("Choisir un type de compte");
		
		if ( choix ==1) {
			String log= saisieString("Entrer votre login");
			String pass= saisieString("Entrer votre password");
			String mail= saisieString("Entrer votre mail");
			String tel= saisieString("Entrer votre numero de telephone");
			System.out.println("Entrer votre adresse");
			Adresse adr = new Adresse(saisieString("Entrer votre numero"),saisieString("Entrer votre voie"),saisieString("Entrer votre ville"),saisieString("Entrer votre code postal"));
			Compte c = new Client(1,log,pass,mail,tel,adr);
			daoC.insert(c);
		}
		else if ( choix ==2) {
			String log= saisieString("Entrer votre login");
			String pass= saisieString("Entrer votre password");
			String mail= saisieString("Entrer votre mail");
			

			String refuge = saisieString("Saisir refuge "+Arrays.toString(Refuge.values()));
			System.out.println("Entrer votre adresse");
			Adresse adr = new Adresse(saisieString("Entrer votre numero"),saisieString("Entrer votre voie"),saisieString("Entrer votre ville"),saisieString("Entrer votre code postal"));
			Compte c = new Vendeur(1,log,pass,mail,Refuge.valueOf(refuge),adr);
			daoC.insert(c);
		}

		
		
	}

	public static void modifierInfosVendeur() {
		//Pouvoir modifier login/mail/password/adresse(numero,voie,cp,ville) / refuge
		
		System.out.println("Menu modification donnees Vendeur");
		System.out.println("1 - Modification login");
		System.out.println("2 - Modification mail");
		System.out.println("3 - Modification password");
		System.out.println("4 - Modification numero ");
		System.out.println("5 - Modification voie ");
		System.out.println("6 - Modification ville");
		System.out.println("7 - Modification cp");
		System.out.println("8 - Modification refuge");
		System.out.println("9 - Sauvgarder toutes les modifications et revenir vers le menu Vendeur");
		System.out.println("10 - Annuler toutes les modifications et revenir vers le menu Vendeur");

		int choix = saisieInt("Choisir votre action");
		
		Vendeur c=((Vendeur)connected);
		
		
		switch(choix) 
		{
		case 1 : c.setLogin(saisieString("Veuillez saisir votre nouveau login : "));break;
		case 2 : c.setMail(saisieString("Veuillez saisir votre nouveau mail: "));break;
		case 3 : c.setPassword(saisieString("Veuillez saisir votre nouveau password : "));break;
		case 4 : c.getAdresse().setNumero(saisieString("Veuillez saisir votre nouveau numero : "));break;
		case 5 : c.getAdresse().setVoie(saisieString("Veuillez saisir votre nouvelle voie : "));break;
		case 6 : c.getAdresse().setVille(saisieString("Veuillez saisir votre nouvelle ville : "));break;
		case 7 : c.getAdresse().setCp(saisieString("Veuillez saisir votre nouveau CP : "));break;
		case 8 : c.setRefuge(Refuge.valueOf(saisieString("Veuillez saisir votre nouveau refuge : ")));break;
		case 9 : connected=c;daoC.update(c);menuClient();break;
		case 10 : menuClient();break;
		}

		modifierInfosVendeur();
		
	}

	public static void modifierInfosClient() 
	{
		System.out.println("Menu modification donn�es du Client");
		System.out.println("1 - Modification du login");
		System.out.println("2 - Modification du mail");
		System.out.println("3 - Modification du password");
		System.out.println("4 - Modification Adresse : Modification du num�ro");
		System.out.println("5 - Modification Adresse : Modification de la voie");
		System.out.println("6 - Modification Adresse : Modification de la ville");
		System.out.println("7 - Modification Adresse : Modification du cp");
		System.out.println("8 - Modification du tel");
		System.out.println("9 - Sauvgarder toutes les modifications et revenir vers le menu Client");
		System.out.println("10 - Annuler toutes les modifications et revenir vers le menu Client");

		int choix = saisieInt("Choisir une action");
		
		Client c=((Client)connected);

		switch(choix) 
		{
		case 1 : c.setLogin(saisieString("Veuillez saisir votre nouveau login : "));break;
		case 2 : c.setMail(saisieString("Veuillez saisir votre nouveau mail: "));break;
		case 3 : c.setPassword(saisieString("Veuillez saisir votre nouveau password : "));break;
		case 4 : c.getAdresse().setNumero(saisieString("Veuillez saisir votre nouvelle adresse : nouveau numero : "));break;
		case 5 : c.getAdresse().setVoie(saisieString("Veuillez saisir votre nouvelle adresse : nouvelle voie : "));break;
		case 6 : c.getAdresse().setVille(saisieString("Veuillez saisir votre nouvelle adresse : nouvelle ville : "));break;
		case 7 : c.getAdresse().setCp(saisieString("Veuillez saisir votre nouvelle adresse : nouveau CP : "));break;
		case 8 : c.setTel(saisieString("Veuillez saisir votre nouveau numero : "));break;
		case 9 : connected=c;daoC.update(c);menuClient();break;
		case 10 : menuClient();break;
		}

		modifierInfosClient();
		
	}

	public static void showAllComptes() {
		List<Compte> listComptes = new ArrayList<Compte>();
		listComptes=daoC.findAll();
		for (Compte c:listComptes) {
			System.out.println(c);
		}
		
	}
	//----------------------------------------



	//GESTION DES MATCHS

	public static void showMatchsVendeur() {
		//Afficher les match du vendeur connecte
		List<Match> vendeurMatchs = daoM.MatchfindByVendeurId(connected.getId());
		System.out.println(vendeurMatchs);
		
		
		
	}

	public static void showMatchsClient() {
		//Affiche tous les match du client connected
        List<Match> clientMatchs = daoM.MatchfindByClientId(connected.getId());
		System.out.println(clientMatchs);
		
	}

	public static void showAllMatchs() {		
		
		System.out.println(daoM.findAll());
		
	}


	public static void clientMatch() {
		
	//	matchForClient();
		}
		

	//------------------------------




	//GESTION DES FICHES
	public static void deleteFiche() {
		//Afficher toutes mes fiches 
		showFichesVendeur();
		//Choisir l'id a delete

		int choixId = saisieInt("Choisir l'id de la fiche � supprimer");
		String askSuppr = saisieString( "Etes-vous s�r de vouloir supprimer la fiche :" + daoF.findById(choixId).toString()+ "\n(oui/non)");
		// FichefindById(choixId) ===> Column 'vendeur' not found.

		try {
			if (askSuppr.equalsIgnoreCase("oui"))
			{
				daoF.delete(choixId);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		
	}

	
	public static String printFicheMenu(Fiche f) {
		return " 1- id = " + f.getId() + "\n 2- Description = " + f.getDescription() + "\n 3- Creation = " + f.getCreation()+ "\n 4- Nom = " + f.getNom()
				+ "\n 4- Sexe = " + f.getSexe()+ "\n 5- Age = " + f.getAge() + "\n 6- Puce = " + f.getPuce() + "\n 7- Poids = " + f.getPoids() + "\n 8- Couleur = " + f.getCouleur()
				+ "\n 9- Sociable = " + f.isSociable() + "\n10- Animal = " + f.getAnimal() + "\n11- Vendeur = " + f.getVendeur() + "\n12- Matchs = " + f.getMatchs();
	}
	
	public static void updateFiche() {
		//Afficher toutes mes fiches 
		showFichesVendeur();
		
		//FindById de la fiche � modifier

//		Fiche f = new Fiche(1, "C'est une fiche", LocalDate.now(), "Nom animal", "Male", 5, 681, 3.5, "Roux", false, null, null);
		int id = saisieInt("Saisir l'id de la fiche � modifier :");
		Fiche f = daoF.findById(id);
		
		System.out.println(printFicheMenu(f));
		
		//Saisir les modifs
		if (saisieString("Voulez-vous modifier l'index ? ("+f.getId()+") o/n : ").equalsIgnoreCase("o")) {
			f.setId(saisieInt("Entrez le nouvel index (nombre) : "));
		}
		if (saisieString("Voulez-vous modifier la description ? ("+f.getDescription()+") o/n : ").equalsIgnoreCase("o")) {
			f.setDescription(saisieString("Entrez la nouvelle description (texte) : "));
		}
		if (saisieString("Voulez-vous modifier la date de cr�ation ? ("+f.getCreation()+") o/n : ").equalsIgnoreCase("o")) {
			f.setCreation(LocalDate.parse(saisieString("Entrez le nouvel index (format : yyyy-mm-dd) : ")));
		}
		if (saisieString("Voulez-vous modifier le nom ? ("+f.getNom()+") o/n : ").equalsIgnoreCase("o")) {
			f.setNom(saisieString("Entrez le nouveau nom (texte) : "));
		}
		if (saisieString("Voulez-vous modifier le sexe ? ("+f.getSexe()+") o/n : ").equalsIgnoreCase("o")) {
			f.setSexe(saisieString("Entrez le sexe (male/femelle) : "));
		}
		if (saisieString("Voulez-vous modifier la puce ? ("+f.getPuce()+") o/n : ").equalsIgnoreCase("o")) {
			f.setPuce(saisieInt("Entrez lenouveau num�ro de puce (nombre) : "));
		}
		if (saisieString("Voulez-vous modifier le poids ? ("+f.getPoids()+") o/n : ").equalsIgnoreCase("o")) {
			f.setPoids(saisieDouble("Entrez le nouveau poids (nombre) : "));
		}
		if (saisieString("Voulez-vous modifier la couleur ? ("+f.getCouleur()+") o/n : ").equalsIgnoreCase("o")) {
			f.setCouleur(saisieString("Entrez la nouvelle couleur (texte) : "));
		}
		if (saisieString("Voulez-vous modifier le sociable ? ("+f.getId()+") o/n : ").equalsIgnoreCase("o")) {
			switch(saisieString("l'animal est-il sociable ? (o/n) : ")) {
			case "O":
			case "o":
				f.setSociable(true);
				break;
			case "N":
			case "n":
				f.setSociable(false);
				break;
			default:
				System.out.println("Mauvaise saisie, la valeur n'est pas modifi�e");
				break;
			}
		}

		System.out.println(printFicheMenu(f));
		
		//Envoyer les modifs
		daoF.update(f);
		
	}

	public static void addFiche() {
		
					
		Fiche f = new Fiche(null, null, null, null, null, 0, 0, 0, null, false, null, null);
		Animal a;
		f.setDescription(saisieString("R�digez la description de l'animal"));
		f.setCreation(LocalDate.now());
		f.setNom(saisieString("Donnez le nom de votre animal"));
		f.setSexe(saisieString("Donnez le sexe de votre animal"));
		f.setAge(saisieInt("Donnez l'age de votre animal"));
		f.setPuce(saisieInt("Donnez le numero de puce de votre animal"));
		f.setPoids(saisieDouble("Donnez le poids de votre animal"));
		f.setCouleur(saisieString("Renseignez la couleur de votre animal de votre animal"));
		if (saisieString("Votre animal est-il sociable ? (r�pondre oui ou non)").equalsIgnoreCase("oui")) {
			f.setSociable(true);	
			} else {
			System.out.println("Mauvaise saisie, la valeur par d�faut 'non' est conservee");
			}
		switch(saisieString("Votre animal est-il sociable ? (o/n) : ")) {
		case "O":
		case "o":
			f.setSociable(true);
			break;
		case "N":
		case "n":
			f.setSociable(false);
			break;
		default:
			System.out.println("Mauvaise saisie, la valeur par d�faut (non) est conserv�e");
			break;
		}
		do {
			if (saisieString("Quel est le type de votre animal (chat ou chien) ?").equalsIgnoreCase("chien")) {
				Chien c = new Chien(null, null);
				c.setRace(saisieString("Quel est la race de votre chien ?"));
				f.setAnimal(c);	
			} else if (saisieString("Quel est le type de votre animal (chat ou chien) ?").equalsIgnoreCase("chat")) {
					Chat c = new Chat(null, null, false, false);
				c.setRace(saisieString("Quelle est la race de votre chat ?"));
				if (saisieString("Votre chat a-t-il les poils courts (oui ou non) ?").equalsIgnoreCase("oui")) {
					c.setPoilCourt(true);
				}else if (saisieString("Votre chat a-t-il les poils courts (oui ou non) ?").equalsIgnoreCase("non")) {
					c.setPoilCourt(false);
				}else { 
					System.out.println("Mauvaise saisie, la valeur par d�faut (non) est conservee");
				}
				
				if (saisieString("Votre chat porte-t-il malheur (oui ou non) ?").equalsIgnoreCase("oui")) {
					c.setMalheur(true);
				}else if (saisieString("Votre chat porte-t-il malheur (oui ou non) ?").equalsIgnoreCase("non")) {
					c.setMalheur(false);
				}else { 
					System.out.println("Mauvaise saisie, la valeur par d�faut (non) est conservee");
				}
				f.setAnimal(c);	
		}else {
			System.out.println("Mauvaise saisie, merci de r�pondre chat ou chien");
		}
		}while (f.getAnimal() == null);
		
			
		f.setVendeur(((Vendeur)connected));
		
		daoF.insert(f);
	}

	public static void showFichesVendeur() {
		//Afficher les fiches du vendeur connecte
		List<Fiche> fiches = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/safarimeetic?characterEncoding=UTF-8","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from fiche where vendeur = ? ");
			
			ps.setObject(1, connected.getId());
			ResultSet rs = ps.executeQuery();
			
			
			
			

			Fiche f=null;

			while(rs.next()) 
			{
				Animal a = daoA.findById(rs.getInt("animal"));
				Vendeur v = (Vendeur) connected ;
				f = new Fiche(rs.getInt("id_fiche"),rs.getString("description"), LocalDate.parse(rs.getString("creation")), rs.getString("nom"), 
						rs.getString("sexe"), rs.getInt("age"), rs.getInt("puce"), rs.getDouble("poids"), rs.getString("couleur"),
						rs.getBoolean("sociable"), a,v);

				fiches.add(f);
			}

			rs.close();
			ps.close();
			conn.close();
			for ( Fiche i : fiches)
			{
				System.out.println(i.toString());
			}
			

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		
	}


	public static void showAllFiches() {
		//Afficher toutes les fiches
				List<Fiche> fiches = daoF.findAll();
				
				for ( Fiche fiche : fiches)
				{
					System.out.println(fiche);
				}
		
	}

	//-------------------------------------------


	// Gestion des animals

	public static void showAllAnimaux() {
		for(Animal a : daoA.findAll())
		{
			System.out.println(a);
		}
	}
	

	public static void updateAnimal() {

		// Print all animals
		showAllAnimaux();
		// Select an animal to update
		int choix = saisieInt("Quel animal modifier ?");
		Animal a = daoA.findById(choix);

		if (a instanceof Chien)
		{
			Chien c = (Chien) a;
			c.setRace(saisieString("Quelle race ?"));
			daoA.update(c);
		}
		else if (a instanceof Chat) 
		{
			Chat c = (Chat) a;
			c.setRace(saisieString("Quelle race ?"));

			boolean isPoil = (saisieString("Poil court ? (y/n)").equals("y")) ? true : false;
			c.setPoilCourt(isPoil);

			boolean isMalheur = (saisieString("Porte malheur ? (y/n)").equals("y")) ? true : false;
			c.setMalheur(isMalheur);
			
			daoA.update(c);
		}

	}
	

	public static void addAnimal() {	

		String choix = saisieString("Chien ou chat ?");
		String race = saisieString("Race ?");
		Animal a;

		if (choix.equalsIgnoreCase("chien"))
		{
			a=new Chien(race);
			daoA.insert(a);
		}
		

		else if (choix.equalsIgnoreCase("chat")) {
			String poil = saisieString("Poil court ? (y/n)");
			boolean isPoil=false;
			if(poil.equals("y")) {isPoil=true;}

			boolean isMalheur= (saisieString("Porte malheur ? (y/n)").equals("y")) ? true : false;
			a= new Chat(race, isPoil, isMalheur);
			daoA.insert(a);

		}
		else {System.out.println("C'est quoi cet animal ????");}
	}	

	//---------------------



}
