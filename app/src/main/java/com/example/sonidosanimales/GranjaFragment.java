package com.example.sonidosanimales;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class GranjaFragment extends Fragment {

    public GranjaFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(
                R.layout.fragment_granja,
                container,
                false
        );

        MainActivity actividad = (MainActivity) requireActivity();

        // Boton Gallo
        vista.findViewById(R.id.btnGallo).setOnClickListener(v -> {
            actividad.reproducirSonido(R.raw.gallo);
        });

        // Boton Cerdo
        vista.findViewById(R.id.btnCerdo).setOnClickListener(v -> {
            actividad.reproducirSonido(R.raw.cerdo);
        });

        // Boton Oveja
        vista.findViewById(R.id.btnOveja).setOnClickListener(v -> {
            actividad.reproducirSonido(R.raw.oveja);
        });

        // Boton Caballo
        vista.findViewById(R.id.btnCaballo).setOnClickListener(v -> {
            actividad.reproducirSonido(R.raw.caballo);
        });

        return vista;
    }
}
