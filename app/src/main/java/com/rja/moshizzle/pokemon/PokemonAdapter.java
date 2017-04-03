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

    private List<String> mItems = new ArrayList<>();

    public void setItems(List<Pokemon> countries) {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CountryViewHolder.inflate(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof CountryViewHolder) {
            ((CountryViewHolder) holder).setText(mItems.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class CountryViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public static CountryViewHolder inflate(ViewGroup parent) {
            return new CountryViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_holder_pokemon, parent, false));
        }

        public CountryViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.vhp_text);
        }

        public void setText(String text) {
            mTextView.setText(text);
        }

    }

}
