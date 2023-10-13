package br.com.stomach.recipe.views;

import android.app.Activity;
import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.stomach.recipe.R;
import br.com.stomach.recipe.adapters.BotAdapter;
import br.com.stomach.recipe.models.MessageModel;

public class BotView {

    public BotView (Context context) {

        RecyclerView recyclerView = (RecyclerView)((Activity)context).findViewById(R.id.rcy_view_bot);
        LinearLayoutManager layoutManager = new LinearLayoutManager((Activity)context);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<MessageModel> chatMessage = new ArrayList<MessageModel>();
        MessageModel message = new MessageModel(2, "Hi!");
        chatMessage.add(message);
        message = new MessageModel(2, "What can I do?");
        chatMessage.add(message);
        BotAdapter adapter = new BotAdapter(chatMessage);
        recyclerView.setAdapter(adapter);

    }


}
