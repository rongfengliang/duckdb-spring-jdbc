package com.dalong.duckdbdemo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class DuckdbDemoApplication {

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		JdbcTemplate duckdb =new JdbcTemplate();
		duckdb.setDataSource(dataSource);
		return duckdb;
	}
	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("org.duckdb.DuckDBDriver");
		config.setMaximumPoolSize(10);
		config.setMaxLifetime(3);
		config.setJdbcUrl("jdbc:duckdb:");
		HikariDataSource ds = new HikariDataSource(config);
		return ds;
	}
	public static void main(String[] args) {
		SpringApplication.run(DuckdbDemoApplication.class, args);
	}

}
