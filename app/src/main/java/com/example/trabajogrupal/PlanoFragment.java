package com.example.trabajogrupal;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PlanoFragment extends Fragment {
    private PlanoView planoView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plano, container, false);
        planoView = view.findViewById(R.id.planoView); // Asegúrate de que el ID coincida con el de tu XML

        List<Ambiente> ambientes = cargarAmbientesDesdeArchivo();
        planoView.setAmbientes(ambientes); // Carga los ambientes en la vista
        return view;
    }

    private List<Ambiente> cargarAmbientesDesdeArchivo() {
        List<Ambiente> listaAmbientes = new ArrayList<>();
        AssetManager assetManager = getContext().getAssets();

        try (InputStream inputStream = assetManager.open("ambientes.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",", 7);

                if (partes.length == 7) {
                    int id = Integer.parseInt(partes[0].trim());
                    String nombre = partes[1].trim();
                    int x1 = Integer.parseInt(partes[2].trim());
                    int y1 = Integer.parseInt(partes[3].trim());
                    int x2 = Integer.parseInt(partes[4].trim());
                    int y2 = Integer.parseInt(partes[5].trim());
                    String descripcion = partes[6].trim();
                    String imagenUrl = partes[6].trim();

                    // Crea el objeto Ambiente y agrégalo a la lista
                    Ambiente ambiente = new Ambiente(id, nombre, x1, y1, x2, y2, descripcion, imagenUrl);
                    listaAmbientes.add(ambiente);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaAmbientes;
    }
}
