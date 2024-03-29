package br.com.stomach.recipe.models;

import java.math.BigInteger;
import java.util.List;

public class EquationModel {

    private BigInteger _id;

    public List<String> name;
    public String type;
    public String initial;

    public EquationModel() {
    }
    public List<ElementModel> element;


    public void setName(List<String> name) {
        this.name = name;
    }
    public List<String> getName() {
        return this.name;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }
    public String getInitial() {
        return this.initial;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }

    public void setElement(List<ElementModel> element) {
        this.element = element;
    }
    public List<ElementModel> getElement() {
        return this.element;
    }

}
