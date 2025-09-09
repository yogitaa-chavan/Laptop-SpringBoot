package com.LaptopDemo.Laptop.DAO;

import com.LaptopDemo.Laptop.Entity.Laptop;

public interface DaoLaptop {
    public void save(Laptop l);
    public Laptop fetchById(int id);
    public Laptop fetchByImieNo(long imie);
    public void updateDetails(int id);
    public String delete(int id);
}
