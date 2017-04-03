package com.rja.moshizzle.pokemon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rja.moshizzle.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rjaylward on 4/2/17
 */

public class PokemonAdapter extends RecyclerView.Adapter {

    private List<Pokemon> mItems = new ArrayList<>();

    public void setItems(List<Pokemon> pokemon) {
        mItems = pokemon;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TextViewHolder.inflate(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof TextViewHolder) {
            ((TextViewHolder) holder).setText(mItems.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    static class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public static TextViewHolder inflate(ViewGroup parent) {
            return new TextViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_holder_text, parent, false));
        }

        public TextViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.vht_text);
        }

        public void setText(String text) {
            mTextView.setText(text);
        }

    }

}
