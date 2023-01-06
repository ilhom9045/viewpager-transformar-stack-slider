package edu.arbelkilani.viewpagertransformation

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso

class ViewPagerFragment : Fragment(R.layout.item_photo) {

    private val viewModel by lazy { ViewModelProvider(requireActivity())[MainActivityViewModel::class.java] }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardView: CardView = view.findViewById(R.id.cardView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val locationTextView: TextView = view.findViewById(R.id.locationTextView)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        val item = arguments?.getSerializable(DATA) as Photo

        locationTextView.text = item.credit.alias
        titleTextView.text = item.credit.name

        Picasso.get()
            .load(item.url)
            .into(imageView)

        viewModel.setFragmentHeight(cardView.height)
    }

    companion object {

        private const val DATA = "DATA"

        fun newInstance(data: Photo): ViewPagerFragment {
            val args = Bundle()
            args.putSerializable(DATA, data)
            val fragment = ViewPagerFragment()
            fragment.arguments = args
            return fragment
        }
    }
}