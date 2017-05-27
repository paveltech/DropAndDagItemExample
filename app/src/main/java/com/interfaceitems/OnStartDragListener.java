package com.interfaceitems;

import android.support.v7.widget.RecyclerView;

/**
 * Created by android on 5/27/2017.
 */

public interface OnStartDragListener {

    /**
     * called when a view is requesting a start of drag
     */

    void onStartDrag(RecyclerView.ViewHolder viewHolder);
}
