package br.com.stomach.recipe.viewsmodels;

import android.os.AsyncTask;

import java.util.concurrent.ExecutionException;

import br.com.stomach.recipe.services.HttpRecipe;
import br.com.stomach.recipe.models.EquationModel;
import br.com.stomach.recipe.parsers.EquationParser;

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
            EquationParser equation = new EquationParser();
            return equation.parse(response);
        }
    }

}
