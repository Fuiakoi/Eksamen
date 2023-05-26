package com.example.demo11;

import DBcontroller.DBSQL;
import UseCases.UseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Demo11Application {
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Demo11Application.class, args);
		DBSQL db = new DBSQL();

		UseCase UC = new UseCase();
		//UC.addAdmin("1idiotdum@hotmail.com","olivererenluder");
	}
}