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
import br.com.semudando.AppStyleSheet.primary
import br.com.semudando.HeaderStyles.header
import br.com.semudando.HeaderStyles.icon
import br.com.semudando.HeaderStyles.icons
import br.com.semudando.HeaderStyles.selected
import br.com.semudando.HeaderStyles.title
import br.com.semudando.plausible.plausible
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color.white
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginLeft
import org.jetbrains.compose.web.css.marginRight
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

object HeaderStyles : StyleSheet(AppStyleSheet) {

   val header by style {
      backgroundColor(primary)
      height(56.px)

      display(Flex)
      alignItems(AlignItems.Center)
   }

   val title by style {
      color(white)
      margin(16.px)
      display(Flex)

      (self + " div") {
         marginLeft(10.px)
         marginRight(10.px)
      }
   }

   val selected by style {

   }

   val icons by style {
      display(Flex)
      alignItems(AlignItems.Center)
      margin(8.px)
      property("margin-left", "auto")
   }

   val icon by style {
      height(32.px)
      width(32.px)
      margin(8.px)
   }
}

@Composable
fun Header() {
   Div({ classes(header) }) {
      Div({ classes(title) }) {
         Div { Text("Se Mudando") }

         Page.values().forEach { page ->
            Div({ onClick { pageState = page } }) {
               if (pageState == page) {
                  Span({ classes(selected) }) {
                     Text(page.title)
                  }
               } else {
                  Text(page.title)
               }
            }
         }
      }
      Icons()
   }
}

@Composable
fun Icons() {
   Div({ classes(icons) }) {
      Div({ classes(icon); onClick { plausible("Linkedin") } }) {
         A("https://www.linkedin.com/company/projeto-se-mudando/") {
            Img("icons/linkedin.png", "Linkedin")
         }
      }
      Div({ classes(icon) }) {
         A("https://www.instagram.com/se.mudando/") {
            Img("icons/instagram.png", alt = "Instagram")
         }
      }
      Div({ classes(icon) }) {
         A("https://www.facebook.com/semudando") {
            Img("icons/facebook.png", alt = "Facebook")
         }
      }
   }
}