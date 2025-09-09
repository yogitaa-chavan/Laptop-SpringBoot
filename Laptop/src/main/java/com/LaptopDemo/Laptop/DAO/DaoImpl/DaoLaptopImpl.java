package com.LaptopDemo.Laptop.DAO.DaoImpl;

import com.LaptopDemo.Laptop.DAO.DaoLaptop;
import com.LaptopDemo.Laptop.Entity.Laptop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Scanner;

@Repository
public class DaoLaptopImpl implements DaoLaptop {
    private final EntityManager mgr;

    @Autowired
    public DaoLaptopImpl(EntityManager mgr) {
        this.mgr = mgr;
    }

    @Override
    @Transactional
    public void save(Laptop l) {
        mgr.persist(l);
    }

    @Override
    public Laptop fetchById(int id) {
        Laptop l = mgr.find(Laptop.class,id);
        if(l!=null){
            return l;
        }else{
            return null;
        }
    }

    @Override
    public Laptop fetchByImieNo(long imie) {
        try {
            Query q = mgr.createQuery("select l from Laptop l where l.imieNo=:imie");
            q.setParameter("imie", imie);

            return (Laptop) q.getSingleResult();
        }
        catch(NoResultException nre){
            return null;
        }
    }

    @Override
    @Transactional
    public void updateDetails(int id) {
        Scanner sc = new Scanner(System.in);
        Laptop l = mgr.find(Laptop.class,id);

        if(l==null){
            System.out.println("No Laptop With This ID");
        }else{
            System.out.println("Enter new Price : ");
            l.setPrice(sc.nextDouble());
            System.out.println("Updated!!");
        }
    }

    @Override
    @Transactional
    public String delete(int id) {
        Laptop l = mgr.find(Laptop.class,id);
        if(l==null){
            return "No Laptop to Remove";
        }else{
            mgr.remove(l);
            return "Deleted Successfully";
        }
    }
}
