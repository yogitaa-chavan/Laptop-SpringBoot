package com.LaptopDemo.Laptop;

import com.LaptopDemo.Laptop.DAO.DaoLaptop;
import com.LaptopDemo.Laptop.Entity.Laptop;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class LaptopApplication {

    @Bean
    public CommandLineRunner commandLineRunner(DaoLaptop l){
        return runner-> {

            for(;;){
                Scanner sc = new Scanner(System.in);
                System.out.println("1.Add Laptop /n 2.Fetch Laptop By Id /n 3.Fetch Laptop By IMIE Number /n 4.Update Laptop Deatails By Id /n 5.Remove Laptop /n 6.Exit");
                int ch = sc.nextInt();
                sc.nextLine();
                switch (ch) {
                    case 1:
                        System.out.println("Enter The Laptop Model");
                        String model = sc.nextLine();
                        System.out.println("Enter The Laptop Price");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter The Laptop Ram");
                        int ram = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter The Laptop IMIE Number");
                        long imie = sc.nextLong();

                        l.save(new Laptop(model, price, ram, imie));
                        break;

                    case 2:    //2nd fetch by id
                        System.out.println("Enter The Id");
                        Laptop l2 = l.fetchById(sc.nextInt());
                        if (l2 == null) {
                            System.out.println("No Laptop with this ID");
                        } else {
                            System.out.println(l2);
                        }
                        break;
                    case 3:
                        //  fetchbyIMIENO
                        System.out.println("Enter The IMIE Number");
                        Laptop l3 = l.fetchByImieNo(sc.nextInt());
                        if (l3 == null) {
                            System.out.println("No Laptop with this IMIE Number");
                        } else {
                            System.out.println(l3);
                        }
                        break;
                    case 4:
                        //update price
                        System.out.println("Enter The Laptop Id");
                        l.updateDetails(sc.nextInt());
                        break;
                    case 5:
                        //to remove
                        System.out.println("Enter Laptop Id");
                        System.out.println(l.delete(sc.nextInt()));
                        break;
                    case 6:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Enter Valid Number (Between 1 to 6) ");
                }

            }







        };
    }
	public static void main(String[] args) {
		SpringApplication.run(LaptopApplication.class, args);
	}

}
