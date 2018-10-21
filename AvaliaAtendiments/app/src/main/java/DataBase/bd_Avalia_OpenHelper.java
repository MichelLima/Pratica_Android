package DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class bd_Avalia_OpenHelper extends SQLiteOpenHelper {

    private static final String NOME_BD = "Atendimento_bd";
    private static final int VERSAO_BD = 8;

    public bd_Avalia_OpenHelper(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(ScriptDDL.getCreateTableClient());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       //sqLiteDatabase.execSQL("DROP TABLE COLABORADOR");
        //onCreate(sqLiteDatabase);

    }
}
