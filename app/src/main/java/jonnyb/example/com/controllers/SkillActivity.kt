package jonnyb.example.com.controllers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import jonnyb.example.com.R
import jonnyb.example.com.constants.EXTRA_PLAYER
import jonnyb.example.com.model.Player
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

     var player : Player? = null

    var skill : String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player =intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        iamTxt.text = getString(R.string.i_am_a) + " ${player?.league}"

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER,player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)
    }


    fun onBeginnerBtnClick(view : View)
    {
        skill = "Beginner"
        ballerBtn.isChecked = false
    }

    fun onBallerBtnClick(view : View)
    {
        skill = "Baller"
        beginnerBtn.isChecked = false
    }

    fun onFinishBtnClick(view : View){

        if(skill != "")
        {
            val intentVal : Intent = Intent(this, FinishActivity::class.java)
            player?.skill = skill
            intentVal.putExtra(EXTRA_PLAYER, player)

            startActivity(intentVal)

        }else{
            Toast.makeText(this, "select the Skill, Please!", Toast.LENGTH_SHORT).show()
        }
    }


}
