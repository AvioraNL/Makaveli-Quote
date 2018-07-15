/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.makaveli.makaveliquote;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.makaveli.makaveliquote.quote.Quote;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author liiba
 */
public final class Connection {
    private Set<Quote> quotes;
    
    public Connection() {
        try {
            saveQuote();
        } catch (UnirestException | JSONException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      public  void saveQuote() throws UnirestException, JSONException {
        quotes = new TreeSet<>();
        JSONArray body = connection().getBody().getArray();
        for (int i = 0; i < body.length(); i++) {
            JSONObject responsek = body.getJSONObject(i);
            quotes.add(new Quote(responsek.getString("author"), responsek.getString("quote"), responsek.getString("category")));
        }
    }

    public HttpResponse<JsonNode> connection() throws UnirestException {
        String[] category = {"movies", "famous"};
        Random random = new Random();
        int randomIndex = random.nextInt(category.length);

        HttpResponse<JsonNode> response = Unirest.get("https://andruxnet-random-famous-quotes.p.mashape.com/?cat" + category[randomIndex] + "&count=1")
                .header("X-Mashape-Key", "DTPbs16sqdmshZmDNC8kUxt5xEeYp1shoKmjsnGAKYVrcjkKVg")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "application/json")
                .asJson();

        return response;
    }

    public Set<Quote> getQuotes() {
        return quotes;
    }
    
    
    
}
