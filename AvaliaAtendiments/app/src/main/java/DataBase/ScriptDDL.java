package DataBase;

public class ScriptDDL {

    public static String getCreateTableClient(){

            StringBuilder sql = new StringBuilder();


            sql.append("CREATE TABLE  IF NOT EXISTS COLABORADOR( ");
            sql.append("CODIGO INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ");
            sql.append("NOME VARCHAR(50) NOT NULL DEFAULT (''), ");
            sql.append("SOBRENOME VARCHAR(50) NOT NULL DEFAULT (''), ");
            sql.append("DATA_NASCIMENTO VARCHAR(10) NOT NULL DEFAULT (''), ");
            sql.append("OPERACAO VARCHAR(50) NOT NULL DEFAULT (''), ");
            sql.append("LIKE INTEGER(16) DEFAULT (''), ");
            sql.append("DESLIKE INTEGER(16) DEFAULT (''), ");
            sql.append("HATEDESLIKE INTEGER(16) DEFAULT (''))");

            return sql.toString();
    }
}
