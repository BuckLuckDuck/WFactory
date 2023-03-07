package com.example.worldfactory.activity.word

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import com.example.worldfactory.databinding.FragmentVideoBinding

private const val valid_video_uri = "https://learnenglish.britishcouncil.org/general-english/video-zone"

private fun isAllowedURI(uri: String): Boolean {
    return uri.startsWith(valid_video_uri, ignoreCase = true)
}

class VideoFragment : Fragment() {

    private class VideoWebView : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            if(isAllowedURI(request?.url.toString())) {
                return super.shouldOverrideUrlLoading(view, request)
            }

            return true
        }
    }

    private var _binding: FragmentVideoBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if ((activity as WordActivity).isOnVideo()) {
                    if (binding.webview.canGoBack() && isAllowedURI(binding.webview.url.toString())) {
                        binding.webview.goBack()
                    }
                } else {
                    isEnabled = false
                    activity?.onBackPressed()
                }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webview.webViewClient = VideoWebView()
        binding.webview.loadUrl(valid_video_uri)
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.settings.setSupportZoom(true)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}