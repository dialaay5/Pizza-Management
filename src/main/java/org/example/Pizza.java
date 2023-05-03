package org.example;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
@Getter
@Setter

public abstract class Pizza {
    protected int id;
    protected EnumPizzaStoreName enumPizzaStoreName;
    protected String address;
    protected int number_of_employees;
    protected String phone_number;
    protected int rank;
    protected HashMap<Integer, Employee> map_of_employees = new HashMap<>();

    public Pizza(){

    }
    public Pizza(int id, EnumPizzaStoreName enumPizzaStoreName,int number_of_employees,int rank) {
        this.id = id;
        this.enumPizzaStoreName = enumPizzaStoreName;
        this.number_of_employees = number_of_employees;
        this.rank = rank;
    }

    public void add_employee(Employee employee) {
        if (employee.getEnumPizzaStoreName().equals(this.enumPizzaStoreName)) {
            map_of_employees.put(employee.getId(), employee);
            System.out.println(map_of_employees.get(employee.getId()));
        }
    }
    public void hiringEmployee(Employee employee) { // גיוס עובדים
        if (!map_of_employees.containsKey(employee.getId())) {
            map_of_employees.put(employee.getId(), employee);
            number_of_employees++;
            this.rank = calculateRank();
            System.out.println("תהליך הגיוס עבר בהצלחה!");
        } else {
            System.out.println("השם של העובד כבר מופיע ברשימת העובדים. אי אפשר לגייס מחדש");        }
    }

    public void resigningEmployee(Employee employee) { // התפטרות עובדים
        if (map_of_employees.containsKey(employee.getId())) {
            map_of_employees.remove(employee.getId());
            number_of_employees--;
            this.rank = calculateRank();
            System.out.println("תהליך ההתפטרות עבר בהצלחה!");
        } else {
            System.out.println("השם של העובד כבר לא מופיע ברשימת העובדים, אי אפשר לעשות תהליך התפטרות");
        }
    }

    public double calculateEmployeeExpenses(){
        double amount_of_expenses = 0;
        for (var entry : map_of_employees.entrySet()) {
            amount_of_expenses += entry.getValue().getSalary();
        }
        return amount_of_expenses;
    }

    public abstract int calculateRank();

    public void calculateRangedRank(int range){
        int totalRanks = 0;
        for (var entry : map_of_employees.entrySet()) {
            if(entry.getValue().getPizza_rank_date().plusDays(range).equals(LocalDate.now())){
                totalRanks += entry.getValue().getPizza_rank();
                System.out.printf("total employees ranks that is valid in the range = %s\n" ,totalRanks);
            }
            else{
                entry.getValue().setRankk();
            }
        }
    }
}
