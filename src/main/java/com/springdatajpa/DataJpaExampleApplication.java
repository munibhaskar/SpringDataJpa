package com.springdatajpa;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.springdatajpa.bo.FetchStudents;
import com.springdatajpa.bo.Students;
import com.springdatajpa.repoistory.FetchStudentsRepoistry;
import com.springdatajpa.repoistory.StudentRepoistory;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.springdatajpa.repoistory")
public class DataJpaExampleApplication implements CommandLineRunner{
	
	
	@Autowired
	private StudentRepoistory studentRepoistry;	
	
	@Autowired
	private FetchStudentsRepoistry fetchRepoistory;
	
	public static void main(String[] args) {
		SpringApplication.run(DataJpaExampleApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		
		
		/*// insert operations
		Address address = new Address();
		address.setFirstAddress("261099");
		address.setSecondAddress("ram");
		
		Students students = new Students();
		students.setFirstName("sony1");
		students.setLastName("s1");
		students.setGenderCode("M");
		students.setPassword("Pass@1231");
		students.setSuffixName("Mr");
		students.setAddress(address);
		studentRepoistry.save(students);
		
		List<Students> studentList = studentRepoistry.findAll();
		Address address1 = studentList.get(0).getAddress();
		System.out.println(address1.getFirstAddress());
		System.out.println(studentList.size());*/
		List<Students> students = studentRepoistry.findAll();
		System.out.println(students.size());

		// get list of records with where condition

		List<Students> whereStudents = studentRepoistry.findByFirstName("sony2");

		System.out.println(whereStudents.size());

		// get list of records with where condition

		List<Students> lastStudents = studentRepoistry.findByLastName("Mathew");

		System.out.println(lastStudents.size());

		// get list of records with 2 conditions using and

		// Doubt: why we need to give Always caps starting

		List<Students> andStudents = studentRepoistry.findByFirstNameAndMiddleName("sony", "Mathew");
		System.out.println(andStudents.size());

		// get list of records with 2 conditions using or

		List<Students> orStudents = studentRepoistry.findByFirstNameOrMiddleName("sony", "Mathew1");
		System.out.println(orStudents.size());
		
		// get list of records using Equals is and not
		List<Students> equalsStudents = studentRepoistry.findByFirstNameEquals("sony");
		System.out.println(equalsStudents.size());
		
		List<Students> isStudents = studentRepoistry.findByFirstNameIs("sony");
		System.out.println(isStudents.size());
		
		List<Students> notStudents = studentRepoistry.findByFirstNameNot("sony");
		System.out.println(notStudents.size());
		
		List<FetchStudents> fetchStudents = fetchRepoistory.findFetchStudents("sony");
		System.out.println(fetchStudents.size());
		
	}
}
