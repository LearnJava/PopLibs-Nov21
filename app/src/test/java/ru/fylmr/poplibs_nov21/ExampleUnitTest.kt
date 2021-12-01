package ru.fylmr.poplibs_nov21

import android.widget.Button
import org.junit.Test

import org.junit.Before
import org.mockito.Mockito

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    lateinit var firstButton:Button
    lateinit var secondButton:Button
    lateinit var thirdButton:Button
    lateinit var view: MainView
    lateinit var mainPresenter: MainPresenter
    lateinit var myButtons: MyButtons

    @Before
    fun setUp() {
        view = Mockito.mock(MainView::class.java)
        mainPresenter = MainPresenter(view)
        firstButton = Mockito.mock(Button::class.java)
        secondButton = Mockito.mock(Button::class.java)
        thirdButton = Mockito.mock(Button::class.java)
        myButtons = MyButtons(firstButton.id, secondButton.id, thirdButton.id)
    }

    @Test
    fun counterClickFirstButtonTest() {
        val result = mainPresenter.counterClick(myButtons, firstButton.id)
        assert(result.toInt() > 0)
    }

    @Test
    fun counterClickSecondButtonTest() {
        val result = mainPresenter.counterClick(myButtons, secondButton.id)
        assert(result.toInt() > 0)
    }

    @Test
    fun counterClickThirdButtonTest() {
        val result = mainPresenter.counterClick(myButtons, thirdButton.id)
        assert(result.toInt() > 0)
    }
}