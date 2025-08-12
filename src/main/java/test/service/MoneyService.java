package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.GetMapping;
import test.model.dao.MoneyDao;
import test.model.dto.MoneyDto;

import java.util.ArrayList;

@Service
public class MoneyService {
    @Autowired
    private MoneyDao moneyDao;

    public ArrayList<MoneyDto> moneyPrint(){
        return moneyDao.moneyPrint();
    }   // func end


}
