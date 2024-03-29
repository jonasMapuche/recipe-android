package br.com.stomach.recipe.viewsmodels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.stomach.recipe.models.ElementModel;
import br.com.stomach.recipe.models.EquationModel;

public class EquationViewModel {
    public EquationModel parse(String json) {
        try {
            EquationModel equation = new EquationModel();
            JSONObject jsonObj = new JSONObject(json);
            equation.setName(Collections.singletonList(jsonObj.getString("name")));
            equation.setInitial(jsonObj.getString("initial"));
            equation.setType(jsonObj.getString("type"));
            JSONArray array = jsonObj.getJSONArray("element");
            for (int i=0; i < array.length(); i++) {
                JSONObject objArray = array.getJSONObject(i);
                ElementModel element = new ElementModel();
                element.setName(objArray.getString("name"));
                element.setAmount(Integer.parseInt(objArray.getString("amount")));
                element.setMultiplier(Integer.parseInt(objArray.getString("multiplier")));
                element.setValence(Integer.parseInt(objArray.getString("valence")));
                List<ElementModel> list_element = new ArrayList<ElementModel>();
                list_element.add(element);
                equation.setElement(list_element);
            }
            return equation;
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}