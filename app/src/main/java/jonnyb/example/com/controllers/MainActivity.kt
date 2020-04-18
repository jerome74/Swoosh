package jonnyb.example.com.controllers

import android.content.Intent
import android.os.Bundle
import jonnyb.example.com.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getStarted.setOnClickListener {
            val intentVal : Intent = Intent(this, LeagueActivity::class.java)
            startActivity(intentVal)
        }
    }
}
