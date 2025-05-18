package com.java.pms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PlayerOperations {
	
	private Player[] playerArr = new Player[10];
	private int ctr = 0;
	
	public void storefromuser(Scanner sc) {
		
		if(ctr<playerArr.length) {
			playerArr[ctr] = new Player();
			
			System.out.print("\nEnter Player name: ");
			sc.nextLine();  // To consume any leftover newline
	        playerArr[ctr].setName(sc.nextLine());
	        
	        System.out.print("\nEnter jersey no: ");
	        playerArr[ctr].setJersey_num(sc.nextInt());
	        
	        System.out.print("\nEnter No of matches: ");
	        playerArr[ctr].setNo_of_matches(sc.nextInt());
	        
	        System.out.print("\nEnter Runs: ");
	        playerArr[ctr].setRuns(sc.nextInt());
	        
	        System.out.print("\nEnter Wickets: ");
	        playerArr[ctr].setWickets(sc.nextInt());
	        
	        System.out.println("\nNew Player added sucessfully!");
			
			ctr++;		
		}
		
		else {
			System.out.println("\nPlayer array is full!");
		}
		
		
	}
	
	public void displayPlayers() {
		if(ctr > 0) {
			playerArr[0].displayTitle();
			
			for(int i = 0; i<ctr; i++) {
				playerArr[i].displayinarr();
			}
		}
		else {
			System.out.println("\nNo Player to display!");
		}
	}
	
	public int searchPlayerData(Scanner sc){
		
		if(ctr==0) {
			System.out.println("\nPlayer Array is Empty!");
			return -1;
		}
		
		System.out.print("\nSearch player by \n\n1. Name \n2. Jersey Number \n\nEnter your choice: ");
		int choice = sc.nextInt();
		
		if(choice==1){
			
			System.out.print("\nEnter player name: ");
		   	sc.nextLine();
		   	String uname = sc.nextLine();
			
			for(int i = 0; i < this.ctr; i++){
				if(playerArr[i].getName().equalsIgnoreCase(uname)){
					playerArr[i].display();
					return i;
				}
			}
			System.out.println("\nPlayer Not Found!");
			return -1;
		}
		
		else if(choice == 2){
			
			System.out.print("\nEnter player jersey number: ");
			int ujerseyNum = sc.nextInt();
			
			for(int i=0; i<this.ctr; i++){
				if(playerArr[i].getJersey_num()==ujerseyNum){
					playerArr[i].display();
					return i;
				}
			}
			System.out.println("\nPlayer Not Found!");
			return -1;
		}
		
		else{
			System.out.println("\nWrong Input!");
			return searchPlayerData(sc);
		}
		
	}
	
	public void updatePlayerData(Scanner sc) {
		
		if(ctr==0) {
			System.out.println("\nPlayer Array is Empty!");
			return;
		}
	
		int index = this.searchPlayerData(sc);
		if(index==-1){
			return;
		}
		System.out.print("\n\nSelect what do you want to update! \n\n1. Name \n2. Jersey Number \n3. No of Matches \n4. Runs \n5. Wickets \n\nEnter your choice: ");
		int choice = sc.nextInt();
		
		switch(choice){
			case 1: {
				System.out.print("\nEnter new name: ");
			   	sc.nextLine();
			   	String uName = sc.nextLine();
			   	
	            this.playerArr[index].setName(uName);
	            
	            System.out.println("\nPlayer name updated!");
				break;
			}
			
			case 2: {
				System.out.print("\nEnter new Jersey Number: ");
			   	int uJersey = sc.nextInt();
				
			   	this.playerArr[index].setJersey_num(uJersey);
				
			   	System.out.println("\nPlayer Jersey Number updated!");
				break;
			}
			
			case 3: {
				System.out.print("\nEnter updated No of matches: ");
				int uNoOfMatches = sc.nextInt();
				
				this.playerArr[index].setNo_of_matches(uNoOfMatches);
				
				System.out.println("\nPlayer no of matches updated!");
				break;
			}
			
			case 4: {
				System.out.print("\nEnter updated runs: ");
				int uRuns = sc.nextInt();
				
				this.playerArr[index].setRuns(uRuns);
				
				System.out.println("\nPlayer runs updated!");
				break;
			}
			
			case 5: {
				System.out.print("\nEnter updated wickets: ");
				int uWickets = sc.nextInt();
				
				this.playerArr[index].setWickets(uWickets);
				
				System.out.println("\nPlayer wickets updated!");
				break;
			}
			
			default: {
				System.out.println("\nWrong Input! Please try agin!");
				this.updatePlayerData(sc);
				break;
			}
		}
	}

	public void removePlayerData(Scanner sc){
		
		if(ctr==0) {
			System.out.println("\nPlayer Array is Empty!");
			return;
		}
		
		int index = this.searchPlayerData(sc);
		
		if (index < 0 || index >= ctr) {
			if(index==-1) {
				return;
			}
	        System.out.println("Invalid index");
	        return;
		}
		
		for(int i = index; i<ctr-1; i++){
			this.playerArr[i] = this.playerArr[i+1];
		}
		
		System.out.println("\nPlayer Removed Successfully!");
		
		// Nullify last element
	    this.playerArr[ctr - 1] = null;
	    ctr--;  // Decrease count
	}
	
	public void displaySorted(Scanner sc){
		
		if(ctr==0) {
			System.out.println("\nPlayer Array is Empty!");
			return;
		}
		
		System.out.print("\nSelect how you want to sort the data! \n\n1. Runs \n2. Wickets \n3. No of Matches \n\nEnter your choice: ");
		int ch1 = sc.nextInt();
		System.out.print("\n1. Ascending  \n2. Descending \n\nEnter your choice : ");
		int ch2 = sc.nextInt();
		
		switch(ch1){
			case 1: {
				if(ch2==1){
					Arrays.sort(playerArr, 0, ctr, Comparator.comparingInt(Player::getRuns));
			        System.out.println("\nSorted by Runs (Ascending):");
			        this.displayPlayers();
				}
				else if(ch2==2){
					Arrays.sort(playerArr, 0, ctr, Comparator.comparingInt(Player::getRuns).reversed());
			        System.out.println("\nSorted by Runs (Descending):");
			        this.displayPlayers();
				}
					
				else{
					System.out.println("\nWrong Input! Please try agin!");
				}
				
				break;
			}
			
			case 2: {
				if(ch2==1){
					Arrays.sort(playerArr, 0, ctr, Comparator.comparingInt(Player::getWickets));
			        System.out.println("\nSorted by Wickets (Ascending):");
					this.displayPlayers();
				}
				else if(ch2==2){
					Arrays.sort(playerArr, 0, ctr, Comparator.comparingInt(Player::getWickets).reversed());
			        System.out.println("\nSorted by Wickets (Descending):");
					this.displayPlayers();
				}
					
				else{
					System.out.println("\nWrong Input! Please try agin!");
				}
				
				break;
			}
				
			case 3: {
				if(ch2==1){
					Arrays.sort(playerArr, 0, ctr, Comparator.comparingInt(Player::getNo_of_matches));
			        System.out.println("\nSorted by Matches (Ascending):");
					this.displayPlayers();
				}
				else if(ch2==2){
					Arrays.sort(playerArr, 0, ctr, Comparator.comparingInt(Player::getNo_of_matches).reversed());
			        System.out.println("\nSorted by Matches (Descending):");
					this.displayPlayers();
				}
					
				else{
					System.out.println("\nWrong Input! Please try agin!");
				}
				
				break;
			}
			
			default: {
				System.out.println("\nWrong Input! Please try agin!");
				break;
			}
		}	
	}
	
	void enterHardcodeValues(){
		
		if(ctr < this.playerArr.length) {
			this.playerArr[ctr++] = new Player("Virat Kohli", 18, 200, 18000, 50);
			System.out.println("\nPlayer Added Successfully!");
		}
		else {
			System.out.println("\nPlayer Array is full!");
			return;
		}
		
		
		if(ctr<this.playerArr.length) {
			this.playerArr[ctr++] = new Player("Rohit Sharma", 45, 250, 15000, 80);
			System.out.println("\nPlayer Added Successfully!");
		}
		else {
			System.out.println("\nPlayer Array is full!");
			return;
		}
		
		
		if(ctr<this.playerArr.length) {
			this.playerArr[ctr++] = new Player("Hardik Pandya", 33, 150, 8000, 150);
			System.out.println("\nPlayer Added Successfully!");
		}
		else {
			System.out.println("\nPlayer Array is full!");
			return;
		}
		
		
		if(ctr<this.playerArr.length) {
			this.playerArr[ctr++] = new Player("Shubhman Gill", 7, 50, 6000, 20);
			System.out.println("\nPlayer Added Successfully!");
		}
		else {
			System.out.println("\nPlayer Array is full!");
			return;
		}
		
		
		if(ctr<this.playerArr.length) {
			this.playerArr[ctr++] = new Player("Jasprit Bumrah", 93, 90, 1500, 200);
			System.out.println("\nPlayer Added Successfully!");
		}
		else {
			System.out.println("\nPlayer Array is full!");
			return;
		}
		
	}
	

}
