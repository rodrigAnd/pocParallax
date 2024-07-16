package com.fiap.pocparallax

import android.graphics.Canvas
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StackItemDecorator(private val overlapMargin: Int, private val maxElevation: Float) : RecyclerView.ItemDecoration() {
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount
        val itemCount = state.itemCount
        val layoutManager = parent.layoutManager as LinearLayoutManager

        val parentMidPoint = parent.top + parent.height / 2f

        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)

            if (position != RecyclerView.NO_POSITION) {
                val childMidPoint = (child.top + child.bottom) / 2f
                val distanceFromCenter = parentMidPoint - childMidPoint
                val scale = 1 - Math.min(Math.abs(distanceFromCenter) / parent.height, 0.5f)
                val elevation = maxElevation * (1 - Math.abs(distanceFromCenter) / parent.height)

                if (distanceFromCenter < 0) {
                    child.translationY = -overlapMargin * (1 - scale)
                } else {
                    child.translationY = overlapMargin * (1 - scale)
                }
                child.scaleX = scale
                child.scaleY = scale
                child.elevation = elevation
            }
        }
    }
}