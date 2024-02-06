package org.example.Miko.Assignment.Controller;

import org.example.Miko.Assignment.Service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    AssemblyService assemblyService;

    @GetMapping("/operate")
    public String operate(@RequestBody String statement)
    {
        return  assemblyService.operate(statement);
    }
}
