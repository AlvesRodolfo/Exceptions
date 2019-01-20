package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.Exceptions;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		try {
			
		
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number  = sc.nextInt();
			sc.nextLine(); //consumir a quebra de linha
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial Balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withDraw = sc.nextDouble();
			
			Account acc = new Account(number, holder, balance, withDraw);
			
			System.out.println();
			System.out.print("Enter the amount for withdraw:  ");
			double amount = sc.nextDouble();
			acc.withDraw(amount);
			
			System.out.println(acc);
			}
		
		catch (Exceptions e){
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		catch (InputMismatchException r) {  //tratando erros de entrada
			System.out.println("Tipo não aceito");
		}
		
		catch (RuntimeException r) {
			System.out.println("Error inesperado");
		}
		

		
		sc.close();
	}

}
