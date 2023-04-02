package com.example.myapplication.solid.lsp

/**
 * Child type should be able to replace the parent without changing the behavior of program
 * */

//example of LSP

interface Waste{
    fun process()
}

class OrganicWaste:Waste{

    override fun process() {
     println("Organic waste processed")
    }

}

class PlasticWaste:Waste{

    override fun process() {
        println("Plastic waste processed")
    }

}

class WasteManagementService{

    fun process(waste: Waste){
        waste.process()
    }
}

fun main(){

    val wasteManagementService = WasteManagementService()
    var waste:Waste

    waste = OrganicWaste()
    wasteManagementService.process(waste)

    waste = PlasticWaste()
    wasteManagementService.process(waste)

}