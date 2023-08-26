package com.pluralsight.bdd.loyalty_card;

public class MorningFreshnessMember {
    private final String name;
    private SuperSmoothieSchema schema;
    private int earnedPoints;

    public MorningFreshnessMember(String name, SuperSmoothieSchema schema) {
        this.name = name;
        this.schema = schema;
    }

    public void orders(Integer quantity, String drink) {
        earnedPoints += schema.getPointsFor(drink) * quantity;
    }

    public int getPoints() {
        return earnedPoints;
    }
}
