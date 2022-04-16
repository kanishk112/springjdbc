package com.springjdbc;

import com.springjdbc.dao.studentDao;
import com.springjdbc.entities.student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class app {
    public static void main(String[] args)
    {
        System.out.println("Hello World");
        ApplicationContext con=new AnnotationConfigApplicationContext(JDBCconfig.class);
        studentDao st=con.getBean("studentDao", studentDao.class);
        student s=new student();
        s.setId(1123);
        s.setName("Hari");
        s.setCity("120 ft road");
        int res=st.insert(s);
        System.out.println("no. of rows inserted are: "+res);
//        int res=st.change(s);
//        System.out.println("no. of rows cahnged are: "+s);
    }
}
