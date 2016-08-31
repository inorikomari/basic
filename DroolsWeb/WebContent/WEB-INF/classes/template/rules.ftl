package com.drool.rules.score

declare RuleModel
<#list properties as prop>
	${prop.name}:${prop.type}
</#list>
end

<#list rules as rs>
rule "${rs.rule_no}"
	salience 9
  	when
      	${rs.when}
  	then
      	${rs.then}
end
</#list>

<#list weights as wt>
rule "${wt.rule_no}"
	salience 9
  	when
      	${wt.when}
  	then
      	${wt.then}
end
</#list>

rule "weighted"
	salience 0
	no-loop true
	when
		rm:RuleModel();
	then
		${weighted}
end