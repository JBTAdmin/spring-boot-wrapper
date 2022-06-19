package com.jbt.scheduler.Scheduler;

import org.springframework.scheduling.annotation.Scheduled;

public class JbtScheduler {

	@Scheduled(cron = "${jbt.cron}")
	public void Job(){
    System.out.println("Scheduler Started");
	}
}
