package com.funcrib.weekthreetask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.funcrib.weekthreetask.R
import com.funcrib.weekthreetask.adapter.DebitCardPagerAdapter
import com.funcrib.weekthreetask.adapter.PartnersRvAdapter
import com.funcrib.weekthreetask.resources.DebitCards
import com.funcrib.weekthreetask.resources.Partners
import com.google.android.material.tabs.TabLayout

/*The fragment initialization parameters*/
private const val CURRENT = "param1"

/**
 * create an instance of this fragment.
 */
class SupportFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var current: String? = null
    lateinit var textView: TextView
    lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            current = it.getString(CURRENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_support, container, false)
        textView = view.findViewById(R.id.support_text)
        image = view.findViewById(R.id.support_image)

        /*Set Image and Text for corresponding Bottom Nav Item*/
        when (current) {
            "SUPPORT" -> {
                textView.text = "SUPPORT"
                image.setImageResource(R.drawable.help_image)
            }
            "PAYMENTS" -> {
                textView.text = "PAYMENTS"
                image.setImageResource(R.drawable.payments_image)
            }
            "HISTORY" -> {
                textView.text = "HISTORY"
                image.setImageResource(R.drawable.history_image)
            }
            "MORE" -> {
                textView.text = "MORE"
                image.setImageResource(R.drawable.more_image)
            }
            else -> {
                textView.text = "NULL"
                image.setImageResource(R.drawable.error_image)
            }
        }

        return view
    }

    companion object {
        /* Method to create a new instance of this fragment using the provided parameters */
        @JvmStatic
        fun newInstance(currentFrag: String) =
            SupportFragment().apply {
                arguments = Bundle().apply {
                    putString(CURRENT, currentFrag)

                }
            }
    }

}