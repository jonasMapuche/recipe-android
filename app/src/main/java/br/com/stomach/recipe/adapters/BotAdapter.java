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

        View item_view_receiver = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_received_message, parent, false);
        //ReceiverViewHolder view_holder_receiver = new ReceiverViewHolder(item_view_receiver);
        return new ViewHolder(item_view_receiver);

    }

    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public void onBindViewHolder(@NonNull BotAdapter.ViewHolder holder, final int position) {
        holder.getTextView().setText(message.get(position).text);
    }

    @Override
    public int getItemCount() {
        return message.toArray().length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txt_viw_received);
        }
        public TextView getTextView() {
            return textView;
        }
    }
}
