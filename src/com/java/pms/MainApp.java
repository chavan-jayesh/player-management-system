package com.java.pms;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		PlayerOperations playerApp = new PlayerOperations();
		
		do {
			System.out.print("\n1. Add Data \n2. Remove Data \n3. Search Data \n4. Update Data \n5. Display all Players Data \n6. Display sorted data \n8. Hardcode Values \n0. Exit \n\nEnter your choice: ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:{	//Add Data
					playerApp.storefromuser(sc);
					break;
				}
				
				case 2:{	//Remove Data
					playerApp.removePlayerData(sc);
					break;
				}
				
				case 3: {	//Search Data
					playerApp.searchPlayerData(sc);
					break;
				}
				
				case 4: {   //Update Data
					playerApp.updatePlayerData(sc);
					break;
				}
				
				case 5: {   //Display Data
					playerApp.displayPlayers();
					break;
				}
				
				case 6: {  //Display Sorted
					playerApp.displaySorted(sc);
					break;
				}
				
				
				case 8:{   //Hardcode Values
					playerApp.enterHardcodeValues();
					break;
				}
				
				case 0: {
					System.out.println("\nThank you!\n");
					break;
				}
				
				default: {
					System.out.println("\nWrong Input! Please try again!");
					break;
				}
			}
			
		} while(choice!=0);
		
		sc.close();

	}

}
