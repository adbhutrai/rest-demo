package com.adbhut.util;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;

public class RuleBookHelloWorld {
	public static void main(String[] args) {
		/*RuleBook ruleBook = RuleBookBuilder.create().addRule(rule -> rule.withNoSpecifiedFactType()
		        .then(f -> System.out.print("Hello ")).then(f -> System.out.println("World"))).build();
		        
		        *ruleBook.run(new FactMap());
		        */
		
		// @formatter:off
		RuleBook ruleBook = RuleBookBuilder.create()
			    .addRule(rule -> rule.withFactType(String.class)
			      .when(f -> f.containsKey("hello"))
			      .using("hello")
			      .then(System.out::print))
			    .addRule(rule -> rule.withFactType(String.class)
			      .when(f -> f.containsKey("world"))
			      .using("world")
			      .then(System.out::println))
			    .build();
		
		
		
		//@formatter:on
		
		NameValueReferableMap factMap = new FactMap();
		factMap.setValue("hello", "pagal ");
		factMap.setValue("world", " World");
		ruleBook.run(factMap);
		
		
		RuleBook ruleBook1 = RuleBookBuilder.create()
				  .addRule(rule -> rule.withFactType(String.class)
				    .when(f -> f.containsKey("hello") && f.containsKey("world"))
				    .using("hello").then(System.out::print)
				    .using("world").then(System.out::println))
				  .build();
		
		factMap.setValue("hello", "hello ");
		
		ruleBook1.run(factMap);
		
	}
}
