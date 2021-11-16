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
import br.com.semudando.page.DonatePage
import br.com.semudando.page.HomePage
import br.com.semudando.page.ProgramPage
import br.com.semudando.page.WhoWeArePage
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.boxSizing
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.renderComposable

fun main() {
  renderComposable("root") {
    Style(AppStyleSheet)
    Div {
      val (page, setPage) = remember { mutableStateOf<Page>(Page.Home) }

      Header(page, setPage)

      page.compose()

      Footer()
    }
  }
}

sealed class Page(
  val title: String,
  val compose: @Composable () -> Unit,
) {
  object Home : Page("Início", { HomePage() })
  object WhoWeAre : Page("Quem somos", { WhoWeArePage() })
  object Program : Page("Programa abrindo portas", { ProgramPage() })
  object Donate : Page("Faça uma doação", { DonatePage() })

  companion object {
    fun values(): List<Page> = listOf(Home, WhoWeAre, Program, Donate)
  }
}

object AppStyleSheet : StyleSheet() {
  val primary = Color("#023e8a")
  val primaryLight = Color("#02558b")
  val lightBlue = Color("#88d2f1")
  val darkGrayBlue = Color("#3577a2")
  val cinnabar = Color("#eb4a3b")

  val accent = Color("#eb4a3b")
  val accentLight = Color("#d9554d")

  init {
    "*" {
      property("font-family", "Lexend")
      boxSizing("border-box")
    }
  }
}