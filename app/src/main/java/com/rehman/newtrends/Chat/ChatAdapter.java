package com.rehman.newtrends.Chat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.rehman.newtrends.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ChatModel> mDataList;

    public ChatAdapter(Context context, ArrayList<ChatModel> mDataList) {
        this.context = context;
        this.mDataList = mDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(context).inflate(R.layout.chat_list,parent,false);

        return new MyViewHolder(myView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ChatModel model = mDataList.get(position);

        holder.adminMassage_text.setVisibility(View.GONE);
        holder.my_chat_text.setVisibility(View.GONE);

        if (model.getChatType().equals("admin"))
        {
            holder.my_chat_text.setVisibility(View.VISIBLE);
            holder.my_chat_text.setText(model.getMessage());
        }
        if (model.getChatType().equals("user"))
        {
            holder.adminMassage_text.setVisibility(View.VISIBLE);
            holder.adminMassage_text.setText(model.getMessage());
        }


    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView my_chat_text,adminMassage_text;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            my_chat_text = itemView.findViewById(R.id.my_chat_text);
            adminMassage_text = itemView.findViewById(R.id.adminMassage_text);
        }
    }


}
