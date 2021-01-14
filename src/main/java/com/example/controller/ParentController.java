package com.example.controller;

import com.example.model.Child;
import com.example.model.Parent;
import com.example.repository.ChildRepository;
import com.example.repository.ParentRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import static java.util.stream.Collectors.toList;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class ParentController {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    @GetMapping("parents")
    public Page<Parent> getParents(@RequestParam(name = "page", defaultValue="0") int page,
                                   @RequestParam(name = "size", defaultValue = "2") int size) {
        List<Parent> parents = this.parentRepository.findAll();

        // for each parent, get child data based of parent id
        // add the amount paid for each child
        // set totalAmountPaid of parent
        for (Parent parent : parents) {
            List<Child> children = this.childRepository.findByParentId(parent.getId());
            int totalPaidAmount = 0;

            for (Child child: children) {
                totalPaidAmount += child.getPaidAmount();
            }

            parent.setTotalPaidAmount(totalPaidAmount);

        }

        // Pagination
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Parent> pageData = this.parentRepository.findAll(pageRequest);

        return pageData;


        //return this.parentRepository.findAll();
    }
}
