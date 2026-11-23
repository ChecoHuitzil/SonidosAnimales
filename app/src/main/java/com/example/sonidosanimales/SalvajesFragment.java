package com.example.sonidosanimales;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class SalvajesFragment extends Fragment {

    public SalvajesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(
                R.layout.fragment_salvajes,
                container,
                false
        );

        MainActivity actividad = (MainActivity) requireActivity();

        // Boton Elefante
        vista.findViewById(R.id.btnElefante).setOnClickListener(v -> {
            actividad.reproducirSonido(R.raw.elefante);
        });

        // Boton Rana
        vista.findViewById(R.id.btnRana).setOnClickListener(v -> {
            actividad.reproducirSonido(R.raw.rana);
        });

        // Boton Lobo
        vista.findViewById(R.id.btnLobo).setOnClickListener(v -> {
            actividad.reproducirSonido(R.raw.lobo);
        });

        return vista;
    }
}
