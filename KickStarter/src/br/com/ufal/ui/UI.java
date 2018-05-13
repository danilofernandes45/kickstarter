package br.com.ufal.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import br.com.ufal.database.Database;
import br.com.ufal.pledge.Pledge;
import br.com.ufal.project.*;
import br.com.ufal.reward.*;
import br.com.ufal.user.*;
import br.com.ufal.util.*;

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
				   "2. Criar conta\n" +
				   "3. Buscar projetos\n" +
				   "4. Criar projeto\n" +
				   "0. Fechar");
		int option = -1;
		try{
			option = Integer.valueOf(input.nextLine());
			
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
				   "3. Editar conta\n" +
				   "4. Editar perfil\n" +
				   "5. Ver meus projetos\n" +
				   "6. Sair\n" +
				   "0. Fechar");
		int option = -1;
		try{
			option = Integer.valueOf(input.nextLine());
			
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
					showProjectsUser();
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
	
	private void showProjectsUser() {
		
		ArrayList<Project> projects = userLogged.getProjects();
		int count = 0;
		
		for(Project p : projects) {
			System.out.println("Codigo: "+count+"\n"+p.shortView());
		}
		
		try {
			int id = 0;
			do {
				System.out.println("Digite o codigo do projeto: ");
				id = Integer.valueOf(input.nextLine());
			}while(id < 0 || id >= projects.size());
			
			System.out.println(projects.get(id));
			
			System.out.println("Editar?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			
			int cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				editProject(projects.get(id));
			}
			
		}catch(NumberFormatException e) {
			System.out.println("Entrada invalida");
		}
		
		
	}

	private void editProject(Project project) {
		
		try {
			int cod;
			
			if(userLogged.equals( project.getCreator() )) {
				
				System.out.println("Deseja excluir o projeto?\n"
								 + "1. Sim\n"
								 + "2. Nao");
				cod = Integer.valueOf(input.nextLine());
				
				if(cod == 1) {
					deleteProject(project);
					System.out.println("Feito");
					return;
				}
				
			} else {
				
				System.out.println("Deseja deixar o projeto?\n"
								 + "1. Sim\n"
								 + "2. Nao");
				cod = Integer.valueOf(input.nextLine());
				
				if(cod == 1) {
					leaveTheProject(project);
					System.out.println("Feito");
					return;
				}
				
			}
			
			System.out.println("Editar categoria?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				project = changeCategory(project);
			}
			
			System.out.println("Editar titulo?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				project.setTitle( input.nextLine());
			}
			
			System.out.println("Editar sinopse?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				project.setShortBlurb( input.nextLine());
			}
			
			System.out.println("Editar localizacao?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				Location location = project.getLocation();
				System.out.println("Pais");
				location.setCountry( input.nextLine());
				System.out.println("Cidade");
				location.setCity( input.nextLine());
			}
			
			System.out.println("Editar a quantidade em dinheiro a ser arrecadada?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				project.setFundingGoal( Float.valueOf(input.nextLine()));
			}
			
			System.out.println("Editar descricao detalhada do projeto?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				project.setDescription( input.nextLine());
			}
			
			System.out.println("Editar a descricao dos riscos e desafios do projeto?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				project.setDescripRisksChallenges( input.nextLine());
			}
			
			System.out.println("Editar o periodo disponivel para doacao?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				editFundingDurationProject(project);
			}
			
			System.out.println("Adicionar colaborador?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				addColaboratorProject(project);
			}
			
			System.out.println("Editar recompensas?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				editRewardsProject(project);
			}
			
		}catch(NumberFormatException e) {
			System.out.println("Entrada invalida");
		}
		
	}

	private void editRewardsProject(Project project) {
		
		try {			
			int cod = 0;
			boolean thereAreRewards = false;
			do {
				thereAreRewards = ( project.getRewards().size() != 0 );
				
				System.out.println("1. Criar recompensa");
				
				if( thereAreRewards )
					System.out.println("2. Editar recompensa");
				
				cod = Integer.valueOf(input.nextLine());
			
			}while(cod != 1 && (cod != 2 || !thereAreRewards));
			
			if(cod == 1) {
				createReward(project);
			} else {
				Reward reward = selectReward(project, false);
				if( reward == null ) {
					System.out.println("Entrada invalida");
				} else {
					editReward(reward);
				}
			}
			
			
		}catch(NumberFormatException e) {
			System.out.println("Entrada invalida");
		}
		
	}

	private void editReward(Reward reward) {
		
		try {
			
			int cod;
			System.out.println("Editar titulo?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				reward.setTitle( input.nextLine() );
			}
			
			System.out.println("Editar descricao?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				reward.setDescription( input.nextLine() );
			}
			
			System.out.println("Editar valor minimo de doacao?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				reward.setValueDonation( Float.valueOf(input.nextLine()) );
			}
			
			System.out.println("Editar detalhes de entrega?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				reward.setShippingDetails(editShippingDetails());
			}

			System.out.println("Editar Data estimada para o envio da recompensa?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				reward.setEstimatedDelivery(editDate());
			}
			
			System.out.println("Editar limite de disponibilidade?\n"
							 + "1. Sim\n"
							 + "2. Nao");
			cod = Integer.valueOf(input.nextLine());
			
			if(cod == 1) {
				reward.setLimit(editLimitAvailable());
			}
			
			System.out.println("Feito!");			
			
		}catch(NumberFormatException e) {
			System.out.println("Entrada invalida");
		}
		
	}

	private void createReward(Project project) {
		
		try {
			Reward reward = new Reward();
			System.out.println("Titulo:");
			reward.setTitle( input.nextLine() );
			System.out.println("Descricao:");
			reward.setDescription( input.nextLine() );
			System.out.println("Valor minimo de doacao para receber essa recompensa:");
			reward.setValueDonation( Float.valueOf(input.nextLine()) );
			
			reward.setShippingDetails(editShippingDetails());
			
			System.out.println("Data estimada para o envio da recompensa");
			reward.setEstimatedDelivery(editDate());
			
			reward.setLimit(editLimitAvailable());
			
			project.addReward(reward);
			
		}catch(NumberFormatException e) {
			System.out.println("Entrada invalida");
		}
		
	}

	private LimitAvailable editLimitAvailable() throws NumberFormatException{
		
		System.out.println("Limite de disponibilidade\n"
						 + "Quantidade disponivel:");
		int banckerLimit = Integer.valueOf(input.nextLine());
		
		System.out.println("Data de inicio");
		Date timeStart = editDate();
		
		System.out.println("Data de fim");
		Date timeEnd = editDate();
		
		return ( new LimitAvailable(banckerLimit, timeStart, timeEnd) );
	}

	private Date editDate() {
		
		Date date = null;
		
		do {
			System.out.println("Digite no formato dd-mm-aaaa:");
			date = TimerTime.convertDateString( input.nextLine() );
		}while(date == null);
		
		return date;
	}
	
	private long editTime() {
		
		long time = -1;
		
		do {
			System.out.println("Digite no formato hh:mm:ss :");
			time = TimerTime.convertTimeString( input.nextLine() );
		}while(time == -1);
		
		return time;
	}
	
	private Shipping editShippingDetails() throws NumberFormatException{
		
		int cod = 0;
		do {
			System.out.println("Detalhes da entrega:\n"
							 + "1. Sem entrega\n"
						     + "2. Entrega em todo o mundo\n"
						     + "3. Entrega em paises especificos");
			
			cod = Integer.valueOf(input.nextLine());
			
		}while(cod < 1 && cod > 3);
		
		Shipping shipping = null;
		if(cod == 1) {
			shipping = new NoShipping();
		}
		else if(cod == 2) {
			shipping = new ShippingEverywhere();
		} else {
			
			ArrayList<String> countries = new ArrayList<>();
			do {
				
				System.out.println("Pais:");
				countries.add( input.nextLine() );
				
				System.out.println("1. Adicionar outro pais\n"
								 + "2. Concluir");
				cod = Integer.valueOf(input.nextLine());
				
			}while(cod == 1);
			
			shipping = new ShippingEspecificCountries(countries);
		}
		
		return shipping;
		
	}
	
	private void addColaboratorProject(Project project) {

		
		System.out.println("Email do colaborador:");
		User user = database.searchUserByEmail( input.nextLine() );
	
		if(user == null){
			System.out.println("Usuario não encontrado!");
		} else {
			user.addProject(project);
			System.out.println("Feito!");
		}
		
		
	}
	
	private void leaveTheProject(Project project) {
		
		project.removeColaborator(userLogged);
		userLogged.removeProject(project);
		
	}
	
	private void deleteProject(Project project) {
		
		for(User user : project.getColaborators()) {
			user.removeProject(project);
		}
		
		userLogged.removeProject(project);
		database.removeProject(project);
		
	}

	private void editFundingDurationProject(Project project) {
		
		try {
			Timer timer = null;
			int cod = 0;
			do {
				System.out.println("1. Numero de dias restantes\n"
								 + "2. Instante [Data e Hora]");
				cod = Integer.valueOf(input.nextLine());
			
			}while(cod != 1 && cod != 2);
			
			if(cod == 1) {
				
				int amountDays = Integer.valueOf( input.nextLine() );
				timer = new TimerDays(new Date(), amountDays);
				
			}else {
	
				Date date = editDate();
				
				long time = editTime();
				
				timer = new TimerTime(date, time);
				
			}
			
			project.setFundingDuration(timer);
			
			System.out.println("Feito!");
			
		}
		catch(NumberFormatException e) {
			System.out.println("Entrada invalida");
		}
		
	}
	
	private Project changeCategory(Project project) {
		
		Project newProject = selectCategory();
		newProject.copy(project);
		
		userLogged.removeProject(project);
		database.removeProject(project);
		database.createProject(newProject);
		userLogged.addProject(newProject);
		
		return newProject;
	}

	private void editProfile() {
		
		try {
			
			int cod = 0;
			while(cod != 1 && cod != 2) {
				
				System.out.println("1. Editar informacoes pessoais\n"
								 + "2. Editar informacoes bancarias");
				cod = Integer.valueOf(input.nextLine());
			}
			
			if(cod == 1)
				editProfilePersonal();
			else
				editProfileBankAccount();
			
		} catch(NumberFormatException e) {
			System.out.println("Entrada invalida");
		}
		
	}

	private void editProfileBankAccount() {
		
		BankAccount bankAccount = userLogged.getProfile().getBankAccount();
		
		System.out.println("Nome do banco:");
		bankAccount.setBank( input.nextLine() );
		System.out.println("Agencia:");
		bankAccount.setAgency( input.nextLine() );
		System.out.println("Numero da conta:");
		bankAccount.setAccount( input.nextLine() );
		
	}

	private void editProfilePersonal() {
		
		Profile profile = userLogged.getProfile();
		Address address = profile.getAddress();
		
		System.out.println("Primeiro nome:");
		profile.setFirstName( input.nextLine());
		System.out.println("Ultimo nome:");
		profile.setLastName( input.nextLine());
		
		System.out.println("Endereco\n\n"
						 + "Pais:");
		address.setCountry( input.nextLine() );
		System.out.println("Cidade:");
		address.setCity( input.nextLine() );
		System.out.println("Rua:");
		address.setStreetName( input.nextLine() );
		System.out.println("Numero:");
		address.setNumber( input.nextLine() );
		System.out.println("Codigo postal:");
		address.setPostalCode( input.nextLine() );
		
		String dateString;
		Date date;
		do {
			System.out.println("Data de nascimento [dd-mm-aaaa]:");
			dateString = input.next();
			date = TimerTime.convertDateString(dateString);			
			
		}while( date == null);
			
		profile.setDateBirth(date);
		
		System.out.println("Feito");
		
	}

	private void editAccount() {

		String email;
		do {
			System.out.println("Email:");
			email = input.nextLine();
		}while(isUnavailable(email));
		
		userLogged.setEmail(email);
		
		System.out.println("Senha:");
		userLogged.setPassword( input.nextLine() );
		
		System.out.println("Name: ");
		userLogged.setName( input.nextLine() );
		
		Location location = userLogged.getLocation();
		System.out.println("Localizacao\nPais:");
		location.setCountry( input.nextLine());
		System.out.println("Cidade:");
		location.setCity( input.nextLine());
		
		System.out.println("Biografia:");
		userLogged.setBiografy( input.nextLine() );
		
		System.out.println("Website:");
		userLogged.setWebsite( input.nextLine() );
		
		System.out.println("ID do Google Analytics:");
		userLogged.setIdGoogleAnalytics( input.nextLine() );
		
	}

	private boolean isUnavailable(String email) {
		
		if(userLogged != null && email.equals( userLogged.getEmail() ))
			return false;
		
		User user = database.searchUserByEmail(email);
		
		if(user == null)
			return false;
			
		
		return true;
	}

	private void signUp() {
		
		System.out.println("Nome:");
		String name = input.nextLine();
		
		String email = "";
		String email2 = "";
		boolean isValid = true;
		do{
			
			System.out.println("Email:");
			email = input.nextLine();
			System.out.println("Confirmar email:");
			email2 = input.nextLine();
			
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
			passwd = input.nextLine();
			System.out.println("Confirmar senha:");
			passwd2 = input.nextLine();
			
			if(!email.equals(email2))
				System.out.println("Senhas distintas");
			
		}while(!passwd.equals(passwd2));
		
		User user = new User(name, email, passwd);
		database.createUser(user);
		System.out.println("Feito!");
		
		userLogged = user;
		
	}
	
	private void signOut() {	
		userLogged = null;
	}
	
	private void login() {
		
		int count = 0;
		while(userLogged == null && count<2) {
			System.out.println("Email:");
			String email = input.nextLine();
			System.out.println("Senha:");
			String passwd = input.nextLine();
			
			User user = database.searchUserByEmail(email);
			
			if(user == null || !passwd.equals(user.getPassword())){
				System.out.println("Email ou senha incorretos");
			} else {
				userLogged = user;
				System.out.println("Feito!");
			}
			
			count++;
		}
	}

	private void createProject() {	
		
		try{
			
			Project project = selectCategory();
			
			System.out.println("Titulo: ");
			project.setTitle( input.nextLine() );
			
			System.out.println("Sinopse: ");
			project.setShortBlurb( input.nextLine() );
			
			System.out.println("Pais:");
			project.setLocation(new Location( input.nextLine() ));
			
			int cod;
			while(userLogged == null){
				
				System.out.println("Para concluir, selecione uma das opcoes:\n" +
									"1. Realizar login\n" +
									"2. Criar conta");
				do{
					cod = Integer.valueOf(input.nextLine());
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
	
	private Project selectCategory() throws NumberFormatException{
		
		String[] categories = {"Art", "Comics", "Crafts", "Dance", "Design", "Fashion", "Film/Video", "Food", "Game", "Journalism", "Music", "Photography", "Publishing", "Technology", "Theater"};
		Project[] projCat = {new ArtProject(), new ComicsProject(), new CraftsProject(), new DanceProject(), new DesignProject(), new FashionProject(), new FilmVideoProject(), new FoodProject(), new GameProject(), new JournalismProject(), new MusicProject(), new PhotographyProject(), new PublishingProject(), new TechnologyProject(), new TheaterProject()};
		
		System.out.println("Selecione a categoria:");
		for(int i=0; i<15; i++){
			System.out.println(i+" - "+categories[i]);
		}	
		
		int cod;
		do{
			cod = Integer.valueOf(input.nextLine());
		}while(cod <0 || cod>=15);
		
		return projCat[cod];
		
		
	}
	
	private void searchProject(){
		
		System.out.println("Titulo do projeto:");
		String title = input.nextLine();
		
		ArrayList<Project> result = database.searchAvailableProjectsByTitle(title);
		
		if(result.size() == 0){
			System.out.println("Nenhum resultado encontrado!");
			return;
		}
		
		int count = 0;
		for(Project p : result) {
			
			System.out.println("Codigo: "+count+"\n" +
							   "Titulo: "+p.getTitle()+"\n" +
							   "Criador: "+p.getCreator().getName()+"\n");
			count++;
		}
		
		System.out.println("\nCodigo do projeto: ");
		
		try{
			
			int cod = -1;
			do {
				cod = Integer.valueOf(input.nextLine());
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
				cod = Integer.valueOf(input.nextLine());
			}while(cod != 1 && cod != 2);
			
			if(cod == 1) {
				doPledge(project);
			}
			
		}catch(NumberFormatException e){
			System.out.println("Entrada inválida!");
		}
		
	}

	private void doPledge(Project project) {
		
		Reward reward = selectReward(project, true);
		float value = 0;
		float minimalValue = reward == null ? 10 : reward.getValueDonation();
		
		try{
		
			do{
				System.out.println("Valor da doacao [Valor minimo: "+minimalValue+"]:");
				value = Float.valueOf(input.nextLine());
			}while(value < minimalValue);
			
			System.out.println("Numero do cartao: ");
			String cardNumber = input.nextLine();
			System.out.println("Nome do titular: ");
			String cardHolderName = input.nextLine();
			System.out.println("Mes de expiracao: ");
			int monthEx = Integer.valueOf(input.nextLine());
			System.out.println("ano de expiracao: ");
			int yearEx = Integer.valueOf(input.nextLine());
			System.out.println("Senha: ");
			String securityCode = input.nextLine();
				
			Pledge pledge = new Pledge(value, cardNumber, cardHolderName, monthEx, yearEx, securityCode);
			
			project.addPledge(pledge);
			
		}catch(NumberFormatException e){
			System.out.println("Entrada inválida!");
		}
	}

	private Reward selectReward(Project project, boolean isPledge) {
		
		ArrayList<Reward> rewards;
		
		if(isPledge) {
			System.out.println("Codigo: 0\n" +
						   	   "Doar sem recompensa\n");
			
			rewards = project.getAvailableRewards();

		} else {
			
			rewards = project.getRewards();
			
		}
		
		int count = 1;
		for(Reward r : rewards) {
			System.out.println("Codigo: "+count+"\n"+r);
			count++;
		}
		
		System.out.println("\nCodigo da recompensa: ");
		Reward reward = null;
		try{
			
			int cod = -1;
			do {
				cod = Integer.valueOf(input.nextLine());
			}while(cod < 0 || cod > rewards.size() || (!isPledge && cod == 0));
			
			if(cod != 0){
				reward = rewards.get(cod-1);
			}			
			
		}catch(NumberFormatException e){
			System.out.println("Entrada inválida!");
		}
		
		return reward;
		
	}
	
}
