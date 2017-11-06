package control;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.leon.floripapp.R;

import java.net.URLEncoder;

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
        Button videoButton = (Button) findViewById((R.id.video));
        TextView dataFuncionamento = (TextView) findViewById((R.id.dataFuncionamento));
        TextView descricao = (TextView) findViewById((R.id.descricao));

        Intent intent = getIntent();
        festa = (Festa) intent.getSerializableExtra("festa");


        nome.setText(festa.getNome());
        cidade.setText(festa.getCidade());
        descricao.setText(festa.getDescricao());
        valor.setText(festa.getValor());
        dataFuncionamento.setText(festa.getDataFuncionamento());

        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = festa.getVideo();

                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
                try {
                    startActivity(appIntent);
                } catch (ActivityNotFoundException ex) {
                    startActivity(webIntent);
                }
            }
        });

        mapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                    new Intent(Intent.ACTION_VIEW,
                        Uri.parse(String.format("geo:0,0?q=%s", URLEncoder.encode(festa.getCidade()))
                    ))
                );
            }
        });
    }
}

