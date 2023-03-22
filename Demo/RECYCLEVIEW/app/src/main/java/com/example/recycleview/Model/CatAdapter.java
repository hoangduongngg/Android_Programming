package com.example.recycleview.Model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview.R;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{
    private List<Cat> mList;

    public CatAdapter(List<Cat> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);


        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = mList.get(position);
        if (cat==null) {
            return;
        }

        holder.img.setImageResource(cat.getImg());
        holder.textView.setText(cat.getName());
    }

    @Override
    public int getItemCount() {
        if (mList!=null) {
            return mList.size();
        }
        return 0;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView textView;
        public CatViewHolder(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.img);
            textView = view.findViewById(R.id.tname);
        }
    }

}
