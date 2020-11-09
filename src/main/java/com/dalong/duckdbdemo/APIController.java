package com.dalong.duckdbdemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @Autowired
    private JdbcTemplate  jdbcTemplate;
    @RequestMapping(value = {"/init"})
    public Object demo(){

        jdbcTemplate.execute("CREATE TABLE items (item VARCHAR, value DECIMAL(10,2), count INTEGER)");
        return "ok";
    }

    @RequestMapping(value = {"/insert"})
    public Object insert(){

        for (int i = 0; i < 10000 ; i++) {
            jdbcTemplate.execute("INSERT INTO items VALUES ('jeans', 20.0, 1), ('hammer', 42.2, 2)");
        }
        return "ok";
    }

    @RequestMapping(value = {"/q"})
    public Object query(){

        return jdbcTemplate.queryForList("select * from items");
    }
}
