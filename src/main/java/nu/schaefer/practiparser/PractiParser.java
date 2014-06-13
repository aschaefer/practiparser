package nu.schaefer.practiparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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

public class PractiParser {
	public static void main(String[] args) throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		// Either load via cfg file or command line args
		String clubName = "Guthsville Rod & Gun Club";
		String clubID = "SCSA178";
		String scoreFileName = "/tmp/match_scores.json";
		String scoreDefFileName = "/tmp/match_def.json";
		String csvFilename = "/tmp/output.csv";
		
		MatchScores scores = mapper.readValue(new File(scoreFileName), MatchScores.class);
		//System.out.println(scores);
		MatchDef definition = mapper.readValue(new File(scoreDefFileName), MatchDef.class);
		//System.out.println(definition);

		createScsaCsv(scores, definition, csvFilename, clubName, clubID);
	}
	
	public static void createScsaCsv(MatchScores scores, MatchDef definition, String filename, String clubName, String clubID){
		List<ShooterRecord> allShooters = new ArrayList<ShooterRecord>();
		List<ShooterRecord> mainMatchShooters = new ArrayList<ShooterRecord>();
		List<ShooterRecord> lrRifleMatchShooters = new ArrayList<ShooterRecord>();
		List<ShooterRecord> lrPistolMatchShooters = new ArrayList<ShooterRecord>();
		int shooterNum = 1;
		Map<String, MatchShooter> shooterMap = new HashMap<String, MatchShooter>();
		
		Set<String> divisionsInUse = new HashSet<String>();
		Set<String> lrRifleDivisionsInUse = new HashSet<String>();
		Set<String> lrPistolDivisionsInUse = new HashSet<String>();
		
		
		Set<String> mainStages = new HashSet<String>();
		Set<String> lrRifleStages = new HashSet<String>();
		Set<String> lrPistolStages = new HashSet<String>();
		
		for (MatchShooter shooter : definition.getMatchShooters()) {
			shooterMap.put(shooter.getShUuid(), shooter);
			ShooterRecord shooterRecord = new ShooterRecord();
			shooterRecord.setFirstName(shooter.getShFn());
			shooterRecord.setLastName(shooter.getShLn());
			shooterRecord.setShooterScsaId(shooter.getShId());
			shooterRecord.setShooterNumber(shooterNum++);
			String division = shooter.getShDvp();
			String powerFactor = shooter.getShPf();
			String sex = shooter.getShGen(); //MALE for male
			String adult = shooter.getShAge(); //ADULT for adult
			boolean disqualified = shooter.getShDq(); 
			System.out.println(division);

			if ( "IPSC".equals(division)){
				shooterRecord.setDivisionCode("IPRD");
				divisionsInUse.add("IPRD");
				mainMatchShooters.add(shooterRecord);
			}
			if ( "Limited".equals(division)){
				shooterRecord.setDivisionCode("ISP");
				divisionsInUse.add("ISP");
				mainMatchShooters.add(shooterRecord);
			}
			if ( "Open".equals(division)){
				shooterRecord.setDivisionCode("OPN");
				divisionsInUse.add("OPN");
				mainMatchShooters.add(shooterRecord);
			}
			if ( "Production".equals(division)){
				shooterRecord.setDivisionCode("PROD");
				divisionsInUse.add("PROD");
				mainMatchShooters.add(shooterRecord);
			}
			if ( "Revolver".equals(division)){
				shooterRecord.setDivisionCode("OSR");
				divisionsInUse.add("OSR");
				mainMatchShooters.add(shooterRecord);
			}
			if ( "Single Stack".equals(division)){
				shooterRecord.setDivisionCode("SS");
				divisionsInUse.add("SS");
				mainMatchShooters.add(shooterRecord);
			}
			
			// TODO: Looks like these need to go into a different "match" 
			// as ezSteel will not allow them in a regular match
			if ( "Rimfire Pistol Iron".equals(division)){
				shooterRecord.setDivisionCode("RFPI");
				lrPistolDivisionsInUse.add("RFPI");
				lrPistolMatchShooters.add(shooterRecord);
			}
			if ( "Rimfire Pistol Open".equals(division)){
				shooterRecord.setDivisionCode("RFPO");
				lrPistolDivisionsInUse.add("RFPO");
				lrPistolMatchShooters.add(shooterRecord);
			}
			if ( "Rimfire Rifle Iron".equals(division)){
				shooterRecord.setDivisionCode("RFRI");
				lrRifleDivisionsInUse.add("RFRI");
				lrRifleMatchShooters.add(shooterRecord);
			}
			if ( "Rimfire Rifle Open".equals(division)){
				shooterRecord.setDivisionCode("RFRO");
				lrRifleDivisionsInUse.add("RFRO");
				lrRifleMatchShooters.add(shooterRecord);
			}
			allShooters.add(shooterRecord);
		}

		Map<String, MatchStage> stageMap = new HashMap<String, MatchStage>();
		for (MatchStage stage : definition.getMatchStages()) {
			stageMap.put(stage.getStageUuid(), stage);
		}
		
		// Build data structures
		for (MatchScore score : scores.getMatchScores()) {
			MatchStage stage = stageMap.get(score.getStageUuid());
			System.out.println("Scores for Stage " + score.getStageNumber()
					+ " - " + stage.getStageName());

			for (StageStagescore stageScore : score.getStageStagescores()) {

				MatchShooter shooter = shooterMap.get(stageScore.getShtr());

				if (shooter != null) {
					System.out.print(shooter.getShFn() + " "
							+ shooter.getShLn() + " : ");
				} else {
					System.out.print("UNKNOWN SHOOTER");
				}

				if (stageScore.getDnf()) {
					System.out.print(" **DNF** ");
				}
				System.out.print(shooter.getShDvp() + " ");
				double totalTime = 0;
				double worstTime = 0;
				for (double str : stageScore.getStr()) {
					System.out.print(str + ",");
					totalTime += str;
					if (str > worstTime) {
						worstTime = str;
					}
				}
				totalTime -= worstTime;
				System.out.print("(" + totalTime + ")");
				System.out.println();
			}
		}
		
		String startDate = "20140531";
		String endDate = "20140531";
		String CR = "\n";
		
		int lineCount = 0;
		// Spit out the CSV
		try {
			BufferedWriter csvWriter = new BufferedWriter(new FileWriter(filename));
			csvWriter.write("AA,1,1,???,???,1,,,,,,,,,,,,,,,,,,,," + CR);
			lineCount++;
			csvWriter.write("ER,"+clubID+",1,"+clubName+","+startDate+","+endDate + ",,,,,,,,,,,,,,,,,,,," + CR);
			lineCount++;
			for ( ShooterRecord shooter: allShooters){
				csvWriter.write(shooter.toCsv() + CR);
				lineCount++;
			}
			// List competitors EC
			// FE line - ?? Possibly sum of all competitors, and all competitors with SCSA number
			
			//TODO: Only use match types if they were in PS output
			csvWriter.write("MR,1,Main Match,SC,,,,,,,,,,,,,,,,,,,,," + CR);
			lineCount++;
			csvWriter.write("MR,2,Rimfire Pistol,SC,,,,,,,,,,,,,,,,,,,,," + CR);
			lineCount++;
			csvWriter.write("MR,3,Rimfire Rifle,SC,,,,,,,,,,,,,,,,,,,,," + CR);
			lineCount++;

			
			// List Divisions
			if ( divisionsInUse.contains("IPRD")){
				csvWriter.write("DR,IPSC Production,IPRD,1,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( divisionsInUse.contains("ISP")){
				csvWriter.write("DR,Limited,ISP,1,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( divisionsInUse.contains("OPN")){
				csvWriter.write("DR,Open,OPN,1,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( divisionsInUse.contains("OSR")){
				csvWriter.write("DR,Open Revolver,OSR,1,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( divisionsInUse.contains("PROD")){
				csvWriter.write("DR,Production,PROD,1,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( divisionsInUse.contains("SS")){
				csvWriter.write("DR,Single Stack,SS,1,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( lrPistolDivisionsInUse.contains("RFPI")){
				csvWriter.write("DR,Rimfire Iron,RFPI,2,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( lrPistolDivisionsInUse.contains("RFPO")){
				csvWriter.write("DR,Rimfire Optics,RFPO,2,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( lrRifleDivisionsInUse.contains("RFRI")){
				csvWriter.write("DR,Rimfire Rifle Iron,RFRI,3,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( lrRifleDivisionsInUse.contains("RFRO")){
				csvWriter.write("DR,Rimfire Rifle Open,RFRO,3,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}

			
			if ( divisionsInUse.contains("RFPI")){
				csvWriter.write("DR,Rimfire Iron,RFRI,1,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( divisionsInUse.contains("RFPO")){
				csvWriter.write("DR,Rimfire Optics,RFRO,1,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( divisionsInUse.contains("RFRI")){
				csvWriter.write("DR,Rimfire Rifle Ironk,SS,1,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
			if ( divisionsInUse.contains("RFRO")){
				csvWriter.write("DR,Rimfire Rifle Open,SS,1,,,,,,,,,,,,,,,,,,,,,," + CR);
				lineCount++;
			}
//			if ( divisionsInUse.contains("IPRD")){
//				csvWriter.write("DR, IPSC Production, IPRD, 1" + CR);
//			}
			// List Stages
			// CO lines - ??

			// Ordered by what?
			for ( ShooterRecord shooter: mainMatchShooters){
				csvWriter.write(shooter.toEsCsv() + CR);
				lineCount++;
			}
			// List scores per competitor per stage. Ordered by match #, then competitor #, then stage #
			// ZZ line - total line count?
			csvWriter.write("ZZ,"+ (++lineCount) +",,,,,,,,,,,,,,,,,,,,,,,,"+ CR);
			csvWriter.flush();
			csvWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
