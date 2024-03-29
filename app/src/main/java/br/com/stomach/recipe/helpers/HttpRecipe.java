package br.com.stomach.recipe.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpRecipe {

    private static String url = "http://192.168.0.18:8080/recipe/equation/";
    public static String getEquation(String initial) {
        String response = "";
        try {
            URL apiEnd = new URL(url + initial);
            int id_response;
            HttpURLConnection connect;
            InputStream stream;
            connect = (HttpURLConnection) apiEnd.openConnection();
            connect.setRequestMethod("GET");
            connect.setReadTimeout(15000);
            connect.setConnectTimeout(15000);
            connect.connect();
            id_response = connect.getResponseCode();
            if(id_response < HttpURLConnection.HTTP_BAD_REQUEST){
                stream = connect.getInputStream();
            }else{
                stream = connect.getErrorStream();
            }
            response = deserializeResponse(stream);
            stream.close();
            connect.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return response;
    }

    private static String deserializeResponse(InputStream stream) {
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader response;
            String line;
            response = new BufferedReader(new InputStreamReader(stream));
            while((line = response.readLine())!=null){
                buffer.append(line);
            }
            response.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
