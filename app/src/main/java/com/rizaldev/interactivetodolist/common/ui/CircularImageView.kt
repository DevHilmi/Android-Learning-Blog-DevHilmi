package com.rizaldev.interactivetodolist.common.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.rizaldev.interactivetodolist.R


class CircularImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(getContext(), R.layout.view_circular_image, this)
    }

}
