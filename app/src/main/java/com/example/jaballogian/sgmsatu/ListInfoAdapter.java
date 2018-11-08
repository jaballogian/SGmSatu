package com.example.jaballogian.sgmsatu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListInfoAdapter extends BaseAdapter {

    private List<ListInfo> mListInfo;
    private Activity mContext;

    public ListInfoAdapter (Activity context, List<ListInfo> listsInfo){

        mListInfo = listsInfo;
        mContext = context;
    }

    private class ViewHolder{

        //ImageView imageGambar;
        TextView textJudul, textIsi;
    }

    @Override
    public View getView(int position, View view, ViewGroup container){

        if(view == null){

            view = LayoutInflater.from(mContext).inflate(R.layout.list_info, container, false);
        }

        ViewHolder viewHolder = (ViewHolder) view.getTag();
        if(viewHolder == null){

            viewHolder = new ViewHolder();
            //viewHolder.imageGambar = view.findViewById(R.id.gambarImageViewListInfo);
            viewHolder.textJudul = view.findViewById(R.id.judulTextViewListInfo);
            viewHolder.textIsi = view.findViewById(R.id.isiTextViewListInfo);
            view.setTag(viewHolder);
        }

        //viewHolder.imageGambar.setImageDrawable(mListInfo.get(position));
        viewHolder.textJudul.setText(mListInfo.get(position).getJudul());
        viewHolder.textIsi.setText(mListInfo.get(position).getIsi());

        return view;
    }

    @Override
    public int getCount() {

        if(mListInfo != null){

            return mListInfo.size();
        }
        else {

            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return mListInfo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
