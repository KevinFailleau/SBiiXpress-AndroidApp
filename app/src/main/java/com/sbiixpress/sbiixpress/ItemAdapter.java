package com.sbiixpress.sbiixpress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter{
    ArrayList<Object> list;
    private static final int ITEM = 0;
    private static final int HEADER = 1;
    private LayoutInflater inflater;

    public ItemAdapter(Context context, ArrayList<Object> list)
    {
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position) instanceof MenuItems)
        {
            return ITEM;
        }
        else
        {
            return HEADER;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
        {
            switch(getItemViewType(i)){
                case ITEM:
                    view = inflater.inflate(R.layout.itemsmenu, null);
                    break;
                case HEADER:
                    view = inflater.inflate(R.layout.headermenu, null);
                    break;
            }
        }
        switch(getItemViewType(i)){
            case ITEM:
                TextView name =  (TextView) view.findViewById(R.id.item);
                name.setText(((MenuItems)list.get(i)).getName());
                break;
            case HEADER:
                TextView nameHeader = (TextView) view.findViewById(R.id.header);
                nameHeader.setText((String) list.get(i));
                break;
        }
        return view;

    }
}
