package com.example.mhm.mhm.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mhm.mhm.R;
import com.example.mhm.mhm.model.ModelCat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ModelCatAdapter extends RecyclerView.Adapter <ModelCatAdapter.CatViewHolder>{

    private Context mContext;
    private ArrayList<ModelCat> modelCatArrayList;

    //create a constructor for our adapter

    public ModelCatAdapter (Context context, ArrayList<ModelCat> modellist) {

        mContext = context;
        modelCatArrayList = modellist;



    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.holder_items,viewGroup, false);

        return new CatViewHolder(v);




    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder catViewHolder, int i) {

        ModelCat currentItem = modelCatArrayList.get(i);


        String imageUrl = currentItem.getmImage();
        String creato = currentItem.getmCreator();
        int numLikes = currentItem.getmLikes();


        catViewHolder.mTextViewCreator.setText(creato);
        catViewHolder.mLikes.setText(numLikes);
        Picasso.get().load(imageUrl).fit().centerInside().into(catViewHolder.mImage);


    }

    @Override
    public int getItemCount() {
        return modelCatArrayList.size();
    }


    public class CatViewHolder extends RecyclerView.ViewHolder {


    public ImageView mImage;
    public TextView mTextViewCreator;
    public  TextView mLikes;



    public CatViewHolder(@NonNull View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.image_view);
        mTextViewCreator =itemView.findViewById(R.id.textCreator);
        mLikes = itemView.findViewById(R.id.textLike);



    }
}






}


