package br.com.ufal.ui;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.ufal.database.Database;
import br.com.ufal.pledge.Pledge;
import br.com.ufal.project.*;
import br.com.ufal.reward.Reward;
import br.com.ufal.user.Profile;
import br.com.ufal.user.User;
import br.com.ufal.util.Location;

public class UI {

	private Scanner input;
	private Database database;
	private User userLogged;
	
	public UI(){
		
		input = new Scanner(System.in);
		database = Database.getInstance();

	}
	
	public void showInitialPage(){
	
		int option = -1;
				
		do{
			
			if(userLogged == null)
				option = showMenu();
			else
				option = showMenuWithUserLogged();
			
		}while(option != 0);
		
		input.close();
			
	}
	
	
	private int showMenu() {
		
		System.out.println("KickStarter\n\n" +
				   "1. Login\n" +
				   "2. Criar conta" +
				   "3. Buscar projetos\n" +
				   "4. Criar projeto\n" +
				   "0. Fechar");
		int option = -1;
		try{
			option = Integer.valueOf(input.next());
			
			switch(option){
			
				case 1:
					login();
					break;
				case 2:
					signUp();
					break;
				case 3:
					searchProject();
					break;
				case 4:
					createProject();
					break;
			
			}
			
		} catch(NumberFormatException e) {
			System.out.println("Entrada inválida!");
			option = -1;
		}
		
		return option;
		
	}
	
	private int showMenuWithUserLogged() {
		
		System.out.println("KickStarter\n\n" +
				   "1. Buscar projetos\n" +
				   "2. Criar projeto\n" +
				   "3. Editar conta" +
				   "4. Editar perfil" +
				   "5. Editar projeto" +
				   "6. Sair\n" +
				   "0. Fechar");
		int option = -1;
		try{
			option = Integer.valueOf(input.next());
			
			switch(option){
			
				case 1:
					searchProject();
					break;
				case 2:
					createProject();
					break;
				case 3:
					editAccount();
					break;
				case 4:
					editProfile();
					break;
				case 5:
					editProject();
					break;
				case 6:
					signOut();
					break;
			
			}
			
		} catch(NumberFormatException e) {
			System.out.println("Entrada inválida!");
			option = -1;
		}
		
		return option;
		
	}
	
	private void editProject() {
		// TODO Auto-generated method stub
		
	}

	private void editProfile() {
		// TODO Auto-generated method stub
		
	}

	private void editAccount() {

		
		
	}

	private void signUp() {
		
		System.out.println("Primeiro nome:");
		String name = input.nextLine();
		
		String email = "";
		String email2 = "";
		boolean isValid = true;
		do{
			
			System.out.println("Email:");
			email = input.next();
			System.out.println("Confirmar email:");
			email2 = input.next();
			
			if(!email.equals(email2) || email.equals("")){
				System.out.println("Emails inconsistentes");
				isValid = false;
			} else if(database.searchUserByEmail(email) != null){
				System.out.println("Ja existe um usuario cadastrado com esse email");
				isValid = false;
			}
			
		}while(!isValid);
		
		
		String passwd = "";
		String passwd2 = "";
		do{
		
			System.out.println("Senha:");
			passwd = input.next();
			System.out.println("Confirmar senha:");
			passwd2 = input.next();
			
			if(!email.equals(email2))
				System.out.println("Senhas distintas");
			
		}while(!passwd.equals(passwd2));
		
		Profile profile = new Profile(name);
		User user = new User(profile, email, passwd);
		database.createUser(user);
		System.out.println("Feito!");
		
		userLogged = user;
		
	}
	
	private void signOut() {	
		userLogged = null;
	}
	
	private void login() {
		
		System.out.println("Email:");
		String email = input.next();
		System.out.println("Senha:");
		String passwd = input.next();
		
		User user = database.searchUserByEmail(email);
		
		if(user == null || !passwd.equals(user.getPassword())){
			System.out.println("Email ou senha incorretos");
		} else {
			userLogged = user;
			System.out.println("Feito!");
		}
		
	}

	private void createProject() {
		
		String[] categories = {"Art", "Comics", "Crafts", "Dance", "Design", "Fashion", "Film/Video", "Food", "Game", "Journalism", "Music", "Photography", "Publishing", "Technology", "Theater"};
		Project[] projCat = {new ArtProject(), new ComicsProject(), new CraftsProject(), new DanceProject(), new DesignProject(), new FashionProject(), new FilmVideoProject(), new FoodProject(), new GameProject(), new JournalismProject(), new MusicProject(), new PhotographyProject(), new PublishingProject(), new TechnologyProject(), new TheaterProject()};
		
		System.out.println("Selecione a categoria:");
		for(int i=0; i<16; i++){
			System.out.println(i+" - "+categories[i]);
		}		
		
		try{
			int cod;
			do{
				cod = input.nextInt();
			}while(cod <0 || cod>15);
			Project project = projCat[cod];
			
			System.out.println("Sinopse: ");
			project.setShortBlurb( input.nextLine() );
			
			System.out.println("Pais:");
			project.setLocation(new Location( input.nextLine() ));
			
			if(userLogged == null){
				
				System.out.println("Para concluir, selecione uma das opcoes:\n" +
									"1. Realizar login\n" +
									"2. Criar conta");
				do{
					cod = input.nextInt();
				}while(cod !=2 && cod!=1);
				
				if(cod == 1)
					login();
				else
					signUp();
			}
			
			project.setCreator(userLogged);
			userLogged.addProject(project);
			database.createProject(project);
			
			System.out.println("Feito!");
			
		}catch(NumberFormatException e) {
			System.out.println("Entrada inválida!");
		}
		
	}
	private void searchProject() {
		
		System.out.println("Titulo do projeto:");
		String title = input.nextLine();
		
		ArrayList<Project> result = database.searchProjectsByTitle(title);
		
		if(result.size() == 0){
			System.out.println("Nenhum resultado encontrado!");
			return;
		}
		
		int count = 0;
		for(Project p : result) {
			
			System.out.println("Codigo: "+count+"\n" +
							   "Titulo: "+p.getTitle()+"\n" +
							   "Criador: "+p.getCreator().getProfile().getName()+"\n");
			count++;
		}
		
		System.out.println("\nCodigo do projeto: ");
		
		try{
			
			int cod = -1;
			do {
				cod = input.nextInt();
			}while(cod < 0 || cod >= result.size());
			
			showProject(result.get(cod));
			
		}catch(NumberFormatException e){
			System.out.println("Entrada inválida!");
		}
		
	}

	private void showProject(Project project) {
		
		System.out.println(project);
		
		System.out.println("1. Doar\n" +
						   "2. Voltar");
		
		try{
			
			int cod = -1;
			do {
				cod = input.nextInt();
			}while(cod != 1 && cod != 2);
			
			if(cod == 1) {
				doPledge(project);
			}
			
		}catch(NumberFormatException e){
			System.out.println("Entrada inválida!");
		}
		
	}

	private void doPledge(Project project) {
		
		Reward reward = selectReward(project);
		float value = 0;
		float minimalValue = reward == null ? 10 : reward.getValueDonation();
		
		try{
		
			do{
				System.out.println("Valor da doacao [Valor minimo: "+minimalValue+"]:");
				value = input.nextFloat();
			}while(value < minimalValue);
			
			System.out.println("Numero do cartao: ");
			String cardNumber = input.next();
			System.out.println("Nome do titular: ");
			String cardHolderName = input.nextLine();
			System.out.println("Mes de expiracao: ");
			int monthEx = input.nextInt();
			System.out.println("ano de expiracao: ");
			int yearEx = input.nextInt();
			System.out.println("Senha: ");
			String securityCode = input.next();
				
			Pledge pledge = new Pledge(value, cardNumber, cardHolderName, monthEx, yearEx, securityCode);
			
			project.addPledge(pledge);
			
		}catch(NumberFormatException e){
			System.out.println("Entrada inválida!");
		}
	}

	private Reward selectReward(Project project) {
		
		ArrayList<Reward> rewards = project.getRewards();
		
		System.out.println("Codigo: 0\n" +
						   "Doar sem recompensa\n");
		
		int count = 1;
		for(Reward r : rewards) {
			System.out.println("Codigo: "+count+"\n"+r);
		}
		
		System.out.println("\nCodigo da recompensa: ");
		Reward reward = null;
		try{
			
			int cod = -1;
			do {
				cod = input.nextInt();
			}while(cod < 0 || cod > rewards.size());
			
			if(cod != 0){
				reward = rewards.get(cod-1);
			}			
			
		}catch(NumberFormatException e){
			System.out.println("Entrada inválida!");
		}
		
		return reward;
		
	}
	
}
