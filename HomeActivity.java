package com.bsky.bskyresident.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.bsky.bskyresident.R;
import com.bsky.bskyresident.base.BaseActivity;
import com.bsky.bskyresident.home.fragment.FamilyDocFragment;
import com.bsky.bskyresident.home.fragment.HealthyFragment;
import com.bsky.bskyresident.home.fragment.MessageFragment;
import com.bsky.bskyresident.home.fragment.MineFragment;
import com.bsky.bskyresident.home.fragment.ServiceFragment;
import com.bsky.utilkit.lib.Pair;
import com.bsky.utilkit.lib.utils.LogUtil;


import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @CopyRight: This is my copyright.
 * @Author: vectoria
 * @CreateDate: 2017/8/1 16:40
 * @Description: 用户端首页
 */

public class ResidentHomeActivity extends BaseActivity {

    private ViewPager viewpager;
    private TabLayout tabLayout;
    private HomeAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * UI 初始化
     */
    private void initView(){
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        List<Pair<String,Integer,Fragment>> pairList = initData();
        adapter = new HomeAdapter(getSupportFragmentManager(),this, pairList);
        viewpager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewpager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                LogUtil.d(LogUtil.TAG_VECTORIA,"onTabSelected"+tab.getText());
                viewpager.setCurrentItem(tab.getPosition());
                tab.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                LogUtil.d(LogUtil.TAG_VECTORIA,"onTabUnselected"+tab.getText());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * 内容定制化
     */
    private List<Pair<String,Integer,Fragment>> initData(){
        List<Pair<String,Integer,Fragment>> pairList = new ArrayList<>();
        pairList.add(new Pair<String,Integer,Fragment>(
                getResourceString(R.string.tab_familydoc),R.drawable.nim_emoji_icon,new FamilyDocFragment()));
        pairList.add(new Pair<String,Integer,Fragment>(
                getResourceString(R.string.tab_healthy), R.drawable.nim_emoji_icon,new HealthyFragment()));
        pairList.add(new Pair<String,Integer, Fragment>(
                getResourceString(R.string.tab_service), R.drawable.nim_emoji_icon,new ServiceFragment()));
        pairList.add(new Pair<String,Integer, Fragment>(
                getResourceString(R.string.tab_message), R.drawable.nim_emoji_icon,new MessageFragment()));
        pairList.add(new Pair<String,Integer, Fragment>(
                getResourceString(R.string.tab_mine), R.drawable.nim_emoji_icon,new MineFragment()));
        return pairList;
    }

}
