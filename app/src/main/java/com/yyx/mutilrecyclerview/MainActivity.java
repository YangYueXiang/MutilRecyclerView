package com.yyx.mutilrecyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yyx.mutilrecyclerview.adapter.GridProgramAdapter;
import com.yyx.mutilrecyclerview.adapter.ProgramAdapter;
import com.yyx.mutilrecyclerview.bean.DataBean;
import com.yyx.mutilrecyclerview.utils.ViewPagerUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpProgram;
    private ImageView ivProgramRight;
    private ImageView ivProgramLeft;
    private List<DataBean> list;
    private ProgramAdapter programAdapter;
    private List<GridView> gridViews;
    private int allpage;
    private LinearLayout layout_indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vpProgram = findViewById(R.id.vp_program);
        ivProgramRight = findViewById(R.id.iv_program_right);
        ivProgramLeft = findViewById(R.id.iv_program_left);
        layout_indicator = findViewById(R.id.layout_indicator);
        //清空indocator
        layout_indicator.removeAllViews();
        initData();
        //得到总页数
        allpage=list.size()/8;
       if (list.size()%8!=0){
           allpage=list.size()/8+1;
       }
        programAdapter = new ProgramAdapter(getContext(), list);
        vpProgram.setAdapter(programAdapter);
        vpProgram.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for (int i = 0; i < 5; i++) {
                    int childCount = layout_indicator.getChildCount();
                    if (childCount > 0) {
                        View view = layout_indicator.getChildAt(i);
                        if (i == position)
                            view.setBackgroundResource(R.drawable.view1);
                        else
                            view.setBackgroundResource(R.drawable.view2);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置indicator
        ViewPagerUtils.setIndicator(this, 5, layout_indicator);

        ivProgramLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = vpProgram.getCurrentItem();
                if (currentItem > 0) {
                    currentItem--;
                }
                vpProgram.setCurrentItem(currentItem);
            }
        });
        ivProgramRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem1 = vpProgram.getCurrentItem();
                if (currentItem1 < allpage) {
                    currentItem1++;
                }
                vpProgram.setCurrentItem(currentItem1);
            }
        });
    }

    private void initData() {
        gridViews = new ArrayList<>();
        list = new ArrayList<>();
        list.add(new DataBean(1,"视频1",3,R.drawable.picture));
        list.add(new DataBean(2,"相册1",1,R.drawable.picture));
        list.add(new DataBean(3,"视频1",3,R.drawable.picture));
        list.add(new DataBean(4,"相册1",1,R.drawable.picture));
        list.add(new DataBean(5,"视频1",3,R.drawable.picture));
        list.add(new DataBean(6,"图片1",2,R.drawable.picture));
        list.add(new DataBean(7,"视频1",3,R.drawable.picture));
        list.add(new DataBean(8,"图片1",2,R.drawable.picture));

        list.add(new DataBean(9,"视频2",3,R.drawable.picture));
        list.add(new DataBean(10,"图片2",2,R.drawable.picture));
        list.add(new DataBean(11,"视频2",3,R.drawable.picture));
        list.add(new DataBean(1,"视频2",3,R.drawable.picture));
        list.add(new DataBean(2,"相册2",1,R.drawable.picture));
        list.add(new DataBean(3,"视频2",3,R.drawable.picture));
        list.add(new DataBean(4,"相册2",1,R.drawable.picture));
        list.add(new DataBean(5,"视频2",3,R.drawable.picture));

        list.add(new DataBean(6,"图片3",2,R.drawable.picture));
        list.add(new DataBean(7,"视频3",3,R.drawable.picture));
        list.add(new DataBean(8,"图片3",2,R.drawable.picture));
        list.add(new DataBean(9,"视频3",3,R.drawable.picture));
        list.add(new DataBean(10,"图片3",2,R.drawable.picture));
        list.add(new DataBean(11,"视频3",3,R.drawable.picture));
        list.add(new DataBean(1,"视频3",3,R.drawable.picture));
        list.add(new DataBean(2,"相册3",1,R.drawable.picture));

        list.add(new DataBean(3,"视频4",3,R.drawable.picture));
        list.add(new DataBean(4,"相册4",1,R.drawable.picture));
        list.add(new DataBean(5,"视频4",3,R.drawable.picture));
        list.add(new DataBean(6,"图片4",2,R.drawable.picture));
        list.add(new DataBean(7,"视频4",3,R.drawable.picture));
        list.add(new DataBean(8,"图片4",2,R.drawable.picture));
        list.add(new DataBean(9,"视频4",3,R.drawable.picture));
        list.add(new DataBean(10,"图片4",2,R.drawable.picture));

        list.add(new DataBean(11,"视频5",3,R.drawable.picture));

    }


    private Context getContext(){
        return this;
    }
}
