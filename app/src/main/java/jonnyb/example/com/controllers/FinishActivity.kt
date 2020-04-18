package jonnyb.example.com.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jonnyb.example.com.R
import jonnyb.example.com.constants.EXTRA_PLAYER
import jonnyb.example.com.model.Player
import kotlinx.android.synthetic.main.activity_finished.*

class FinishActivity : BaseActivity() {


    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finished)


        player =intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        lookingTxt.text = "Looking for a ${player.league} ${player.skill} League near to you..."

    }
}
