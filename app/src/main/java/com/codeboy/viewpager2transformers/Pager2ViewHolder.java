package com.codeboy.viewpager2transformers;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Pager2ViewHolder extends RecyclerView.ViewHolder {
    ImageView picture;
    int ItemPosition;
    public Pager2ViewHolder(@NonNull View itemView) {
        super(itemView);
        picture = itemView.findViewById(R.id.picture);
    }

    public void setItemPosition(int itemPosition) {
        ItemPosition = itemPosition;
    }

    void Bind(){

    }
}
