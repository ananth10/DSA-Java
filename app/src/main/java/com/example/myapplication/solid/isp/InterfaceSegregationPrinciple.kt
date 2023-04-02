package com.example.myapplication.solid.isp



/**
 * The Interface segregation principle states that developers should not be forced to depend upon the interfaces that they not use.
 * */

//Violation of isp

interface OnClickList{

    fun onClick()
    fun onLongPress()
}

class MyComponent : OnClickList{ //here i just need only onClick and i dont need onLongPress, so we need to segregate the interfaces
    override fun onClick() {

    }

    override fun onLongPress() {

    }

}

interface OnClickListOnly{
    fun onClick()
}

interface OnLongPress{
    fun onLongPress()
}

class MyComp:OnClickListOnly{ //here we used only onClick fun

    override fun onClick() {

    }

}