import java.util.Date;
import java.util.List;

public class Funcionario {

    private int codigo;
    private String nome;
    private Date data_nascimento;
    private List<String> operacao;
    private int cont_Like;
    private int cont_deslike;
    private int cont_hate_deslike;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public List<String> getOperacao() {
        return operacao;
    }

    public void setOperacao(List<String> operacao) {
        this.operacao = operacao;
    }

    public int getCont_Like() {
        return cont_Like;
    }

    public void setCont_Like(int cont_Like) {
        this.cont_Like = cont_Like;
    }

    public int getCont_deslike() {
        return cont_deslike;
    }

    public void setCont_deslike(int cont_deslike) {
        this.cont_deslike = cont_deslike;
    }

    public int getCont_hate_deslike() {
        return cont_hate_deslike;
    }

    public void setCont_hate_deslike(int cont_hate_deslike) {
        this.cont_hate_deslike = cont_hate_deslike;
    }
}
