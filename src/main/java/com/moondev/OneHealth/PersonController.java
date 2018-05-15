package com.moondev.OneHealth;

import com.moondev.OneHealth.dao.PersonMapper;
import com.moondev.OneHealth.profile.PersonInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableTransactionManagement
@RestController
public class PersonController {

    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("/save")
    public Integer save() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setAge(25);
        personInfo.setName("Angle 中文");
        personInfo.setCompany("Apple");
        personMapper.insert(personInfo);
        return personInfo.getId();
    }

    @RequestMapping("/update")
    public Long update() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setId(3098);
        personInfo.setName("邦邦");
        personInfo.setAge(36);
        personInfo.setCompany("Google");
        return personMapper.update(personInfo);
    }

    @RequestMapping("/delete")
    public Long delete() {
        return personMapper.delete(1);
    }

    @RequestMapping("/selectById")
    public PersonInfo selectById() {
        return personMapper.selectById(3098);
    }

    @RequestMapping("/transaction")
    @Transactional
    public boolean transaction() {
        delete();

        int i = 3 / 0;

        save();
        return true;
    }
}
