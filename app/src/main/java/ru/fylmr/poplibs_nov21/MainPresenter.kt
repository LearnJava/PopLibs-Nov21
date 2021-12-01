package ru.fylmr.poplibs_nov21

class MainPresenter(
    private val view: MainView
) {

    private val model = CountersModel()

    fun counterClick(myButtons: MyButtons, buttonClickedId: Int): String {
        var nextValue = ""
            when (buttonClickedId) {
            myButtons.firstButton -> {
                nextValue = model.increment(0).toString()
            }
            myButtons.secondButton -> {
                nextValue = model.increment(1).toString()
            }
            myButtons.thirdButton -> {
                nextValue = model.increment(2).toString()
            }
        }
        return nextValue
    }
}