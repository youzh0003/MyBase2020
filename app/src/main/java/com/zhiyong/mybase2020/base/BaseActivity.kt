package com.zhiyong.mybase2020.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.zhiyong.mybase2020.R

open class BaseActivity : AppCompatActivity() {


    protected fun replaceFragment(newFragment: Fragment) {

        replaceFragment(newFragment, R.anim.slide_in_right,
            R.anim.slide_out_left, R.anim.pop_in_from_left,
            R.anim.pop_out_to_right)
    }

    private fun replaceFragment(newFragment: Fragment, animIn: Int, animOut: Int, popIn: Int, popOut: Int) {

        val fm = supportFragmentManager

        val transaction = fm.beginTransaction()
        val backStateName = newFragment.javaClass.name

        transaction.setCustomAnimations(animIn, animOut, popIn, popOut)

        val oldFragment = fm.findFragmentById(R.id.container)

        if (oldFragment != null) {
            // avoid loadingDialog same fragment twice
            if (oldFragment.javaClass.name.equals(newFragment.javaClass.name, ignoreCase = true)) {


            } else {
                transaction.add(R.id.container, newFragment, backStateName)
                transaction.hide(oldFragment)
            }
        } else {
            transaction.add(R.id.container, newFragment, backStateName)
        }

        transaction.addToBackStack(backStateName)
        transaction.commit()
        fm.executePendingTransactions()
    }
}