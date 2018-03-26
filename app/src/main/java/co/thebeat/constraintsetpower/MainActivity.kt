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
    private lateinit var divider: View
    private lateinit var textDescr: AppCompatTextView
    private lateinit var image: ImageView
    private lateinit var title: AppCompatTextView
    private lateinit var subtitle: AppCompatTextView
    private lateinit var author: AppCompatTextView
    private lateinit var button: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = findViewById(R.id.container)
        divider = findViewById(R.id.divider)
        image = findViewById(R.id.image)
        textDescr = findViewById(R.id.textDescription)
        title = findViewById(R.id.title)
        subtitle = findViewById(R.id.subtitle)
        author = findViewById(R.id.author)
        button = findViewById(R.id.button)
    }
}
