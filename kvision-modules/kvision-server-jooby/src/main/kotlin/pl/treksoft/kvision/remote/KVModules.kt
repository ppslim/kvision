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
package pl.treksoft.kvision.remote

import com.google.inject.AbstractModule
import com.google.inject.Module
import com.typesafe.config.Config
import io.jooby.AssetSource
import io.jooby.Environment
import io.jooby.Kooby
import io.jooby.di.GuiceModule
import io.jooby.json.JacksonModule

/**
 * Initialization function for Jooby server.
 */
fun Kooby.kvisionInit(vararg modules: Module) {
    assets("/", "/assets/index.html")
    assets("/*", AssetSource.create(javaClass.classLoader, "assets"))
    install(GuiceModule(MainModule(this), *modules))
    install(JacksonModule())
}

internal class MainModule(private val kooby: Kooby) : AbstractModule() {
    override fun configure() {
        bind(Kooby::class.java).toInstance(kooby)
        bind(Environment::class.java).toInstance(kooby.environment)
        bind(Config::class.java).toInstance(kooby.config)
    }
}
