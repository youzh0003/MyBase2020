package com.zhiyong.mybase2020.base

import android.content.Context
import androidx.fragment.app.Fragment
import java.lang.ClassCastException

abstract class BaseFragment: Fragment() {

    interface Listener {

    }
    private lateinit var mListener: Listener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = try{
            context as Listener
        }catch (e: ClassCastException){
            throw ClassCastException(
                "${context.toString()} must implement ${javaClass.simpleName}.Listener"
            )
        }
    }
}