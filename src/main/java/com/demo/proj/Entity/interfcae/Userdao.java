package com.demo.proj.Entity.interfcae;

import org.springframework.data.repository.CrudRepository;

import com.demo.proj.Entity.Student;

public interface Userdao extends CrudRepository<Student,Integer>
{
	

}
