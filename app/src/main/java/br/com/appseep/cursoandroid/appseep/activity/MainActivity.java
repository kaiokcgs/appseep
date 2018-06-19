package br.com.appseep.cursoandroid.appseep.activity;

import android.content.Intent;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.google.firebase.auth.FirebaseAuth;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;

import br.com.appseep.cursoandroid.appseep.fragment.EscolasFragment;
import br.com.appseep.cursoandroid.appseep.helper.SlidingTabLayout;
import br.com.appseep.cursoandroid.appseep.R;
import br.com.appseep.cursoandroid.appseep.config.ConfiguracaoFirebase;

public class MainActivity extends AppCompatActivity{

    private FirebaseAuth autenticacao;
    private Toolbar toolbar;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private MaterialSearchView materialSearchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();

        toolbar = (Toolbar) findViewById(R.id.toolbar_principal);
        toolbar.setTitle("ESCOLAS");
        setSupportActionBar(toolbar);

        //Configurar o Adapter
        final FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                FragmentPagerItems.with(this)
                        .add("Lista das Escolas", EscolasFragment.class)
                        .create()
        );
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_pagina);
        viewPager.setAdapter( adapter );

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewPagerTab);
        viewPagerTab.setViewPager( viewPager );

        //Configuração do search view
        materialSearchView = (MaterialSearchView) findViewById(R.id.materialSearchPrincipal);

        //Listener para o Searchview
        materialSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                EscolasFragment fragment = (EscolasFragment) adapter.getPage(0);
                fragment.recarregarEscolas();
            }
        });

        //Listener para caixa de texto
        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                EscolasFragment fragment = (EscolasFragment) adapter.getPage(0);

                String textoDigitado = newText.toUpperCase();
                fragment.pesquisarEscola(textoDigitado);

                return true;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Carrega o arquivo de menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        //Configurar botão de pesquisa
        MenuItem item = menu.findItem(R.id.item_pesquisa);
        materialSearchView.setMenuItem(item);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.item_sair:
                deslogarUsuario();
                return true;
            case R.id.item_pesquisa:
                onPause();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    public void deslogarUsuario(){
        autenticacao.signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


}
