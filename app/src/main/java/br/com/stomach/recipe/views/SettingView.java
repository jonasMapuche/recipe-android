package br.com.stomach.recipe.views;

import android.app.Activity;
import android.content.Context;
import android.widget.TextView;

import br.com.stomach.recipe.R;
import br.com.stomach.recipe.viewsmodels.SettingViewModel;

public class SettingView {
    public SettingView(Context context) {
        SettingViewModel settingViewModel = new SettingViewModel();

        TextView text_abou = (TextView)((Activity)context).findViewById(R.id.tex_viw_about);
        text_abou.setText(settingViewModel.getAbout());
    }
}
