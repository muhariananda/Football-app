package com.aria.footballapp.ui.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.aria.footballapp.R
import com.aria.footballapp.ui.favorite.FavoriteFragment
import com.aria.footballapp.ui.league.LeagueFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() {

    companion object {
        private const val SELECTED_MENU = "selected_menu"
    }

    private lateinit var navigationView: BottomNavigationView
    private lateinit var actionBarTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.elevation = 0F

        navigationView = bottom_nav
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        savedInstanceState?.getInt(SELECTED_MENU)
            ?: navigationView.setSelectedItemId(R.id.action_league)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SELECTED_MENU, navigationView.selectedItemId)
    }

    private var mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem: MenuItem ->
            var fragment: Fragment? = null

            if (menuItem.itemId == R.id.action_league) {
                fragment = LeagueFragment.instance()
                actionBarTitle = resources.getString(R.string.app_name)
            } else if (menuItem.itemId == R.id.action_favorite) {
                fragment = FavoriteFragment.getInstance()
                actionBarTitle = resources.getString(R.string.favorite)
            }

            if (fragment != null) {
                supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.container, fragment)
                    .commit()
            }

            if (supportActionBar != null) {
                supportActionBar?.title = actionBarTitle
            }

            true
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_seach) {
            startActivity<SearchActivity>()
        }
        return super.onOptionsItemSelected(item)
    }
}
