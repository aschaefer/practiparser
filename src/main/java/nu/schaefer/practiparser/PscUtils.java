package nu.schaefer.practiparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class PscUtils {

	StringBuffer matchDef = null;
	StringBuffer scores = null;
	
//	byte[] matchDefFile = null;
//	byte[] scoreFile = null;
	
	public void openPscFile(String filename, String tmpDir) throws Exception{
		matchDef = new StringBuffer();
		scores = new StringBuffer();
		
    	ZipInputStream zis = new ZipInputStream(new FileInputStream(filename));
    	ZipEntry ze = zis.getNextEntry();
 
    	while(ze!=null){
 
    	   String fileName = ze.getName();
    	   System.out.println(fileName);
    	   
//           //File newFile = new File(outputFolder + File.separator + fileName);
// 
//           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
// 
//            //create all non exists folders
//            //else you will hit FileNotFoundException for compressed folder
//            new File(newFile.getParent()).mkdirs();
// 
    	   FileOutputStream fos = new FileOutputStream(new File(tmpDir + File.separator + fileName), false);             
// 
//            int len;
//            byte[] buffer = new byte[(int)ze.getSize()];
//            zis.read(buffer);
            
//            if (fileName.equals("match_def.json")){
//            	this.matchDefFile = buffer;
//            }
//            
//            if (fileName.equals("match_scores.json")){
//            	this.scoreFile = buffer;
//            }
    	   	byte[] buffer = new byte[1024];
            int len;
            while ((len = zis.read(buffer)) > 0) {
       		fos.write(buffer, 0, len);
            }
 
            fos.close(); 
            
            ze = zis.getNextEntry();
    	}
 
        zis.closeEntry();
    	zis.close();
    	String command = "/Users/andrew/src/practiParser/scripts/convert.sh /tmp/league/match_scores.json /tmp/league/match_def.json";
    	Process p = Runtime.getRuntime().exec(command);
    	
    	
        p.waitFor();
        
        BufferedReader reader = 
             new BufferedReader(new InputStreamReader(p.getInputStream()));
     
        String line = "";			
        while ((line = reader.readLine())!= null) {
    	System.out.println(line);
        }
	}
	
	public StringBuilder getMatchDef(){
		return null;
	}
	public StringBuilder getScores(){
		return null;
	}
	
//	public byte[] getMatchDefFile() {
//		return matchDefFile;
//	}
//
//	public byte[] getScoreFile() {
//		return scoreFile;
//	}

	public static void main(String[] args) throws Exception{
		PscUtils util = new PscUtils();
		util.openPscFile("/Users/andrew/psc/PASteelLeagueOntelauneeMatch1_AndrewSchaefersiPhone.psc", "/tmp/league");
		util.openPscFile("/Users/andrew/psc/PASteelLeagueUnamiMatch2_AndrewSchaefersiPhone.psc", "/tmp/league");
		util.openPscFile("/Users/andrew/psc/PASteelLeagueLPRGCMatch3_AndrewSchaefersiPhone.psc", "/tmp/league");
		util.openPscFile("/Users/andrew/psc/PASteelLeagueUnamiMatch4_AndrewSchaefersiPhone.psc", "/tmp/league");
		util.openPscFile("/Users/andrew/psc/PASteelLeagueLPRGCMatch5_AndrewSchaefersiPhone.psc", "/tmp/league");
		util.openPscFile("/Users/andrew/psc/PASteelLeagueGuthsvilleMatch6_AndrewSchaefersiPhone.psc", "/tmp/league");
		

	}
}
