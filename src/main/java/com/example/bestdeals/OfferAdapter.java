package com.example.bestdeals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {
    private ArrayList<OfferItem> myOfferList;
    private OnItemClickListener myListener;

    public static class OfferViewHolder extends RecyclerView.ViewHolder{
        public ImageView offerPic;
        public TextView restName;
        public TextView restOffer;
        public TextView restTime;

        public OfferViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            offerPic = itemView.findViewById(R.id.restPic);
            restName = itemView.findViewById(R.id.restName);
            restOffer = itemView.findViewById(R.id.restOffer);
            restTime = itemView.findViewById(R.id.restSched);

            //Setting listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        myListener = listener;
    }

    public OfferAdapter(ArrayList<OfferItem> offerList){
        myOfferList = offerList;
    }

    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.offer_item, parent, false);
        OfferViewHolder ovh = new OfferViewHolder(v, myListener);
        return ovh;
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder holder, int position) {
        OfferItem currentOffer = myOfferList.get(position);

        //Setting text and images
        holder.offerPic.setImageResource(currentOffer.getIconPic());
        holder.restName.setText(currentOffer.getName());
        holder.restOffer.setText(currentOffer.getDeals());
        holder.restTime.setText("Offer Period: " + currentOffer.getPeriod());
    }

    @Override
    public int getItemCount() {
        return myOfferList.size();
    }
}
