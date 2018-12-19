package ua.logos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BaseController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello world";
    }

    @GetMapping("category")
    public List<String> showCategories() {
        return getCategories();
    }

    @GetMapping("category/{categoryIndex}")
    public String showCategoryByIndex(
            @PathVariable("categoryIndex") int index
    ) {

        if (index < 0 || index > getCategories().size() - 1) {
            return "Incorrect index [" + index + "]";
        }

        return getCategories().get(index);
    }

    @PutMapping("category/{categoryIndex}")
    public ResponseEntity<?> udpateCategoryList(
            @PathVariable("categoryIndex") int index,
            @RequestParam(required = false, name = "categoryName") String cName,
            @RequestParam(required = false, name = "category1") String cat1
    ) {
        System.out.println("Category1: " + cat1);
        List<String> cats = getCategories();
        if (index < 0 || index > cats.size() - 1) {
            return new ResponseEntity<>(
                    "Incorrect index [" + index + "]",
                    HttpStatus.BAD_REQUEST);
        }

        if (cName == null) {
            cName = "Default";
        }

        cats.set(index, cName);
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }


    private List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Java");
        categories.add("JPA/Hibernate");
        categories.add("HTML/CSS");
        categories.add("JavaScript");
        categories.add("TypeScript");
        categories.add("MySQL");
        categories.add("RestAPI");
        return categories;
    }
}
