package com.example.nohemy.fastfood;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class menu extends Activity implements GetRestListener, AdapterView.OnItemClickListener, View.OnClickListener {
    ArrayList data;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        LoadInterface();
    }

    private void LoadInterface() {

        try {
            JSONObject params = new JSONObject();
            params.put("url", "http://192.168.1.100:8181/menu");
            GetRest peticion = new GetRest();
            peticion.execute(params);
            peticion.setOnPostListener(this);
        } catch (JSONException s) {
            s.printStackTrace();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnResponsePost(GetRest sender) {
        JSONObject respuesta = sender.RESPONSE;
        try {

            ArrayList data = new ArrayList();
            JSONArray listaServer = respuesta.getJSONArray("lista");
            for (int i = 0; i < listaServer.length(); i++) {
                Item p = new Item();
                JSONObject d = (JSONObject) listaServer.get(i);
                p.setDescripcion(d.getString("des"));
                p.setNombre(d.getString("nombre"));
                p.setPrecio(d.getInt("precio"));
                p.setUrl(d.getString("img"));
                data.add(p);
            }
            ListAdapter adapter = new ListAdapter(this, data);
            ListView lista = (ListView) this.findViewById(R.id.lista);
            lista.setAdapter(adapter);
            lista.setOnItemClickListener(this);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void LoadFragment(String detalle, Bitmap img) {
        Bundle params = new Bundle();
        params.putString("detalle", detalle);
        DetalleFragment fr = new DetalleFragment(img);
        fr.setArguments(params);
        FragmentManager fragment = this.getFragmentManager();
        FragmentTransaction transactionFragment = fragment.beginTransaction();
        transactionFragment.replace(R.id.frameDetailsProduct, fr).commit();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //LoadFragment(((Item) data.get(i)).getDescripcion(), ((Item) data.get(i)).getBitmap());
       // Toast.makeText(this,((Item)data.get(i)).getDescripcion(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        String cad = "HOLA ";
        /*for (int i = 0; i < ListaCarrito.informacion.size(); i++) {
            cad += ListaCarrito.informacion.get(i).detalle + "  ";
        }*/
        Toast.makeText(this, cad, Toast.LENGTH_LONG).show();
    }
}
