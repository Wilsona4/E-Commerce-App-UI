package com.funcrib.weekthreetask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.funcrib.weekthreetask.R
import com.funcrib.weekthreetask.adapter.DebitCardPagerAdapter
import com.funcrib.weekthreetask.adapter.PartnersRvAdapter
import com.funcrib.weekthreetask.resources.DebitCards
import com.funcrib.weekthreetask.resources.Partners
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class ProductsFragment : Fragment() {

    private var partners = Partners()
    private val debitCards = DebitCards()

    private lateinit var viewPager: ViewPager2
    private lateinit var tabIndicator: TabLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerViewAdapter: PartnersRvAdapter
    private lateinit var viewPagerAdapter: DebitCardPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        /*Initialize layouts*/
        tabIndicator = view.findViewById(R.id.tab_layout)
        viewPager = view.findViewById(R.id.view_pager)
        recyclerView = view.findViewById(R.id.recycler_view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*Initialize and Load Debit Cards to ViewPager*/
        loadDebitCards()

        /*Initialize Recycler View*/
        initRecyclerView()
    }

    /*Method to Initialize and Load Debit Cards to ViewPager*/
    private fun loadDebitCards() {
        /*Instantiate Debit Card List*/
        val debitCards = debitCards.debitCardList

        /*Set-Up ViewPager Adapter*/
        viewPagerAdapter = DebitCardPagerAdapter(debitCards)
/*TODO comment later*/
        viewPager.apply {
            adapter = viewPagerAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 2
            setPadding(150, 0, 150, 0)
        }
/*TODO comment later*/
        val marginPageTransformer = MarginPageTransformer(30)
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(marginPageTransformer)
        compositePageTransformer.addTransformer { page, position ->
            page.scaleY = 1 - (0.25f * kotlin.math.abs(position))
        }

        viewPager.setPageTransformer(compositePageTransformer)


        /*Set-Up Dot Indicator*/
        TabLayoutMediator(tabIndicator, viewPager) { tab, position ->
            viewPager.setCurrentItem(tab.position, true)
        }.attach()
    }


    /*Initialize Recycler View and Set-up Adapter*/
    private fun initRecyclerView() {
        /*Instantiate Partners List*/
        val partnersList = partners.partnersList

        /*Initialize Layout Manager and Adapter*/
        layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAdapter = PartnersRvAdapter(partnersList)

        /*Set-Up RecyclerView Adapter*/
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerViewAdapter
    }

    companion object {
        /* Use this factory method to create a new instance of this fragment */
        fun newInstance() = ProductsFragment()
    }
}