package nu.schaefer.practiparser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
	private static int NUM_REQUIRED_MATCHES = 8; 
	public static void main(String[] args) throws Exception{
		
		File f = new File("/tmp/league");
		f.mkdir();
		
		PscUtils util = new PscUtils();

		int matchNum = 1;
		
		String PATH = "/Users/andrew/PASL-PSC/2023/";
		
		util.openPscFile( PATH + "PASteelLeagueLPRGCApril232023_iPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);

		util.openPscFile( PATH + "PASteelLeagueGuthsville572023_iPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeaguePricetown642023_iPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);

		util.openPscFile( PATH + "PASteelLeagueBlueRidge6112023_iPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeaguePalmyra6252023_iPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PA_Steel_League_Lower_Providence_7_16_2023_Export.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeagueTopton7232023_iPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);

		
		/*
		 * 2022
		PATH = "/Users/andrew/PASL-PSC/2022/";
		util.openPscFile( PATH + "PA_Steel_League_Topton_4_24_2022_Export.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeaguePricetownMay82022_AndrewsiPhone11.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PA_Steel_League_5-22-2022_Lower_Providence_Export.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague6-5-2022Palmyra_AndrewsiPhone11.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeagueGuthsville6262022_AndrewsiPhone11.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeaguePricetown7102022_AndrewsiPhone11.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague7-24-2022BlueRidge_AndrewsiPhone11.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PA_Steel_League_7-31-2022_Ontelaunee_Export.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);

		util.openPscFile( PATH + "PASteelLeague8-14-2022LowerProvidence_AndrewsiPhone11.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);

		util.openPscFile( PATH + "PA_Steel_League_8-28-2022_Blue_Ridge_Export.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeaguePalmyra9112022_AndrewsiPhone11.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PA_Steel_League_9-25-2022_Topton_Export.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);

		util.openPscFile( PATH + "PASteelLeagueGuthsville1092022_iPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);

		util.openPscFile( PATH + "PASteelLeague10-30-2022Ontelaunee_iPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		*/
		
		/* 2021
		String PATH = "/Users/andrew/PASL-PSC/2021/";
		util.openPscFile( PATH + "PASteelLeagueTopton4252021_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague5-9-2021Pricetown_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague5-23-2021Ontelaunee_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague6-6-2021Pricetown_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague6-13-2021LowerProvidence_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague7-11-2021Guthsville_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague7-18-2021LowerProvidence_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague8-8-2021Palmyra_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague8-22-2021BlueRidge_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague8-29-2021Ontelaunee_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague9-12-2021Palmyra_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague9-26-2021Topton_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeagueGuthsville10102021_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		
		util.openPscFile( PATH + "PASteelLeague10-17-2021BlueRidge_StevensiPad.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match " + matchNum, matchNum++);
		*/
		/*
		
		util.openPscFile("/Users/andrew/psc/2019/PASteelLeagueLowerProvidenceMay52019_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 1", 1);
		
		util.openPscFile("/Users/andrew/psc/2019/PASteelLeague5-19-2019Topton_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 2", 2);
		
		util.openPscFile("/Users/andrew/psc/2019/PA_Steel_League_5-26-2019_Pricetown_Export.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 3", 3);
		
		util.openPscFile("/Users/andrew/psc/2019/PA_Steel_League_Blue_Ridge_June_9_2019_Export.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 4", 4);
		
		util.openPscFile("/Users/andrew/psc/2019/PASteelLeague6-30-2019Ontelaunee_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 5", 5);
		
		util.openPscFile("/Users/andrew/psc/2019/PASteelLeague7-7-2019BlueRidge_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 6", 6);
		
		util.openPscFile("/Users/andrew/psc/2019/PA_Steel_League_Guthsville_7-14-2019_Export.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 7", 7);
		
		util.openPscFile("/Users/andrew/psc/2019/PASteelLeagueNewHollandJul212019_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 8", 8);
		
		util.openPscFile("/Users/andrew/psc/2019/PASteelLeaguePricetownAug42019_StevensiPad.psc", "/tmp/league/");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 9", 9);
		
		util.openPscFile("/Users/andrew/psc/2019/PASteelLeague8-11-2019Ontelaunee_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 10", 10);

		util.openPscFile("/Users/andrew/psc/2019/PASteelLeagueGuthsvilleAugust252019_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 11", 11 );
		
		util.openPscFile("/Users/andrew/psc/2019/PASteelLeague9-8-2019Topton_AndrewsiPhone11.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 12", 12 );
		
		util.openPscFile("/Users/andrew/psc/2019/PASteelLeagueNewHollandSep152019_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 13", 13 );
			
		util.openPscFile("/Users/andrew/psc/2019/PASteelLeagueLowerProvidenceOct132019_AndrewsiPhone11.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 14", 14 );
		
		*/
		
		/*
		
		
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeagueBlueRidgeApr152018_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 1", 1);
		
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeague4-22-2018Topton_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 2", 2);
		
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeague5-6-2018Pricetown_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 3", 3);
		
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeagueLPRGCMay272018_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 4", 4);
		
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeagueLowerProvidenceJun32018_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 5", 5);
		
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeagueNewHollandJune172018_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 6", 6);
		
		
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeagueOntelauneeJune242018_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 7", 7);
		
		util.openPscFile("/Users/andrew/psc/2018/PaSteelLeagueGuthsvilleJul82018_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 8", 8);
		
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeague7-22-2018BlueRidge_AndrewsiPhoneX.psc", "/tmp/league/");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 9", 9);
			
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeague8-12-2018Ontelaunee_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 10", 10);

		util.openPscFile("/Users/andrew/psc/2018/Guthsville_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 11", 11 );
		
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeagueToptonSept102018_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 12", 12 );
		
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeagueNewHollanSep162018_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 13", 13 );
		
		util.openPscFile("/Users/andrew/psc/2018/PASteelLeaguePricetownSep302018_AndrewsiPhoneX.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 14", 14 );
		
		*/
		
/*		
		util.openPscFile("/Users/andrew/psc/2018/", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 12", 12);
*/
//		
//		util.openPscFile("/Users/andrew/psc/2016/PASteelLeague10-09-2016Topton_StevensiPad.psc", "/tmp/league");
//		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 13", 13);
//		
//		util.openPscFile("/Users/andrew/psc/2016/PASteelLeague10-16-2016NewHolland_AndrewsiPhone.psc", "/tmp/league");
//		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 14", 14);
		
		

		
		
//		util.openPscFile("/Users/andrew/psc/2015/PASteelLeague2015LPRGCMatch6_AndrewsiPhone.psc", "/tmp/league");
//		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 6", 5);
//		util.openPscFile("/Users/andrew/psc/2015/PASteelLeague2015ToptonMatch7_AndrewsiPhone.psc", "/tmp/league");
//		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 7", 5);
//		util.openPscFile("/Users/andrew/psc/2015/PASteelLeague2015UnamiMatch8_AndrewsiPhone.psc", "/tmp/league");
//		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 8", 5);
//		util.openPscFile("/Users/andrew/psc/2015/PASteelLeague2015ToptonMatch9_AndrewsiPhone.psc", "/tmp/league");
//		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 9", 5);
//		util.openPscFile("/Users/andrew/psc/2015/PASteelLeague2015GuthsvilleMatch10_AndrewsiPhone.psc", "/tmp/league");
//		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 10", 5);
//		util.openPscFile("/Users/andrew/psc/2015/PASteelLeague2015PricetownMatch11_AndrewsiPhone.psc", "/tmp/league");
//		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 11", 5);
//		util.openPscFile("/Users/andrew/psc/2015/PASteelLeague2015OntelauneeMatch12_AndrewsiPhone.psc", "/tmp/league");
//		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 12", 5);
//		util.openPscFile("/Users/andrew/psc/2015/PASteelLeague2015PricetownMatch13_AndrewsiPhone.psc", "/tmp/league");
//		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 13", 5);
//		util.openPscFile("/Users/andrew/psc/2015/PASteelLeague2015NewHollandMatch14_AndrewsiPhone.psc", "/tmp/league");
//		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", " Match 14", 5);


		/*
		util.openPscFile("/Users/andrew/psc/PASteelLeagueUnamiMatch2_AndrewSchaefersiPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Unami Match 2", 2);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueLPRGCMatch3_AndrewSchaefersiPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "LPRGC Match 3", 3);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueUnamiMatch4_AndrewSchaefersiPhone-3.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Unami Match 4", 4);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueLPRGCMatch5_AndrewSchaefersiPhone-4.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "LPRGC Match 5", 5);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueGuthsvilleMatch6_AndrewSchaefersiPhone-1.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Guthsville Match 6", 6);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueNewHollandMatch7_AndrewSchaefersiPhone-2.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "New Holland Match 7", 7);
		util.openPscFile("/Users/andrew/psc/PASteelLeaguePricetownMatch8_AndrewSchaefersiPhone-4.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Pricetown Match 8", 8);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueToptonMatch9_AndrewSchaefersiPhone-1.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Topton Match 9", 9);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueGuthsvilleMatch10_AndrewSchaefersiPhone-1.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Guthsville Match 10", 10);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueToptonMatch11_AndrewSchaefersiPhone.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Topton Match 11", 11);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueNewHollandMatch12_AndrewSchaefersiPhone-1.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "New Holland Match 12", 12);
		util.openPscFile("/Users/andrew/psc/PASteelLeagueOntelauneeMatch13_AndrewSchaefersiPhone-1.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Ontelaunee Match 13", 13);
		util.openPscFile("/Users/andrew/psc/PASteelLeaguePricetownMatch14_AndrewSchaefersiPhone-1.psc", "/tmp/league");
		compileMatchResults("/tmp/league/match_def.json", "/tmp/league/match_scores.json", "Pricetown Match 14", 14);
*/		
		
		
		buildFinalReport(NUM_REQUIRED_MATCHES);
	}
	private static void buildFinalReport(int cutoffMatchNum) {
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
					String lastName = shooter.getLastName();
					String shooterName = getShooterName(shooter.getFirstName(), shooter.getLastName());
					
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
					if ( leaguePoints.isPopulated() && !shooter.isMakeup()){
						System.err.println("!!!!!Duplicate non-makeup score encountered for shooter " + shooter.getFirstName() + " " + shooter.getLastName() + " Division: " + division + " Match: " + matchNum);
						System.err.println("Skipping second entry");
						continue;
					}
					if (shooter.isMakeup()){
						leaguePoints = pointsForShooter.get(matchNum-1);
					}
//					if (shooter.isMakeup()){
//						if (matchNum==0){
//							System.out.println("Shooter attempted to shoot a makeup in the first match, which is impossible");
//						} else {
//							leaguePoints = pointsForShooter.get(matchNum-1);
//						}
//						leaguePoints.setLeaguePoints(leaguePoints.getLeaguePoints()-3);
//					}
					if (shooter.isDisqualified()) {
						leaguePoints.setLeaguePoints(0);
					} else if (shooter.isDnf()){
						leaguePoints.setLeaguePoints(1);	
					} else {
						leaguePoints.setLeaguePoints(points);
					}
					// Makeups place ordering does not count against the rest of the league shooters
					if ( !shooter.isDnf() && !shooter.isMakeup()){
						points--;
					}
					
					leaguePoints.setTime(shooter.getTotalTime());
					leaguePoints.setFirstName(shooter.getFirstName());
					leaguePoints.setLastName(shooter.getLastName());
					leaguePoints.setDq(shooter.isDisqualified());
					leaguePoints.setDnf(shooter.isDnf());
					leaguePoints.setMakeup(shooter.isMakeup());
					leaguePoints.setMatchNum(matchNum);
					leaguePoints.setPopulated(true);
					if ( leaguePoints.isMakeup()){
						leaguePoints.setMatchNum(matchNum-1);
					}
				}
			}
			matchNum++;
		}
		
		Comparator<LeaguePoints> pointsSorter = new Comparator<LeaguePoints>() {
		    public int compare(LeaguePoints s1, LeaguePoints s2) {
		    	return Integer.compare(s2.getLeaguePoints(), s1.getLeaguePoints());
		    }
		};
//		int cutoffMatchNum = 7;
		for (String division: leagueResults.keySet()){
			System.out.println("New Shooter " + division);
			Map<String, List<LeaguePoints>> divisionShooters = leagueResults.get(division);
			for (String shooterName: divisionShooters.keySet()){
				List<LeaguePoints> shooterLeaguePoints = divisionShooters.get(shooterName);
				List<LeaguePoints> tmpPoints = new ArrayList<LeaguePoints>();	
				tmpPoints.addAll(shooterLeaguePoints);
				Collections.sort(tmpPoints, pointsSorter);
				for (int i = cutoffMatchNum; i < tmpPoints.size(); i++){
					tmpPoints.get(i).setAboveCutoff(false);
				}
				
				//Throw-away code
				int totalMatchPoints = 0;
				for (LeaguePoints point: tmpPoints){
					if ( point.isAboveCutoff()){
						totalMatchPoints += point.getLeaguePoints();
					}
				}
				System.out.println("total points for shooter:" + totalMatchPoints);
			}
		}
		
		// Print them out
		try {

			BufferedWriter htmlWriter = new BufferedWriter(new FileWriter("/tmp/scores.html", false));
			
			BufferedReader headerReader = new BufferedReader(new FileReader("/Users/andrew/src/practiParser/templates/header.html"));
			String line = null;
			int sortColumn = (matchNames.size() *2) +1;
			while ( (line = headerReader.readLine()) != null){
				htmlWriter.append(line.replaceAll("%%SORTCOL%%", sortColumn+"").replaceAll("%%SORTCOL1%%", sortColumn+1 +"")+"\n");
			}
			headerReader.close();
			int tableNum = 1;
			List<PrizeTablePick> prizeTablePicks = new ArrayList<PrizeTablePick>();
			Map<String, Set<String>> clubsForShooter = new HashMap<String, Set<String>>();
			Map<String, List<PrizeTablePick>> prizeTablePicksByDivision = new HashMap<String, List<PrizeTablePick>>();
			for (String division: leagueResults.keySet()){
				System.out.println("Division: " + division);
				htmlWriter.append(buildTableHeader(division, tableNum++));
				htmlWriter.append("<tbody>\n");

				Map<String, List<LeaguePoints>> divisionShooters = leagueResults.get(division);
				for (String shooterName: divisionShooters.keySet()){	
					List<LeaguePoints> shooterLeaguePoints = divisionShooters.get(shooterName);
					boolean haveShooterName = false;
					StringBuilder sbName = new StringBuilder();
					StringBuilder sbScores = new StringBuilder();
					int leaguePointsTotal = 0;
					int numMatches = 0;
					int numMatchWins = 0;
					String prettyShooterName = null;
					int matchNumber = 1;
					PrizeTablePick pick = new PrizeTablePick();
					
					for (LeaguePoints point: shooterLeaguePoints){
						
						if ( !haveShooterName && (!point.getLastName().isEmpty() || !point.getFirstName().isEmpty())){
							//System.out.print(point.getLastName() + "," + point.getFirstName()+",");
							prettyShooterName = point.getLastName().replaceAll("MAKEUP", "").replaceAll("makeup", "").replaceAll("Makeup", "").trim() + " " + point.getFirstName();
							sbName.append("<tr><td>" + prettyShooterName+ "</td>");
							haveShooterName = true;
						}
						double totalTime = Math.round(point.getTime() * 100.0) / 100.0;
						if (point.isAboveCutoff()){
							leaguePointsTotal += point.getLeaguePoints();
						}
						if ( point.getLeaguePoints() == 100){
							numMatchWins++;
						}
						if ( point.getLeaguePoints() > 0 || point.isDnf() || point.isDq()){
							numMatches++;
							pick.getClubsAttended().add(getClubName(matchNumber));
							if (clubsForShooter.get(prettyShooterName) == null){
								clubsForShooter.put(prettyShooterName, new HashSet<String>());
							}
							pick.getLeaguePointsList().add(point);
							clubsForShooter.get(prettyShooterName).add(getClubName(matchNumber));
								
						}
						matchNumber++;
						sbScores.append("<td>");
						if (point.isDq()){
							sbScores.append("DQ");
						} else if (point.isDnf()){
							sbScores.append("DNF");
						} else {
							sbScores.append(totalTime);
						}
						sbScores.append("</td><td>");
						
						if (point.isAboveCutoff()){
							sbScores.append("<b>");
						}
						sbScores.append("" + point.getLeaguePoints() );
						if ( point.isMakeup()){
							sbScores.append(" M");
						}
						if (point.isAboveCutoff()){
							sbScores.append("</b>");
						}

						sbScores.append("</td>");
						
						
						//System.out.print(point.getTime() + ":" + point.getLeaguePoints() + ",");
					}
					
					htmlWriter.append(sbName.toString() + sbScores.toString());

					
					//System.out.println();
					htmlWriter.append("<td>"+leaguePointsTotal+"</td>");
					htmlWriter.append("<td>"+numMatches+"</td>");
					htmlWriter.append("<td>"+numMatchWins+"</td>");
					htmlWriter.append("</tr>\n");
					

					if ( numMatches >= NUM_REQUIRED_MATCHES){
						
						pick.setLeaguePoints(leaguePointsTotal);
						pick.setShooterName(prettyShooterName);
						pick.setDivision(division);
						pick.setNumMatchesAttended(numMatches);
//						pick.setNumMatchesWon(numMatchWins);
						prizeTablePicks.add(pick);
						
						if ( prizeTablePicksByDivision.get(division) == null){
							prizeTablePicksByDivision.put(division, new ArrayList<PrizeTablePick>());
						}
						prizeTablePicksByDivision.get(division).add(pick);
					}
				}
				htmlWriter.append("</tbody>");
				htmlWriter.append("</table>\n");  
			}
			htmlWriter.append("</div></body></html>");
			htmlWriter.close();
			
			Comparator<PrizeTablePick> leaguePickSorter = new Comparator<PrizeTablePick>() {
			    public int compare(PrizeTablePick s1, PrizeTablePick s2) {
			    	if ( s1.getLeaguePoints() == s2.getLeaguePoints()){
			    		return Integer.compare(getDivisionPriority(s1.getDivision()), getDivisionPriority(s2.getDivision()));
			    	} else {
			    		return Integer.compare(s2.getLeaguePoints(), s1.getLeaguePoints());
			    	}
			    }
			};
			
			Comparator<PrizeTablePick> divisionPickSorter = new Comparator<PrizeTablePick>() {
			    public int compare(PrizeTablePick s1, PrizeTablePick s2) {
			    	if ( s1.getLeaguePoints() != s2.getLeaguePoints()){
			    		return Integer.compare(s2.getLeaguePoints(), s1.getLeaguePoints());
			    	} else {
			    		int retVal = 0;
			    		for (int i = 100; i > 0; i-- ){
			    			int s1Count = 0;
			    			int s2Count = 0;
			    			for (LeaguePoints lp: s1.getLeaguePointsList()){
			    				if ( lp.getLeaguePoints() == i){
			    					s1Count++;
			    				}
			    			}
			    			for (LeaguePoints lp: s2.getLeaguePointsList()){
			    				if ( lp.getLeaguePoints() == i){
			    					s2Count++;
			    				}
			    			}
			    			if ( s1Count != 0 || s2Count != 0){
			    				if (s1Count != s2Count){
			    					return Integer.compare(s2Count, s1Count);
			    				}
			    			}
			    		}
			    		return Integer.compare(s1.getNumMatchesAttended(), s2.getNumMatchesAttended());
			    		//fixme
//			    		if ( s1.getNumMatchesAttended() != s2.getNumMatchesAttended()){	
//			    			return Integer.compare(s2.getNumMatchesAttended(), s1.getNumMatchesAttended());
//			    		} else {
//			    		return Integer.compare(s2.getNumMatchesWon(), s1.getNumMatchesWon());
//			    		}
			    	}
			    }
			};
			Collections.sort(prizeTablePicks, leaguePickSorter);
			int pickNum = 1;
			
			System.out.println("Combined League Pick Order");
			for (PrizeTablePick pick: prizeTablePicks){
				System.out.println(pickNum++ + " " + pick.getShooterName() +" "+ pick.getDivision() +" "+ pick.getLeaguePoints());
			}
			int totalLeaguePicks = 0;

			BufferedWriter pickWriter = new BufferedWriter(new FileWriter("/tmp/divisionPicks.html", false));
			writeHeader(pickWriter);
			for (String division: prizeTablePicksByDivision.keySet()){
				int divisionPickNum = 1;
				int divisionTotalPicks = 0;
				System.out.println("\nPicks for Division " + division);
				pickWriter.write("<div class=\"page\">");
				pickWriter.write("<br>Picks for Division " + division + "<br>");
				pickWriter.write("<table border=\"1\"><tr><td>Pick Order</td><td>Name</td><td>League Points</td><td>Clubs Not Attended</td><td>Winning Tie Breaker</td></tr>");
				List<PrizeTablePick> picks = prizeTablePicksByDivision.get(division);
				Collections.sort(picks, divisionPickSorter);
				for (PrizeTablePick pick: picks){
					Set<String> requiredClubs = new HashSet<String>();
					requiredClubs.add("Blue Ridge");
					requiredClubs.add("Palmyra");
					requiredClubs.add("Ontelaunee");
					requiredClubs.add("Topton");
					requiredClubs.add("Pricetown");
					requiredClubs.add("Guthsville");
					requiredClubs.add("Lower Providence");
					requiredClubs.removeAll(clubsForShooter.get(pick.getShooterName()));
					boolean validShooter = true;
					if (!requiredClubs.isEmpty()){
						validShooter = false;
					}
					
//					System.out.println(divisionPickNum + " " + pick.getShooterName() +" "+ pick.getLeaguePoints()+" "+ pick.getNumMatchesAttended() +" "+ pick.getNumMatchesWon() + " " + requiredClubs);
					if (validShooter){
						System.out.println(divisionPickNum + " " + pick.getShooterName() +" "+ pick.getLeaguePoints()+ " " + printPickCounts(pick.getLeaguePointsList()));
						pickWriter.write("<tr><td>" + divisionPickNum + "</td><td>" + pick.getShooterName() +"</td><td>"+ pick.getLeaguePoints()+"</td><td>"+ requiredClubs+ "</td><td>"+ printPickCounts(pick.getLeaguePointsList()) + "</td></tr>");
						//pickWriter.write("<tr><td>" + "TBD" + "</td><td>" + pick.getShooterName() +"</td><td>"+ pick.getLeaguePoints()+"</td><td>"+ requiredClubs+ "</td><td>"+ printPickCounts(pick.getLeaguePointsList()) + "</td></tr>");
					} else {
						System.out.println("X" + " " + pick.getShooterName() +" "+ pick.getLeaguePoints()+" Missing Club: " + requiredClubs);
						pickWriter.write("<tr><td>Missing Club</td><td>" + pick.getShooterName() +"</td><td>"+ pick.getLeaguePoints()+"</td><td>"+ requiredClubs+"</td></tr>");
					}
					pickWriter.write("\n");
					if (validShooter){
					
						totalLeaguePicks++;
						divisionTotalPicks++;
						divisionPickNum++;
					}
//					divisionPickNum++;
					
				}
				pickWriter.write("</table>");
				pickWriter.write("<b>Total Division Picks: " + divisionTotalPicks + "</b><br><br>");

				System.out.println("Total Division Picks: " + divisionTotalPicks + "\n");
				
			}
			
			System.out.println("Total Picks For League By Division: " + totalLeaguePicks);
			pickWriter.write("Total Picks For League By Division: " + totalLeaguePicks);
			pickWriter.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	private static void writeHeader(BufferedWriter pickWriter) throws IOException {
		
		BufferedReader headerReader = new BufferedReader(new FileReader("/Users/andrew/src/practiParser/templates/pickHeader.html"));
		String line = null;
		int sortColumn = (matchNames.size() *2) +1;
		while ( (line = headerReader.readLine()) != null){
			pickWriter.append(line.replaceAll("%%SORTCOL%%", sortColumn+"").replaceAll("%%SORTCOL1%%", sortColumn+1 +"")+"\n");
		}
		

		
		
		
	}
	private static String getClubName(int matchNumber) {
		String[] matchList = {"Lower Providence","Guthsville","Pricetown","Blue Ridge","Palmyra","Lower Providence","Topton","Blue Ridge","Guthsville","Ontelaunee","Palmyra","Topton", "Pricetown","Ontelaunee"};
		return matchList[matchNumber+1];
/*
		if (matchNumber == 1){
			return "Topton";
		}
		if (matchNumber == 2){
			return "Pricetown";
		}
		if (matchNumber == 3){
			return "Lower Providence";
		}
		if (matchNumber == 4){
			return "Palmyra";
		}
		if (matchNumber == 5){
			return "Guthsville";
		}
		if (matchNumber == 6){
			return "Pricetown";
		}
		if (matchNumber == 7){
			return "Blue Ridge";
		}
		if (matchNumber == 8){
			return "Ontelaunee";
		}
		if (matchNumber == 9){
			return "Lower Providence";
		}
		if (matchNumber == 10){
			return "Blue Ridge";
		}
		if (matchNumber == 11){
			return "Palmyra";
		}
		if (matchNumber == 12){
			return "Topton";
		}
		if (matchNumber == 13){
			return "Guthsville";
		}
		if (matchNumber == 14){
			return "Ontelaunee";
		}
		
		return null;
		*/
	}
	private static String printPickCounts(List<LeaguePoints> picks){
		
		StringBuilder sb = new StringBuilder();
		for (int i = 100; i > 0; i--){
			int counter = 0;
			int unusedCounter = 0;
			for (LeaguePoints p: picks){
				if (i == p.getLeaguePoints() && p.isAboveCutoff()){
					counter++;
				}
				if (i == p.getLeaguePoints() && !p.isAboveCutoff()){
					unusedCounter++;
				}
			}
			if (counter != 0){
				sb.append(i + "(" + counter + ") ");
			}
			if (unusedCounter != 0){
				sb.append(i + "[" + unusedCounter + "] ");
			}
		}
		return sb.toString();
		
	}
	private static int getDivisionPriority(String division){
			if ("Stock Auto".equals(division)){
				return 1;
			}
			if ("Revolver".equals(division)){
				return 2;
			}
			if ("Open Auto".equals(division)){
				return 3;
			}
			if ("Pistol Caliber Carbine".equals(division)){
				return 4;
			}
			if (".22 Stock Auto".equals(division)){
				return 5;
			}
			if (".22 Open Auto".equals(division)){
				return 6;
			}
			if (".22 Rifle".equals(division)){
				return 7;
			}
			System.err.println("Can't find priority for division " + division);
			return 0;
	}
	private static String getShooterName(String firstName, String lastName){
		firstName = firstName.toLowerCase().trim().replaceAll("\\.", "");;
		lastName = lastName.toLowerCase().trim().replaceAll("\\.", "");
		
		if ( lastName.indexOf("gottlieb") != -1 && firstName.indexOf("mike") != -1){
			firstName = "michael";
		}
		if ( lastName.indexOf("gottlieb") != -1 && firstName.indexOf("mkichael") != -1){
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
		if ( lastName.indexOf("elchleberger") != -1 && firstName.indexOf("ic") != -1){
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
		if ( lastName.indexOf("forero") != -1 && firstName.indexOf("joe") != -1){
			firstName = "joseph";
			lastName = "forero";
		}
		if ( lastName.indexOf("yost") != -1 && firstName.indexOf("thomas") != -1){
			firstName = "tom";
			lastName = "yost";
		}
		if ( lastName.indexOf("j") != -1 && firstName.indexOf("chris") != -1){
			firstName = "chris";
			lastName = "james";
		}
		if ( lastName.indexOf("michel") != -1 && firstName.indexOf("fred") != -1){
			firstName = "frederick";
			lastName = "michel";
		}
		if ( lastName.indexOf("mark") != -1 && firstName.indexOf("good") != -1){
			firstName = "mark";
			lastName = "good";
		}
		if ( lastName.indexOf("parry") != -1 && firstName.indexOf("matthew") != -1){
			firstName = "matt";
			lastName = "parry";
		}
		if ( lastName.indexOf("parry") != -1 && firstName.indexOf("lenny") != -1){
			firstName = "leonard";
			lastName = "parry";
		}
		if ( lastName.indexOf("mcdermott") != -1 && firstName.indexOf("mike") != -1){
			firstName = "michael";
			lastName = "mcdermott";
		}
		if ( lastName.indexOf("bowers") != -1 && firstName.indexOf("josh") != -1){
			firstName = "joshua";
			lastName = "bowers";
		}
		if ( lastName.indexOf("snyder") != -1 && firstName.indexOf("dave") != -1){
			firstName = "david";
			lastName = "snyder";
		}
		if ( lastName.indexOf("tripke") != -1 && firstName.indexOf("mattman") != -1){
			firstName = "matt";
			lastName = "tripke";
		}
		if ( lastName.indexOf("albanese") != -1 && firstName.indexOf("michael") != -1){
			firstName = "mike";
			lastName = "albanese";
		}
		if ( lastName.indexOf("andrew") != -1 && firstName.indexOf("offner") != -1){
			firstName = "andrew";
			lastName = "offner";
		}
		if ( lastName.indexOf("drew") != -1 && firstName.indexOf("offner") != -1){
			firstName = "drew";
			lastName = "offner";
		}

		if ( lastName.indexOf("iii") != -1 && firstName.indexOf("james") != -1){
			firstName = "james";
			lastName = "graziano3";
		}
		if ( lastName.indexOf("III") != -1 && firstName.indexOf("james") != -1){
			firstName = "james";
			lastName = "graziano3";
		}
		if ( lastName.indexOf("sr") != -1 && lastName.indexOf("graziano") != -1){
			firstName = "james";
			lastName = "grazianosr";
		}
		if ( lastName.indexOf("sr.") != -1 && lastName.indexOf("graziano") != -1){
			firstName = "james";
			lastName = "grazianosr";
		}
//		if ( lastName.indexOf("hlavinka") != -1 && lastName.indexOf("sr") != -1){
//			firstName = "vince";
//			lastName = "hlavinka_sr";
//		}
//		if ( lastName.indexOf("hlavinka") != -1 && lastName.indexOf("jr") != -1){
//			firstName = "vince";
//			lastName = "hlavinka_jr";
//		}
//		if ( lastName.indexOf("hlaqvinka") != -1){
//			firstName = "vince";
//			lastName = "hlavinka_sr";
//		}
		
		if ( lastName.indexOf("hla") != -1){
			firstName = "vince";
			lastName = "hlavinka_sr";
		}
		
		
		if ( lastName.indexOf("reppert") != -1 && firstName.indexOf("steve") != -1){
			firstName = "steven";
			lastName = "reppert";
		}
		if ( lastName.indexOf("schwartz") != -1 && firstName.indexOf("dom") != -1){
			firstName = "dominic";
			lastName = "schwartz";
		}
		if ( lastName.indexOf("sweeny") != -1 && firstName.indexOf("april") != -1){
			firstName = "april";
			lastName = "sweeney";
		}
		if ( lastName.indexOf("sweeny") != -1 && firstName.indexOf("ryan") != -1){
			firstName = "ryan";
			lastName = "sweeney";
		}
		if ( lastName.indexOf("van name") != -1){
			lastName = "vanname";
		}
		if ( lastName.indexOf("m") != -1 && firstName.indexOf("richard") != -1){
			firstName = "richard";
			lastName = "miller";
		}
		if ( lastName.indexOf("romaniw") != -1 && firstName.indexOf("mike") != -1){
			firstName = "michael";
			lastName = "romaniw";
		}
		if ( lastName.indexOf("ballas") != -1 && firstName.indexOf("jes") != -1){
			firstName = "jessica";
			lastName = "ballas";
		}
		if ( lastName.indexOf("o\'neill") != -1 && firstName.indexOf("dav") != -1){
			firstName = "dave";
			lastName = "oneill";
		}
		if ( lastName.indexOf("oneill") != -1 && firstName.indexOf("dav") != -1){
			firstName = "dave";
			lastName = "oneill";
		}

		if ( lastName.indexOf("omensettet") != -1 && firstName.indexOf("kurt") != -1){
			firstName = "kurt";
			lastName = "omensetter";
		}
		if ( lastName.indexOf("esposito") != -1 && firstName.indexOf("joe") != -1){
			firstName = "joseph";
			lastName = "esposito";
		}
		if ( lastName.indexOf("finney") != -1 && firstName.indexOf("dave") != -1){
			firstName = "david";
			lastName = "finney";
		}
		if ( lastName.indexOf("montogmery") != -1 && firstName.indexOf("david") != -1){
			firstName = "david";
			lastName = "montgomery";
		}
		if ( lastName.indexOf("SCHWARTZENTRUBER".toLowerCase()) != -1 && firstName.indexOf("jake") != -1){
			firstName = "Jake";
			lastName = "Schwarztrauber";
		}
		if ( lastName.indexOf("schwarztrauber") != -1 && firstName.indexOf("jacob") != -1){
			firstName = "Jake";
			lastName = "Schwarztrauber";
		}
		if ( lastName.indexOf("gottlieb") != -1 && firstName.indexOf("chris") != -1){
			firstName = "C.";
			lastName = "Gottlieb";
		}
		if ( lastName.indexOf("ruck, sr") != -1 && firstName.indexOf("steven") != -1){
			firstName = "steven";
			lastName = "ruck, sr.";
		}
		if ( lastName.indexOf("omenetter") != -1 && firstName.indexOf("kurt") != -1){
			firstName = "Kurt";
			lastName = "Omensetter";
		}
		
		if ( lastName.indexOf("sefass") != -1 && firstName.indexOf("eric") != -1){
			firstName = "Eric";
			lastName = "Serfass";
		}
		
		if ( lastName.indexOf("montgomery") != -1 && firstName.indexOf("dave") != -1){
			firstName = "david";
			lastName = "montgomery";
		}
		

		if ( lastName.indexOf("clark-huffman") != -1){
			firstName = "nellierae";
			lastName = "clark-huffman";
		}

		if ( lastName.indexOf("das") != -1 && firstName.indexOf("johann") != -1){
			firstName = "johann";
			lastName = "das";
		}
		
		if ( lastName.indexOf("danner") != -1 && firstName.indexOf("john") != -1){
			firstName = "john";
			lastName = "danner";
		}
		
		if ( lastName.indexOf("nace") != -1 && firstName.indexOf("dan") != -1){
			firstName = "dan";
			lastName = "nace";
		}
		if ( lastName.indexOf("thornr") != -1 && firstName.indexOf("christian") != -1){
			firstName = "christian";
			lastName = "thorne";
		}
		
		if ( lastName.indexOf("amees") != -1 && firstName.indexOf("michael") != -1){
			firstName = "michael";
			lastName = "ames";
		}
		if ( lastName.indexOf("luczak") != -1 && firstName.indexOf("thomas") != -1){
			firstName = "tom";
			lastName = "luczak";
		}
		if ( lastName.indexOf("augustine") != -1 && firstName.indexOf("albert") != -1){
			firstName = "al";
			lastName = "augustine";
		}
		if ( lastName.indexOf("piper") != -1 && firstName.indexOf("thomas") != -1){
			firstName = "tom";
			lastName = "piper";
		}
		if ( lastName.indexOf("sickmann") != -1 && firstName.indexOf("anton") != -1){
			firstName = "anton";
			lastName = "siekmann";
		}
		if ( lastName.indexOf("pickard") != -1 && firstName.indexOf("frederick j.") != -1){
			firstName = "fred";
			lastName = "pickard";
		}
		if ( lastName.indexOf("drummond") != -1 && firstName.indexOf("george m.") != -1){
			firstName = "george m";
			lastName = "drummond";
		}
		if ( lastName.indexOf("delprado") != -1){
			lastName = "del prado";
		}
		if ( lastName.indexOf("delprado") != -1 && firstName.indexOf("leeanne") != -1){
			firstName = "leanne";
			lastName = "delprado";
		}

		if ( lastName.indexOf("thorne") != -1 && firstName.indexOf("glock34") != -1){
			firstName = "christian";
			lastName = "thorne";
		}
		
		if ( lastName.indexOf("roland") != -1 && firstName.indexOf("jenifer") != -1){
			firstName = "jennifer";
		}
		
		if ( lastName.indexOf("delfino") != -1 && firstName.indexOf("joseph") != -1){
			firstName = "joe";
		}
		
		if ( lastName.indexOf("willi") != -1 && firstName.indexOf("jeffery") != -1){
			firstName = "jeff";
		}
		
		if ( lastName.indexOf("johann") != -1 && firstName.indexOf("das") != -1){
			firstName = "johann";
			lastName = "das";
		}
		if ( lastName.indexOf("duhaime") != -1 && firstName.indexOf("david") != -1){
			firstName = "dave";	
		}
		if ( lastName.indexOf("billig") != -1 && firstName.indexOf("jim") != -1){
			firstName = "james";	
		}
		if ( lastName.indexOf("thorne") != -1 && firstName.indexOf("chris") != -1){
			firstName = "christian";	
		}
		if ( lastName.indexOf("renfroe") != -1 && firstName.indexOf("joe") != -1){
			firstName = "joseph";	
		}
		if ( lastName.indexOf("ruck") != -1 ){//&& firstName.indexOf("steven") != -1
			lastName = "ruck";
			firstName = "steven";
		}
		
		return firstName.toLowerCase().replaceAll("makeup", "").trim() + lastName.toLowerCase().replaceAll("makeup", "").trim();
	}
	private static String buildTableHeader(String division, int tableNum){
		StringBuilder sb = new StringBuilder();
		sb.append("<table cellpadding=\"0\" cellspacing=\"0\" border=\"1\" class=\"display\" id=\"example"+tableNum+"\">");
		sb.append("<thead>");

		sb.append("<tr><td><b>"+division+"</b></td>");
		for ( String matchName: matchNames){
			sb.append("<td><b>"+matchName+"</b></td><td>pts</td>");
		}
		sb.append("<td><b>Total Points</b></td>");
		sb.append("<td><b>Matches Attended</b></td>");
		sb.append("<td><b>Matches Won</b></td>");
		//sb.append("<td><b>Tie Breaker</b></td>");
		sb.append("</tr>");
		sb.append("</thead>");

		return sb.toString();
	}
	private static void compileMatchResults(String scoreDefFileName, String scoreFileName, String matchName, int matchNum) throws Exception{
		System.out.println("Processing match " + matchName);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MatchScores scores = mapper.readValue(new File(scoreFileName), MatchScores.class);
		System.out.println(scores);
		MatchDef definition = mapper.readValue(new File(scoreDefFileName), MatchDef.class);
		results.add(processResults(scores, definition, matchNum));
		matchNames.add(matchName);
	}
	private static Map<String, List<ShooterRecord>> processResults(MatchScores scores, MatchDef definition, int matchNum){
		List<ShooterRecord> mainMatchShooters = new ArrayList<ShooterRecord>();

		int shooterNum = 1;
		Map<String, MatchShooter> shooterMap = new HashMap<String, MatchShooter>();
		Map<String, ShooterRecord> shooterRecordMap = new HashMap<String, ShooterRecord>();
		int numStages = definition.getMatchStages().size();
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
			shooterRecord.setStagesInMatch(numStages);
			shooterRecord.setSquad(shooter.getShSqd());
			//If the shooter is on squad 20, set them to DNF so that they receive credit for the match. This is the special squad for missed match form shooters.
			if (shooter.getShSqd() == 20){
				shooterRecord.setDnf(true);
			}
			//String division = shooter.getShDvp();
			String powerFactor = shooter.getShPf();
			String sex = shooter.getShGen(); //MALE for male
			String adult = shooter.getShAge(); //ADULT for adult
			boolean disqualified = false;
			try {
				disqualified = shooter.getShDq(); 
			} catch (Exception e){}
			
			shooterRecord.setDisqualified(disqualified);
			
			if ( shooter.getShLn().toLowerCase().indexOf("makeup") != -1){
				shooterRecord.setMakeup(true);
			}
			if (shooter.getShGrd() != null && shooter.getShGrd().toLowerCase().indexOf("makeup") != -1){
				shooterRecord.setMakeup(true);
			}
			if (shooterRecord.getClassCode() != null && "makeup".equals(shooterRecord.getClassCode().toLowerCase()) ){
				shooterRecord.setMakeup(true);
			}
			
			mainMatchShooters.add(shooterRecord);
		}

		Map<String, MatchStage> stageMap = new HashMap<String, MatchStage>();
		for (MatchStage stage : definition.getMatchStages()) {
			boolean stageDeleted = false;
			try {stageDeleted = stage.getStageDeleted();} catch (Exception e){}
			if (!stageDeleted){
			  stageMap.put(stage.getStageUuid(), stage);
			} else {
				System.err.println("Stage " + stage.getStageName() + " was deleted from the results.");
			}
		}
		List<String> stageList = new ArrayList<String>();
		// Build data structures
		for (MatchScore score : scores.getMatchScores()) {
			MatchStage stage = stageMap.get(score.getStageUuid());
			// Check to see if the stage was not in the list. If it wasn't, then it was a deleted stage.
			if (stage == null){
				continue;
			}
			stageList.add(stage.getStageName());

			for (StageStagescore stageScore : score.getStageStagescores()) {

				//MatchShooter shooter = shooterMap.get(stageScore.getShtr());
				ShooterRecord shooterRecord = shooterRecordMap.get(stageScore.getShtr());

				double totalTime = 0;
				double worstTime = 0;
				List<Double> calcedScores = new ArrayList<Double>();
				
				for (double str : stageScore.getStr()) {
					calcedScores.add(Math.min(str, 30));
				}
				boolean dnf = false;
				try {dnf = stageScore.getDnf();} catch (Exception e){}
				if (dnf){
					shooterRecord.setDnf(true);
				}
				int scoreIndex = 0;
				for (List<Integer> penalties: stageScore.getPenss()){
					int penaltyIdx = 0;
					for ( int penalty: penalties){
						if ( penalty != 0){
							double newScore = 0;
							//TODO: Parse penalty values properly from the match definition
							if ( penaltyIdx == 0){
								newScore = calcedScores.get(scoreIndex) + 3 * penalty;
							}
							if ( penaltyIdx == 1){
								newScore = calcedScores.get(scoreIndex) + 3 * penalty;
							}
							if ( penaltyIdx == 2){
								newScore = calcedScores.get(scoreIndex) + 30;
							}
							//TODO: THIS IS A HACK!!! Penalty has a 4 second value.
							if ( penaltyIdx == 3){
								newScore = calcedScores.get(scoreIndex) + 3 * penalty;
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
				shooterRecord.getStageScores().add(calcedScores);
				//if ( totalTime == 0 ){
				//	shooterRecord.setDnf(true);
				//}
				shooterRecord.setStagesScored(shooterRecord.getStagesScored()+1);
			}
		}
		removeFunShooters(mainMatchShooters);
		removeZeroTimeShooterEntries(mainMatchShooters);
		findZeroTimeRuns(mainMatchShooters);
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
			if (shooter.getTotalTime() == 0 && !shooter.isDnf()){
				shootersToRemove.add(shooter);
				System.err.println("Removing scores for shooter " + shooter.getFirstName() + " " + shooter.getLastName() + " as they have 0 time and are not a DNF");
			}
		}
		shooters.removeAll(shootersToRemove);
		
	}
	
	private static void findZeroTimeRuns(List<ShooterRecord> shooters) {
//		List<ShooterRecord> shootersToRemove = new ArrayList<ShooterRecord>();
		for (ShooterRecord shooter: shooters){
			if ( !shooter.isDnf() && !shooter.isDisqualified()){
				int stage = 1;
				for (List<Double> scores: shooter.getStageScores()){
					for (Double score:scores){
						if (score == 0.0){
							System.err.println("Stage " + stage + " " + shooter.getFirstName() + " " + shooter.getLastName() + " division " + shooter.getDivisionCode() + " has an invalid score. Scores:" + scores);
						}
					}
					stage++;
				}
	
			}
		}
//		shooters.removeAll(shootersToRemove);
		
	}
	
	private static Double findStageTotal(List<Double> stageScores){
		Double score = new Double(0);
		Double slowest = new Double(0);
		for ( Double stageScore: stageScores){
			score = score + stageScore;
			if (stageScore > slowest){
				slowest = stageScore;
			}
		}
		score = score - slowest;
		return score;
	}
	private static Double findStageFastest(List<Double> stageScores){
		
		Double fastest = new Double(30);
		for ( Double stageScore: stageScores){
			if (stageScore < fastest && stageScore != 0.0){
				fastest = stageScore;
			}
		}
		return fastest;
	}
	private static Map<String, List<ShooterRecord>> calculateFinishOrder(List<ShooterRecord> shooters){
		
		Comparator<ShooterRecord> scoreSorter = new Comparator<ShooterRecord>() {
		    public int compare(ShooterRecord s1, ShooterRecord s2) {
		    	if ( s1.getTotalTime() != s2.getTotalTime() || s1.getTotalTime() == 0.0 && s2.getTotalTime() == 0.0){
		    		return Double.compare(s1.getTotalTime(), s2.getTotalTime());

		    	} else {
		    		int s1Wins = 0;
		    		int s2Wins = 0;
		    		for (int i = 0; i < s1.getStagesInMatch(); i++){
		    		
		    		  if (findStageTotal(s1.getStageScores().get(i)) < findStageTotal(s2.getStageScores().get(i))){
		    		    s1Wins++;
		    		  } else if ( findStageTotal(s1.getStageScores().get(i)) == findStageTotal(s2.getStageScores().get(i))){
		    			  	double s1Fastest = findStageFastest(s1.getStageScores().get(i));
		    			  	double s2Fastest = findStageFastest(s2.getStageScores().get(i));
		    			  	if ( s1Fastest < s2Fastest){
		    			  		s1Wins++;
		    			  	} else {
		    			  		s2Wins++;
		    			  	}
		    		  } else {
		    		 	s2Wins++;
		    		  }
		    		}
		    	  //System.out.println("Shooter " + s1.getLastName() + " has " + s1Wins + " stage wins." );
		    	  //System.out.println("Shooter " + s2.getLastName() + " has " + s2Wins + " stage wins." );
		    	  //System.out.println("returning comparison of  " + (s1Wins-s2Wins) );
		    	  return s2Wins-s1Wins;
		    	}
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
