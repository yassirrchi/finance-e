package com.erpfinance.erpfinance.Controller;

import com.erpfinance.erpfinance.Entities.Menu.MenuItem;
import com.erpfinance.erpfinance.Repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/menu")
@CrossOrigin(origins = "http://localhost:4200")
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;
    @GetMapping("/all")
    public List<MenuItem> getALLMenus(){
        return  menuRepository.findAll();

    }
}
