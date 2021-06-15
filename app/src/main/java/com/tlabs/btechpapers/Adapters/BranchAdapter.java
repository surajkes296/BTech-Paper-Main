/*
 * Copyright 2020 Pratyush Tiwari
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created by Pratyush Tiwari on 31/1/21 7:35 PM
 *  Last modified 31/1/21 7:21 PM
 *
 *
 */

package com.tlabs.btechpapers.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tlabs.btechpapers.R;
import com.tlabs.btechpapers.Activity.Sem;

import java.util.List;

public class BranchAdapter extends RecyclerView.Adapter<BranchAdapter.ViewHolder> {
    private final LayoutInflater layoutInflater;
    private final List<String> cardText;
    private final List<Integer> drawable;
    final Context appContext;
    public BranchAdapter(Context context, List<String> cardText, List<Integer> drawable){
        this.layoutInflater=LayoutInflater.from(context);
        this.cardText =cardText;
        this.drawable =drawable;
        appContext=context;
    }

    @NonNull
    @Override
    public BranchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.card_design,parent,false);

        GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        params.height = (parent.getMeasuredHeight() / 2);
        view.setLayoutParams(params);
        return new BranchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BranchAdapter.ViewHolder holder, final int position) {

        final String branch= cardText.get(position);
        final Integer image= drawable.get(position);
        holder.cardTextView.setText(branch);
        holder.cardTextView.setCompoundDrawablesWithIntrinsicBounds(0,image,0,0);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(appContext, Sem.class);
                intent.putExtra("branch",branch);
                appContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardText.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final CardView cardView;
        final TextView cardTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView=itemView.findViewById(R.id.cardView);
            cardTextView =itemView.findViewById(R.id.cardTextView);
        }
    }
}