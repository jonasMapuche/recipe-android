package br.com.stomach.recipe.parsers;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.stomach.recipe.models.GolangModel;

public class GolangParser {
    public GolangModel parse(String json) {
        try {
            GolangModel golang = new GolangModel();
            JSONObject jsonObj = new JSONObject(json);
            golang.setMessage(jsonObj.getString("message"));
            return golang;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
