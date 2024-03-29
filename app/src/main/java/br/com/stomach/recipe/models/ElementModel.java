package br.com.stomach.recipe.models;

public class ElementModel   {

    public String name;
    public int multiplier;
    public int amount;
    public int valence;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
    public int getMultiplier() {
        return this.multiplier;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getAmount() {
        return this.amount;
    }
    public void setValence(int valence) {
        this.valence = valence;
    }
    public int getValence() {
        return this.valence;
    }
}
