package com.shellcore.android.collapsingtoolbar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shellcore.android.collapsingtoolbar.fillings.Cheese;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shell on 25/11/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    // Variables
    private List<Cheese> cheeses;
    private CheeseItemListener listener;

    public DataAdapter(List<Cheese> cheeses, CheeseItemListener listener) {
        this.cheeses = cheeses;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ingredient_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cheese cheese = cheeses.get(position);
        holder.imgCheese.setImageResource(cheese.getImage());
        holder.txtName.setText(cheese.getName());
        holder.cheese = cheese;
    }

    @Override
    public int getItemCount() {
        return cheeses.size();
    }

    public void removeItem(int position) {
        cheeses.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, cheeses.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Components
        @BindView(R.id.item_container)
        LinearLayout itemContainer;
        @BindView(R.id.img_cheese)
        ImageView imgCheese;
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.btn_add)
        Button btnAdd;

        // Variables
        public Cheese cheese;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.btn_add)
        public void addCheese() {
            if (listener != null) {
                listener.addCheese(cheese);
            }
        }

        @OnClick({R.id.item_container, R.id.txt_name, R.id.img_cheese})
        public void selectCheese() {
            if (listener != null) {
                listener.selectCheese(cheese);
            }
        }
    }
}
