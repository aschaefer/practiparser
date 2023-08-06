package nu.schaefer.practiparser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrizeTablePick {
	int leaguePoints;
	String shooterName;
	String division;
	int numMatchesAttended;
	List<LeaguePoints> leaguePointsList = new ArrayList<LeaguePoints>();
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
	public Set<String> getClubsAttended() {
		return clubsAttended;
	}
	public void setClubsAttended(Set<String> clubsAttended) {
		this.clubsAttended = clubsAttended;
	}
	public List<LeaguePoints> getLeaguePointsList() {
		return leaguePointsList;
	}
	public void setLeaguePointsList(List<LeaguePoints> leaguePointsList) {
		this.leaguePointsList = leaguePointsList;
	}
	public int getNumMatchesAttended() {
		return numMatchesAttended;
	}
	public void setNumMatchesAttended(int numMatchesAttended) {
		this.numMatchesAttended = numMatchesAttended;
	}
}
