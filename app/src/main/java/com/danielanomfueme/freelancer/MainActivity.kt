package com.danielanomfueme.freelancer

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var mPager: ViewPager

    var layouts: IntArray = intArrayOf(
        R.layout.first_slide,
        R.layout.second_slide,
        R.layout.third_slide,
        R.layout.fourth_slide,
        R.layout.fifth_slide
    )

    lateinit var dotsLayout: LinearLayout
    lateinit var dots: Array<ImageView>
    lateinit var mAdapter: PageAdapter

    lateinit var buttonNext : Button
    lateinit var buttonSkip : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (PrefManger(this).checkPreference())
        {
            loadHome()
        }

        if (Build.VERSION.SDK_INT >= 19)
        {
             window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        else    {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        setContentView(R.layout.activity_main)
        mPager = findViewById(R.id.slideviewpager)
        mAdapter = PageAdapter(layouts, this)
        mPager.adapter = mAdapter
        dotsLayout = findViewById(R.id.dots)
        buttonNext = findViewById(R.id.button_next)
        buttonSkip = findViewById(R.id.button_skip)
        buttonSkip.setOnClickListener(this)
        buttonNext.setOnClickListener(this)

        createDots(0)
        mPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                createDots(position)
                if (position == layouts.size - 1){
                    buttonNext.setText("Start")
                    buttonSkip.visibility = View.INVISIBLE
                }

                else    {
                    buttonNext.setText("Next")
                    buttonSkip.visibility = View.VISIBLE
                }

            }
        })
    }

    override fun onClick(v: View?) {
        when (v!!.id){
            R.id.button_skip -> {
                loadHome()
                PrefManger(this).writeSP()
            }
            R.id.button_next -> {
                loadNextSlide()
            }
        }
    }

    private fun loadNextSlide() {
        var nextSlide: Int = mPager.currentItem + 1
        if (nextSlide < layouts.size){
            mPager.setCurrentItem(nextSlide)
        }
        else    {
            loadHome()
            PrefManger(this).writeSP()
        }
    }

    private fun loadHome() {
        startActivity(Intent(this, SignUpActivity::class.java))
        finish()
    }

    fun createDots(position: Int) {
        if (dotsLayout != null) {
            dotsLayout.removeAllViews()
        }
        dots = Array(layouts.size, { i -> ImageView(this) })

        for (i in 0..layouts.size - 1) {
            dots[i] = ImageView(this)
            if (i == position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots))
            } else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive_dots))
            }

            var params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)

            params.setMargins(4,0,4,0)
            dotsLayout.addView(dots[i], params)

        }
    }


}