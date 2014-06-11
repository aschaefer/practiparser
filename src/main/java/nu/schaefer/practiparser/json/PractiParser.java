package nu.schaefer.practiparser.json;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

public class PractiParser {
	public static void main(String[] args) throws Exception{
		   ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		   //mapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		   
		   MatchScores scores = mapper.readValue(new File("/tmp/match_scores.json"), MatchScores.class);
		   System.out.println(scores);
		   MatchDef definition = mapper.readValue(new File("/tmp/match_def.json"), MatchDef.class);
		   System.out.println(definition);
	}
}
