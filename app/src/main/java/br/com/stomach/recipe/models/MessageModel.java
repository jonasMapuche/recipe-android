package br.com.stomach.recipe.models;

public class MessageModel
{
    public int sender;
    public String text;

    public MessageModel(int sender, String text) {
        this.sender = sender;
        this.text = text;
    }
    public String getText() {
        return text;
    }
    public int getSender() {
        return sender;
    }

}
