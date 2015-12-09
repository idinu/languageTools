package org.languagetool.test;

import java.io.IOException;
import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.language.Chinese;
import org.languagetool.rules.PatternRuleHandle;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;
import org.languagetool.rules.patterns.PatternRule;
import org.languagetool.rules.patterns.PatternRuleLoader;

public class LanguageTest {
	private static Rule demoRule1;

	public static void main(String args[]) throws IOException{
		PatternRuleLoader prg = new PatternRuleLoader();
		PatternRuleHandle rulehandle=new PatternRuleHandle();
		  List<PatternRule> rules;
		  String name = "grammar.xml";
	JLanguageTool langTool = new JLanguageTool(new BritishEnglish());//实例化语法语言
	langTool.activateDefaultPatternRules();//加载默认语法判断
	//加载自己的规则
//	try {
//		 //System.out.println(JLanguageTool.getDataBroker().getFromRulesDirAsStream(name));
//		rules = prg.getRules(JLanguageTool.getDataBroker().getFromRulesDirAsStream(name), name);
//		  final Rule demoRule1 = rulehandle.getRuleById("GROUND_VS_MINCED", rules);
//		  System.out.println(demoRule1.getCategory()+"\n"+demoRule1.getDescription());
//			for(PatternRule rule:rules){
//				langTool.addRule(rule);
//			}
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	//
	//List<RuleMatch> matches = langTool.check("Sorry for my bed English.");//只用默认有判断规则
	List<RuleMatch> matches = langTool.check("In the UK, the word 'gotten' is usually no longer used. Did you mean got?");
	 
	for (RuleMatch match : matches) {
	  System.out.println("Potential error at line " +
	      match.getLine() + ", column " +
	      match.getColumn() + ": " + match.getMessage());
	  System.out.println("Suggested correction: " +
	      match.getSuggestedReplacements());
	}
	}
}
