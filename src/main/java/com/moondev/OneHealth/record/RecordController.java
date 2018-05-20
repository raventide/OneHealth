package com.moondev.OneHealth.record;

import com.moondev.OneHealth.manage.PersonBean;
import com.moondev.OneHealth.record.RecordBean;
import com.moondev.OneHealth.manage.PersonMapper;
import com.moondev.OneHealth.record.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;
import java.time.LocalDateTime;

@Controller
public class RecordController {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private RecordMapper recordMapper;

    @RequestMapping("/record")
    public String record(RecordBean recordBean,Model model) {

        List<PersonBean> people = personMapper.selectAll();
        model.addAttribute("people",people);
        return "record/record";
    }

    @RequestMapping(value = "/record",method = RequestMethod.POST)
    public String record(@Valid RecordBean recordBean, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("insert failed: " + recordBean);
            return "record/record";
        }
        recordBean.setDateTime(recordBean.getDateTime().now());
        recordMapper.insert(recordBean);
        System.out.println("insert ok: " + recordBean);
        return "redirect:/record";
    }

}
