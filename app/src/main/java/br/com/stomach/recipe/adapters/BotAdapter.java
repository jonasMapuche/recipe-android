package br.com.stomach.recipe.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import br.com.stomach.recipe.R;
import br.com.stomach.recipe.models.MessageModel;

public class BotAdapter extends RecyclerView.Adapter <BotAdapter.ViewHolder> {


    private ArrayList<MessageModel> message;
    public int VIEW_TYPE_SEND = 1;
    public int VIEW_TYPE_RECEIVED = 2;

    public BotAdapter(ArrayList<MessageModel> message)
    {
        this.message = message;
    }

    @NonNull
    @Override
    public BotAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_RECEIVED) {
            View item_view_receiver = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_received_message, parent, false);
            return new ViewHolder(item_view_receiver, VIEW_TYPE_RECEIVED);
        } else {
            View item_view_sender = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_send_message, parent, false);
            return new ViewHolder(item_view_sender, VIEW_TYPE_SEND);
        }
    }

    public int getItemViewType(int position) {
        if (this.message.get(position).sender==VIEW_TYPE_SEND) return VIEW_TYPE_SEND;
        else return VIEW_TYPE_RECEIVED;
    }

    @Override
    public void onBindViewHolder(@NonNull BotAdapter.ViewHolder holder, final int position) {
        if (getItemViewType(position) == VIEW_TYPE_RECEIVED)
            holder.getTextView().setText(message.get(position).text);
        else
            holder.getTextView().setText(message.get(position).text);
    }

    @Override
    public int getItemCount() {
        return message.toArray().length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        public ViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);
            if (viewType == VIEW_TYPE_RECEIVED)
                textView = (TextView) itemView.findViewById(R.id.txt_viw_received);
            else
                textView = (TextView) itemView.findViewById(R.id.txt_viw_send);
        }
        public TextView getTextView() {
            return textView;
        }
    }
}
