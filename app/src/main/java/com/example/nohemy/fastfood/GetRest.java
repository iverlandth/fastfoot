package com.example.nohemy.fastfood;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by ditmaros on 01/06/2015.
 */
public class GetRest extends AsyncTask<JSONObject,String,JSONObject>{
    GetRestListener listener;
    JSONObject RESPONSE;
    String URL;

    public void setOnPostListener(GetRestListener l){
        listener=l;
    }

    @Override
    protected JSONObject doInBackground(JSONObject... jsonObjects) {
        JSONObject res=null;
        try {

            String url=jsonObjects[0].getString("url");
            URL=url;
            HttpClient http=new DefaultHttpClient();
            HttpGet get=new HttpGet(url);
            get.setHeader("content-type","application/json");
            HttpResponse respuesta= http.execute(get);

            res=new JSONObject(EntityUtils.toString(respuesta.getEntity()));

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    protected void onPostExecute(JSONObject result)
    {
        RESPONSE=result;
        try {
            listener.OnResponsePost(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
