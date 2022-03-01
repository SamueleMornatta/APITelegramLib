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
public class TMessage {
    String message_id;
    TUtente from;
    TChat chat;
    String date;
    String text;
    public TMessage(JSONObject json) {
        this.message_id = json.has("message_id") ? Integer.toString(json.getInt("message_id")) : null;
        this.from = new TUtente(json.getJSONObject("from"));
        this.chat = new TChat(json.getJSONObject("chat"));
        this.date = json.has("date") ? Integer.toString(json.getInt("date")) : null;
        this.text = json.has("text") ? json.getString("text") : null;
    }

    public String getMessage_id() {
        return message_id;
    }

    public TUtente getFrom() {
        return from;
    }

    public TChat getChat() {
        return chat;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}