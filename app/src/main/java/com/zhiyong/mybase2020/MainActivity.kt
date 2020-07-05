package com.zhiyong.mybase2020

import android.os.Bundle
import com.zhiyong.mybase2020.base.BaseActivity
import com.zhiyong.mybase2020.base.BaseFragment
import com.zhiyong.mybase2020.home.HomeFragment

class MainActivity : BaseActivity(),
    BaseFragment.Listener,
    HomeFragment.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(HomeFragment.newInstance())
    }
}
