package com.example.android.dropanddagitemexample;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.interfaceitems.ItemTouchHelperAdapter;
import com.interfaceitems.ItemTouchHelperViewHolder;
import com.interfaceitems.OnStartDragListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by android on 5/27/2017.
 */

public class RecycleListAdapter extends RecyclerView.Adapter<RecycleListAdapter.ItemViewHolder> implements ItemTouchHelperAdapter{


    public final List<String> stringList = new ArrayList<>();
    public final OnStartDragListener onStartDragListener;
    public Context context;


    public RecycleListAdapter(Context context , OnStartDragListener onStartDragListener){
        this.context = context;
        this.onStartDragListener = onStartDragListener;

        stringList.addAll(Arrays.asList(context.getResources().getStringArray(R.array.dummy_items)));
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_main , parent , false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.textView.setText(stringList.get(position));
        holder.imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN){
                    onStartDragListener.onStartDrag(holder);
                }

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(stringList , fromPosition , toPosition);
        notifyItemMoved(fromPosition , toPosition);
        return false;
    }

    @Override
    public void onItemDismised(int position) {
        stringList.remove(position);
        notifyItemRemoved(position);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder{


        public TextView textView;
        public ImageView imageView;


        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_1);
            imageView = (ImageView) itemView.findViewById(R.id.handle_1);
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.YELLOW);
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }
}
