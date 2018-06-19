package br.com.appseep.cursoandroid.appseep.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import br.com.appseep.cursoandroid.appseep.R;
import br.com.appseep.cursoandroid.appseep.activity.EscolaActivity;
import br.com.appseep.cursoandroid.appseep.adapter.EscolaAdapter;
import br.com.appseep.cursoandroid.appseep.config.ConfiguracaoFirebase;
import br.com.appseep.cursoandroid.appseep.helper.RecyclerItemClickListener;
import br.com.appseep.cursoandroid.appseep.model.Escola;

/**
 * A simple {@link Fragment} subclass.
 */
public class EscolasFragment extends Fragment {

    private RecyclerView recyclerView;
    private EscolaAdapter adapter;
    private ArrayList<Escola> listaEscolas = new ArrayList<>();
    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerEscolas;


    public EscolasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_escolas, container, false);

        //Configurações iniciais
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewListaEscolas);
        firebase = ConfiguracaoFirebase.getFirebase().child("escolas");

        //Configurar Adapter
        adapter = new EscolaAdapter(listaEscolas, getActivity());

        //Configurar recyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager (new LinearLayoutManager(getActivity()));

        adapter = new EscolaAdapter(listaEscolas, getActivity());
        recyclerView.setAdapter(adapter);

        //Configurar o evento de clique no recyclerview
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Escola escolaSelecionada = listaEscolas.get(position);

                        Intent i = new Intent(getActivity(), EscolaActivity.class);
                        i.putExtra("escolaDados", escolaSelecionada);
                        startActivity(i);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    }
                }
                )
        );


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        recuperarEscolas();
    }

    @Override
    public void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListenerEscolas);
    }

    public void recarregarEscolas(){

        adapter = new EscolaAdapter(listaEscolas, getActivity());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public void recuperarEscolas(){
        valueEventListenerEscolas = firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dados: dataSnapshot.getChildren()){
                    Escola escola = dados.getValue(Escola.class);
                    listaEscolas.add(escola);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void pesquisarEscola(final String texto){
        listaEscolas.clear();
        if(texto.length() > 0){

            Query query = firebase.orderByChild("escola").startAt(texto).endAt(texto + "\uf8ff");

            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {             for(DataSnapshot ds : dataSnapshot.getChildren() ){             listaEscolas.add(ds.getValue(Escola.class));
        }
                   adapter.notifyDataSetChanged();

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        }




}
