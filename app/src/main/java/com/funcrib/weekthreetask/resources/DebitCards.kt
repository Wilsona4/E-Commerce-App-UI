package com.funcrib.weekthreetask.resources

import com.funcrib.weekthreetask.R
import com.funcrib.weekthreetask.model.DebitCardModel

class DebitCards {

    val debitCardList = initDebitCards()

    /*Initialize Debit Cards List*/
    private fun initDebitCards(): ArrayList<DebitCardModel> {
        val list = ArrayList<DebitCardModel>()

        /*Add Debit Cards to List*/
        list.add(DebitCardModel("Darot", "23,764,133.00", R.color.teal))
        list.add(DebitCardModel("Olalekan", "28,046,523.00", R.color.red))
        list.add(DebitCardModel("Oladapo", "25,313,414.00", R.color.blue))
        list.add(DebitCardModel("Ransom", "24,133,393.00", R.color.special_cards_color))
        list.add(DebitCardModel("Samuel", "22,133,642.00", R.color.shopping_bag_blue))
        list.add(DebitCardModel("Ruthy", "23,003,323", R.color.shopping_bag_red))

        return list
    }
}