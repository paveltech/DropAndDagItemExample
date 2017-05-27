package com.interfaceitems;

/**
 * Created by android on 5/27/2017.
 */

public interface ItemTouchHelperAdapter {

    /**
     * called when a item is draged for enough time to move or swipe
     */

    boolean onItemMove(int fromPosition , int toPosition);

    /**
     * called when a item is dismised when swipe
     */

    void onItemDismised(int position);
}
