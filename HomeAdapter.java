package com.bsky.bskyresident.home;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bsky.utilkit.lib.Pair;

import java.util.List;

/**
 * @CopyRight: This is my copyright.
 * @Author: vectoria
 * @CreateDate: 2017/8/3 15:37
 * @Description:
 */

public class HomeAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private List<Pair<String,Integer,Fragment>> pairList;

    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }

    public HomeAdapter(FragmentManager fm, Context context,List<Pair<String,Integer,Fragment>> pairList){
        super(fm);
        this.context = context;
        this.pairList = pairList;
    }

    @Override
    public Fragment getItem(int position) {
        return pairList.get(position).fragment;
    }

    @Override
    public int getCount() {
        return pairList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pairList.get(position).title;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }

    public View getTabView(int position){
        View view = LayoutInflater.from(context).inflate(com.bsky.utilkit.lib.R.layout.item_tab_layout, null);
        TextView tv= (TextView) view.findViewById(com.bsky.utilkit.lib.R.id.tv_tab);
        ImageView img = (ImageView) view.findViewById(com.bsky.utilkit.lib.R.id.iv_tab);
        tv.setText(pairList.get(position).title);
        img.setImageResource(pairList.get(position).icon);
        return view;
    }
}
