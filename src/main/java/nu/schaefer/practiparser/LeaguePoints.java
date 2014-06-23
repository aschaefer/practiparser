package nu.schaefer.practiparser;

public class LeaguePoints {

	private int leaguePoints;
	private int matchNum;
	private double time;
	private boolean dq = false;
	private boolean dnf = false;
	private String firstName = "";
	private String lastName = "";
	boolean makeup = false;
	boolean populated = false;
	
	public int getLeaguePoints() {
		return leaguePoints;
	}
	public void setLeaguePoints(int leaguePoints) {
		this.leaguePoints = leaguePoints;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public boolean isDq() {
		return dq;
	}
	public void setDq(boolean dq) {
		this.dq = dq;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isMakeup() {
		return makeup;
	}
	public void setMakeup(boolean makeup) {
		this.makeup = makeup;
	}
	public int getMatchNum() {
		return matchNum;
	}
	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
	}
	public boolean isDnf() {
		return dnf;
	}
	public void setDnf(boolean dnf) {
		this.dnf = dnf;
	}
	public boolean isPopulated() {
		return populated;
	}
	public void setPopulated(boolean populated) {
		this.populated = populated;
	}
}
