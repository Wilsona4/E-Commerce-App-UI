package com.funcrib.weekthreetask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.funcrib.weekthreetask.R
import com.funcrib.weekthreetask.model.PartnersModel
import kotlinx.android.synthetic.main.partners_recycler_view_item.view.*

class PartnersRvAdapter(var partnersList: ArrayList<PartnersModel>) : RecyclerView.Adapter<PartnersRvAdapter.RecyclerViewHolder>() {

    /*Create the RecyclerView Holder*/
    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view)

    /*Create a view holder to display items*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.partners_recycler_view_item, parent, false)
        return RecyclerViewHolder(view)
    }

    /*Bind data to views and display the data at the specified position*/
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.itemView.apply {
            rvPartner.text = partnersList[position].name
            rvDiscount.text = partnersList[position].discount
            rvOffer.text = partnersList[position].merchandise
            rvImage.setImageResource(partnersList[position].image)
        }
    }

    /*Returns the total number of items in the data set held by the adapter*/
    override fun getItemCount(): Int {
        return partnersList.size
    }
}