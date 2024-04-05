package br.com.stomach.recipe.viewsmodels;

import br.com.stomach.recipe.models.EquationModel;

public class MainViewModel {

    RecipeViewModel _recipeViewModel;

    public MainViewModel() {
    }

    public String getElement(String inital)
    {
        EquationModel equation = null;
        try {
            _recipeViewModel = new RecipeViewModel();
            equation = _recipeViewModel.getEquation(inital);
        } catch (Exception e) {
            e.toString();
        }
        return equation.getName().get(0);
    }

}
