package com.example.nohemy.fastfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nohemy on 22/06/2015.
 */
public class ListAdapter extends BaseAdapter {
    private Context container;
    private List<Item> datos;

    public ListAdapter(menu catalogo, List<Item> data) {
        container = catalogo;
        datos = data;

    }

    @Override
    public int getCount() {
        return this.datos.size();
    }

    @Override
    public Object getItem(int i) {

        return this.datos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewGroup parent = viewGroup;
        if (row == null) {
            LayoutInflater inflate = (LayoutInflater) this.container.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflate.inflate(R.layout.item_list, parent, false);
        }

        //TextView descripcionTxt = (TextView) row.findViewById(R.id.textView);
        TextView nombre = (TextView) row.findViewById(R.id.textView2);
        TextView precio = (TextView) row.findViewById(R.id.textPrecio);
        ImageView img = (ImageView) row.findViewById(R.id.imageView);
        Item info = this.datos.get(i);

        //descripcionTxt.setText(info.getDescripcion());
        nombre.setText(info.getNombre());
        precio.setText("Bs. " + String.valueOf(info.getPrecio()));
        LoadImages load = new LoadImages(img);
        load.execute(info.getUrl());

        //img.setImageBitmap();

        return row;
    }
}
