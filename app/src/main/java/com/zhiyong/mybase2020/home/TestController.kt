package com.zhiyong.mybase2020.home

import com.airbnb.epoxy.CarouselModelBuilder
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyModel
import com.zhiyong.mybase2020.BuildConfig
import com.zhiyong.mybase2020.model.TestData
import com.zhiyong.mybase2020.modelview.TestModel
import com.zhiyong.mybase2020.modelview.TestModel_

class TestController(val listener: TestModel.Listener) : EpoxyController() {

    var rowItems: List<TestData> = ArrayList()

    init {
        if(BuildConfig.DEBUG) isDebugLoggingEnabled = true
        setFilterDuplicates(true)
    }
    fun addData(data: TestData){
        val mergedList = mutableListOf<TestData>()
            .apply {
                rowItems.forEach { i -> add(i.copy()) }
                add(data.copy())
            }
        rowItems = mergedList
        requestModelBuild()
    }

    fun removeData(id: String) {
        val newList = mutableListOf<TestData>()
            .apply {
                rowItems.forEach {
                    if (it.id != id) add(it.copy())
                }
            }
        rowItems = newList
        requestModelBuild()
    }

    fun addData(newList: List<TestData>) {
        val mergedList = mutableListOf<TestData>()
            .apply {
                rowItems.forEach { i -> add(i.copy()) }
                newList.forEach { j -> add(j.copy()) }
            }
        rowItems = mergedList
        requestModelBuild()
    }

    override fun buildModels() {
        rowItems.forEach{item ->
            TestModel_()
                .id(item.id)
                .listener(listener)
                .testData(item)
                .addTo(this)
        }
    }
}

/** For use in the buildModels method of EpoxyController. A shortcut for creating a Carousel model, initializing it, and adding it to the controller.
 *
 */
inline fun EpoxyController.carousel(modelInitializer: CarouselModelBuilder.() -> Unit) {
    CarouselModel_().apply {
        modelInitializer()
    }.addTo(this)
}

/** Add models to a CarouselModel_ by transforming a list of items into EpoxyModels.
 *
 * @param items The items to transform to models
 * @param modelBuilder A function that take an item and returns a new EpoxyModel for that item.
 */
inline fun <T> CarouselModelBuilder.withModelsFrom(
    items: List<T>,
    modelBuilder: (T) -> EpoxyModel<*>
) {
    models(items.map { modelBuilder(it) })
}