package org.example;

public class PizzaDominos extends Pizza{


    public PizzaDominos(int id, EnumPizzaStoreName enumPizzaStoreName, int number_of_employees, int rank) {
        super(id, enumPizzaStoreName, number_of_employees, rank);
    }

    @Override
    public int calculateRank() {
        int ranks_sum = 0;
        for (var entry : map_of_employees.entrySet()) {
            ranks_sum += entry.getValue().getPizza_rank();
        }
        setRank(ranks_sum);
        return getRank();
    }
}