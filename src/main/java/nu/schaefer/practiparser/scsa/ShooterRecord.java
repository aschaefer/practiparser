package nu.schaefer.practiparser.scsa;

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
	
	// Needed for Es Line
	private String totalTime = "";
	private String divisionCode = "";
	
	public String toCsv(){
		return "EC," + shooterNumber + "," + shooterScsaId + "," + firstName + "," + lastName +  "," + colF +  "," + colG +  "," + colH +  "," + colI +  "," + colJ +  "," + colK +  "," + colL+",,,,,,,,,,,,,,";
	}
	public String toEsCsv(){
		return "ES,1," + shooterNumber + ","+divisionCode+",?,?," + totalTime + "TRUE,FALSE," + totalTime + ",,,,,,,,,,,,,,,,";
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
	
	public String getTotalTime() {
		return totalTime;
	}
	
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public String getDivisionCode() {
		return divisionCode;
	}
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	
	
}
