package com.moondev.OneHealth.record;

import com.moondev.OneHealth.manage.PersonBean;
import com.moondev.OneHealth.record.RecordBean;
import com.moondev.OneHealth.manage.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class RecordController {

    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("/record")
    public String record(RecordBean recordBean,Model model) {

        List<PersonBean> people = personMapper.selectAll();
        model.addAttribute("people",people);
        return "record/record";
    }
}
