package ru.fylmr.poplibs_nov21

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.fylmr.poplibs_nov21.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    lateinit var myButtons: MyButtons

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myButtons = MyButtons(binding.btnCounter1.id, binding.btnCounter2.id, binding.btnCounter3.id,)

        val listener = View.OnClickListener { view ->
            val value = presenter.counterClick(myButtons, view.id)
            setButtonText(view.id, value)
        }

        binding.btnCounter1.setOnClickListener(listener)
        binding.btnCounter2.setOnClickListener(listener)
        binding.btnCounter3.setOnClickListener(listener)
    }

    override fun setButtonText(index: Int, text: String) = when (index) {
        myButtons.firstButton -> binding.btnCounter1.text = text
        myButtons.secondButton -> binding.btnCounter2.text = text
        myButtons.thirdButton -> binding.btnCounter3.text = text
        else -> error("Неверный индекс")
    }
}