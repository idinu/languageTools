package org.languagetool.rules;



import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.languagetool.JLanguageTool;
import org.languagetool.databroker.ResourceDataBroker;
import org.languagetool.rules.patterns.PatternRule;
import org.languagetool.rules.patterns.PatternRuleLoader;

public class PatternRuleHandle  {

	 public static void main(String args[]){
		  final PatternRuleLoader prg = new PatternRuleLoader();
		    final String name = "grammar.xml";
		    List<PatternRule> rules;
		    InputStream dir=JLanguageTool.getDataBroker().getFromRulesDirAsStream(name);
		   
			try {
				 System.out.println(JLanguageTool.getDataBroker().getFromRulesDirAsStream(name));
				rules = prg.getRules(JLanguageTool.getDataBroker().getFromRulesDirAsStream(name), name);
				  final Rule demoRule1 = getRuleById("GROUND_VS_MINCED", rules);
				  System.out.println(demoRule1.getCategory()+"\n"+demoRule1.getDescription());
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		  
	  }
	
	
	  public void testGetRules() throws Exception {
	    //final PatternRuleLoader prg = new PatternRuleLoader();
	    //final String name = "/xx/grammar.xml";
	    //final List<org.languagetool.rules.patterns.PatternRule> rules = prg.getRules(JLanguageTool.getDataBroker().getFromRulesDirAsStream(name), name);
	    
	   // final Rule demoRule1 = getRuleById("DEMO_RULE", rules);
	  }
	 
	  private Set<String> getCategoryNames(List<PatternRule> rules) {
	    final Set<String> categories = new HashSet<>();
	    for (PatternRule rule : rules) {
	      categories.add(rule.getCategory().getName());
	    }
	    return categories;
	  }

	  public static Rule getRuleById(String id, List<PatternRule> rules) {
	    for (Rule rule : rules) {
	      if (rule.getId().equals(id)) {
	        return rule;
	      }
	    }
	    throw new RuntimeException("No rule found for id '" + id + "'");
	  }

	  public List<Rule> getRulesById(String id, List<PatternRule> rules) {
	    final List<Rule> result = new ArrayList<>();
	    for (Rule rule : rules) {
	      if (rule.getId().equals(id)) {
	        result.add(rule);
	      }
	    }
	    return result;
	  }

	}