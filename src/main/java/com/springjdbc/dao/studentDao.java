package com.springjdbc.dao;

import com.springjdbc.entities.student;

public interface studentDao {
    public int insert(student st);
    public int change(student st);
    public student getStudent(int studentId);
}
