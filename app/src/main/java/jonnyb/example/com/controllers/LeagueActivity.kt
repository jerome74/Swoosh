package jonnyb.example.com.controllers

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import jonnyb.example.com.R
import jonnyb.example.com.constants.EXTRA_PLAYER
import jonnyb.example.com.model.Player
import kotlinx.android.synthetic.main.activity_legue.*

class LeagueActivity : BaseActivity() {

    var player : Player? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_legue)
    }

    var league = ""

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)
    }

    fun onMensClicked(view : View)
    {
        womensBtn.isChecked = false
        coedBtn.isChecked = false
        league = "Mens"
    }

    fun onWomensClicked(view : View)
    {
        mensBtn.isChecked = false
        coedBtn.isChecked = false
        league = "Womens"
    }

    fun onCoedClicked(view : View)
    {
        womensBtn.isChecked = false
        mensBtn.isChecked = false
        league = "Co-ed"
    }

    fun leagueNextClicked(view : View){
        if(league != ""){
            val intentVal : Intent = Intent(this, SkillActivity::class.java)
            player  = Player(league,"")
            intentVal.putExtra(EXTRA_PLAYER, player )
            startActivity(intentVal);
        }
        else{
            Toast.makeText(this,"select a League! Please", Toast.LENGTH_SHORT).show()
        }

    }
}
