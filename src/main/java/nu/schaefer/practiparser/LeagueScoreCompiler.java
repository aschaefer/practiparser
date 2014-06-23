package nu.schaefer.practiparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nu.schaefer.practiparser.json.MatchDef;
import nu.schaefer.practiparser.json.MatchScore;
import nu.schaefer.practiparser.json.MatchScores;
import nu.schaefer.practiparser.json.MatchShooter;
import nu.schaefer.practiparser.json.MatchStage;
import nu.schaefer.practiparser.json.StageStagescore;
import nu.schaefer.practiparser.scsa.ShooterRecord;

import org.codehaus.jackson.map.ObjectMapper;

public class LeagueScoreCompiler {
	private static List<Map<String, List<ShooterRecord>>> results = new ArrayList<Map<String, List<ShooterRecord>>>();
	private static List<String> matchNames = new ArrayList<String>();
	public static void main(String[] args) throws Exception{
		PscUtils util = new PscUtils();
		util.openPscFile("/Users/andrew/psc/PASteelLeagueOntelauneeMatch1_AndrewSchaefersiPhone-v2.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Ontelaunee Match 1", 1);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueUnamiMatch2_AndrewSchaefersiPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Unami Match 2", 2);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueLPRGCMatch3_AndrewSchaefersiPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "LPRGC Match 3", 3);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueUnamiMatch4_AndrewSchaefersiPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Unami Match 4", 4);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueLPRGCMatch5_AndrewSchaefersiPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "LPRGC Match 5", 5);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueGuthsvilleMatch6_AndrewSchaefersiPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Guthsville Match 6", 6);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueNewHollandMatch7_AndrewSchaefersiPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "New Holland Match 7", 6);
		buildFinalReport();
	}
	private static void buildFinalReport() {
		// Division - MatchNum - ShooterName - LeaguePoints
		// Map<String, List<Map<String, LeaguePoints>>> leagueResults = new HashMap<String, List<Map<String, LeaguePoints>>>();
		
		
		// Division  - ShooterName -  MatchNum - LeaguePoints
		Map<String, Map<String, List<LeaguePoints>>> leagueResults = new HashMap<String, Map<String, List<LeaguePoints>>>();

		//List<Map<String, Map<String, ShooterRecord>>> leagueResults = new ArrayList<Map<String, Map<String, ShooterRecord>>>();
		int matchNum = 0;
		for ( Map<String, List<ShooterRecord>> matchResults: results){
	
			for (String division: matchResults.keySet()){
				List<ShooterRecord> shooters = matchResults.get(division);
				int points = 100;
				for (ShooterRecord shooter: shooters){
					String shooterName = getShooterName(shooter.getFirstName(), shooter.getLastName());
					boolean makeup = false;
					if ( shooter.getLastName().toLowerCase().indexOf("makeup") != -1){
						makeup = true;
					}
					if (leagueResults.get(division) == null){
						leagueResults.put(division, new HashMap<String, List<LeaguePoints>>());
					}
					Map<String, List<LeaguePoints>> divisionShooters = leagueResults.get(division);
					if ( !divisionShooters.containsKey(shooterName)){
						List<LeaguePoints> matchScores = new ArrayList<LeaguePoints>();
						for (String matchName: matchNames){
							matchScores.add(new LeaguePoints());
						}
						divisionShooters.put(shooterName, matchScores);
					}
					List<LeaguePoints> pointsForShooter = divisionShooters.get(shooterName);
					
					LeaguePoints leaguePoints = pointsForShooter.get(matchNum);
					if (makeup){
						leaguePoints = pointsForShooter.get(matchNum-1);
						leaguePoints.setLeaguePoints(leaguePoints.getLeaguePoints()-3);
					}
					if (shooter.isDisqualified()) {
						leaguePoints.setLeaguePoints(0);
					} else {
						leaguePoints.setLeaguePoints(points--);
					}

					leaguePoints.setTime(shooter.getTotalTime());
					leaguePoints.setFirstName(shooter.getFirstName());
					leaguePoints.setLastName(shooter.getLastName());
					leaguePoints.setDq(shooter.isDisqualified());
					leaguePoints.setDnf(shooter.isDnf());
					leaguePoints.setMakeup(makeup);
					leaguePoints.setMatchNum(matchNum);
					if ( leaguePoints.isMakeup()){
						leaguePoints.setMatchNum(matchNum-1);
					}
					//pointsForShooter.add(leaguePoints);
					//matchDivisionResults.put(shooterName, leaguePoints);
				}
			}
			matchNum++;
		}
		
		
		
		// Print them out
		try {
			BufferedWriter htmlWriter = new BufferedWriter(new FileWriter("/tmp/scores.html"));
			int tableNum = 1;
			for (String division: leagueResults.keySet()){
				System.out.println("Division: " + division);
				htmlWriter.append(buildTableHeader(division, tableNum++));
				htmlWriter.append("<tbody>");
				Map<String, List<LeaguePoints>> divisionShooters = leagueResults.get(division);
				for (String shooterName: divisionShooters.keySet()){	
					List<LeaguePoints> shooterLeaguePoints = divisionShooters.get(shooterName);
					boolean haveShooterName = false;
					StringBuilder sbName = new StringBuilder();
					StringBuilder sbScores = new StringBuilder();
					int leaguePointsTotal = 0;
					for (LeaguePoints point: shooterLeaguePoints){
						
						if ( !haveShooterName && (!point.getLastName().isEmpty() || !point.getFirstName().isEmpty())){
							//System.out.print(point.getLastName() + "," + point.getFirstName()+",");
							sbName.append("<tr><td>" + point.getLastName().replaceAll("MAKEUP", "").replaceAll("makeup", "").replaceAll("Makeup", "").trim() + " " + point.getFirstName()+ "</td>");
							haveShooterName = true;
							
						}
						double totalTime = Math.round(point.getTime() * 100.0) / 100.0;
						leaguePointsTotal += point.getLeaguePoints();
						sbScores.append("<td>" + totalTime + "</td><td>" + point.getLeaguePoints() );
						if ( point.isMakeup()){
							sbScores.append(" M");
						}
						if ( point.isDq()){
							sbScores.append(" DQ");
						}
						if ( point.isDnf()){
							sbScores.append(" DNF");
						}
						sbScores.append("</td>");
						//System.out.print(point.getTime() + ":" + point.getLeaguePoints() + ",");
					}
					
					htmlWriter.append(sbName.toString() + sbScores.toString());
					//System.out.println();
					htmlWriter.append("<td>"+leaguePointsTotal+"</td></tr>");
				}
				htmlWriter.append("</tbody>");
				htmlWriter.append("</table>"); 
			}
			htmlWriter.append("</div></body></html>");
			htmlWriter.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private static String getShooterName(String firstName, String lastName){
		firstName = firstName.toLowerCase().trim();
		lastName = lastName.toLowerCase().trim();
		
		if ( lastName.indexOf("gottlieb") != -1 && firstName.indexOf("mike") != -1){
			firstName = "michael";
		}
		if ( lastName.indexOf("rochiele") != -1 && firstName.indexOf("tom") != -1){
			firstName = "tom";
			lastName = "rachiele";
		}
		if ( lastName.indexOf("rochiele") != -1 && firstName.indexOf("dominic") != -1){
			firstName = "dominic";
			lastName = "rachiele";
		}
		if ( lastName.indexOf("parsons") != -1 && firstName.indexOf("dave") != -1){
			firstName = "david";
			lastName = "parsons";
		}
		if ( lastName.indexOf("masi") != -1 && firstName.indexOf("pat") != -1){
			firstName = "patrick";
			lastName = "masi";
		}
		if ( lastName.indexOf("garrido") != -1 && firstName.indexOf("ken") != -1){
			firstName = "ken";
			lastName = "garrido";
		}
		if ( lastName.indexOf("donnet") != -1 && firstName.indexOf("jean") != -1){
			firstName = "jj";
			lastName = "donnet";
		}
		if ( lastName.indexOf("schwartz") != -1 && firstName.indexOf("dom") != -1){
			firstName = "dom";
			lastName = "schwartz";
		}
		if ( lastName.indexOf("demarco") != -1 && firstName.indexOf("art") != -1){
			firstName = "art";
			lastName = "demarco";
		}
		if ( lastName.indexOf("shupp") != -1 && firstName.indexOf("mike") != -1){
			firstName = "michael";
			lastName = "shupp";
		}
		if ( lastName.indexOf("stout") != -1 && firstName.indexOf("don") != -1){
			firstName = "donald";
			lastName = "stout";
		}
		if ( lastName.indexOf("litwin") != -1 && firstName.indexOf("hen") != -1){
			firstName = "henry";
			lastName = "litwin";
		}
		if ( lastName.indexOf("olewine") != -1 && firstName.indexOf("tom") != -1){
			firstName = "thomas";
			lastName = "olewine";
		}
		if ( lastName.indexOf("eichelberger") != -1 && firstName.indexOf("ic") != -1){
			firstName = "dick";
			lastName = "eichelberger";
		}
		if ( lastName.indexOf("eichleberger") != -1 && firstName.indexOf("ic") != -1){
			firstName = "dick";
			lastName = "eichelberger";
		}
		if ( lastName.indexOf("olewine") != -1 && firstName.indexOf("tom") != -1){
			firstName = "thomas";
			lastName = "olewine";
		}
		if ( lastName.indexOf("olewine") != -1 && firstName.indexOf("tom") != -1){
			firstName = "thomas";
			lastName = "olewine";
		}
		if ( lastName.indexOf("olewine") != -1 && firstName.indexOf("tom") != -1){
			firstName = "thomas";
			lastName = "olewine";
		}
		if ( lastName.indexOf("olewine") != -1 && firstName.indexOf("tom") != -1){
			firstName = "thomas";
			lastName = "olewine";
		}
		if ( lastName.indexOf("ames") != -1 && firstName.indexOf("mike") != -1){
			firstName = "michael";
			lastName = "ames";
		}
		if ( lastName.indexOf("adams") != -1 && firstName.indexOf("jim") != -1){
			firstName = "jim";
			lastName = "adams";
		}
		if ( lastName.indexOf("halabura") != -1 && firstName.indexOf("zack") != -1){
			firstName = "zack";
			lastName = "halabura";
		}
		if ( lastName.indexOf("zack") != -1 && firstName.indexOf("halabura") != -1){
			firstName = "zack";
			lastName = "halabura";
		}
		return firstName.toLowerCase().replaceAll("makeup", "").trim() + lastName.toLowerCase().replaceAll("makeup", "").trim();
	}
	private static String buildTableHeader(String division, int tableNum){
		StringBuilder sb = new StringBuilder();
		sb.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"1\" class=\"display\" id=\"example"+tableNum+"\">");
		sb.append("<thead>");

		sb.append("<tr><td><b>"+division+"</b></td>");
		for ( String matchName: matchNames){
			sb.append("<td><b>"+matchName+"</b></td><td>points</td>");
		}
		sb.append("<td><b>Total Points</b></td></tr>");
		sb.append("</thead>");

		return sb.toString();
	}
	private static void compileMatchResults(String scoreDefFileName, String scoreFileName, String matchName, int matchNum) throws Exception{
		System.out.println("Processing match " + matchName);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MatchScores scores = mapper.readValue(new File(scoreFileName), MatchScores.class);
		//System.out.println(scores);
		MatchDef definition = mapper.readValue(new File(scoreDefFileName), MatchDef.class);
		results.add(processResults(scores, definition, matchNum));
		matchNames.add(matchName);
	}
	private static Map<String, List<ShooterRecord>> processResults(MatchScores scores, MatchDef definition, int matchNum){
		List<ShooterRecord> mainMatchShooters = new ArrayList<ShooterRecord>();

		int shooterNum = 1;
		Map<String, MatchShooter> shooterMap = new HashMap<String, MatchShooter>();
		Map<String, ShooterRecord> shooterRecordMap = new HashMap<String, ShooterRecord>();
				
		for (MatchShooter shooter : definition.getMatchShooters()) {
			ShooterRecord shooterRecord = new ShooterRecord();
			shooterMap.put(shooter.getShUuid(), shooter);
			shooterRecordMap.put(shooter.getShUuid(), shooterRecord);
			shooterRecord.setFirstName(shooter.getShFn());
			shooterRecord.setLastName(shooter.getShLn());
			shooterRecord.setShooterScsaId(shooter.getShId());
			shooterRecord.setShooterNumber(shooterNum++);
			shooterRecord.setDivisionCode( shooter.getShDvp());
			shooterRecord.setClassCode(shooter.getShGrd());
			//String division = shooter.getShDvp();
			String powerFactor = shooter.getShPf();
			String sex = shooter.getShGen(); //MALE for male
			String adult = shooter.getShAge(); //ADULT for adult
			boolean disqualified = shooter.getShDq(); 
			shooterRecord.setDisqualified(disqualified);

			mainMatchShooters.add(shooterRecord);
		}

		Map<String, MatchStage> stageMap = new HashMap<String, MatchStage>();
		for (MatchStage stage : definition.getMatchStages()) {
			stageMap.put(stage.getStageUuid(), stage);
		}
		List<String> stageList = new ArrayList<String>();
		// Build data structures
		for (MatchScore score : scores.getMatchScores()) {
			MatchStage stage = stageMap.get(score.getStageUuid());
			stageList.add(stage.getStageName());

			for (StageStagescore stageScore : score.getStageStagescores()) {

				MatchShooter shooter = shooterMap.get(stageScore.getShtr());
				ShooterRecord shooterRecord = shooterRecordMap.get(stageScore.getShtr());

				double totalTime = 0;
				double worstTime = 0;
				List<Double> calcedScores = new ArrayList<Double>();
				
				for (double str : stageScore.getStr()) {
					calcedScores.add(Math.min(str, 30));
				}
				int scoreIndex = 0;
				for (List<Integer> penalties: stageScore.getPenss()){
					int penaltyIdx = 0;
					for ( int penalty: penalties){
						if ( penalty != 0){
							double newScore = 0;
							if ( penaltyIdx == 0){
								newScore = calcedScores.get(scoreIndex) + 3;
							}
							if ( penaltyIdx == 1){
								newScore = calcedScores.get(scoreIndex) + 3;
							}
							if ( penaltyIdx == 2){
								newScore = calcedScores.get(scoreIndex) + 30;
							}
							calcedScores.remove(scoreIndex);
							calcedScores.add(scoreIndex, Math.min(newScore, 30));
						}
						penaltyIdx++;
					}
					scoreIndex++;
				}
				
				for (double str : calcedScores) {
					totalTime += str;
					if (str > worstTime) {
						worstTime = str;
					}
				}
				totalTime -= worstTime;
				// Round to hundredths
				totalTime = Math.round(totalTime * 100.0) / 100.0;
				shooterRecord.setTotalTime(totalTime + shooterRecord.getTotalTime());
				if ( totalTime == 0 ){
					shooterRecord.setDnf(true);
				}
				shooterRecord.setStagesScored(shooterRecord.getStagesScored()+1);
			}
		}
		removeFunShooters(mainMatchShooters);
		removeZeroTimeShooterEntries(mainMatchShooters);
		Map<String, List<ShooterRecord>> shootersByDivision = calculateFinishOrder(mainMatchShooters);
		
		for (String division: shootersByDivision.keySet()){
			System.out.println("Division: " + division);
			List<ShooterRecord> orderedShooters = shootersByDivision.get(division);
			for ( ShooterRecord shooter: orderedShooters){
				System.out.println(shooter);
			}
		}
		return shootersByDivision;
	}
	
	private static void removeFunShooters(List<ShooterRecord> shooters) {
		List<ShooterRecord> shootersToRemove = new ArrayList<ShooterRecord>();
		for (ShooterRecord shooter: shooters){
			if ( "Fun".equals(shooter.getClassCode())){
				shootersToRemove.add(shooter);
			}
		}
		shooters.removeAll(shootersToRemove);
		
	}
	
	private static void removeZeroTimeShooterEntries(List<ShooterRecord> shooters) {
		List<ShooterRecord> shootersToRemove = new ArrayList<ShooterRecord>();
		for (ShooterRecord shooter: shooters){
			if ( shooter.getTotalTime() == 0){
				shootersToRemove.add(shooter);
			}
		}
		shooters.removeAll(shootersToRemove);
		
	}
	private static Map<String, List<ShooterRecord>> calculateFinishOrder(List<ShooterRecord> shooters){
		
		Comparator<ShooterRecord> scoreSorter = new Comparator<ShooterRecord>() {
		    public int compare(ShooterRecord s1, ShooterRecord s2) {
		    	return Double.compare(s1.getTotalTime(), s2.getTotalTime());
		    }
		};
		
		Comparator<ShooterRecord> dnfDqSorter = new Comparator<ShooterRecord>() {
		    public int compare(ShooterRecord s1, ShooterRecord s2) {
		    	boolean s1bad = s1.isDisqualified() || s1.isDnf();
		    	boolean s2bad = s2.isDisqualified() || s2.isDnf();
		    	if ( s1bad & !s2bad){
		    		return 1;
		    	}
		    	if ( !s1bad & s2bad){
		    		return -1;
		    	}
		    	return 0;
		    }
		};
		
		Map<String, List<ShooterRecord>> shootersByDivision = new HashMap<String, List<ShooterRecord>>();
		for (ShooterRecord shooter:shooters){
			if ( shootersByDivision.get(shooter.getDivisionCode())==null){
				shootersByDivision.put(shooter.getDivisionCode(), new ArrayList<ShooterRecord>());
			}
			shootersByDivision.get(shooter.getDivisionCode()).add(shooter);
			Collections.sort(shootersByDivision.get(shooter.getDivisionCode()), scoreSorter);
			Collections.sort(shootersByDivision.get(shooter.getDivisionCode()), dnfDqSorter);
		}
		for (List<ShooterRecord> orderedShooters: shootersByDivision.values()){
			int place = 1;
			for ( ShooterRecord shooter: orderedShooters){
				shooter.setPlace(place++);
			}
		}
		return shootersByDivision;
	}
}
