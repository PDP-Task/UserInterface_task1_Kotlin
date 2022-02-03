package com.example.lesson1_task1_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.button.MaterialButton
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {
    private lateinit var getBtn: MaterialButton
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var lottieAnim: LottieAnimationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titles = listOf(
            "Say Hello to\nGlobal Top-Up",
            "Say Hi to\nGlobal Top-Up",
            "Say Hello to\nGlobal Top-Up"
        )

        val des = listOf(
            "Say Hello to\nGlobal Top-Up, Global Top-Up",
            "Say Hi to\nGlobal Top-Up, Global Top-Up",
            "Say Hello to\nGlobal Top-Up, Global Top-Up"
        )

        viewPager = findViewById(R.id.view_pager_main)
        val dots = findViewById<DotsIndicator>(R.id.dots)
        lottieAnim = findViewById(R.id.lottie_anim)
        getBtn = findViewById(R.id.get_btn)
        viewPagerAdapter = ViewPagerAdapter(this, titles, des)
        viewPager.adapter = viewPagerAdapter
        dots.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                when (position) {
                    0 -> {
                        lottieAnim.setAnimation(R.raw.anim_1)
                        getBtn.visibility = View.GONE
                    }
                    1 -> {
                        lottieAnim.setAnimation(R.raw.anim_2)
                        getBtn.visibility = View.GONE
                    }
                    2 -> {
                        lottieAnim.setAnimation(R.raw.anim_3)
                        getBtn.visibility = View.VISIBLE
                    }
                }
                lottieAnim.playAnimation()
            }

            override fun onPageSelected(position: Int) {}

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}