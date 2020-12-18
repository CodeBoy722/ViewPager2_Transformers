package com.codeboy.viewpager2transformers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class Pager2RecyclerAdapter extends RecyclerView.Adapter<Pager2ViewHolder> {

    List<Integer> ResourceIDs;
    Context ParentContext;

    public Pager2RecyclerAdapter(List<Integer> resourceIDs, Context parentContext) {
        ResourceIDs = resourceIDs;
        ParentContext = parentContext;
    }

    @NonNull
    @Override
    public Pager2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(ParentContext);
       View ItemView = inflater.inflate(R.layout.layout_item_pager2_page,null,false);
       return new Pager2ViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Pager2ViewHolder holder, int position) {
        holder.setPagePosition(position);
        holder.setResourceID(ResourceIDs.get(position));
        holder.Bind(ParentContext);
    }

    @Override
    public int getItemCount() {
        return ResourceIDs.size();
    }
}
