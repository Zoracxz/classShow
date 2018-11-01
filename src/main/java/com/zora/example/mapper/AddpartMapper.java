package com.zora.example.mapper;

import com.zora.example.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddpartMapper {

    public void addEmp(Emp emp);

    public List<Emp> findAll();
}
