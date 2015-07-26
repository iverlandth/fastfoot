package com.example.nohemy.fastfood;

/**
 * Created by Nohemy on 07/07/2015.
 */

import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.xml.sax.Parser;

/**
 * Created by ditmaros on 22/06/2015.
 */
public class DetalleFragment extends Fragment implements View.OnClickListener {
    ImageView img;
    TextView detalle;
    Button comprar;
    Bitmap generalImg;

    public DetalleFragment(Bitmap img) {
        generalImg = img;
    }

    public void onCreate(Bundle data) {
        super.onCreate(data);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmento, container, false);
        Bundle params = this.getArguments();
        img = (ImageView) root.findViewById(R.id.img);
        detalle = (TextView) root.findViewById(R.id.descripcion);
        comprar = (Button) root.findViewById(R.id.button);
        comprar.setOnClickListener(this);
        String url = params.getString("url");
        detalle.setText(params.getString("detalle"));
        img.setImageBitmap(generalImg);
        return root;
    }

    @Override
    public void onClick(View view) {
        /*
        CarritoDeCompras item = new CarritoDeCompras();
        item.detalle = detalle.getText().toString();
        item.precio = Integer.parseInt(precio.getText().toString());
        item.img = generalImg;
        ListaCarrito.informacion.add(item);*/
    }
}
