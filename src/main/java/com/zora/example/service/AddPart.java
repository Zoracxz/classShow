package com.zora.example.service;

import com.zora.example.entity.Emp;

import java.util.List;

public interface AddPart {
    boolean addEmp(Emp emp);
    List<Emp> findAll();
}
