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
public class TChat {
    String id, first_name, type;
    public TChat(JSONObject json) {
        this.id = Integer.toString(json.getInt("id"));
        this.first_name = json.getString("first_name");
        this.type = json.getString("type");
    }

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getType() {
        return type;
    }
}
