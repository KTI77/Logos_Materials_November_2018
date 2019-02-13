package ua.logos.controller;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BaseController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/test")
    public String getTest() {
        return "test data";
    }

    @GetMapping("/category")
    public List<String> showCategories() {
        return getCategories();
    }

    @GetMapping("/category/{categoryIndex}")
    public String showCategoryByIndex(
            @PathVariable("categoryIndex") int category
            ) {

        if(category < 0 || category >= getCategories().size()) {
            return "Incorrect index.";
        }

        return getCategories().get(category);
    }

    private List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Java");
        categories.add("JPA");
        categories.add("HTML/CSS");
        categories.add("JavaScript");
        categories.add("C#");
        categories.add("RubyRails");
        categories.add("Angular 7");

        return categories;
    }
}
