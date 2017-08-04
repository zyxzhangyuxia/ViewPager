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
 * @CreateDate: 2017/8/1 17:41
 * @Description: 首页-健康 标签
 */

public class HealthyFragment extends BaseFragment {

    private String text;
    public HealthyFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_healthy_layout,container,false);
        TextView tv_content = view.findViewById(R.id.tv_healthy_content);
//        tv_content.setText(text);
        return view;
    }
}
