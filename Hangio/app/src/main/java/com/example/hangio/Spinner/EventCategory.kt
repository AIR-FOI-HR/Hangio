package com.example.hangio.Spinner

public class EventCategory {
    val eventCategories = arrayOf<String>()


    fun addEventCategories() {
        eventCategories.fill("Sport")
        eventCategories.fill("Movies")
        eventCategories.fill("Coffee/Drink")
        eventCategories.fill("Concert")
        eventCategories.fill( "Night out")
        eventCategories.fill("Walk")
        eventCategories.fill("Casual hanging out")
        eventCategories.fill("House party")
        eventCategories.fill("Theatre play")
        eventCategories.fill("Museum visit")
        eventCategories.fill("Other")
    }

}