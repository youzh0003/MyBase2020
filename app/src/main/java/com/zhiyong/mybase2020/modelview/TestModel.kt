package com.zhiyong.mybase2020.modelview

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.zhiyong.mybase2020.R
import com.zhiyong.mybase2020.base.KotlinHolder
import com.zhiyong.mybase2020.model.TestData

@EpoxyModelClass(layout = R.layout.item_test)
abstract class TestModel: EpoxyModelWithHolder<TestModel.TestHolder>() {

    interface Listener{
        fun longClickItem(id: String)
    }

    @EpoxyAttribute
    lateinit var listener: Listener

    @EpoxyAttribute
    lateinit var testData: TestData

    override fun bind(holder: TestHolder) {
        holder.tvText.text = testData.text
        holder.itemView.setOnLongClickListener {
            listener.longClickItem(testData.id)
            true
        }
    }

    override fun unbind(holder: TestHolder) {
        super.unbind(holder)
        holder.itemView.setOnLongClickListener(null)
    }

    inner class TestHolder: KotlinHolder(){
        val itemView by bind<ConstraintLayout>(R.id.parentLayout)
        val tvText by bind<TextView>(R.id.tvText)
    }
}