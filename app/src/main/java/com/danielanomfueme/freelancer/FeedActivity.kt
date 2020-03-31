package com.danielanomfueme.freelancer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class FeedActivity : AppCompatActivity() {

    lateinit var feedFragment : FeedFragment
    lateinit var searchFragment: SearchFragment
    lateinit var messageFragment: MessageFragment
    lateinit var profileFragment: ProfileFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feed_layout)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.bottom_nav)



        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when  (item.itemId){

                R.id.feed -> {
                    feedFragment = FeedFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_feed,feedFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.search -> {
                    searchFragment = SearchFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,searchFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.Message -> {
                    messageFragment = MessageFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,messageFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.profile -> {
                    profileFragment = ProfileFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout,profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }
            true
        }

    }
}
