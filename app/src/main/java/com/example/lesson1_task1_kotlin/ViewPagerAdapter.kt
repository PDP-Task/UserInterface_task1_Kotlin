package com.example.lesson1_task1_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class ViewPagerAdapter(
    private val context: Context,
    private val titles: List<String>,
    private val descriptions: List<String>
): PagerAdapter(){

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater.inflate(R.layout.item_layout, container, false)
        view.findViewById<TextView>(R.id.text_title).text = titles[position]
        view.findViewById<TextView>(R.id.text_description).text = descriptions[position]

        (container as ViewPager).addView(view)

        return view
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewpager = container as ViewPager
        val view = `object` as View
        viewpager.removeView(view)
    }
}