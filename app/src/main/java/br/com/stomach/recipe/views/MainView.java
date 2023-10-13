package br.com.stomach.recipe.views;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import br.com.stomach.recipe.R;
import br.com.stomach.recipe.viewsmodels.MainViewModel;

public class MainView {
    public MainView(Context context){
        MainViewModel mainViewModel = new MainViewModel();

        FloatingActionButton fab = (FloatingActionButton)((Activity)context).findViewById(R.id.floating_element_ion_1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Floating element ion number 1", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
            }
        });
    }
}
