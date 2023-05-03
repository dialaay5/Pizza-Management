package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static EnumPizzaStoreName getRandomStoreName() {
        Random random = new Random();
        return EnumPizzaStoreName.values()[random.nextInt(EnumPizzaStoreName.values().length)];
    }

    public static double getRandomSalary() { // r.nextInt(high-low) + low; // between 7000 to 3000
        Random rand = new Random();
        return rand.nextInt(7000 - 3000) + 3000;
    }

    public static int getRandomPizzaRank() { // between 10 to 1
        Random rand = new Random();
        return rand.nextInt(100 - 1) + 1;
    }
public static LocalDate getRandomDate() {
    long minDay = LocalDate.of(2023, 1, 1).toEpochDay();
    long maxDay = LocalDate.of(2023, 5, 2).toEpochDay();
    long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
    LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
    return randomDate;
}
    public static void main(String[] args) {
        PizzaHut pizzaHut = new PizzaHut(20,EnumPizzaStoreName.PIZZAHUT, 3,3);
        PizzaDominos pizzaDominos = new PizzaDominos(10,EnumPizzaStoreName.PIZZADOMINOS, 2,0);

        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee(1,EnumPizzaStoreName.PIZZADOMINOS, getRandomSalary(),getRandomPizzaRank(), getRandomDate(),null));
        employeeArrayList.add(new Employee(2,EnumPizzaStoreName.PIZZAHUT, getRandomSalary(),getRandomPizzaRank(), getRandomDate()," "));
        employeeArrayList.add(new Employee(3,EnumPizzaStoreName.PIZZADOMINOS, getRandomSalary(),getRandomPizzaRank(), getRandomDate(),null));
        employeeArrayList.add(new Employee(4,EnumPizzaStoreName.PIZZAHUT, getRandomSalary(),getRandomPizzaRank(), getRandomDate(),null));
        employeeArrayList.add(new Employee(5,EnumPizzaStoreName.PIZZAHUT, getRandomSalary(),getRandomPizzaRank(), getRandomDate()," "));

        System.out.println("Pizza Hut: employees");
        employeeArrayList.forEach(pizzaHut::add_employee);
        System.out.println(" ");

        System.out.println("Pizza Dominos: employees");
        employeeArrayList.forEach(pizzaDominos::add_employee);
        System.out.println(" ");

        System.out.printf("Pizza Hut: Calculate Employee Expenses = %s₪\n" ,pizzaHut.calculateEmployeeExpenses());
        System.out.printf("Pizza Dominos: Calculate Employee Expenses = %s₪\n" ,pizzaDominos.calculateEmployeeExpenses());

        //pizzaDominos.hiringEmployee(new Employee(1,EnumPizzaStoreName.PIZZADOMINOS, getRandomSalary(),getRandomPizzaRank(), getRandomDate(),null));

        //pizzaHut.resigningEmployee(new Employee(2,EnumPizzaStoreName.PIZZAHUT, getRandomSalary(),getRandomPizzaRank(), getRandomDate()," "));
        //System.out.println(pizzaHut.map_of_employees);
        //pizzaHut.hiringEmployee(new Employee(2,EnumPizzaStoreName.PIZZAHUT, getRandomSalary(),getRandomPizzaRank(), getRandomDate()," "));

        System.out.println(" ");
        System.out.printf("Pizza Hut Calculate Ranks:  %s\n" ,pizzaHut.calculateRank());
        System.out.printf("Pizza Dominos Calculate Ranks:  %s\n" ,pizzaDominos.calculateRank());

        pizzaHut.calculateRangedRank(20);
        pizzaDominos.calculateRangedRank(15);
        System.out.println(employeeArrayList.get(0).getPizza_rank());








    }















    }
