package com.zhiyong.mybase2020.home

import com.zhiyong.mybase2020.base.BasePresenter
import com.zhiyong.mybase2020.base.BaseView

interface HomeContract {
    interface Presenter: BasePresenter
    interface View: BaseView<Presenter>
}