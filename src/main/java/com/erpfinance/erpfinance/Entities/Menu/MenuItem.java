package com.erpfinance.erpfinance.Entities.Menu;

import jakarta.persistence.*;

import java.util.List;



public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @OneToMany

    private List<MenuItem> menuItems;

}
