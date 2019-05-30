package com.example.healthtracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthtracker.backend.Entry;

import java.util.List;

public class EntryLayoutAdapter extends RecyclerView.Adapter<EntryLayoutAdapter.EntryHolder> {

    public static class EntryHolder extends RecyclerView.ViewHolder{
        public TextView textDescription;
        public TextView textLength;
        public TextView textMood;

        public EntryHolder(@NonNull View itemView){
            super(itemView);

            this.textDescription = itemView.findViewById(R.id.text_description);
            this.textLength = itemView.findViewById(R.id.text_length);
            this.textMood = itemView.findViewById(R.id.text_mood);
        }

        public void setEntry(Entry entry){
            this.textDescription.setText(String.format("%s", entry.getDescription()));
            this.textLength.setText(String.format("%s", entry.getLength()));
            this.textMood.setText(String.format("%d", entry.getMood()));
        }
    }

    private List<Entry> entries;

    public EntryLayoutAdapter(List<Entry> entries){
        this.entries = entries;
    }

    public void removeEntry(int index){
        this.entries.remove(index);
        this.notifyItemRemoved(index);
    }

    public void setEntries(List<Entry> entries){
        this.entries = entries;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EntryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.single_entry, parent, false);

        EntryHolder holder = new EntryHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EntryHolder holder, int position) {
        Entry entry = entries.get(position);
        holder.setEntry(entry);
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }
}
