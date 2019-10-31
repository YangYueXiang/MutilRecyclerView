package com.yyx.mutilrecyclerview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.yyx.mutilrecyclerview.MyGridView;
import com.yyx.mutilrecyclerview.R;
import com.yyx.mutilrecyclerview.bean.DataBean;

import java.util.ArrayList;
import java.util.List;

public class ProgramAdapter extends PagerAdapter {
    private Context context;
    private List<DataBean> list;

    public ProgramAdapter(Context context, List<DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
//        int count = list.size() / 8;
//        if (list.size() % 8 > 0) {
//            count++;
//        }
        final int count = (int) Math.ceil(list.size() / 8.0f);
        return count;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        View inflate = View.inflate(context, R.layout.view_vp_program_item, null);
        int start = 0;
        int end = 0;
        MyGridView gvProgram = inflate.findViewById(R.id.gv_program);

        start = (position * 8);
        end = (position * 8) + 8;

        List<DataBean> pageList = new ArrayList<>();
        for (int i = start; i < end && i < list.size(); i++) {
            pageList.add(list.get(i));
        }
        GridProgramAdapter gridProgramAdapter = new GridProgramAdapter(context, pageList);
        gvProgram.setAdapter(gridProgramAdapter);
        container.addView(inflate);
        return inflate;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
