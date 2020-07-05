package com.zhiyong.mybase2020.base

interface BaseView<T: BasePresenter> {
    fun setPresenter(presenter: T)
}