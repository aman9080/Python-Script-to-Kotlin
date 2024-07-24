import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.ui.PlayerView

class MainActivity : AppCompatActivity() {

    private lateinit var playerView: PlayerView
    private lateinit var daddyliveAddon: DaddyliveAddon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerView = findViewById(R.id.player_view)
        daddyliveAddon = DaddyliveAddon(this, playerView)

        val mode = intent.getStringExtra("mode")
        val params = intent.extras?.keySet()?.associateWith { intent.getStringExtra(it) }.orEmpty()
        daddyliveAddon.executeMode(mode ?: "", params)
    }

    override fun onDestroy() {
        super.onDestroy()
        playerView.player?.release()
    }
}
