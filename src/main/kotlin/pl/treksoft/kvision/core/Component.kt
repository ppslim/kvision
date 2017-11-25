package pl.treksoft.kvision.core

import com.github.snabbdom.VNode
import org.w3c.dom.Node
import pl.treksoft.jquery.JQuery

@Suppress("TooManyFunctions")
interface Component {
    var parent: Component?
    var visible: Boolean
    var width: CssSize?
    var height: CssSize?

    fun addCssClass(css: String): Widget
    fun removeCssClass(css: String): Widget
    fun addSurroundingCssClass(css: String): Widget
    fun removeSurroundingCssClass(css: String): Widget

    fun renderVNode(): VNode
    fun getElement(): Node?
    fun getElementJQuery(): JQuery?
    fun getElementJQueryD(): dynamic
    fun clearParent(): Component
    fun getRoot(): Root?
    fun dispose()
}
