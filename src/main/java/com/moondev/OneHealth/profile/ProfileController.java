package com.moondev.OneHealth.profile;

import com.moondev.OneHealth.date.LocalDateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import java.util.Locale;

@Controller
public class ProfileController {
    @RequestMapping("/profile")
    public String displayProfile(ProfileForm profileForm) {
        return "profile/profilePage";

    }

    @RequestMapping(value = "/profile",method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "profile/profilePage";
        }

        System.out.println("save ok " + profileForm);
        return "redirect:/profile";
    }

    @ModelAttribute("dateFormat")
    public String localFormat(Locale locale) {
        return LocalDateFormatter.getPattern(locale);
    }
}
