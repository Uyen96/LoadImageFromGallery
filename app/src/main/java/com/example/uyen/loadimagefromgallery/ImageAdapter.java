package com.example.uyen.loadimagefromgallery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder> {

    private Context mContext;
    private List<Image> mImages;

    public ImageAdapter(Context context, List<Image> images) {
        mContext = context;
        mImages = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.list_image, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.bindData(mImages.get(i));
    }

    @Override
    public int getItemCount() {
        return mImages != null ? mImages.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public MyViewHolder(View view) {
            super(view);
            mImageView = view.findViewById(R.id.image);
        }

        public void bindData(Image image) {
            Picasso.with(mContext)
                    .load(image.getUri())
                    .placeholder(R.mipmap.ic_launcher)
                    .into(mImageView);
        }
    }
}
