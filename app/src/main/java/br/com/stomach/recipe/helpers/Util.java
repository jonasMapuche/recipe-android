package br.com.stomach.recipe.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class Util {
    public static String deserializeResponse(InputStream stream) {
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

    public static OutputStream serializaRequest(String json, HttpURLConnection connect) throws IOException {
        OutputStream os = connect.getOutputStream();
        try {
            byte[] input = json.getBytes("utf-8");
            os.write(input, 0, input.length);
        }catch(IOException e){
            e.printStackTrace();
        }
        return os;
    }
}
