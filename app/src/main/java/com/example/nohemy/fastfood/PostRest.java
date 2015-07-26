package com.example.nohemy.fastfood;

import android.content.Entity;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by ditmaros on 01/06/2015.
 */
public class PostRest extends AsyncTask<JSONObject,String,JSONObject>{
    private PostRestListener listener;
    public JSONObject RESPONSE;
    public String URL;
    public void setOnPostListener(PostRestListener l){
        listener=l;
    }
    @Override
    protected JSONObject doInBackground(JSONObject... params) {
        String url= null;
        try {
            url = params[0].getString("url");
            URL=url;
            HttpClient http=new DefaultHttpClient();
            HttpPost post=new HttpPost(url);
            post.setHeader("content-type","application/json");
            JSONObject data=params[1];
            StringEntity jsonData=new StringEntity(data.toString());
            post.setEntity(jsonData);
            HttpResponse res=http.execute(post);
            String jsonCadena=EntityUtils.toString(res.getEntity());
            JSONObject respuesta=new JSONObject(jsonCadena);
            return respuesta;
        } catch (JSONException e) {
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
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
