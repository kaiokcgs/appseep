package br.com.appseep.cursoandroid.appseep.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import br.com.appseep.cursoandroid.appseep.R;
import br.com.appseep.cursoandroid.appseep.config.ConfiguracaoFirebase;
import br.com.appseep.cursoandroid.appseep.model.Escola;
import br.com.appseep.cursoandroid.appseep.model.Usuario;
import de.hdodenhof.circleimageview.CircleImageView;

public class EscolaActivity extends AppCompatActivity {

    private CircleImageView circleImageView;
    private TextView textViewEscola;
    private Escola destinatarioEscola;
    private TextView textViewGestores;
    private TextView textViewGre;
    private TextView textViewMunicipio;
    private TextView textViewJornada;
    private TextView textViewFirst;
    private TextView textViewSecond;
    private TextView textViewTerceiro;
    private TextView textTelefone;
    private TextView textData_Gestao;
    private TextView textCelular;
    private TextView textIdepe;
    private TextView textEndereco;

    private RecyclerView recyclerViewEscola;
    private StorageReference storageReference;
    private DatabaseReference firebase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escola);

        //Configurações da toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Configurações iniciais
        textViewEscola = (TextView) findViewById(R.id.textViewEscola);
        circleImageView = (CircleImageView) findViewById(R.id.circleImageViewFotoGestor);
        textViewGestores = (TextView) findViewById(R.id.textViewGestores);
        textViewGre = (TextView) findViewById(R.id.textViewGre);
        textViewMunicipio = (TextView) findViewById(R.id.textViewMunicipio);
        textViewJornada = (TextView) findViewById(R.id.textViewJornada);
        textViewFirst = (TextView) findViewById(R.id.textViewFirst);
        textViewSecond = (TextView) findViewById(R.id.textViewSecond);
        textViewTerceiro = (TextView) findViewById(R.id.textViewTerceiro);
        textTelefone = (TextView) findViewById(R.id.textTelefone);
        textData_Gestao = (TextView) findViewById(R.id.textData_Gestao);
        textCelular = (TextView) findViewById(R.id.textCelular);
        textIdepe = (TextView) findViewById(R.id.textIdepe);
        textEndereco = (TextView) findViewById(R.id.textEndereco);

                //Recuperar dados da escola selecionada
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){

            destinatarioEscola = (Escola) bundle.getSerializable("escolaDados");

            textViewEscola.setText(destinatarioEscola.getEscola());

            textViewGestores.setText(getResources().getString(R.string.gestor, destinatarioEscola.getGestor()));

            textViewGre.setText(getResources().getString(R.string.gre ,destinatarioEscola.getGre()));

            textViewMunicipio.setText(getResources().getString(R.string.municipio ,destinatarioEscola.getMunicipio()));

            textViewJornada.setText(getResources().getString(R.string.jornada, destinatarioEscola.getJornada()));

            textViewFirst.setText(getResources().getString(R.string.ano1, destinatarioEscola.getAno1().concat(" Turmas")));

            textViewSecond.setText(getResources().getString(R.string.ano2, destinatarioEscola.getAno2().concat(" Turmas")));

            textViewTerceiro.setText(getResources().getString(R.string.ano3, destinatarioEscola.getAno3().concat(" Turmas")));

            textTelefone.setText(getResources().getString(R.string.telefone, destinatarioEscola.getTelefone()));

            textData_Gestao.setText(getResources().getString(R.string.data_gestao, destinatarioEscola.getData_gestao()));

            textCelular.setText(getResources().getString(R.string.celular, destinatarioEscola.getCelular()));

            textIdepe.setText(getResources().getString(R.string.idepe, destinatarioEscola.getIdepe()));

            textEndereco.setText(getResources().getString(R.string.endereco, destinatarioEscola.getEndereco()));

            String foto = destinatarioEscola.getFoto();
            if(foto !=null){
                Uri url = Uri.parse(destinatarioEscola.getFoto());
                Glide.with(EscolaActivity.this)
                        .load(url)
                        .into(circleImageView);
            }else{
                circleImageView.setImageResource(R.drawable.padrao);
            }
        }

    }

}