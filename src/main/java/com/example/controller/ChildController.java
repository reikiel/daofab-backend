package com.example.controller;

import com.example.model.Child;
import com.example.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class ChildController {

    @Autowired
    private ChildRepository childRepository;

    // get children of parent
    @RequestMapping(value="/parent/{parentid}", method = RequestMethod.GET)
    public List<Child> getChildren(@PathVariable("parentid") Long parentid) {
        return this.childRepository.findByParentId(parentid);
    }

    @GetMapping("children")
    public List<Child> getAllChildren() {
        return this.childRepository.findAll();
    }

}
