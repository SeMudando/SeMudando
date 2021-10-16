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

@file:OptIn(ExperimentalComposeWebApi::class)

package br.com.semudando.page

import androidx.compose.runtime.Composable
import br.com.semudando.AppStyleSheet
import br.com.semudando.AppStyleSheet.cinnabar
import br.com.semudando.AppStyleSheet.darkGrayBlue
import br.com.semudando.AppStyleSheet.primary
import br.com.semudando.page.ProgramPageStyles.bold
import br.com.semudando.page.ProgramPageStyles.descriptionContainer
import br.com.semudando.page.ProgramPageStyles.descriptionContent
import br.com.semudando.page.ProgramPageStyles.descriptionImages
import br.com.semudando.page.ProgramPageStyles.descriptionText
import br.com.semudando.page.ProgramPageStyles.descriptionTextContainer
import br.com.semudando.page.ProgramPageStyles.iconTextBlock
import br.com.semudando.page.ProgramPageStyles.introContainer
import br.com.semudando.page.ProgramPageStyles.introContent
import br.com.semudando.page.ProgramPageStyles.titleText
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color.white
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.css.FlexDirection.Companion.Column
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.filter
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.lineHeight
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.selectors.plus
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProgramPage() {
   Div({ classes(introContainer) }) {
      Span({ classes(titleText) }) {
         Text("Através do Rapid Re-Housing, pretendemos tratar o problema na sua raíz:")
      }

      Div({ classes(introContent) }) {
         IconTextBlock("icons/home.svg", "Morada Própria", true)
         IconTextBlock("icons/resources.png", "Recursos Básicos")
         IconTextBlock("icons/social.png", "Reinserção Social")
      }
   }

   Div({ classes(descriptionContainer) }) {
      Button {
         Text("Apoie nossa causa")
      }

      Div({ classes(descriptionContent) }) {
         Div({ classes(descriptionTextContainer) }) {
            Div({ classes(descriptionText) }) {
               Span {
                  P() { Text("Luciana e Roberto:") }
                  P() { Text("Nossa primeira família assistida") }
                  P() { Text("Estamos juntos desde novembro de 2020, sendo oficialmente os primeiros assistidos do Se Mudando no programa de Rapid Re-Housing.") }
                  P() { Text("Desde então, nosso trabalho vai muito além de garantir que os nossos assistidos não estejam desamparados e em situação de rua, nós os ajudamos a consquistarem a independência e estabilidade para terem uma vida digna.") }
                  P() { Text("E como fazemos isso dar certo?") }
                  P() { Text("Nós fornecemos moradia fixa, cesta básica, consultas com psicólogos e fisioterapeutas, contato e incentivo acerca de uma fonte de renda, entre muitas outras ações.") }
                  Span({ classes(bold) }) {
                     Text("Tudo isso para devolver a eles a autonomia e a segurança de forma eficiente!")
                  }
               }
            }
         }
         Div({ classes(descriptionImages) }) {
               Img("images/todo_mundo.png") {}
               Img("images/visita.png") {}
         }
      }
   }
}

@Composable
fun IconTextBlock(icon: String, text: String, invert: Boolean = false) {
   Div({ classes(iconTextBlock) }) {
      Img(icon) {
         style {
            if (invert) {
               filter { invert(100.percent) }
            }
         }
      }
      Span { Text(text) }
   }
}

object ProgramPageStyles : StyleSheet(AppStyleSheet) {

   val introContainer by style {
      minHeight(300.px)
      backgroundColor(cinnabar)
      display(Flex)
      flexDirection(Column)
      alignItems(AlignItems.Center)

      padding(30.px)
   }

   val titleText by style {
      color(white)
      fontSize(30.px)
      textAlign("center")
   }

   val introContent by style {
      display(Flex)
      justifyContent(JustifyContent.Center)
      width(60.percent)
      marginTop(100.px)
   }

   val iconTextBlock by style {
      display(Flex)
      flexDirection(Column)
      alignItems(AlignItems.Center)
      width(33.percent)

      (self + " img") {
         width(64.px)
         height(64.px)
      }

      (self + " span") {
         fontSize(25.px)
         color(white)
         fontWeight("bold")
      }
   }

   val descriptionContainer by style {
      minHeight(300.px)
      backgroundColor(white)
      display(Flex)
      flexDirection(Column)
      alignItems(AlignItems.Center)

      padding(30.px)

      (self + " button") {
         backgroundColor(darkGrayBlue)
         color(white)
         fontSize(54.px)
         padding(20.px)
         borderRadius(20.px)
      }
   }

   val descriptionContent by style {
      display(Flex)
      width(60.percent)
      marginTop(40.px)
   }

   val descriptionTextContainer by style {
      display(Flex)
      width(50.percent)
   }

   val descriptionText by style {
      display(Flex)
      width(80.percent)
      backgroundColor(darkGrayBlue)
      padding(32.px)

      (self + " span") {
         color(white)
         fontSize(20.px)
         lineHeight(1.5.em)
      }
   }

   val bold by style {
      backgroundColor(primary)
   }

   val descriptionImages by style {
      display(Flex)
      flexDirection(Column)
      width(50.percent)

      (self + " img") {
         height(100.percent)
         property("object-fit", "contain")
         property("filter", "drop-shadow(0 0 0.75rem crimson)")
      }
   }
}