package com.yyx.mutilrecyclerview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yyx.mutilrecyclerview.R;
import com.yyx.mutilrecyclerview.bean.DataBean;

import java.util.List;

public class GridProgramAdapter extends BaseAdapter {
    private Context context;
    private List<DataBean> list;

    public GridProgramAdapter(Context context, List<DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        DataBean dataBean = list.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            int type = dataBean.getType();
            switch (type) {
                case 1:
                    convertView = View.inflate(context, R.layout.view_gv_pictures_item, null);
                    holder.tvFileName = convertView.findViewById(R.id.tv_pictures_name);
                    holder.ivFilePicture = convertView.findViewById(R.id.iv_pictures_one);
                    break;
                case 2:
                    convertView = View.inflate(context, R.layout.view_gv_picture_item, null);
                    holder.tvFileName = convertView.findViewById(R.id.tv_picture_name);
                    holder.ivFilePicture = convertView.findViewById(R.id.iv_picture);
                    break;
                case 3:
                    convertView = View.inflate(context, R.layout.view_gv_video_item, null);
                    holder.tvFileName = convertView.findViewById(R.id.tv_video_name);
                    holder.ivFilePicture = convertView.findViewById(R.id.iv_video_picture);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String picturesName = dataBean.getName();
        int imageResource = dataBean.getImageResource();
        int type = dataBean.getType();
        switch (type) {
            case 1:
                holder.tvFileName.setText(picturesName);
                holder.ivFilePicture.setImageResource(R.drawable.picture);
                break;
            case 2:
                holder.tvFileName.setText(picturesName);
                holder.ivFilePicture.setImageResource(R.drawable.picture);
                break;
            case 3:
                holder.tvFileName.setText(picturesName);
                holder.ivFilePicture.setImageResource(R.drawable.picture);
                break;
        }

        return convertView;
    }

    static class ViewHolder {
        TextView tvFileName;
        ImageView ivFilePicture;
    }
}
