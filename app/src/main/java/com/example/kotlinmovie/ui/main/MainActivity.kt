package com.example.kotlinmovie.ui.main

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.example.kotlinmovie.R
import com.example.kotlinmovie.common.BaseActivity
import com.example.kotlinmovie.ui.main.home.HomeFragment
import com.example.kotlinmovie.ui.main.profile.ProfileFragment
import com.example.kotlinmovie.ui.main.users.UserFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainDelegate {

    private val HOME_FRAGMENT="home";
    private val PROFILE_FRAGMENT="profile";
    private val USERS_FRAGMENT="user";

    private lateinit var fragmentToShow : Fragment


    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun setUpContents(savedInstanceState: Bundle?) {
//        setupToolbar(false)
        setupAhBottomNavBar();
    }

    private fun setupAhBottomNavBar() {
        val homeItem=AHBottomNavigationItem("home", R.drawable.nav_home )
        val usersItem=AHBottomNavigationItem("users", R.drawable.nav_users)
        val profileItem=AHBottomNavigationItem("profile", R.drawable.nav_profile)

        bottom_navigation.addItem(homeItem)
        bottom_navigation.addItem(usersItem)
        bottom_navigation.addItem(profileItem)

        //change colors
        bottom_navigation.accentColor=Color.parseColor("#e6e6e6")
//        bottom_navigation.inactiveColor=Color.parseColor("#17FFC7")#55aa77
        bottom_navigation.inactiveColor=Color.parseColor("#99ccad")


        // Enable the translation inside the CoordinatorLayout
        bottom_navigation.isBehaviorTranslationEnabled = true

        bottom_navigation.isTranslucentNavigationEnabled = true

        // Set background color
        bottom_navigation.defaultBackgroundColor = resources.getColor(R.color.colorPrimaryDark)

        //set Listener
        bottom_navigation.setOnTabSelectedListener(AHBottomNavigation.OnTabSelectedListener{position :Int , wasSelected : Boolean ->

            when(position){
                0 -> {
                    displayView(HOME_FRAGMENT)
                    return@OnTabSelectedListener true
                }
                1 ->{
                    displayView(USERS_FRAGMENT)
                    return@OnTabSelectedListener true
                }
                2 ->{
                    displayView(PROFILE_FRAGMENT)
                    return@OnTabSelectedListener true
                }
                else -> return@OnTabSelectedListener true

            }
        })
        bottom_navigation.currentItem=0
    }

    fun displayView(frag: String) {
        when(frag){
            HOME_FRAGMENT -> {
                fragmentToShow = HomeFragment()
            }
            USERS_FRAGMENT -> {
                fragmentToShow = UserFragment()
            }
            PROFILE_FRAGMENT -> {
                fragmentToShow = ProfileFragment()
            }

        }

        if (this::fragmentToShow.isInitialized) {

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container,fragmentToShow).commit()

        }

    }

}