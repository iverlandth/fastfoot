package com.example.nohemy.fastfood;

import org.json.JSONException;

import java.util.EventListener;

/**
 * Created by ditmaros on 01/06/2015.
 */
public interface PostRestListener extends EventListener {

    public void OnResponsePost(PostRest sender) throws JSONException;

}

