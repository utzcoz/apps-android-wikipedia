package org.wikipedia.suggestededits

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.view_suggested_edits_task_item.view.*
import org.wikipedia.R

internal class SuggestedEditsTaskView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : LinearLayout(context, attrs, defStyle) {

    init {
        View.inflate(context, R.layout.view_suggested_edits_task_item, this)
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun setUpViews(task: SuggestedEditsTask, callback: Callback?) {
        image.setImageDrawable(task.imageDrawable)
        title.text = task.title
        description.text = task.description
        addContainer.setOnClickListener {
            if (!task.disabled) {
                callback?.onViewClick(task, false)
            }
        }
        translateContainer.setOnClickListener {
            if (!task.disabled) {
                callback?.onViewClick(task, true)
            }
        }
    }

    interface Callback {
        fun onViewClick(task: SuggestedEditsTask, isTranslate: Boolean)
    }
}
