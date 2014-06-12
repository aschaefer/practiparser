package nu.schaefer.practiparser.json;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class PractiParser {
	public static void main(String[] args) throws Exception{
		   ObjectMapper mapper = new ObjectMapper(); 
		   MatchScores scores = mapper.readValue(new File("/tmp/match_scores.json"), MatchScores.class);
		   System.out.println(scores);
		   MatchDef definition = mapper.readValue(new File("/tmp/match_def.json"), MatchDef.class);
		   System.out.println(definition);
		   
		   Map<String, MatchShooter> shooterMap = new HashMap<String,MatchShooter>();
		   for (MatchShooter shooter: definition.getMatchShooters()){
			   shooterMap.put(shooter.getShUuid(), shooter);
		   }
		   
		   Map<String, MatchStage> stageMap = new HashMap<String,MatchStage>();
		   for (MatchStage stage: definition.getMatchStages()){
			   stageMap.put(stage.getStageUuid(), stage);
		   }
		   
		   for (MatchScore score: scores.getMatchScores()){
			   MatchStage stage = stageMap.get(score.getStageUuid());
			   System.out.println("Scores for Stage " + score.getStageNumber() + " - " + stage.getStageName() );
			  
			   for ( StageStagescore stageScore: score.getStageStagescores()){
				  
				  MatchShooter shooter = shooterMap.get(stageScore.getShtr());
				  if ( shooter != null){
					  System.out.print(shooter.getShFn() + " " + shooter.getShLn() + " : ");
				  } else {
					  System.out.print("UNKNOWN SHOOTER");
				  }
				  
				  if ( stageScore.getDnf()){
					  System.out.print(" **DNF** ");
				  }
				  double totalTime = 0;
				  double worstTime = 0;
				  for(double str: stageScore.getStr()){
					  System.out.print( str+",");
					  totalTime += str;
					  if ( str > worstTime){
						  worstTime = str;
					  }
				  }
				  totalTime -= worstTime;
				  System.out.print("("+totalTime+")");
				  System.out.println();
			   }
		   }
	}
}
