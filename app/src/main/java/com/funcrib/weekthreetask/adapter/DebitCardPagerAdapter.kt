package com.funcrib.weekthreetask.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.funcrib.weekthreetask.R
import com.funcrib.weekthreetask.model.DebitCardModel
import kotlinx.android.synthetic.main.debit_card_viewpager_item.view.*
import kotlinx.android.synthetic.main.fragment_products.view.*

class DebitCardPagerAdapter(private val debitCardList: ArrayList<DebitCardModel>, private val viewPager: ViewPager2) :
    RecyclerView.Adapter<DebitCardPagerAdapter.PagerViewHolder>() {

    /*Create the RecyclerView Holder*/
    class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    /*Create a view holder to display items*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.debit_card_viewpager_item, parent, false)
        return PagerViewHolder(view)
    }

    /*Create a view holder to display items*/
    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        /*Implementing Runnable loop for infinite View Pager*/
        if (position == debitCardList.size - 2) {
            viewPager.post(runnable())
        }
        holder.itemView.apply {

            /*Get the list and its data at each position and instantiate them*/
            val debitCard = debitCardList[position]

            /*Set List Data to UI Views*/
            debit_card_name.text = debitCard.name
            debit_card_balance.text = debitCard.balance

            debit_card.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this.context, debitCard.color))

            setOnClickListener {
                Toast.makeText(
                    context,
                    "${debitCard.name} has a Balance of $${debitCard.balance}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    /*Returns the total number of items in the data set held by the adapter*/
    override fun getItemCount(): Int {
        return debitCardList.size
    }


    private fun runnable() = Runnable {
        debitCardList.addAll(debitCardList)
        notifyDataSetChanged()
    }

}