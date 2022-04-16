package com.springjdbc.dao;

import com.springjdbc.entities.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component("studentDao")
public class impl implements studentDao{
    @Autowired
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(student st) {
        String query="insert into student(id,name,city) values(?,?,?)";
        int r=jdbcTemplate.update(query,st.getId(),st.getName(),st.getCity());
        return r;
    }

    @Override
    public int change(student st) {
        String query="UPDATE student SET name=?,city=? WHERE id=?";
        int r=this.jdbcTemplate.update(query,st.getName(),st.getCity(),st.getId());
        return r;
    }

    @Override
    public student getStudent(int studentId) {
        String query="select *from student where id=?";
        RowMapper<student> rowMapper=new RowmapperImpl();
        student st=this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
        return st;
    }
}
