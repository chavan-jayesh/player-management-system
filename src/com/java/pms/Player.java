package com.java.pms;

public class Player {
	
	private String name;
    private int jersey_num;
    private int no_of_matches;
    private int runs;
    private int wickets;
	
	public Player() {
		this.name = "Not Given";
		this.jersey_num = 0;
		this.no_of_matches = 0;
		this.runs = 0;
		this.wickets = 0;
	}

	public Player(String name, int jersey_num, int no_of_matches, int runs, int wickets) {
		this.name = name;
		this.jersey_num = jersey_num;
		this.no_of_matches = no_of_matches;
		this.runs = runs;
		this.wickets = wickets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJersey_num() {
		return jersey_num;
	}

	public void setJersey_num(int jersey_num) {
		this.jersey_num = jersey_num;
	}

	public int getNo_of_matches() {
		return no_of_matches;
	}

	public void setNo_of_matches(int no_of_matches) {
		this.no_of_matches = no_of_matches;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

    public void display() {
    	System.out.println("\n+-------------------+-------------+-----------------+----------+-----------+");
        System.out.print("|    Player name    |  Jersey No  |  No of matches  |   Runs   |  Wickets  |");
        System.out.println("\n+-------------------+-------------+-----------------+----------+-----------+");
        System.out.printf("|%19s|%13d|%17d|%10d|%11d|", this.name, this.jersey_num, this.no_of_matches, this.runs, this.wickets);
        System.out.println("\n+-------------------+-------------+-----------------+----------+-----------+");
    }
    
    public void displayTitle() {
        System.out.println("\n+-------------------+-------------+-----------------+----------+-----------+");
        System.out.print("|    Player name    |  Jersey No  |  No of matches  |   Runs   |  Wickets  |");
        System.out.println("\n+-------------------+-------------+-----------------+----------+-----------+");
    }
    
    public void displayinarr() {
    	System.out.printf("|%19s|%13d|%17d|%10d|%11d|", this.name, this.jersey_num, this.no_of_matches, this.runs, this.wickets);
        System.out.println("\n+-------------------+-------------+-----------------+----------+-----------+");
    }
	

}
