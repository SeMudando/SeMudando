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

package br.com.semudando.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import br.com.semudando.AppStyleSheet
import br.com.semudando.components.DonationFormStyle.allBoxesContainer
import br.com.semudando.components.DonationFormStyle.boxContainer
import br.com.semudando.components.DonationFormStyle.creditCardCvvInput
import br.com.semudando.components.DonationFormStyle.creditCardExpirationDateInput
import br.com.semudando.components.DonationFormStyle.creditCardForm
import br.com.semudando.components.DonationFormStyle.creditCardLabel
import br.com.semudando.components.DonationFormStyle.creditCardNumberInput
import br.com.semudando.components.DonationFormStyle.donationButton
import br.com.semudando.components.DonationFormStyle.donationValue
import br.com.semudando.components.DonationFormStyle.inputIcon
import br.com.semudando.components.DonationFormStyle.selectedBoxContainer
import br.com.semudando.components.DonationFormStyle.unselectedBoxContainer
import br.com.semudando.masks.CreditCardMask
import br.com.semudando.masks.CvvMask
import br.com.semudando.masks.DateMask
import br.com.semudando.masks.MoneyMask
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color.black
import org.jetbrains.compose.web.css.Color.white
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.css.DisplayStyle.Companion.InlineBlock
import org.jetbrains.compose.web.css.FlexWrap.Companion.Wrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle.Companion.Solid
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.filter
import org.jetbrains.compose.web.css.flexBasis
import org.jetbrains.compose.web.css.flexWrap
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontStyle
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.right
import org.jetbrains.compose.web.css.selectors.plus
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.PasswordInput
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.TextInput
import org.w3c.dom.HTMLInputElement

val values = listOf("1", "5", "10", "25", "50", "100")

@Composable
fun DonationForm() {
  var selected by remember { mutableStateOf(values[1]) }

  Div({ classes(allBoxesContainer) }) {
    values.forEach {
      if (it == selected) {
        SelectedBox("R$ $it") { selected = it }
      } else {
        UnselectedBox("R$ $it") { selected = it }
      }
    }
    Div({ classes(inputIcon) }) {
      TextInput(selected) {
        prop({ element: HTMLInputElement, _: Any -> MoneyMask(element) }, "donationInput")

        classes(donationValue)
        onInput {
          selected = it.value
        }
      }
    }

    Div({ classes(creditCardLabel) }) {
      Img("icons/credit-card.png") {
        style {
          width(24.px)
          height(24.px)
          filter { invert(100.percent) }
        }
      }
      Span { Text("Cartão de Crédito") }
      Img("icons/lock-check.png") {
        style {
          filter {
            invert(78.percent)
            sepia(46.percent)
            saturate(4268.percent)
            hueRotate(77.deg)
            brightness(88.percent)
            contrast(84.percent)
          }
        }
      }
    }

    val creditCardNumber = remember { mutableStateOf("") }
    val creditCardExpirationDate = remember { mutableStateOf("") }
    val creditCardCvv = remember { mutableStateOf("") }

    Div({ classes(creditCardForm) }) {
      Input(InputType.Text) {
        prop({ element: HTMLInputElement, _: Any -> CreditCardMask(element) }, "donationInput")

        value(creditCardNumber.value)
        classes(creditCardNumberInput)
        placeholder("Número do cartão de crédito")
        onInput {
          creditCardNumber.value = it.value
        }
      }

      TextInput(creditCardExpirationDate.value) {
        prop({ element: HTMLInputElement, _: Any -> DateMask(element) }, "donationInput")
        classes(creditCardExpirationDateInput)
        placeholder("Val. ex. 11/29")
        onInput {
          creditCardExpirationDate.value = it.value
        }
      }

      PasswordInput(creditCardCvv.value) {
        prop({ element: HTMLInputElement, _: Any -> CvvMask(element) }, "donationInput")
        classes(creditCardCvvInput)
        placeholder("CVV ex. 123")
        onInput {
          creditCardCvv.value = it.value
        }
      }
    }

    Button({
      classes(donationButton); onClick {
      makeDonation(creditCardNumber,
        creditCardExpirationDate,
        creditCardCvv)
    }
    }) {
      Span {
        Text("DOAR R$$selected,00")
      }
    }
  }
}


@Composable
fun SelectedBox(value: String, click: () -> Unit) {
  Button({ classes(boxContainer, selectedBoxContainer); onClick { click() } }) {
    Img("icons/check-circle.png")
    Span { Text(value) }
  }
}

@Composable
fun UnselectedBox(value: String, click: () -> Unit) {
  Button({ classes(boxContainer, unselectedBoxContainer); onClick { click() } }) {
    Span { Text(value) }
  }
}

fun makeDonation(
  ccNumber: MutableState<String>,
  ccExpirationDate: MutableState<String>,
  ccCvv: MutableState<String>,
) {
  ccNumber.value = ""
  ccExpirationDate.value = ""
  ccCvv.value = ""
}

object DonationFormStyle : StyleSheet(AppStyleSheet) {

  val allBoxesContainer by style {
    display(Flex)
    flexWrap(Wrap)
    width(100.percent)
    padding(5.px)
  }

  val boxContainer by style {
    display(Flex)
    alignItems(AlignItems.Center)
    justifyContent(JustifyContent.Center)
    height(64.px)

    margin(5.px)
    flexBasis(33.3.percent - 10.px)

    border(1.px, Solid, black)
  }

  val selectedBoxContainer by style {
    position(Position.Relative)
    display(InlineBlock)
    backgroundColor(AppStyleSheet.primary)

    (self + " span") {
      color(white)
      fontSize(16.px)
    }

    (self + " img") {
      position(Position.Absolute)
      top(2.px)
      right(2.px)
      width(20.px)
      height(20.px)
    }
  }

  val unselectedBoxContainer by style {
    backgroundColor(AppStyleSheet.lightBlue)
    (self + " span") {
      color(black)
      fontSize(16.px)
    }
  }

  val donationValue by style {
    width(100.percent)
    fontSize(16.px)
  }

  val inputIcon by style {
    display(Flex)
    width(100.percent)

    (self + " input") {
      padding(10.px)
    }
  }

  val creditCardLabel by style {
    display(Flex)
    alignItems(AlignItems.Center)
    marginTop(8.px)
  }

  val creditCardForm by style {
    display(Flex)
    gap(4.px)
    width(100.percent)
    marginTop(10.px)

    (self + " input") {
      padding(10.px)
    }
  }

  val creditCardNumberInput by style {
    width(100.percent)
  }

  val creditCardExpirationDateInput by style {
    width(50.percent)
  }

  val creditCardCvvInput by style {
    width(50.percent)
  }

  val donationButton by style {
    width(100.percent)
    backgroundColor(AppStyleSheet.accentLight)
    padding(20.px)
    marginTop(10.px)
    borderRadius(3.px)

    (self + " span") {
      color(white)
      fontSize(24.px)
      fontStyle("bold")
    }
  }
}
