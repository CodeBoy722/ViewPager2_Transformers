package com.codeboy.viewpager2transformers;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Pager2ViewHolder extends RecyclerView.ViewHolder {
    ImageView picture;
    TextView number;
    int PagePosition;
    int resourceID;
    public Pager2ViewHolder(@NonNull View itemView) {
        super(itemView);
        picture = itemView.findViewById(R.id.picture);
        number = itemView.findViewById(R.id.number);
    }

    public void setPagePosition(int pagePosition) {
        PagePosition = pagePosition;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    void Bind(Context context){
        Glide.with(context)
                .load(resourceID)
                .apply(new RequestOptions().centerCrop())
                .into(picture);

        number.setText(PagePosition);
    }
}
