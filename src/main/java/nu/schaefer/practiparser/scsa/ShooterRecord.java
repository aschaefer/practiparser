package nu.schaefer.practiparser.scsa;

import java.util.ArrayList;
import java.util.List;

public class ShooterRecord {
	private int shooterNumber;
	private String shooterScsaId;
	private String firstName;
	private String lastName;
	private String colF = "FALSE";
	private String colG = "FALSE";
	private String colH = "FALSE";
	private String colI = "FALSE";
	private String colJ = "FALSE";
	private String colK = "FALSE";
	private String colL = "FALSE";
	private List<List<Double>> stageScores = new ArrayList<List<Double>>();
	private boolean disqualified = false;
	private boolean dnf = false;
	private boolean makeup = false;
	private int place = -1;
	private int stagesScored = 0;
	private int stagesInMatch = 5;
	private int squad = -1;
	
	// Needed for Es Line
	private double totalTime = 0;
	private String divisionCode = "";
	private String classCode = "";
	
	public String toCsv(){
		return "EC," + shooterNumber + "," + shooterScsaId + "," + firstName + "," + lastName +  "," + colF +  "," + colG +  "," + colH +  "," + colI +  "," + colJ +  "," + colK +  "," + colL+",,,,,,,,,,,,,,";
	}
	public String toEsCsv(int matchNum, int place){
		totalTime = Math.round(totalTime * 100.0) / 100.0;
		return "ES,"+matchNum+"," + shooterNumber + ","+divisionCode+","+place+",?," + totalTime + ",TRUE,FALSE," + totalTime + ",,,,,,,,,,,,,,,,";
	}
	public String toSsCsv(int matchNum, String CR){
		StringBuilder sb = new StringBuilder();
		int stageNum = 1;
		for (List<Double> stageScore: stageScores){
			for ( Double score: stageScore){
				sb.append("SS,"+matchNum+","+(stageNum++) +","+shooterNumber+",8.00,2.00,0,FALSE,2.00,0,FALSE,2.00,0,FALSE,4.00,0,FALSE,2.00,0,FALSE,,,,,,");
			}
		}
		return "";
	}
	public int getShooterNumber() {
		return shooterNumber;
	}

	public void setShooterNumber(int shooterNumber) {
		this.shooterNumber = shooterNumber;
	}

	public String getShooterScsaId() {
		return shooterScsaId;
	}

	public void setShooterScsaId(String shooterScsaId) {
		this.shooterScsaId = shooterScsaId;
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

	public String getColF() {
		return colF;
	}

	public void setColF(String colF) {
		this.colF = colF;
	}

	public String getColG() {
		return colG;
	}

	public void setColG(String colG) {
		this.colG = colG;
	}

	public String getColH() {
		return colH;
	}

	public void setColH(String colH) {
		this.colH = colH;
	}

	public String getColI() {
		return colI;
	}

	public void setColI(String colI) {
		this.colI = colI;
	}

	public String getColJ() {
		return colJ;
	}

	public void setColJ(String colJ) {
		this.colJ = colJ;
	}

	public String getColK() {
		return colK;
	}

	public void setColK(String colK) {
		this.colK = colK;
	}

	public String getColL() {
		return colL;
	}

	public void setColL(String colL) {
		this.colL = colL;
	}
	
	public double getTotalTime() {
		return totalTime;
	}
	
	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}
	public String getDivisionCode() {
		return divisionCode;
	}
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	public List<List<Double>> getStageScores() {
		return stageScores;
	}
	public void setStageScores(List<List<Double>> stageScores) {
		this.stageScores = stageScores;
	}
	public boolean isDisqualified() {
		return disqualified;
	}
	public void setDisqualified(boolean disqualified) {
		this.disqualified = disqualified;
	}
	public boolean isDnf() {
//		if ( stagesScored != stagesInMatch){
//			return true;
//		}
		return dnf;
	}
	public void setDnf(boolean dnf) {
		this.dnf = dnf;
	}
	public int getPlace() {
		return place;
	}
	public void setPlace(int place) {
		this.place = place;
	}
	public int getStagesScored() {
		return stagesScored;
	}
	public void setStagesScored(int stagesScored) {
		this.stagesScored = stagesScored;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public boolean isMakeup() {
		return makeup;
	}
	public void setMakeup(boolean makeup) {
		this.makeup = makeup;
	}
	public int getStagesInMatch() {
		return stagesInMatch;
	}
	public void setStagesInMatch(int stagesInMatch) {
		this.stagesInMatch = stagesInMatch;
	}
	
	public int getSquad() {
		return squad;
	}
	public void setSquad(int squad) {
		this.squad = squad;
	}
	@Override
	public String toString() {
		return "ShooterRecord [shooterNumber=" + shooterNumber
				+ ", shooterScsaId=" + shooterScsaId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", stageScores="
				+ stageScores + ", disqualified=" + disqualified + ", dnf="
				+ dnf + ", makeup=" + makeup + ", place=" + place + ", squad=" + squad
				+ ", stagesScored=" + stagesScored + ", totalTime=" + totalTime
				+ ", divisionCode=" + divisionCode + ", classCode=" + classCode
				+ "]";
	}

}
