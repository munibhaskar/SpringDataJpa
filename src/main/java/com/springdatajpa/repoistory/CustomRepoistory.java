/**
 * 
 */
package com.springdatajpa.repoistory;

import java.util.List;

import com.springdatajpa.bo.FetchStudents;

/**
 * @author Vicky
 *
 */
public interface CustomRepoistory {
	

	  
	List<FetchStudents> findFetchStudents(String firstName);

}
