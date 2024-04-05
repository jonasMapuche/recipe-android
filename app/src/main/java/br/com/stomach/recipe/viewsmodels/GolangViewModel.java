package br.com.stomach.recipe.viewsmodels;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import br.com.stomach.recipe.models.GolangModel;
import br.com.stomach.recipe.parsers.GolangParser;
import br.com.stomach.recipe.services.HttpGolang;

public class GolangViewModel {

    private String initial;
    public GolangModel getMessage (String initial) throws ExecutionException, InterruptedException {
        this.initial = initial;
        GolangModel golang = new GetJson().execute().get();
        return golang;
    }

    private class GetJson extends AsyncTask<Void, Void, GolangModel> {

        @Override
        protected void onPreExecute(){
        }

        @Override
        protected GolangModel doInBackground(Void... voids) {
            HttpGolang http = new HttpGolang();
            GolangModel golangmodel = new GolangModel();
            golangmodel.setMessage(initial);
            Gson gson = new Gson();
            String json = gson.toJson(golangmodel);
            String response = http.postMessage(json);
            GolangParser golang = new GolangParser();
            return golang.parse(response);
        }
    }
}
