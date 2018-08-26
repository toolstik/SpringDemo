package com.example.demo.controller;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import com.example.demo.dal.dao.User;
import com.example.demo.models.UserListItemModel;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController{

    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/users" }, method = RequestMethod.GET)
    public ModelAndView usersPage(Model model) {
        ModelAndView result = new ModelAndView();
        result.setViewName("usersPage");
        List<UserListItemModel> users = userService.findAll()
        		.stream()
        		.map(new Function<User, UserListItemModel>(){
        			
        			@Override
        			public UserListItemModel apply(User user) {
                        UserListItemModel userModel = new UserListItemModel();
                        userModel.setName(user.getName());

                        List<String> stringRoles =  user.getRoles()
                            .stream()
                            .map(r -> r.getName())
                            .collect(Collectors.toList());

                        userModel.setRoles(String.join(", ", stringRoles));
                        userModel.setCreateDate(user.getCreateDate());
                        userModel.setGender(user.isGender() ? "M" : "F");
                        return userModel;
        			}
                })
                .collect(Collectors.toList());
        result.addObject("users", users);
        return result;
    }

    private Date convertUtcToLocal(Date utc){
        return Date.from(utc.toInstant().atZone(ZoneId.systemDefault()).toInstant());
    }

}