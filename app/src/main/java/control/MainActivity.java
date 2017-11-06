package control;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.leon.floripapp.R;

import java.util.List;

import dao.FestaDAO;
import domain.Festa;

public class MainActivity extends AppCompatActivity {
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.list_view);

        carregaLista();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Festa festa = (Festa) lista.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, InformacoesActivity.class);
                intent.putExtra("festa", festa);
                startActivity(intent);
            }
        });
    }

    @NonNull
    private ListView carregaLista() {
        FestaDAO dao = new FestaDAO(this);
        List<Festa> festas = dao.buscaFestas();
        dao.close();

        ArrayAdapter<Festa> adapter = new ArrayAdapter<Festa>(this, android.R.layout.simple_list_item_1, festas);
        lista.setAdapter(adapter);
        return lista;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_informacoes_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ordenaNome:
                carregaLista();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


//    public void startMapsActivity(View view) {
//
//        Intent mapIntent = new Intent(this, MapsActivity.class);
//
//        startActivity(mapIntent);
//    }

}
