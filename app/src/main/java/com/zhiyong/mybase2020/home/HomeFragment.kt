package com.zhiyong.mybase2020.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zhiyong.mybase2020.R
import com.zhiyong.mybase2020.adapter.FadeAnimator
import com.zhiyong.mybase2020.base.BaseFragment
import com.zhiyong.mybase2020.model.TestData
import com.zhiyong.mybase2020.modelview.TestModel
import com.zhiyong.mybase2020.utils.DateUtils
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: BaseFragment(), HomeContract.View, TestModel.Listener {

    private val TAG = javaClass.simpleName

    interface Listener {

    }

    lateinit var controller: TestController

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerview()
        var index = 0
        tvAdd.setOnClickListener{
            controller.addData(TestData(DateUtils.currentTimeMillis.toString(), "Added data ${index++}"))
        }
    }

    private fun initRecyclerview() {
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rvTest)
        controller = TestController(this).apply {
            addModelBuildListener{
                val pos = recyclerView?.adapter?.itemCount?: -1
                if(pos > 1){
                    recyclerView?.smoothScrollToPosition(pos)
                }
            }
        }
        recyclerView?.apply {
            adapter = controller.adapter
            itemAnimator = FadeAnimator()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun setPresenter(presenter: HomeContract.Presenter) {
        TODO("Not yet implemented")
    }

    override fun longClickItem(id: String) {
        controller.removeData(id)
    }
}