package co.thebeat.constraintsetpower

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.AutoTransition
import android.support.transition.TransitionManager
import android.support.transition.TransitionSet
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

    private val animationDuration = 500L

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
        button.setOnClickListener { toggleAnimations(it as AppCompatButton) }
    }

    private fun toggleAnimations(button: AppCompatButton) {
        when (button.tag) {
            "there" -> {
                playExpandAnimation()
                button.setText(R.string.button_and_back)
                button.tag = "back"
            }
            else -> {
                playContractAnimation()
                button.setText(R.string.button_there)
                button.tag = "there"
            }
        }
    }

    private fun playExpandAnimation() {
        val transition = AutoTransition()
        transition.duration = animationDuration
        transition.ordering = TransitionSet.ORDERING_SEQUENTIAL

        TransitionManager.beginDelayedTransition(container, transition)
        val set = ConstraintSet()
        set.clone(container)

        // Image transition
        set.clear(image.id, ConstraintSet.BOTTOM)
        set.clear(image.id, ConstraintSet.START)

        // Title transition
        set.clear(title.id, ConstraintSet.BOTTOM)
        set.clear(title.id, ConstraintSet.END)
        set.connect(title.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        set.connect(title.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)

        set.setVisibility(subtitle.id, ConstraintSet.VISIBLE)
        set.setVisibility(divider.id, ConstraintSet.VISIBLE)
        set.setVisibility(textDescr.id, ConstraintSet.VISIBLE)
        set.setVisibility(author.id, ConstraintSet.VISIBLE)

        set.applyTo(container)
    }

    private fun playContractAnimation() {
        val transition = AutoTransition()
        transition.ordering = TransitionSet.ORDERING_SEQUENTIAL
        transition.duration = animationDuration

        TransitionManager.beginDelayedTransition(container, transition)
        val set = ConstraintSet()
        set.clone(container)

        // Image transition
        set.connect(image.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
        set.connect(image.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
        set.connect(image.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)

        // Title transition
        set.clear(title.id, ConstraintSet.TOP)
        set.connect(title.id, ConstraintSet.START, image.id, ConstraintSet.START)
        set.connect(title.id, ConstraintSet.END, image.id, ConstraintSet.END)
        set.connect(title.id, ConstraintSet.BOTTOM, image.id, ConstraintSet.TOP)

        set.setVisibility(subtitle.id, ConstraintSet.GONE)

        set.setVisibility(textDescr.id, ConstraintSet.GONE)
        set.setVisibility(author.id, ConstraintSet.GONE)

        set.setVisibility(divider.id, ConstraintSet.GONE)

        set.applyTo(container)
    }
}
