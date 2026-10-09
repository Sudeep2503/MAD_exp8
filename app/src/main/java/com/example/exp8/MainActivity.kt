package com.example.exp8

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.view.KeyEvent
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var urlInput: EditText
    private lateinit var backButton: Button
    private lateinit var forwardButton: Button
    private lateinit var reloadButton: Button

    private val homeUrl = "https://www.google.com"

    // Replace these with your actual student details.
    private val studentName = "Sudeep J S"
    private val studentUsn = "25MCAR0134"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        urlInput = findViewById(R.id.urlInput)
        backButton = findViewById(R.id.backButton)
        forwardButton = findViewById(R.id.forwardButton)
        reloadButton = findViewById(R.id.reloadButton)

        supportActionBar?.title = "Web Explorer"

        configureWebView()
        configureNavigationButtons()

        findViewById<Button>(R.id.goButton).setOnClickListener {
            loadEnteredUrl()
        }

        urlInput.setOnEditorActionListener { _, actionId, event ->
            val enterPressed =
                event?.keyCode == KeyEvent.KEYCODE_ENTER &&
                        event.action == KeyEvent.ACTION_DOWN

            if (actionId == EditorInfo.IME_ACTION_GO ||
                actionId == EditorInfo.IME_ACTION_DONE ||
                enterPressed
            ) {
                loadEnteredUrl()
                true
            } else {
                false
            }
        }

        if (savedInstanceState == null) {
            webView.loadUrl(homeUrl)
        } else {
            webView.restoreState(savedInstanceState)
        }
    }

    private fun configureWebView() {
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false
            }

            override fun onPageFinished(
                view: WebView?,
                url: String?
            ) {
                super.onPageFinished(view, url)

                if (!url.isNullOrBlank()) {
                    urlInput.setText(url)
                }

                updateNavigationButtons()
            }
        }
    }

    private fun configureNavigationButtons() {
        backButton.setOnClickListener {
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                Toast.makeText(
                    this,
                    "No previous page",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        forwardButton.setOnClickListener {
            if (webView.canGoForward()) {
                webView.goForward()
            } else {
                Toast.makeText(
                    this,
                    "No next page",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        reloadButton.setOnClickListener {
            webView.reload()
        }
    }

    private fun loadEnteredUrl() {
        var url = urlInput.text.toString().trim()

        if (url.isBlank()) {
            urlInput.error = "Enter a website address"
            return
        }

        if (!url.contains("://")) {
            url = "https://$url"
        }

        if (!url.startsWith("https://", ignoreCase = true) &&
            !url.startsWith("http://", ignoreCase = true)
        ) {
            urlInput.error = "Enter a valid HTTP or HTTPS URL"
            return
        }

        webView.loadUrl(url)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.menu_home -> {
                webView.loadUrl(homeUrl)
                true
            }

            R.id.menu_google -> {
                webView.loadUrl("https://www.google.com")
                true
            }

            R.id.menu_about -> {
                showAboutDialog()
                true
            }

            R.id.menu_reload -> {
                webView.reload()
                true
            }

            R.id.menu_exit -> {
                showExitDialog()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showAboutDialog() {
        AlertDialog.Builder(this)
            .setTitle("About Web Explorer")
            .setMessage(
                "Web Explorer\n\n" +
                        "An Android application demonstrating " +
                        "Options Menu and WebView.\n\n" +
                        "Student Name: $studentName\n" +
                        "USN: $studentUsn"
            )
            .setPositiveButton("OK", null)
            .show()
    }

    private fun showExitDialog() {
        AlertDialog.Builder(this)
            .setTitle("Exit Application")
            .setMessage("Are you sure you want to exit?")
            .setNegativeButton("Cancel", null)
            .setPositiveButton("Exit") { _, _ ->
                finish()
            }
            .show()
    }

    private fun updateNavigationButtons() {
        if (!::backButton.isInitialized ||
            !::forwardButton.isInitialized
        ) {
            return
        }

        backButton.isEnabled = webView.canGoBack()
        forwardButton.isEnabled = webView.canGoForward()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        webView.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        webView.stopLoading()
        webView.destroy()
        super.onDestroy()
    }
}
