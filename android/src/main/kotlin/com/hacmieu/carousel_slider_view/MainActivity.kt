package com.hacmieu.carousel_slider_view

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow.OnScrollPositionListener
import java.util.*

class MainActivity: AppCompatActivity() {
    private var coverFlow: FeatureCoverFlow? = null
    private var adapter: CoverFlowAdapter? = null
    private var games: ArrayList<Game>? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coverFlow = findViewById<FeatureCoverFlow>(R.id.coverflow)

        val toolbar = findViewById<Toolbar>(R.id.tool_bar)
        setSupportActionBar(toolbar)

        val ab = supportActionBar
        ab?.setDisplayHomeAsUpEnabled(true)
        ab?.setDisplayShowHomeEnabled(true)
        ab?.elevation = 0.0F

        settingDummyData()
        adapter = CoverFlowAdapter(this, games)
        coverFlow?.adapter = adapter
        coverFlow?.setOnScrollPositionListener(onScrollListener())
    }

    override fun onSupportNavigateUp(): Boolean {
        this.finish()
        return super.onSupportNavigateUp()
    }

    private fun onScrollListener(): OnScrollPositionListener? {
        return object : OnScrollPositionListener {
            override fun onScrolledToPosition(position: Int) {
                Log.v("MainActivity", "position: $position")
            }

            override fun onScrolling() {
                Log.i("MainActivity", "scrolling")
            }
        }
    }

    private fun settingDummyData() {
        games = ArrayList()
        games!!.add(Game(R.mipmap.assassins_creed, "Assassin Creed 3"))
        games!!.add(Game(R.mipmap.avatar_3d, "Avatar 3D"))
        games!!.add(Game(R.mipmap.call_of_duty_black_ops_3, "Call Of Duty Black Ops 3"))
        games!!.add(Game(R.mipmap.dota_2, "DotA 2"))
        games!!.add(Game(R.mipmap.halo_5, "Halo 5"))
        games!!.add(Game(R.mipmap.left_4_dead_2, "Left 4 Dead 2"))
        games!!.add(Game(R.mipmap.starcraft, "StarCraft"))
        games!!.add(Game(R.mipmap.the_witcher_3, "The Witcher 3"))
        games!!.add(Game(R.mipmap.tomb_raider, "Tom raider 3"))
        games!!.add(Game(R.mipmap.need_for_speed_most_wanted, "Need for Speed Most Wanted"))
    }
}