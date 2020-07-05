package com.zhiyong.mybase2020.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhiyong.mybase2020.R
import com.zhiyong.mybase2020.base.BaseFragment

class HomeFragment: BaseFragment(), HomeContract.View {

    interface Listener {

    }

    companion object{
        @JvmStatic
        fun newInstance(): HomeFragment{
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = layoutInflater.inflate(R.layout.fragment_home, container, false)
        return v
    }
    override fun setPresenter(presenter: HomeContract.Presenter) {
        TODO("Not yet implemented")
    }
}