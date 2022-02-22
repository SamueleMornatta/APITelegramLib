/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apitelegramlib;

import org.json.JSONObject;

/**
 *
 * @author mornatta_samuele
 */
public class TUtente {
    String id;
    boolean is_bot;
    String first_name;
    String language_code;
    public TUtente(JSONObject json){
        this.id = Integer.toString(json.getInt("id"));
        this.is_bot = json.getBoolean("is_bot");
        this.first_name = json.getString("first_name");
        this.language_code = json.getString("language_code");
    }

    public String getId() {
        return id;
    }

    public boolean isIs_bot() {
        return is_bot;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLanguage_code() {
        return language_code;
    }
    
}
