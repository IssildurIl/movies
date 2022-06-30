package com.iish.movies.recyclerview.decorators

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CustomItemDecorator: RecyclerView.ItemDecoration() {

    var sidePadding = 0
    var topPadding = 0

    fun recyclerDecoration(sidePadding: Int, topPadding: Int) {
        this.sidePadding = sidePadding
        this.topPadding = topPadding
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = topPadding;
        outRect.top = topPadding;
        outRect.left = sidePadding;
        outRect.right = sidePadding;
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }


}