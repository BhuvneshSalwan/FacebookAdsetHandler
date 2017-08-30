package com.hibernate.campaign.main;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateSessionFactory {

	public static SessionFactory factory = null;
	
	public static SessionFactory getFactoryInstance(){
		
		if(null == factory){
		
			//File file = new File("C:\\Users\\ROHIN MITTAL\\workspace\\FacebookAdsetHandler\\src\\main\\resources\\hibernate.cfg.xml");
			
			//factory = new Configuration().configure(file).buildSessionFactory();
			
			factory = new Configuration().configure().buildSessionFactory();
			
			return factory;
			
		}
		else{
			return factory;
		}
		
	}
	
}