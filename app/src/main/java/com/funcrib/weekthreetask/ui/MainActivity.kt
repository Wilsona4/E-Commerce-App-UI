package com.funcrib.weekthreetask.ui

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.funcrib.weekthreetask.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID = "WIL"
    private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*First-time init; Init only when app launches*/
        if (savedInstanceState == null) {
            /*Initialise Default Fragment*/
            initFragment()
        }

        /*Create Notification Channel*/
        createNotificationChannel()

        /*create notification onClick of button*/
        ivNotifications.setOnClickListener {
            addNotification()
        }

        /*Attach Listener for handling selection events on bottom navigation items to Bottom Nav View*/
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }



    /*Method to Create Notification*/
    private fun addNotification() {
        /*Explicit intent to return to Main Activity in the app*/
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }

        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        /*Notification Builder*/
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_credit_card)
            .setContentTitle("Bed Time")
            .setContentText("It's Bed Time. Remember Early to Bed, Early to Rise")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            // Set the intent that will fire when the user taps the notification
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(0, builder.build())
        }
    }

    /*Create the NotificationChannel*/
    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    /** Listener for handling selection events on bottom navigation items. */
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            /*Initialize Intent for Each Bottom Nav Components*/
            when (item.itemId) {
                R.id.mProducts -> {

                    val productsFragment = ProductsFragment.newInstance()
                    openFragment(productsFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.mSupport -> {

                    val supportFragment = SupportFragment.newInstance("SUPPORT")
                    openFragment(supportFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.mPayments -> {

                    val supportFragment = SupportFragment.newInstance("PAYMENTS")
                    openFragment(supportFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.mHistory -> {

                    val supportFragment = SupportFragment.newInstance("HISTORY")
                    openFragment(supportFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.mMore -> {

                    val supportFragment = SupportFragment.newInstance("MORE")
                    openFragment(supportFragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    /*Method to Create Fragment*/
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    /*Method to Add Initial Fragment*/
    private fun initFragment() {
        val productsFragment = ProductsFragment.newInstance()
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            setReorderingAllowed(true)
            replace(R.id.fragment_container, productsFragment)
            addToBackStack(null)
            commit()
        }
    }


}