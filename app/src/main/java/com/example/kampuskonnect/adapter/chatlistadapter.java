package com.example.kampuskonnect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kampuskonnect.R;
import com.example.kampuskonnect.model.chatlist;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class chatlistadapter extends RecyclerView.Adapter<chatlistadapter.ViewHolder> {
    private List<chatlist> list;
    private Context context;

    public chatlistadapter(List<chatlist> list,Context context){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_chat_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull chatlistadapter.ViewHolder holder, int position) {
    chatlist chatlist=list.get(position);
        holder.tvusername.setText(chatlist.getUsername());
        holder.tvdescription.setText(chatlist.getDescription());
        holder.tvdate.setText(chatlist.getDate());
        Picasso.get().load(chatlist.getImageprofile()).placeholder(R.drawable.ic_baseline_person_24).into(holder.chatprofileimage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvusername,tvdescription,tvdate;
        private CircleImageView chatprofileimage;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            tvdate=itemView.findViewById(R.id.chatistdate);
            tvusername=itemView.findViewById(R.id.chatlistusername);
            tvdescription=itemView.findViewById(R.id.chatlistdescription);
            chatprofileimage=itemView.findViewById(R.id.chatlistphoto);

        }
    }
}
