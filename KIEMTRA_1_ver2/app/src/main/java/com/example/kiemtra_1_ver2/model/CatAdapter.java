package com.example.kiemtra_1_ver2.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kiemtra_1_ver2.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private Context context;
    private List<Cat> mList;
    private CatItemListener mCatItem;
    public CatAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }

    public void setClickListener (CatItemListener mCatItem) {
        this.mCatItem = mCatItem;
    }
    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Cat cat = mList.get(position);
        if (cat==null)
            return;
        holder.img.setImageResource(cat.getImg());
        holder.tvName.setText(cat.getName());
        holder.tvDescribe.setText(cat.getDes());
        holder.tvPrice.setText(cat.getPrice() + "");
        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mList.remove(mList.get(position));
                Toast.makeText(context.getApplicationContext(), "Remove successfully!", Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
            }
        });
    }



    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tvName, tvDescribe, tvPrice;
        private Button btRemove;

        public CatViewHolder(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.img);
            tvName = view.findViewById(R.id.txtName);
            tvDescribe = view.findViewById(R.id.txtDescribe);
            tvPrice = view.findViewById(R.id.txtPrice);
            btRemove = view.findViewById(R.id.btRemove);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mCatItem!=null) {
                mCatItem.onItemClick(view, getAdapterPosition());
            }
        }
    }

    public void add(Cat cat) {
        mList.add(cat);
        notifyDataSetChanged();
    }

    public void update (int position, Cat cat) {
        mList.set(position, cat);
        notifyDataSetChanged();
    }
    public interface CatItemListener {
        void onItemClick (View view, int position);
    }

    public Cat getItem (int position) {
        return mList.get(position);
    }




}
