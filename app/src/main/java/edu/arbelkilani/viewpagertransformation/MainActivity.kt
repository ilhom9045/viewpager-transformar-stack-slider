package edu.arbelkilani.viewpagertransformation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this)[MainActivityViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewpager2 = findViewById<ViewPager2>(R.id.viewpager).apply {
            this.adapter = PhotosAdapter(listOfPhotos(), this@MainActivity)
            offscreenPageLimit = 4
            setPageTransformer(SliderTransformer(4))
        }

        viewModel.cardFragmentHeight.observe(this) {
            val layoutParams =
                ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_PARENT,
                    (it*1.1).toInt()
                )
            viewpager2.layoutParams = layoutParams
        }
    }
}