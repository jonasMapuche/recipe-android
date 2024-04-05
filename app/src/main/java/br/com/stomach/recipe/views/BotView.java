package br.com.stomach.recipe.views;

import android.app.Activity;
import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.stomach.recipe.R;
import br.com.stomach.recipe.adapters.BotAdapter;
import br.com.stomach.recipe.models.MessageModel;
import br.com.stomach.recipe.viewsmodels.BotViewModel;

public class BotView {

    public void BotNew (Context context) {

        RecyclerView recyclerView = (RecyclerView)((Activity)context).findViewById(R.id.rcy_view_bot);
        LinearLayoutManager layoutManager = new LinearLayoutManager((Activity)context);
        recyclerView.setLayoutManager(layoutManager);

        BotViewModel botViewModel = new BotViewModel();

        ArrayList<MessageModel> chatMessage = new ArrayList<MessageModel>();
        MessageModel message = new MessageModel(2, botViewModel.getMessage("Hi!"));
        chatMessage.add(message);
        message = new MessageModel(2, botViewModel.getMessage("What can I do?"));
        chatMessage.add(message);
        BotAdapter adapter = new BotAdapter(chatMessage);
        recyclerView.setAdapter(adapter);

    }

    public void BotButton (Context context, String equation) {

        RecyclerView recyclerView = (RecyclerView)((Activity)context).findViewById(R.id.rcy_view_bot);
        LinearLayoutManager layoutManager = new LinearLayoutManager((Activity)context);
        recyclerView.setLayoutManager(layoutManager);

        BotViewModel botViewModel = new BotViewModel();

        ArrayList<MessageModel> chatMessage = new ArrayList<MessageModel>();
        MessageModel message = new MessageModel(2, botViewModel.getMessage(equation));
        chatMessage.add(message);
        BotAdapter adapter = new BotAdapter(chatMessage);
        recyclerView.setAdapter(adapter);

    }

}
