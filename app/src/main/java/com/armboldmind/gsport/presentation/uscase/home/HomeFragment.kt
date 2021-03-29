package com.armboldmind.gsport.presentation.uscase.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.armboldmind.gsport.R
import com.armboldmind.gsport.databinding.FragmentHomeBinding
import com.armboldmind.gsport.presentation.helpers.fadeViewIn
import com.armboldmind.gsport.presentation.helpers.getTranslateAndFadeInAnimation
import com.armboldmind.gsport.presentation.helpers.getTranslateAndFadeOutAnimation
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModel()
    private var homeBinding: FragmentHomeBinding? = null
    private var sportTypeAdapter: SportTypeAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view).also {
            homeBinding = it
        }

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            sportTypeAdapter = SportTypeAdapter { sport, _ ->
                Toast.makeText(context, sport.type, Toast.LENGTH_LONG).show()
            }
            adapter = sportTypeAdapter
        }
        homeViewModel.sports.observe(viewLifecycleOwner, {
            sportTypeAdapter?.addNews(it)
        })

        startSessionTimer()
    }

    private fun startSessionTimer() {
        object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                homeBinding?.countDownTimer?.text = (millisUntilFinished / 1000 + 10).toString()
            }

            override fun onFinish() {
                val anim = getTranslateAndFadeInAnimation(1500, 0, 80)
                val animText = getTranslateAndFadeOutAnimation(1500, 0, 60)
                homeBinding?.countDownTimer?.startAnimation(anim)
                homeBinding?.textContainer?.startAnimation(animText)
                homeBinding?.countDownTimerSolid?.post {
                    fadeViewIn(3000, homeBinding?.countDownTimerSolid)
                }
                startVideoPlayTimer()
            }
        }.start()
    }

    private fun startVideoPlayTimer() {
        object : CountDownTimer(10000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                homeBinding?.countDownTimerSolid?.text = "00:0" + "${millisUntilFinished / 1000}"
            }
            override fun onFinish() {
                showVideoView()
            }
        }.start()
    }

    private fun showVideoView() {
        homeBinding?.containerFirst?.visibility = View.GONE
        homeBinding?.videoContainer?.visibility = View.VISIBLE
        playVideo()
    }

    private fun playVideo() {
        homeBinding?.player?.getYouTubePlayerWhenReady(object: YouTubePlayerCallback {
            override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo("xVuJCXzr9m8", 0f)
            }
        })
    }

    override fun onDestroyView() {
        homeBinding = null
        super.onDestroyView()
    }
}