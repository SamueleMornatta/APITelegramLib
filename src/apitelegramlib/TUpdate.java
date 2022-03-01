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
public class TUpdate {
    String update_id;
    TMessage mess;
    public TUpdate(JSONObject json) {
        this.update_id = json.has("update_id") ? Integer.toString(json.getInt("update_id")) : null;
        this.mess = new TMessage(json.getJSONObject("message"));
    }

    public String getUpdate_id() {
        return update_id;
    }

    public TMessage getMess() {
        return mess;
    }
}
