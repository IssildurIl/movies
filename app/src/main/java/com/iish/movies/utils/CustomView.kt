package com.iish.movies.utils

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iish.movies.R
import com.iish.movies.recyclerview.CinemaListAdapter
import com.iish.movies.recyclerview.decorators.CustomItemDecorator


class CustomView(context: Context, @Nullable attrs: AttributeSet) : LinearLayout(context, attrs) {

    private var view : View = LayoutInflater.from(context).inflate(R.layout.cinema_list, this, true)

    fun setRv(cinemaAdapter: CinemaListAdapter, customItemDecorator: CustomItemDecorator) {
        view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            adapter = cinemaAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            customItemDecorator.recyclerDecoration(10, 10)
            addItemDecoration(customItemDecorator)
        }
    }

    fun setSectorName(name: String) {
        view.findViewById<TextView>(R.id.section_name).text = name
    }

    fun setClickableSpan(){
        val spannableText = view.findViewById<TextView>(R.id.spannable)
        val ss = SpannableString("еще..")
        val clickableSpanLogic: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                //startActivity(Intent(this@MyActivity, NextActivity::class.java))
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                //ds.isUnderlineText = false
            }
        }
        ss.setSpan(clickableSpanLogic, 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableText.text = ss
        spannableText.movementMethod = LinkMovementMethod.getInstance()
        spannableText.highlightColor = Color.TRANSPARENT
    }
}