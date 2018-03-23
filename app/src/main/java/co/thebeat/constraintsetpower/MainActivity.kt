package co.thebeat.constraintsetpower

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatTextView
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var container: ConstraintLayout
    private lateinit var topDivider: View
    private lateinit var bottomDivider: View
    private lateinit var textDescr: AppCompatTextView
    private lateinit var image: ImageView
    private lateinit var title: AppCompatTextView
    private lateinit var subtitle: AppCompatTextView
    private lateinit var popupMessage: AppCompatTextView
    private lateinit var button: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = findViewById(R.id.container)
        topDivider = findViewById(R.id.topDivider)
        bottomDivider = findViewById(R.id.bottomDivider)
        textDescr = findViewById(R.id.textDescription)
        image = findViewById(R.id.image)
        title = findViewById(R.id.title)
        subtitle = findViewById(R.id.subtitle)
        popupMessage = findViewById(R.id.popupMessage)
    }
}
