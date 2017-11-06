package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import domain.Festa;

import java.util.ArrayList;
import java.util.List;


public class FestaDAO extends SQLiteOpenHelper {

    public FestaDAO(Context context) {
        super(context, "GuiaFestas", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE Festas(id INTEGER PRIMARY KEY, nome TEXT NOT NULL, cidade TEXT, descricao TEXT, pago BOOLEAN, valor TEXT, dataFuncionamento TEXT, video TEXT);";
        sqLiteDatabase.execSQL(sql);

        String insereDados = "INSERT INTO Festas VALUES (1, 'Oktoberfest', 'Rua Gentil Batistti Archer, 221 - centro II', 'A maior festa alemã da América do Sul, a Oktoberfest Blumenau conta com diversas atrações artísticas, musicais e culturais, desfiles temáticos e grande variedade em chopes e gastronomia típica', 1, '4 a 22 de Outubro', '14h - 00h', 'A7dG3rNPmpg')," +
                "(2, 'Fenaostra','Centrosul, Florianópolis', 'altux camarão gratinado', 0, '0', '11 a 16 de Outubro', '6U66xyARj_Q')," +
                "(3, 'Fenarreco', 'Blumenau, Santa Catarina','marrequinho', 0, '0', '12h-00h', 'gc4Vl03gBTo');";
        sqLiteDatabase.execSQL(insereDados);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS Festas";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public List<Festa> buscaFestas(){
        SQLiteDatabase database = getReadableDatabase();
        Cursor c = database.rawQuery("SELECT * From Festas", null);

        List<Festa> festas =  new ArrayList<Festa>();
        while(c.moveToNext()){
            Festa festa = new Festa();
            festa.setId(c.getInt(c.getColumnIndex("id")));
            festa.setNome(c.getString(c.getColumnIndex("nome")));
            festa.setCidade(c.getString(c.getColumnIndex("cidade")));
            festa.setDescricao(c.getString(c.getColumnIndex("descricao")));
            festa.setPago(c.getInt(c.getColumnIndex("pago")) > 0);
            festa.setValor(c.getString(c.getColumnIndex("valor")));
            festa.setDataFuncionamento(c.getString(c.getColumnIndex("dataFuncionamento")));
            festa.setVideo(c.getString(c.getColumnIndex("video")));


            festas.add(festa);
        }
        c.close();
        return festas;
    }

    public void salvaAlteracao(Festa festa){
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();

        String[] params={String.valueOf(festa.getId())};
        database.update("Festas",values,"id = ?",params);
    }
}
