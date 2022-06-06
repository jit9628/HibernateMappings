package com.start.hibernate;

import java.io.Serializable;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Set;

import com.entity.Course;
import com.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {

    		Session openSession = new Configuration().configure("com/resources/hibernate.cfg.xml").buildSessionFactory().openSession();
    		System.out.println(openSession);
    		
    		Student  student=new Student();
    		//student.setSid(1);
    		student.setSname("jitendra shukla");
    		student.setEmail("shukla@gmail.com");
    		
                Course course=new Course();
                
                Course course1=new Course();
                
               // course.setCourseid(10017);
                course.setCoursename("advance concept");
                course.setCourseduration("6 month");
                course.setCoursefees(13000);
                course.setStd(student);
                //course1.setCourseid(10018);
                course1.setCoursename("Advance java");
                course1.setCourseduration("12 month");
                course1.setCoursefees(28000);
                course1.setStd(student);
                // List<Course> courses=new ArrayList();
                
                java.util.Set<Course> courses=new HashSet<Course>();
               courses.add(course);
               courses.add(course1);
               student.setCourse(courses);
               Transaction beginTransaction = openSession.beginTransaction();
               int save = (Integer)openSession.save(student);
               beginTransaction.commit();
               if(save>0)
            	   System.out.println("data saved");
               else
            	   System.out.println("error occured");
    		
		} catch (Exception e) {
e.printStackTrace();		}
    }
}
