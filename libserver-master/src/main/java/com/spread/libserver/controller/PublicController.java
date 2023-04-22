package com.spread.libserver.controller;

import com.spread.libserver.doer.dofactory.Operation;
import com.spread.libserver.model.network.CategoryResponse;
import com.spread.libserver.model.network.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublicController {
    @GetMapping("getallcat")
    public CategoryResponse getAllCategoriesManager(){
        return Operation.getAllCategories();
    }

    @PostMapping("login")
    public Response loginUser(@RequestBody String json){
        List<String> list = Operation.jToV(json);
//        System.out.println(objects[0]);
//        System.out.println(objects[1]);
        return Operation.login(list.get(0),list.get(1));
    }

}
