/**
 * 
 */
package com.springdatajpa.repoistory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.springdatajpa.bo.FetchStudents;
import com.springdatajpa.bo.Students;

/**
 * @author Vicky
 *
 */
@Component
public interface StudentRepoistory  extends JpaRepository<Students, Integer>{
	
	List<Students> findAll();
	
	// find a record with name Condition
	
	List<Students> findByFirstName(String firstName);
	
	// find a record with last name Condition
	
		List<Students> findByLastName(String lastName);
	
	// find a record with and condition
	
	List<Students> findByFirstNameAndMiddleName(String firstName,String middleName);
	
	// find a record using or condition
	
	List<Students> findByFirstNameOrMiddleName(String firstName,String middleName);
	
	// find a record using equals, is condition students.first_name =
	List<Students> findByFirstNameEquals(String firstName);
	
	List<Students> findByFirstNameIs(String firstName);
	
	// find a record using not condition in jpql is students_first_name <>
	
	List<Students> findByFirstNameNot(String firstName);
	
	// find a record using like jpql query students.first_name like 'cal%'
	
	List<Students> findByFirstNameLike(String firstName);
	
	// find a record using not like jpql query students.first_name not like 'cal%'
	
	List<Students> findByFirstNameNotLike(String firstName);
	
	// find a record using starting with  jpql query students.first_name like 'cal%'
	
	List<Students> findByFirstNameStartingWith(String firstName);
		
	// find a record using end with jpql query students.first_name not like '%cal'
		
	List<Students> findByFirstNameEndingWith(String firstName);
	
	// find a record using Containing with jpql query students.first_name not like '%cal%'
	
	List<Students> findByFirstNameContaining(String firstName);
	
	// find a record using lessthan,lessthanEqual,greater than,greaterthan equal with jpql query students.student_id <,<=,>,>=
	List<Students> findByStudentIdLessThan(Integer studentId);
	List<Students> findByStudentIdLessThanEqual(Integer studentId);
	List<Students> findByStudentIdGreaterThanEqual(Integer studentId);
	List<Students> findByStudentIdGreaterThan(Integer studentId);
	
	// find a record using Before,After,Between with jpql query students.student_id > , < , between 1 and 2
	
	List<Students> findByStudentIdBefore(Integer studentId);
	List<Students> findByStudentIdAfter(Integer studentId);
	List<Students> findByStudentIdBetween(Integer studentId,Integer studentId2);
	
	// find a record using True and False jpql query student.column = true,false
	
	//List<Students> findByStudentIdActive();
	//List<Students> findByStudentIdFalse();
	
	//find a record using is null, isnotnull,not null with jpql query students.first_name isnull, not null
	List<Students> findByFirstNameIsNull(String firstName);
	List<Students> findByFirstNameIsNotNull(String firstName);
	List<Students> findByFirstNameNotNull(String firstName);
	
	//find a record using In ,Not in jpql query students.first_name in () and not in ()
	List<Students> findByFirstNameIn(List<String> firstName);
	List<Students> findByFirstNameNotIn(List<String> firstName);

	// find a record using ignoreCase jpql query where Upper(column) = UPPer(passedValue)
	
	List<Students> findByFirstNameIgnoreCase(String firstName);
	
	// find a record using order by jpql query where students.first_name = "" order by first_name asc,desc
	
	List<Students> findByFirstNameOrderByFirstNameAsc(String firstName);
	
	List<Students> findByFirstNameOrderByFirstNameDesc(String firstName);
	
	// find a record using First , DistinctColumn,top 5 prefix is Find
	
	List<Students> findFirstByFirstName(String firstName);
	List<Students> findTop5ByFirstName(String firstName);
	List<Students> findDistinctByFirstName(String firstName);
	
	
	// insert a record
	
	Students save(Students student);
	
	// update a record using where column
	
	void delete(Students student);
	
	// using query annotation with question marks
	
	@Query(value ="select s.firstname from Students s where s.firstname = ?1",nativeQuery =true)
	List<String> queryByFirstName(String firstname);
	
	// using query annotation with params
	@Query(value ="select s.firstname from Students s where s.firstname = :firstName",nativeQuery =true)
	List<String> queryByfirstName(@Param("firstName")String firstName);
	
	// updating a value 
	@Modifying
	@Query(value ="update Students s set s.last_name = : lastName where s.first_name : firstName",nativeQuery =true)
	int updatelastNameByFirstName(@Param("lastName")String lastName,@Param("firstName")String firstName);
	

	
	// Named Query
	List<Students> findByFirstNameNamed(@Param("firstName")String firstName);
	
	@Query(name ="Students.findByFirstNameNamed")
	List<Students> namedQueryByFirstName(@Param("firstName")String firstName);
	
	//Named Native queries call it by removing the class name from name from native query
	
	List<Students> getAllRecordsByFirstName(@Param("firstName")String firstName);
	
	//precedence @query -> namedNativeQuery -> query dsl
	
	// paging,sorting,Auditing,Custom repoistry, Locking
	Page<Students> findAll(Pageable page);
	
	
	List<Students> findAll(Sort sort);
	
	
	
	
	
}
