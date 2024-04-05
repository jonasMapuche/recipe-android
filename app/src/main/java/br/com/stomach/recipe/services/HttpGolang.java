package br.com.stomach.recipe.services;

import static br.com.stomach.recipe.helpers.Util.deserializeResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpGolang {
    private static String url = "http://api.stomach.com.br:8885/";
    public static String getMessage(String initial) {
        String response = "";
        try {
            URL apiEnd = new URL(url);
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

    public static String postMessage(String initial) {
        String response = "";
        try {
            URL apiEnd = new URL(url);
            int id_response;
            HttpURLConnection connect;
            InputStream stream;
            connect = (HttpURLConnection) apiEnd.openConnection();
            connect.setRequestMethod("POST");

            OutputStream request = connect.getOutputStream();
            request.write(initial.getBytes());
            request.flush();
            request.close();

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
}
