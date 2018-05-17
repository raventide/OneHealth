package com.moondev.OneHealth.manage;

import com.moondev.OneHealth.manage.PersonBean;
import com.moondev.OneHealth.manage.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ManageController {

    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("/manage")
    public String manage(PersonBean personBean,Model model) {

        List<PersonBean> peopleList = personMapper.selectAll();
        model.addAttribute("peopleList",peopleList);
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

    @RequestMapping(value = "/manage/delete",method = RequestMethod.POST)
    public String deletePerson(PersonBean personBean) {
        long ret = personMapper.delete(personBean.getId());
        if (ret <= 0)
        {
            System.out.println("delete failed: " + personBean.getId() + "," + personBean.getName());
        }
        else {
            System.out.println("delete ok: " + personBean);
        }
        return "redirect:/manage";
    }
}
