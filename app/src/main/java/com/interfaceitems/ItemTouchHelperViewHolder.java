package com.interfaceitems;

/**
 * Created by android on 5/27/2017.
 */

public interface ItemTouchHelperViewHolder {

    /**
     * called when the first regester and item as being or swiped
     */

    void onItemSelected();

    /**
     * called when the item has complited the move or swipe
     */

    void onItemClear();
}
