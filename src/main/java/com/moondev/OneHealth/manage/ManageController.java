package com.moondev.OneHealth.manage;

import com.moondev.OneHealth.manage.PersonBean;
import com.moondev.OneHealth.manage.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class ManageController {

    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("/manage")
    public String manage(PersonBean personBean) {
        return "manage/manage";
    }

    @RequestMapping(value = "/manage",method = RequestMethod.POST)
    public String savePerson(@Valid PersonBean personBean, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "manage/manage";
        }
        personMapper.insert(personBean);
        System.out.println("insert ok: " + personBean);
        return "redirect:/manage";
    }
}
