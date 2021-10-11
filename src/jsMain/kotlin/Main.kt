/*
 *     SeMudandoFront - Repository for SeMudando website
 *     Copyright (C) 2021 Se Mudando
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package br.com.semudando

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import br.com.semudando.page.HomePage
import br.com.semudando.page.WhoWeArePage
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable("root") {
        Style(AppStyleSheet)

        Div {
            val (page, setPage) = remember { mutableStateOf(Page.Home) }

            Header(setPage)

            page.compose()

            Footer()
        }
    }
}

enum class Page(
    val title: String,
    val compose: @Composable () -> Unit
) {
    Home("Início", { HomePage() }),
    WhoWeAre("Quem somos", { WhoWeArePage() });
}

object AppStyleSheet : StyleSheet() {
    val primary = Color("#023e8a")
    val primaryLight = Color("#02558b")
    val lightBlue = Color("#88d2f1")
    val darkGrayBlue = Color("#3577a2")

    val accent = Color("#eb4a3b")
    val accentLight = Color("#d9554d")
}