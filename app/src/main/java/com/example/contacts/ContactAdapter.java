package com.example.contacts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

   private List<Contact> contacts;
   ItemClicked activity;

   public interface ItemClicked
   {
       void onItemClicked(int index);
   }

   public ContactAdapter(Context context, List<Contact> list)
   {
       contacts=list;
       activity=(ItemClicked)context;
   }

   public class ViewHolder extends RecyclerView.ViewHolder
   {
       TextView tvChar,tvName,tvMail;
       public ViewHolder(@NonNull View itemView) {
           super(itemView);

           tvChar = itemView.findViewById(R.id.tvChar);
           tvName=itemView.findViewById(R.id.tvName);
           tvMail=itemView.findViewById(R.id.tvMail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(contacts.indexOf((Contact)v.getTag()));
                }
            });

       }
   }
    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_row_layout,viewGroup,false);
       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(contacts.get(i));

        viewHolder.tvName.setText(contacts.get(i).getName());
        viewHolder.tvMail.setText((contacts.get(i).getEmail()+" ( "+contacts.get(i).getTelNr()+" ) "));
        viewHolder.tvChar.setText(contacts.get(i).getName().toUpperCase().charAt(0) + "");//to convert to string.
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
