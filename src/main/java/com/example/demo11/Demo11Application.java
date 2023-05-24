package com.example.demo11;

import DBcontroller.DBSQL;
import Entities.Entry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Demo11Application {
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Demo11Application.class, args);
		 DBSQL db = new DBSQL();
		DBSQL.deleteBasedOnAge();
	/*	try {
			Entry entry = new Entry();
			DBSQL db = new DBSQL();
			db.entryDK(new Entry("mikkel", "mikkelsen", "kørekort", "string", entry.getNow()));
			System.out.println("success");
			System.out.println(entry.getNow());
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}*/
	}
}