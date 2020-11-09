package com.example.utsmobileno2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.utsmobileno2.FacData
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Call Class Content
        val data = CreateFac()
        rv_list_main.layoutManager = LinearLayoutManager(this)
        rv_list_main.setHasFixedSize(true)
        // Connect Adapter Untuk Menampilkan Item Pada Recycle View Sesuai Jumlah Data Yang Ada
                rv_list_main.adapter = FacAdapter(data, { onItem: FacData ->
            onItemClicked(onItem) })
    }
    // When Click Item
    private fun onItemClicked(onItem: FacData) {
        val showDetailActivityIntent = Intent(this, FacDetail::class.java)
        // Send Intent
        showDetailActivityIntent.putExtra(Intent.EXTRA_INTENT, onItem.nameFac)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TITLE, onItem.descFac)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEMPLATE, onItem.descDet)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, onItem.imgFac)
        showDetailActivityIntent.putExtra(Intent.EXTRA_EMAIL, onItem.emailFac)
        showDetailActivityIntent.putExtra(Intent.EXTRA_ORIGINATING_URI, onItem.webFac)
        // Menampilkan Activity Dengan Intent
        startActivity(showDetailActivityIntent)
    }
}