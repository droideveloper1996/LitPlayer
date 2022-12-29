package com.foxlabz.statisticvideoplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView

class MainActivity : AppCompatActivity() {
    var streamingUrl =
        "https://d1p2c1ey61b4dk.cloudfront.net/f1f2bd39-07b9-4e78-91b7-38e439b15151/hls/TIFFLsmSpdBndCirTra40Min1013-22.m3u8"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        var styleExoPlayer = findViewById<StyledPlayerView>(R.id.exo_player)
        val player = ExoPlayer.Builder(this).build()
        styleExoPlayer.setPlayer(player);
        val mediaItem: MediaItem = MediaItem.fromUri(streamingUrl)
        player.addMediaItem(mediaItem)
        player.prepare()
        player.playWhenReady = true
        var staticList = ArrayList<StatisticDataModel>()
        staticList.add(StatisticDataModel("TUT", "- -", R.mipmap.ic_launcher))
        staticList.add(StatisticDataModel("LBS", "- -", R.mipmap.ic_launcher_round))
        staticList.add(StatisticDataModel("REPS", "- -", R.mipmap.ic_launcher_round))
        var recyclerView = findViewById<RecyclerView>(R.id.rv_statistics)
        var adapter = StatisticRecyclerView(staticList, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }
}