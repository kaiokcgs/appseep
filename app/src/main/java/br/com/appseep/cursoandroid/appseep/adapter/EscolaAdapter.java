package br.com.appseep.cursoandroid.appseep.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import br.com.appseep.cursoandroid.appseep.R;
import br.com.appseep.cursoandroid.appseep.model.Escola;

/**
 * Created by rair.angelos on 10/05/2018.
 */

public class EscolaAdapter extends RecyclerView.Adapter<EscolaAdapter.MyViewHolder>{

    private List<Escola> escolas;
    private Context context;

    public EscolaAdapter(List<Escola> listaEscolas, Context c) {
        this.escolas = listaEscolas;
        this.context = c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_escolas, parent,false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Escola escola = escolas.get(position);

        holder.nome.setText(escola.getEscola());

    }

    @Override
    public int getItemCount() {

        return escolas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome;

        public MyViewHolder(View itemView) {
            super(itemView);

            nome = (TextView)itemView.findViewById(R.id.textNomeEscola);

        }
    }

}
