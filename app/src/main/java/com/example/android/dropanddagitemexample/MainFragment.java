package com.example.android.dropanddagitemexample;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by android on 5/27/2017.
 */

public class MainFragment extends ListFragment {

    public interface OnListItemClickLisener{
        void onListClick(int position);
    }

    public OnListItemClickLisener onListItemClickLisener;

    public MainFragment(){}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onListItemClickLisener = (OnListItemClickLisener) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final String[] items = getResources().getStringArray(R.array.test);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity() , android.R.layout.simple_list_item_1 , items);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        onListItemClickLisener.onListClick(position);
    }
}
