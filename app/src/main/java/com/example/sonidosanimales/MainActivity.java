package com.example.sonidosanimales;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    Button btnGranja, btnSalvajes;

    MediaPlayer reproductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Relacionar los botones
        btnGranja = findViewById(R.id.btnGranja);
        btnSalvajes = findViewById(R.id.btnSalvajes);

        // Boton Granja
        btnGranja.setOnClickListener(v -> {
            cargarFragment(new GranjaFragment());
        });

        // Boton Salvajes
        btnSalvajes.setOnClickListener(v -> {
            cargarFragment(new SalvajesFragment());
        });

        // Mostrar la granja al abrir la app
        if (savedInstanceState == null) {
            cargarFragment(new GranjaFragment());
        }
    }

    // Metodo para cambiar el fragmento del contenedor
    private void cargarFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor, fragment)
                .commit();

    }

    // Metodo para reproducir sonidos (lo usan los fragmentos)
    public void reproducirSonido(int sonido) {

        // Detener sonido anterior
        if (reproductor != null) {
            reproductor.release();
            reproductor = null;
        }

        // Crear nuevo reproductor
        reproductor = MediaPlayer.create(this, sonido);

        if (reproductor != null) {

            reproductor.setOnCompletionListener(mp -> {
                mp.release();

                if (reproductor == mp) {
                    reproductor = null;
                }
            });

            reproductor.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (reproductor != null) {
            reproductor.release();
            reproductor = null;
        }
    }
}
