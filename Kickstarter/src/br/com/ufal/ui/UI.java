package br.com.ufal.ui;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.ufal.database.Database;
import br.com.ufal.project.Project;
import br.com.ufal.user.User;

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
			
	}
	
	
	private int showMenu() {
		
		System.out.println("KickStarter\n\n" +
				   "1. Login\n" +
				   "2. Criar conta" +
				   "3. Buscar projetos\n" +
				   "4. Criar projeto\n" +
				   "5. Fechar");
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
				   "3. Sair\n" +
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
					signOut();
					break;
			
			}
			
		} catch(NumberFormatException e) {
			System.out.println("Entrada inválida!");
			option = -1;
		}
		
		return option;
		
	}
	
	private void signUp() {
		
		
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
		if(user == null || passwd.equals(user.getPassaword())){
			System.out.println("Email ou senha incorretos");
		} else {
			userLogged = user;
		}
		
	}

	private void createProject() {
		
		
		
	}
	private void searchProject() {
		// TODO Auto-generated method stub
		
	}
	
}
