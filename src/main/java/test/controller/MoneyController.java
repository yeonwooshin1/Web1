package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.model.dto.MoneyDto;

import test.service.MoneyService;

import java.util.ArrayList;

@RestController
public class MoneyController {

    @Autowired
    private MoneyService moneyService;


    @GetMapping("/money")
    public ArrayList<MoneyDto> moneyPrint(){
        return moneyService.moneyPrint();
    }   // func end
}
