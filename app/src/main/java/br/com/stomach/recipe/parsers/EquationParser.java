package br.com.stomach.recipe.parsers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.stomach.recipe.models.ElementModel;
import br.com.stomach.recipe.models.EquationModel;

public class EquationParser {
    public EquationModel parse(String json) {
        try {
            EquationModel equation = new EquationModel();
            JSONObject jsonObj = new JSONObject(json);
            equation.setType(jsonObj.getString("type"));
            JSONArray array = jsonObj.getJSONArray("name");
            List<String> name = new ArrayList<String>();
            for (int i=0; i < array.length(); i++) {
                String item = array.get(i).toString();
                name.add(item);
            }
            equation.setName(name);
            equation.setInitial(jsonObj.getString("initial"));
            equation.setType(jsonObj.getString("type"));
            JSONArray array2 = jsonObj.getJSONArray("element");
            for (int i=0; i < array2.length(); i++) {
                JSONObject objArray = array2.getJSONObject(i);
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