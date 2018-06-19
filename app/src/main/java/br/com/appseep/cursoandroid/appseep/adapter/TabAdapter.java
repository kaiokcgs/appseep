package br.com.appseep.cursoandroid.appseep.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.appseep.cursoandroid.appseep.fragment.EscolasFragment;

/**
 * Created by rair.angelos on 09/05/2018.
 */
public class TabAdapter extends FragmentStatePagerAdapter{

    private String [] tituloAbas = {"LISTA"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new EscolasFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {

        return tituloAbas.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tituloAbas[position];
    }
}
