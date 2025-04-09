package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		// Exercício de Fixação
		
		/*
		 * Faça um programa para ler os dados de uma conta bancária e depois realizar um saque nesta conta bancária, mostrando
		 * o novo saldo. Um saque não pode ocorrer ou se não houver saldo na conta, ou se o valor do saque for superior ao limite
		 * de saque da conta. Implemente a conta bancária conforme projeto abaixo:
		 * 
		 * ######################################
		 * # Account							#
		 * # - number : Integer					#
		 * # - holder : String					#
		 * # - balance : Double					#
		 * # - withdrawLimit : Double			#
		 * # + deposit(amount : Double) : void	#
		 * # + withdraw(amount : Double) : void	#
		 * ######################################
		 * 
		 * Examples:
		 * 
		 * Enter account data
		 * Number: 8021
		 * Holder: Bob Brown
		 * Initial balance: 500.00
		 * Withdraw limit: 500.00
		 * 
		 * Enter amount for withdraw: 100.00
		 * New balance: 400.00
		 * 
		 * ######################################
		 * 
		 * Enter account data
		 * Number: 8021
		 * Holder: Bob Brown
		 * Initial balance: 500.00
		 * Withdraw limit: 300.00
		 * 
		 * Enter amount for withdraw: 400.00
		 * Withdraw error: The amount exceeds withdraw limit
		 * 
		 * ######################################
		 * 
		 * Enter account data
		 * Number: 8021
		 * Holder: Bob Brown
		 * Initial balance: 200.00
		 * Withdraw limit: 300.00
		 * 
		 * Enter amount for withdraw: 250.00
		 * Withdraw error: Not enough balance
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter account data");
		System.out.printf("Number: ");
		int number = sc.nextInt();
		System.out.printf("Holder: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.printf("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.printf("Withdraw Limit: ");
		double withdrawLimit = sc.nextDouble();
		Account acc = new Account(number, name, balance, withdrawLimit);
		
		System.out.println();
		System.out.printf("Informe uma quantia para sacar: ");
		double amount = sc.nextDouble();
		
		try {
			acc.withdraw(amount);
			System.out.printf("New balance: %.2f", acc.getBalance());
		}
		catch (BusinessException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		
		sc.close();

	}

}
