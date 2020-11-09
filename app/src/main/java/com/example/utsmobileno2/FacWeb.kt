package com.example.utsmobileno2
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class FacWeb : AppCompatActivity() {
    // Inisiasi Javascript
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setting Layout
        setContentView(R.layout.web_fac)
        // Inisiasi WebView
        val webView = findViewById<WebView>(R.id.web_view)
        // Inisiasi Intent
        val intentFromFac = intent
        if (intentFromFac.hasExtra(Intent.ACTION_VIEW)) {
            // Grab Intent Detail Fac
            val partWeb = intentFromFac.getStringExtra(Intent.ACTION_VIEW)
            webView.settings.javaScriptEnabled = true
            // Proses Load Client -> Alert Javascript Created
            webView.webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    view.loadUrl("javascript:alert('Load Website Success!')")
                }
            }
            // Alert Javascript -> Toast
            webView.webChromeClient = object : WebChromeClient() {
                override fun onJsAlert(
                    view: WebView,
                    url: String,
                    message: String,
                    result: JsResult
                ): Boolean {
                    Toast.makeText(this@FacWeb, message, Toast.LENGTH_LONG).show()
                    result.confirm()
                    return true
                }
            }
            // Parameter WebView Load
            if (partWeb != null) {
                webView.loadUrl(partWeb)
            }
        }
    }
}