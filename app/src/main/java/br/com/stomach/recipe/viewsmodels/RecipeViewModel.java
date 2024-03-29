package br.com.stomach.recipe.viewsmodels;

import android.os.AsyncTask;

import java.util.concurrent.ExecutionException;

import br.com.stomach.recipe.helpers.HttpRecipe;
import br.com.stomach.recipe.models.EquationModel;

public class RecipeViewModel {

    private String initial;

    public EquationModel getEquation (String initial) throws ExecutionException, InterruptedException {
        this.initial = initial;
        EquationModel equation = new GetJson().execute().get();
        return equation;
    }

    private class GetJson extends AsyncTask<Void, Void, EquationModel> {

        @Override
        protected void onPreExecute(){
        }

        @Override
        protected EquationModel doInBackground(Void... voids) {
            HttpRecipe http = new HttpRecipe();
            String response = http.getEquation(initial);
            EquationViewModel equation = new EquationViewModel();
            return equation.parse(response);
        }
    }

}
