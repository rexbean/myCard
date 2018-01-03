package com.example.zihaoli.mycard.Utility;

import android.util.Log;

import com.example.zihaoli.mycard.entity.Person;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by zihaoli on 18/1/3.
 */

public class Util {
    /***
     * using gson parse the json string getting from the url
     * @param jsonString
     * @return a list of person
     */
    public static ArrayList<Person> parseJson(String jsonString){
        if(jsonString == null){
            return null;
        }
        ArrayList<Person> personList = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(jsonString);
        try{
            if(jsonElement.isJsonArray()){
                Log.i(TAG, "-------parsing json Array-------");
                JsonArray objArray = (JsonArray) jsonElement;
                for(int i = 0; i < objArray.size(); i++){
                    JsonObject personObj = (JsonObject) objArray.get(i);
                    String lastName = personObj.get("lastName").getAsString();
                    String firstName = personObj.get("firstName").getAsString();
                    String email = personObj.get("email").getAsString();
                    String company = personObj.get("company").getAsString();
                    String startDate = personObj.get("startDate").getAsString();
                    String bio = personObj.get("bio").getAsString();
                    String avatar = personObj.get("avatar").getAsString();
                    Person p = new Person(i, lastName, firstName, email, company, startDate, bio, avatar);
                    personList.add(p);
                }
            } else {
                return null;
            }
            return personList;
        } catch (JsonParseException e){
            Log.e(TAG, "has json parsing error!");
            Log.e(TAG, e.getMessage());
            return null;
        }
    }

    /***
     * sending GET request to get the json string
     * @param path
     * @return the json string
     */
    public static String getJson(String path){
        HttpURLConnection connection = null;
        try {
            URL url = new URL(path);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Request Version", "HTTP/1.1");
            urlConnection.setRequestProperty("Host", "https://s3-us-west-2.amazonaws.com");
            urlConnection.setRequestProperty("Connection", "close");
            urlConnection.setRequestProperty("Accept", "application/json, text/javascript, */*");
            urlConnection.setRequestProperty("Origin","https://s3-us-west-2.amazonaws.com");
            urlConnection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
            urlConnection.setRequestProperty("USER-AGENT", "Mozilla/5.0 (Windows " +
                    "NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) " +
                    "Chrome/48.0.2564.116 Safari/537.36");
            urlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            urlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            urlConnection.setRequestProperty("ACCEPT-LANGUAGE", "en-US;" +
                    "q=0.6,en;q=0.4");
            InputStream stream = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            bufferedReader.close();
            return sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null){
                connection.disconnect();
            }

        }
        return null;
    }
}
