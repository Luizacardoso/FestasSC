package control;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.leon.floripapp.R;

import dao.FestaDAO;
import domain.Festa;

public class InformacoesActivity extends AppCompatActivity {

    private Festa festa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);


        TextView nome = (TextView) findViewById((R.id.nome));
        TextView cidade = (TextView) findViewById((R.id.cidade));
        Button mapsButton = (Button) findViewById((R.id.mapa));
        TextView valor = (TextView) findViewById((R.id.valor));
        TextView video = (TextView) findViewById((R.id.video));
        TextView dataFuncionamento = (TextView) findViewById((R.id.dataFuncionamento));
        TextView descricao = (TextView) findViewById((R.id.descricao));

        Intent intent = getIntent();
        festa = (Festa) intent.getSerializableExtra("festa");


        nome.setText(festa.getNome());
        cidade.setText(festa.getCidade());
        descricao.setText(festa.getDescricao());
        valor.setText(festa.getValor());
        dataFuncionamento.setText(festa.getDataFuncionamento());
        video.setText(festa.getVideo());

        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+ festa.getCidade());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

            }

}

