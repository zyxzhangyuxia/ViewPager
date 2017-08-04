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
 * @CreateDate: 2017/8/2 14:04
 * @Description: 首页-家医 标签
 */

public class FamilyDocFragment extends BaseFragment {

    String text;

    public FamilyDocFragment(){}


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_family_doc_layout,container,false);
        TextView tv_content = view.findViewById(R.id.tv_family_content);
//        tv_content.setText(text);
        return view;
    }
}
