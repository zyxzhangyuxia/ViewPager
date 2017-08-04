package com.bsky.bskyresident.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bsky.bskyresident.R;
import com.bsky.bskyresident.base.BaseFragment;

/**
 * @CopyRight: This is my copyright.
 * @Author: vectoria
 * @CreateDate: 2017/8/2 14:06
 * @Description: 首页-我的 标签
 */

public class MineFragment extends BaseFragment {

    private String text;

    public MineFragment(){}


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_layout,container,false);
        TextView tv_content = view.findViewById(R.id.tv_mine_content);
//        tv_content.setText(text);
        return view;
    }
}
