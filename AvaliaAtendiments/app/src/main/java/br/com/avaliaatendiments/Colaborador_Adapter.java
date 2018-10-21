package br.com.avaliaatendiments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import Diminio.Entidades.Colaborador;

public class Colaborador_Adapter  extends RecyclerView.Adapter<Colaborador_Adapter.ViewHolderColaborador>{

    private List<Colaborador>dados;

    //CONSTRUTOR
    public Colaborador_Adapter(List<Colaborador>dados){

        this.dados = dados;
    }


    @Override
    public Colaborador_Adapter.ViewHolderColaborador onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_colaborador, parent, false);

        ViewHolderColaborador holderColaborador = new ViewHolderColaborador(view, parent.getContext());

        return holderColaborador;
    }

    @Override
    public void onBindViewHolder(Colaborador_Adapter.ViewHolderColaborador holder,  int position) {

        if ((dados != null) && (dados.size()>0) ){
            Colaborador colaborador = dados.get(position);
            holder.txtNome.setText(colaborador.nome);
            holder.txtsobreNome.setText(colaborador.sobreNome);
        }else {

            Toast.makeText(null,"null", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    //CLASSE QUE MAPEIA REFERENCIAS DA LISTA
    public class  ViewHolderColaborador extends  RecyclerView.ViewHolder{

        public TextView txtNome;
        public TextView txtsobreNome;
        public ViewHolderColaborador(View itemView, final Context context) {
            super(itemView);

            txtNome =  itemView.findViewById(R.id.lst_Nome);
            txtsobreNome = itemView.findViewById(R.id.lst_SobreNome);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(dados.size() > 0) {

                        Colaborador colaborador = dados.get(getLayoutPosition());
                        Intent it = new Intent(context, CardColaborador.class);
                        it.putExtra("COLABORADOR", colaborador);
                        ((AppCompatActivity) context).startActivityForResult(it, 0);

                    }

                }
            });
        }
    }
}
