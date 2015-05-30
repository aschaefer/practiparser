package nu.schaefer.practiparser;

import java.util.HashSet;
import java.util.Set;

public class PrizeTablePick {
	int leaguePoints;
	String shooterName;
	String division;
	int numMatchesAttended = 0;
	int numMatchesWon = 0;
	Set<String> clubsAttended = new HashSet<String>();
	
	public int getLeaguePoints() {
		return leaguePoints;
	}
	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}
	public String getShooterName() {
		return shooterName;
	}
	public void setShooterName(String shooterName) {
		this.shooterName = shooterName;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getNumMatchesAttended() {
		return numMatchesAttended;
	}
	public void setNumMatchesAttended(int numMatchesAttended) {
		this.numMatchesAttended = numMatchesAttended;
	}
	public int getNumMatchesWon() {
		return numMatchesWon;
	}
	public void setNumMatchesWon(int numMatchesWon) {
		this.numMatchesWon = numMatchesWon;
	}
	public Set<String> getClubsAttended() {
		return clubsAttended;
	}
	public void setClubsAttended(Set<String> clubsAttended) {
		this.clubsAttended = clubsAttended;
	}
}
