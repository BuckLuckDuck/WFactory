package com.example.worldfactory.activity.intro

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.worldfactory.R
import com.example.worldfactory.activity.login.LoginActivity
import com.example.worldfactory.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    private lateinit var viewPager: ViewPager2

    private var currentPageIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewpagerintro
        viewPager.adapter = PagerAdapterIntro(this)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position < 2)
                    binding.buttonNext.text = getString(R.string.next_label)
                else
                    binding.buttonNext.text = getString(R.string.lets_start_label)
            }
        })

        binding.buttonNext.setOnClickListener {
            if(currentPageIndex < 2){
                currentPageIndex = viewPager.currentItem

                viewPager.setCurrentItem(currentPageIndex, true)
                if(currentPageIndex == 2) binding.buttonNext.text = getString(R.string.lets_start_label)
                return@setOnClickListener
            }

            val intent = Intent(this@IntroActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.buttonSkip.setOnClickListener {
            val intent = Intent(this@IntroActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if(currentPageIndex > 0){
            currentPageIndex--
            viewPager.setCurrentItem(currentPageIndex, true)
            if(currentPageIndex < 2) binding.buttonNext.text = getString(R.string.next_label)
        } else {
            super.onBackPressed()
        }
    }
}