package com.example.videoplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoRVAdapter extends RecyclerView.Adapter<VideoRVAdapter.ViewHolder> {
    private ArrayList<VideoRVModel> videoRVModelArrayList;
    private Context context;
    private videoClickInterface videoClickInterface;

    public VideoRVAdapter(ArrayList<VideoRVModel> videoRVModelArrayList, Context context, VideoRVAdapter.videoClickInterface videoClickInterface) {
        this.videoRVModelArrayList = videoRVModelArrayList;
        this.context = context;
        this.videoClickInterface = videoClickInterface;
    }

    @NonNull
    @Override
    public VideoRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_rv_item , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoRVAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        VideoRVModel videoRVModel = videoRVModelArrayList.get(position);
        holder.thumbNaikIV.setImageBitmap((videoRVModel.getThumbNail()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoClickInterface.onVideoCLick(position);
            }
        });



    }

    @Override
    public int getItemCount() {
        return videoRVModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbNaikIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbNaikIV = itemView.findViewById(R.id.idIVThumbNail);
        }
    }


    //This interface
    public interface videoClickInterface{
        void onVideoCLick(int position);
    }
}
