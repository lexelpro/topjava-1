package ru.javawebinar.topjava;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestEnv {

	public static void main(String[] args) {
		System.out.println(System.getenv("TOPJAVA_ROOT"));
		try (GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
			appCtx.getEnvironment().setActiveProfiles(Profiles.getActiveDbProfile(), Profiles.REPOSITORY_IMPLEMENTATION);
			appCtx.load("spring/inmemory.xml");
			appCtx.refresh();
			Program program1 = (Program) appCtx.getBean("program1");
			System.out.println("TOPJAVA_ROOT is " + program1.getLogPath());

			Program program2 = (Program) appCtx.getBean("program2");
			System.out.println("TOPJAVA_ROOT is " + program2.getLogPath());
			System.out.println("File with properties exist " + Files.exists(Paths.get(System.getenv("TOPJAVA_ROOT") + "/config/messages/app.properties")));
		}


	}
}
