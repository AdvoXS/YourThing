package com.creation.controllers.rest;

import com.creation.dataobjects.exampleProject;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;


@RestController
@RequestMapping(value = "/projects") //http://localhost:8080/projects
public class exampleRestController {

    // этот метод будет принимать методом GET
    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public exampleProject getMyData(@PathVariable long time) {
        return new exampleProject(new BigDecimal(0), "Andrey", new Date(), new Date());
    }

    // этот метод будет принимать dataobject и отдавать его клиенту
    // обычно метод PUT используют для сохранения либо для обновления объекта
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public exampleProject putMyData(@RequestBody exampleProject md) {
        return md;
    }

    // этот метод будет принимать методом DELETE
    // и на его основе можно удалит объект
    @RequestMapping(value= "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public exampleProject deleteMyData(@PathVariable BigDecimal id) {
        return new exampleProject(new BigDecimal(0), "Andrey", new Date(), new Date());
    }
    // этот метод будет методом POST отдавать объект dataobject
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public exampleProject postMyData() {
        return new exampleProject(new BigDecimal(0), "Andrey", new Date(), new Date());
    }
}
