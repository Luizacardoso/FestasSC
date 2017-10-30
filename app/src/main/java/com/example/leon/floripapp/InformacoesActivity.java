package com.example.leon.floripapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class InformacoesActivity extends AppCompatActivity {

    private PontoTuristico pontoTuristico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        final CheckBox favorito = (CheckBox) findViewById(R.id.favorito);
        TextView nome = (TextView) findViewById((R.id.nome));
        Button mapsButton = (Button) findViewById((R.id.mapa));
        TextView horarioFuncionamento = (TextView) findViewById((R.id.horarioFuncionamento));
        TextView dataFuncionamento = (TextView) findViewById((R.id.dataFuncionamento));
        TextView descricao = (TextView) findViewById((R.id.descricao));

        Intent intent = getIntent();
        pontoTuristico = (PontoTuristico) intent.getSerializableExtra("pontoTuristico");

        favorito.setChecked(pontoTuristico.isFavorito());
        nome.setText(pontoTuristico.getNome());
        horarioFuncionamento.setText(pontoTuristico.getHorarioFuncionamento());
        dataFuncionamento.setText(pontoTuristico.getDataFuncionamento());
        descricao.setText(pontoTuristico.getDescricao());

        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+pontoTuristico.getNome());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pontoTuristico.setFavorito(favorito.isChecked());
                PontoTuristicoDAO dao = new PontoTuristicoDAO(InformacoesActivity.this);
                dao.salvaAlteracao(pontoTuristico);
                dao.close();
            }
        });
    }

}

