package com.zhiyong.mybase2020.adapter

import androidx.core.view.ViewPropertyAnimatorCompat
import androidx.recyclerview.widget.RecyclerView
import com.zhiyong.mybase2020.base.BaseItemAnimator

class FadeAnimator : BaseItemAnimator() {
    override fun addAnimationInit(holder: RecyclerView.ViewHolder?) {
        holder?.let {
            it.itemView.alpha = 0f
        }
    }

    override fun addAnimationCancel(holder: RecyclerView.ViewHolder?) {
        holder?.let {
            it.itemView.alpha = 1f
        }
    }

    override fun setAddAnimation(
        holder: RecyclerView.ViewHolder?,
        animator: ViewPropertyAnimatorCompat?
    ) {
        animator?.alpha(1f)
    }

    override fun oldChangeAnimationEnd(holder: RecyclerView.ViewHolder?) {
        holder?.let {
            it.itemView.alpha = 1f
        }
    }

    override fun removeAnimationEnd(holder: RecyclerView.ViewHolder?) {
        holder?.let {
            it.itemView.alpha = 1f
        }
    }

    override fun newChangeAnimationInit(holder: RecyclerView.ViewHolder?) {
        holder?.let {
            it.itemView.alpha = 0f
        }
    }

    override fun setOldChangeAnimation(
        holder: RecyclerView.ViewHolder?,
        animator: ViewPropertyAnimatorCompat?
    ) {
        animator?.alpha(0f)
    }

    override fun setNewChangeAnimation(
        holder: RecyclerView.ViewHolder?,
        animator: ViewPropertyAnimatorCompat?
    ) {
        animator?.alpha(1f)
    }

    override fun setRemoveAnimation(
        holder: RecyclerView.ViewHolder?,
        animator: ViewPropertyAnimatorCompat?
    ) {
        animator?.alpha(0f)
    }

    override fun newChangeAnimationEnd(holder: RecyclerView.ViewHolder?) {
        holder?.let {
            it.itemView.alpha = 0f
        }
    }
}