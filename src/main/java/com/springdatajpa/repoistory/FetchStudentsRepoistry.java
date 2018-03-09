/**
 * 
 */
package com.springdatajpa.repoistory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springdatajpa.bo.FetchStudents;

/**
 * @author Vicky
 *
 */
@Repository
public class FetchStudentsRepoistry implements CustomRepoistory {
    private static final String SELECT_ENTRIES = "select s.firstname as first_name,s.lastname as last_name from Students s where s.firstname = :firstname";

    @Autowired
    private  NamedParameterJdbcTemplate jdbcTemplate;
    
    @Override
	public List<FetchStudents> findFetchStudents(String firstName) {
    	Map<String, String> queryParams = new HashMap<>();
        queryParams.put("firstname", firstName);
 
        List<FetchStudents> searchResults = jdbcTemplate.query(SELECT_ENTRIES, queryParams, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				FetchStudents fetchStudents = new FetchStudents();
				fetchStudents.setFirstName(rs.getString("first_name"));
				fetchStudents.setLastName(rs.getString("last_name"));
				return fetchStudents;
			}
		});
		return searchResults;
	}

}
