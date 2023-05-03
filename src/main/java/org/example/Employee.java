package org.example;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;

@Setter
@Getter
public class Employee {
    protected int id;
    protected EnumPizzaStoreName enumPizzaStoreName;
    protected String first_name;
    protected String last_name;
    protected String address;
    protected double salary;
    protected LocalDate start_date;
    protected int pizza_rank;
    protected LocalDate pizza_rank_date;
    protected String pizza_surprise;

    public Employee() {
    }

    public Employee(int id, EnumPizzaStoreName enumPizzaStoreName, double salary, int pizza_rank, LocalDate pizza_rank_date, String pizza_surprise) {
        this.id = id;
        this.enumPizzaStoreName = enumPizzaStoreName;
        this.salary = salary;
        this.pizza_rank = pizza_rank;
        this.pizza_rank_date = pizza_rank_date;
        this.pizza_surprise = pizza_surprise;
    }

    public int setRankk(){
        Random random_number = new Random();
        setPizza_rank_date(LocalDate.now());
        return (this.pizza_rank = random_number.nextInt(100) + 1);

    }

    public void activateSurprise(){
        if(this.pizza_surprise != null){
            System.out.println("You got a surprise!!! Congratulations!!!");
        }
    }

    @Override
    public String toString() {
        return "{" +
                "id= " + id +
                " pizza store= " + enumPizzaStoreName +
                " salary= " + salary +
                " pizza_rank= " + pizza_rank +
                " pizza_rank_date= " + pizza_rank_date +
                " pizza_surprise= " + pizza_surprise +
                '}';
    }
}
