package com.example.demo;

import java.util.Scanner;

class Account {
	String userName = "Prashant"; 
	String password = "kaushik";
	public String verifyAccount(String userName,String password) {
		if(this.userName.equals(userName) && this.password.equals(password)) {
			return "Account verified!";
		} else {
			return "Incorrect username/password!";
		}
	}
}

public class Practice15 extends Account {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Practice15 obj = new Practice15();
		System.out.print("Enter the username: ");
		String userName = sc.nextLine();
		System.out.print("Enter the password: ");
		String password = sc.nextLine();
		String message = obj.verifyAccount(userName,password);
		System.out.println(message);
		sc.close();
	}
}