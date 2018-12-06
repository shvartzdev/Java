package ru.shvartz.lab2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.shvartz.lab2.models.User;
import ru.shvartz.lab2.models.implementations.UserDAOImpl;

import java.sql.SQLException;
import java.util.List;

@Controller
public class UserListController {

    @Autowired
    UserDAOImpl userDAO;


    @RequestMapping(value="/list", method= RequestMethod.GET)
    public ModelAndView selectAllUsers() throws SQLException {
        List<User> users = userDAO.selectTable();
        return new ModelAndView("userList", "users",users);
    }

    @RequestMapping(value="/insert", method = RequestMethod.GET)
    public ModelAndView insert()  {
        return new ModelAndView("insert");
    }

    @RequestMapping(value="/insertSave", method = RequestMethod.POST)
    public ModelAndView insertSave(@ModelAttribute("user") User user) throws SQLException {
        userDAO.insertTable(user);
        return new ModelAndView("redirect:/list", "insert", user);
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) throws SQLException{
        userDAO.deleteTable(id);
        return new ModelAndView("redirect:/list");
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id) throws SQLException {
        User user = userDAO.getUserById(id);
        return new ModelAndView("update","user",user);
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public ModelAndView editSave(@ModelAttribute("user") User user) throws SQLException {
        userDAO.updateTable(user);
        return new ModelAndView("redirect:/list");
    }
}
