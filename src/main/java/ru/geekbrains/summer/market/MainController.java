package ru.geekbrains.summer.market;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {
    // ROOT: [http://localhost:8189/summer]
    // GET [http://localhost:8189/summer]/showMeDemo

    @GetMapping("/showMeDemo")
    @ResponseBody
    public String demoMethod() {
        return "DEMO";
    }

    @GetMapping("/page")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/cart")
    public String showCartPage() {
        return "cart";
    }

    // GET http://localhost:8189/summer/add?a=10&b=20
    @GetMapping("/add")
    public String addTwoNumbersAndShowResult(Model model, @RequestParam int a, @RequestParam int b) {
        int result = a + b;
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("addResult", result);
        return "result";
    }

    // GET http://localhost:8189/summer/show_add_form
    @GetMapping("/show_add_form")
    public String showAddForm() {
        return "add_form";
    }

    // GET http://localhost:8189/summer/users/1/profile
    @GetMapping("/users/{id}/profile")
    public String showUserProfile(Model model, @PathVariable Long id) {
        User user = new User(id, "Bob", 30);
        model.addAttribute("user", user);
        return "profile";
    }

    // GET http://localhost:8189/summer/users
    @GetMapping("/users")
    public String showAllUsers(Model model) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User(1L, "Bob", 30),
                new User(2L, "Jack", 40),
                new User(3L, "John", 50),
                new User(4L, "Max", 60)
        ));
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/create_user_form")
    public String showCreateUserForm() {
        return "create_user";
    }

    @PostMapping("/create_new_user")
    public String createNewUser(@RequestParam Long id, @RequestParam String name, @RequestParam int age) {
        User user = new User(id, name, age);
        System.out.println(user);
        return "redirect:/page";
    }
}
