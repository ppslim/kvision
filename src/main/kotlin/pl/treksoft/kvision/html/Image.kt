package pl.treksoft.kvision.html

import com.github.snabbdom.VNode
import pl.treksoft.kvision.core.ResString
import pl.treksoft.kvision.core.Widget
import pl.treksoft.kvision.snabbdom.StringBoolPair
import pl.treksoft.kvision.snabbdom.StringPair

enum class IMAGE_SHAPE(val className: String) {
    ROUNDED("img-rounded"),
    CIRCLE("img-circle"),
    THUMBNAIL("img-thumbnail")
}

open class Image(src: ResString, alt: String? = null, responsive: Boolean = false, shape: IMAGE_SHAPE? = null, centered: Boolean = false, classes: Set<String> = setOf()) : Widget(classes) {
    var src = src
        set(value) {
            field = value
            refresh()
        }
    var alt = alt
        set(value) {
            field = value
            refresh()
        }
    var responsive = responsive
        set(value) {
            field = value
            refresh()
        }
    var shape = shape
        set(value) {
            field = value
            refresh()
        }
    var centered = centered
        set(value) {
            field = value
            refresh()
        }

    override fun render(): VNode {
        return kvh("img")
    }

    override fun getSnAttrs(): List<StringPair> {
        val pr = super.getSnAttrs().toMutableList()
        pr.add("src" to src)
        if (alt != null) pr.add("alt" to alt.orEmpty())
        return pr
    }

    override fun getSnClass(): List<StringBoolPair> {
        val cl = super.getSnClass().toMutableList()
        if (responsive) {
            cl.add("img-responsive" to true)
        }
        if (centered) {
            cl.add("center-block" to true)
        }
        if (shape != null) {
            cl.add(shape?.className.orEmpty() to true)
        }
        return cl
    }
}