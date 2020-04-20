package com.example.matrixtrader.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matrixtrader.R;
import com.example.matrixtrader.helper.StringHelper;
import com.example.matrixtrader.model.Item;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AccountAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Item> itemList = new ArrayList<>();
    private Double totalAmount = 0.0;

    private final int TYPE_HEADER = 0;
    private final int TYPE_ITEM = 1;
    private final int TYPE_TOTAL = 2;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case TYPE_HEADER:
                view = inflater.inflate(R.layout.row_header, parent, false);
                viewHolder = new HeaderViewHolder(view);
                break;

            case TYPE_ITEM:
                view = inflater.inflate(R.layout.row_item, parent, false);
                viewHolder = new ItemViewHolder(view);
                break;

            case TYPE_TOTAL:
                view = inflater.inflate(R.layout.row_total, parent, false);
                viewHolder = new TotalViewHolder(view);
                break;
        }

        return viewHolder;
    }

    public AccountAdapter(ArrayList<Item> list ){
        this.itemList = list;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0){
            return TYPE_HEADER;
        }
        else if (position == itemList.size() + 1){
            return TYPE_TOTAL;
        }
        else{
            return TYPE_ITEM;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == TYPE_HEADER){
           return;
        }

        if (holder.getItemViewType() == TYPE_ITEM){
            Item item = itemList.get(position - 1);
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.symbolTextView.setText(item.getSymbol());
            itemViewHolder.quantityTextView.setText(StringHelper.instance().amountFormat(item.getQty_T2()));
            itemViewHolder.priceTextView.setText(StringHelper.instance().amountFormat(item.getLastPx()));
            Double amount = item.getQty_T2()*item.getLastPx();
            itemViewHolder.amountTextView.setText(StringHelper.instance().amountFormat(amount));
            totalAmount +=  amount;
        }

        if (holder.getItemViewType() == TYPE_TOTAL){
            TotalViewHolder totalViewHolder = (TotalViewHolder) holder;
            totalViewHolder.totalAmountTextView.setText(StringHelper.instance().amountFormat(totalAmount));
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size() + 2;
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder{

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        private TextView symbolTextView;
        private TextView quantityTextView;
        private TextView priceTextView;
        private TextView amountTextView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            symbolTextView = itemView.findViewById(R.id.symbolTextView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            amountTextView = itemView.findViewById(R.id.amountTextView);
        }
    }

    public static class TotalViewHolder extends RecyclerView.ViewHolder{
        private TextView totalAmountTextView;

        public TotalViewHolder(@NonNull View itemView) {
            super(itemView);
            totalAmountTextView = itemView.findViewById(R.id.totalAmountTextView);
        }
    }
}
