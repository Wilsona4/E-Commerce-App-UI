package com.funcrib.weekthreetask.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.funcrib.weekthreetask.R
import com.funcrib.weekthreetask.model.DebitCardModel
import kotlinx.android.synthetic.main.debit_card_viewpager_item.view.*
import kotlinx.android.synthetic.main.fragment_products.view.*

class DebitCardPagerAdapter(private val debitCardList: ArrayList<DebitCardModel>) :
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
        holder.itemView.apply {
//            if (position == debitCardList.size - 2) {
//                view_pager.post(runnable)
//            }
            /*Get the list and its data at each position and instantiate them*/
            val debitCard = debitCardList[position]

            /*Set List Data to UI Views*/
            debit_card_name.text = debitCard.name
            debit_card_balance.text = debitCard.balance

            /*Safe Casting to return Color Red if null*/
            //debit_card.setBackgroundColor(debitCard.color)
            debit_card.backgroundTintList  = ColorStateList.valueOf(ContextCompat.getColor(this.context, debitCard.color))

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


//    private val runnable = Runnable {
//         fun run (){
//            debitCardList.addAll(debitCardList)
//             notifyDataSetChanged()
//        }
//    }

}