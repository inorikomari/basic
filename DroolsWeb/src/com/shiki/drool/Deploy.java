package com.shiki.drool;

import java.io.File;
import java.util.Collection;

import org.drools.core.io.impl.ClassPathResource;
import org.kie.api.KieBase;
import org.kie.api.definition.type.FactType;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import com.shiki.drool.pojo.Person;



@SuppressWarnings("deprecation")
public class Deploy {

	private static KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
			.newKnowledgeBuilder();
	private static Collection<KnowledgePackage> pkgs;
	private static KnowledgeBase kbase = KnowledgeBaseFactory
			.newKnowledgeBase();
	private static StatefulKnowledgeSession ksession;

	private static boolean isinitd = false;

	private static void initDrools(File file) throws Exception {

		kbuilder.add(ResourceFactory.newFileResource(file), ResourceType.DRL);

		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors().toString());
			throw new RuntimeException("Unable to compile drl\".");
		}

		pkgs = kbuilder.getKnowledgePackages();
		kbase.addKnowledgePackages(pkgs);
		ksession = kbase.newStatefulKnowledgeSession();

		isinitd = true;
	}

	private static Double fireRules(Person p) throws Exception {

		// 执行规则运算
		ksession.insert(p);
		ksession.fireAllRules();

		// 回收资源
		// ksession.dispose();
		// pkgs.clear();
		// pkgs = null;
		// kbase = null;
		// kbuilder = null;

		System.out.println("持卡客户评分:" + p.getScore());

		return p.getScore();
	}

	public static Double deploy(File file, Person p) throws Exception {
		if (!isinitd)
			initDrools(file);
		// 计算持卡客户评分
		return fireRules(p);
	}

	public static void main(String[] args) throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(new ClassPathResource("com/shiki/drool/rules/personscore.drl") , ResourceType.DRL);
        KieBase kbase = kbuilder.newKnowledgeBase();
		FactType factType = kbase.getFactType("com.drool.rules.test", "Shiki");
		Object s = factType.newInstance();
		factType.set(s, "name", "Shiki");
		KieSession ksession = kbase.newKieSession();
		
		ksession.insert(s);
		ksession.fireAllRules();
		
		System.out.println(factType.get(s, "id"));
	}

}
