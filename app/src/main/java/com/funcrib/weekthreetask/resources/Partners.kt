package com.funcrib.weekthreetask.resources

import com.funcrib.weekthreetask.R
import com.funcrib.weekthreetask.model.PartnersModel

class Partners {

    val partnersList = initPartnersList()

    /*Initialize Partners List*/
    private fun initPartnersList(): ArrayList<PartnersModel> {
        val list = ArrayList<PartnersModel>()

        /*Add Partners to List*/
        list.add(PartnersModel("AliExpress", "from 4%", "Clothes and shoes", R.drawable.ic_shopping_bag_red))
        list.add(PartnersModel("Aviasales", "from 4.8%", "Tickets and travels", R.drawable.ic_shopping_bag_blue))
        list.add(PartnersModel("Bookgram", "from 5.6%", "Booking and Scheduling", R.drawable.ic_shopping_bag_red))
        list.add(PartnersModel("IbomAir", "from 9%", "Transport", R.drawable.ic_shopping_bag_blue))
        list.add(PartnersModel("SkyNet", "from 3.5%", "Tech", R.drawable.ic_shopping_bag_red))
        list.add(PartnersModel("Jumia", "from 3.8%", "Clothes and shoes", R.drawable.ic_shopping_bag_blue))
        list.add(PartnersModel("Slot", "from 9%", "Mobile Phones", R.drawable.ic_shopping_bag_red))
        list.add(PartnersModel("Apple", "from 6.2%", "Laptops", R.drawable.ic_shopping_bag_blue))
        list.add(PartnersModel("Target", "from 2.4%", "Merchandise", R.drawable.ic_shopping_bag_red))

        return list
    }
}