/*
 * Copyright (c) 2017-present Robert Jaros
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package pl.treksoft.kvision.form.check

import pl.treksoft.kvision.core.Container

/**
 * The basic input component rendered as HTML *input type="checkbox"*.
 *
 * @constructor
 * @param value selection state
 * @param classes a set of CSS class names
 */
open class CheckBoxInput(
    value: Boolean = false,
    classes: Set<String> = setOf()
) : CheckInput(CheckInputType.CHECKBOX, value, classes)

/**
 * DSL builder extension function.
 *
 * It takes the same parameters as the constructor of the built component.
 */
fun Container.checkBoxInput(
    value: Boolean = false,
    classes: Set<String> = setOf(), init: (CheckInput.() -> Unit)? = null
): CheckBoxInput {
    val checkBoxInput = CheckBoxInput(value, classes).apply { init?.invoke(this) }
    this.add(checkBoxInput)
    return checkBoxInput
}
