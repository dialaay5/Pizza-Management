package org.example;

public class PizzaHut extends Pizza{

    public PizzaHut(int id, EnumPizzaStoreName enumPizzaStoreName, int number_of_employees, int rank) {
        super(id, enumPizzaStoreName, number_of_employees, rank);
    }

    @Override
    public int calculateRank() {
        int ranks_sum = 0;
        for (var entry : map_of_employees.entrySet()) {
            ranks_sum += entry.getValue().getPizza_rank();
        }
        setRank(ranks_sum / number_of_employees);
        return getRank();
    }
}
