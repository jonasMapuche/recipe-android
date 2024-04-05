package br.com.stomach.recipe.views;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import java.net.UnknownHostException;

import br.com.stomach.recipe.R;
import br.com.stomach.recipe.viewsmodels.MainViewModel;

public class MainView {

    private String text_button_1 = "NaHCO3";
    private String text_button_2 = "HClO";
    private String text_button_3 = "OH-";
    private String text_button_4 = "H+";

    public MainView(Context context) throws UnknownHostException {
        MainViewModel mainViewModel = new MainViewModel();

        TextView text_element_1 = (TextView)((Activity)context).findViewById(R.id.text_element_1);
        text_element_1.setText(mainViewModel.getElement(text_button_1));

        TextView text_element_2 = (TextView)((Activity)context).findViewById(R.id.text_element_2);
        text_element_2.setText(mainViewModel.getElement(text_button_2));

        TextView text_element_3 = (TextView)((Activity)context).findViewById(R.id.text_element_3);
        text_element_3.setText(mainViewModel.getElement(text_button_3));

        TextView text_element_4 = (TextView)((Activity)context).findViewById(R.id.text_element_4);
        text_element_4.setText(mainViewModel.getElement(text_button_4));

        /*
        FloatingActionButton fab = (FloatingActionButton)((Activity)context).findViewById(R.id.floating_element_ion_1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Floating element ion number 1", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
            }
        });
        */
    }
}
