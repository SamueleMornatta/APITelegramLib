/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apitelegramlib;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.*;

/**
 *
 * @author mornatta_samuele
 */
public class TelegramAPI {

    String token;
    Scanner sc;
    String baseurl;
    String id;
    boolean is_bot;
    String first_name;
    String username;
    boolean can_join_groups;
    boolean can_read_all_group_messages;
    boolean supports_inline_queries;
    String lastOffset;

    public TelegramAPI(String token) throws MalformedURLException, IOException {
        this.token = token;
        baseurl = "https://api.telegram.org/bot" + URLEncoder.encode(token, StandardCharsets.UTF_8) + "/";
        sc = new Scanner(new URL(baseurl + "getMe").openStream());
        String jsonString = sc.next();
        sc.close();
        JSONObject obj = new JSONObject(jsonString);
        if (obj.getBoolean("ok")) {
            this.id = Integer.toString(obj.getJSONObject("result").getInt("id"));
            this.is_bot = obj.getJSONObject("result").getBoolean("is_bot");
            this.first_name = obj.getJSONObject("result").getString("first_name");
            this.username = obj.getJSONObject("result").getString("username");
            this.can_join_groups = obj.getJSONObject("result").getBoolean("can_join_groups");
            this.can_read_all_group_messages = obj.getJSONObject("result").getBoolean("can_read_all_group_messages");
            this.supports_inline_queries = obj.getJSONObject("result").getBoolean("supports_inline_queries");
            this.lastOffset = null;
        } else {
            System.out.println("ERRORE: qualcosa è andato storto");
        }
    }

    public void sendMessage(String chatId, String message) throws MalformedURLException, IOException {
        sc = new Scanner(new URL(baseurl + "sendMessage?chat_id=" + URLEncoder.encode(chatId) + "&text=" + URLEncoder.encode(message)).openStream());
        sc.next();
    }

    public ArrayList<TUpdate> getUpdates() throws MalformedURLException, IOException {
        ArrayList<TUpdate> list = new ArrayList<TUpdate>();
        sc = new Scanner(new URL(baseurl + "getUpdates" + (lastOffset != null ? "?offset=" + lastOffset : "")).openStream());
        String json = sc.useDelimiter("\001A").next();
        JSONObject mess = new JSONObject(json);
        JSONArray arr = mess.getJSONArray("result");
        for (int i = 0; i < arr.length(); i++) {
            list.add(new TUpdate(arr.getJSONObject(i)));
        }
        if (list.size() > 0){
            lastOffset = String.valueOf(Integer.valueOf(list.get(list.size() - 1).update_id) + 1);
        }
        return list;
    }

    public String getToken() {
        return token;
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

    public String getUsername() {
        return username;
    }

    public boolean isCan_join_groups() {
        return can_join_groups;
    }

    public boolean isCan_read_all_group_messages() {
        return can_read_all_group_messages;
    }

    public boolean isSupports_inline_queries() {
        return supports_inline_queries;
    }
}
