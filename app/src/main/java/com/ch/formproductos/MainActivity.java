package com.ch.formproductos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView respuesta;
    private EditText nombre;
    private EditText codigo;
    private EditText valor;
    private EditText tExcento;
    private EditText categoria;
    private Button guardar;
    private Button bExcento;
    private Button masCostoso;
    private Button menosCostoso;
    private ArrayAdapter<String> adapter;
    private ArrayList<Producto> productos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        respuesta = findViewById(R.id.lvRespuesta);
        nombre = findViewById(R.id.txtNombre);
        codigo = findViewById(R.id.txtCodigo);
        valor = findViewById(R.id.txtValor);
        tExcento = findViewById(R.id.txtExcento);
        categoria = findViewById(R.id.txtCategoria);
        guardar = findViewById(R.id.btnGuardar);
        bExcento = findViewById(R.id.btnExcentos);
        menosCostoso = findViewById(R.id.btnMenosCostosos);
        masCostoso = findViewById(R.id.btnMasCostoso);

        guardar.setOnClickListener(this);
        bExcento.setOnClickListener(this);
        menosCostoso.setOnClickListener(this);
        masCostoso.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnGuardar) {
            guardarProducto();
            limpiar();
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, productos);
            respuesta.setAdapter(adapter);
        } else if (v.getId() == R.id.btnExcentos) {
            String siExento = "SI";

            ArrayList<String> lsiExentos = new ArrayList<>();

            for (Producto lproducto : productos) {
                if (lproducto.getpExento().equals(siExento)) {
                    lsiExentos.add(lproducto.toString());
                }
            }

            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lsiExentos);
            respuesta.setAdapter(adapter);

        } else if (v.getId() == R.id.btnMenosCostosos) {
            menorValor();
            ArrayList<String> menorCosto = new ArrayList<>();
            String valorMenor = "Los Productos de menor valor Son: " + "\n";

            for (int menor = 0; menor < 10; menor++) {
                valorMenor += productos.get(menor).getpNombre() + ": " + productos.get(menor).getpDescripcion() + " $" + productos.get(menor).getpValor();
            }

            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menorCosto);
            respuesta.setAdapter(adapter);

        } else if (v.getId() == R.id.btnMasCostoso) {
            mayorValor();
            menorValor();
            ArrayList<String> mayorCosto = new ArrayList<>();
            String valorMeyor = "Los Productos de mayor valor Son: " + "\n";

            for (int mayor = 0; mayor < 10; mayor++) {
                valorMeyor += productos.get(mayor).getpNombre() + ": " + productos.get(mayor).getpDescripcion() + " $" + productos.get(mayor).getpValor();
            }

            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mayorCosto);
            respuesta.setAdapter(adapter);

        }
    }

    private void guardarProducto() {
        String gnombre = nombre.getText().toString();
        String gcodigo = codigo.getText().toString();
        double gvalor = Double.parseDouble(valor.getText().toString());
        String gexcepcion = tExcento.getText().toString();
        String gcategoria = categoria.getText().toString();

        Producto pPrducto = new Producto(gnombre, gcodigo, gvalor, gexcepcion, gcategoria);
        productos.add(pPrducto);
    }

    private void limpiar() {
        nombre.getText().clear();
        codigo.getText().clear();
        valor.getText().clear();
        tExcento.getText().clear();
        categoria.getText().clear();
    }

    private void menorValor() {
        //Metodo para Ordenar de Menor a Mayor la Lista de Productos por valor
        Collections.sort(productos, new Comparator<Producto>() {
            @Override
            public int compare(Producto v1, Producto v2) {
                return new Double(v1.getpValor()).compareTo(new Double(v2.getpValor()));
            }
        });
    }

    private void mayorValor() {
        //Metodo para Ordenar de Mayor a Menor la Lista de Productos por valor
        menorValor();
        Collections.reverse(productos);
    }

    /*private Double promedioValor(String excento) {
        int contador = 0;
        double subtotalSalario = 0;
        double promedio = 0;

        for (Producto funcionario : persona) {
            if (funcionario.getfCargo().equals(cargof)) {
                subtotalSalario += funcionario.getfSalario();
                contador++;
            }
        }
        promedio = subtotalSalario / contador;
        return promedio;
    }*/



}