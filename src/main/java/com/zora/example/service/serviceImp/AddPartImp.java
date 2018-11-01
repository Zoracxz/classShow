package com.zora.example.service.serviceImp;

import com.zora.example.entity.Emp;
import com.zora.example.mapper.AddpartMapper;
import com.zora.example.service.AddPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddPartImp implements AddPart {
    @Autowired
    private AddpartMapper addpartMapper;
    @Override
    public boolean addEmp(Emp emp) {
        addpartMapper.addEmp(emp);
        return true;
    }

    @Override
    public List<Emp> findAll() {
        return addpartMapper.findAll();
    }
}
