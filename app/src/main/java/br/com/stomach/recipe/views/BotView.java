package br.com.stomach.recipe.views;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.stomach.recipe.R;
import br.com.stomach.recipe.adapters.BotAdapter;
import br.com.stomach.recipe.models.MessageModel;
import br.com.stomach.recipe.viewsmodels.BotViewModel;

public class BotView {
    private ArrayList<MessageModel> chatMessage = new ArrayList<MessageModel>();
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private BotAdapter adapter;
    public void BotNew (Context context) {
        recyclerView = (RecyclerView)((Activity)context).findViewById(R.id.rcy_view_bot);
        layoutManager = new LinearLayoutManager((Activity)context);
        recyclerView.setLayoutManager(layoutManager);
        BotViewModel botViewModel = new BotViewModel();
        //ArrayList<MessageModel> chatMessage = new ArrayList<MessageModel>();
        MessageModel message = new MessageModel(2, botViewModel.getMessage("Hi!"));
        chatMessage.add(message);
        message = new MessageModel(2, botViewModel.getMessage("What can I do?"));
        chatMessage.add(message);
        adapter = new BotAdapter(chatMessage);
        recyclerView.setAdapter(adapter);
        ImageButton imageButton = (ImageButton) ((Activity)context).findViewById(R.id.img_but_send);
        imageButton.setOnClickListener(view -> SendMessage(context));
    }
    private void SendMessage(Context context) {
        EditText editText = (EditText) ((Activity)context).findViewById(R.id.edt_txt_input);
        BotViewModel botViewModel = new BotViewModel();
        MessageModel message = new MessageModel(1, botViewModel.getMessage(editText.getText().toString()));
        chatMessage.add(message);
        adapter = new BotAdapter(chatMessage);
        recyclerView.setAdapter(adapter);
    }
    public void BotButton (Context context, String equation) {
        recyclerView = (RecyclerView)((Activity)context).findViewById(R.id.rcy_view_bot);
        layoutManager = new LinearLayoutManager((Activity)context);
        recyclerView.setLayoutManager(layoutManager);
        BotViewModel botViewModel = new BotViewModel();
        //ArrayList<MessageModel> chatMessage = new ArrayList<MessageModel>();
        MessageModel message = new MessageModel(2, botViewModel.getMessage(equation));
        chatMessage.add(message);
        adapter = new BotAdapter(chatMessage);
        recyclerView.setAdapter(adapter);
        ImageButton imageButton = (ImageButton) ((Activity)context).findViewById(R.id.img_but_send);
        imageButton.setOnClickListener(view -> SendMessage(context));
    }

}
