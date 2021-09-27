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

package br.com.semudando.stripe

import androidx.compose.runtime.Composable
import br.com.semudando.AppStyleSheet
import br.com.semudando.stripe.PaymentModal.hide
import br.com.semudando.stripe.PaymentModalStyle.body
import br.com.semudando.stripe.PaymentModalStyle.card
import br.com.semudando.stripe.PaymentModalStyle.container
import br.com.semudando.stripe.PaymentModalStyle.content
import br.com.semudando.stripe.PaymentModalStyle.input
import br.com.semudando.stripe.PaymentModalStyle.sendButton
import br.com.semudando.stripe.PaymentModalStyle.title
import kotlinx.browser.document
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.max
import org.jetbrains.compose.web.attributes.min
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.attributes.step
import org.jetbrains.compose.web.attributes.value
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.css.DisplayStyle.Companion.None
import org.jetbrains.compose.web.css.FlexDirection.Companion.Column
import org.jetbrains.compose.web.css.LineStyle.Companion.Solid
import org.jetbrains.compose.web.css.Position.Companion.Fixed
import org.jetbrains.compose.web.css.Position.Companion.Relative
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.animation
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.border
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.opacity
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.paddingTop
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

object PaymentModal {

    fun show() {
        document.getElementById("payment-modal")!!.asDynamic().style.display = "block"
    }

    fun hide() {
        document.getElementById("payment-modal")!!.asDynamic().style.display = "none"
    }

    @Composable
    operator fun invoke() {
        _PaymentModal()
    }
}

@Composable
private fun _PaymentModal() {
    Div({ classes(container); id("payment-modal"); onClick { hide() } }) {
        Div({ classes(content); onClick { it.stopPropagation() } }) {
            Span({ classes(title) }) {
                Text("Apoie nossa causa")
            }

            Span({ classes(body) }) {
                Text("Faça uma doação!")
            }

            Div({ classes(card) }) {
                CardWrapper()
            }

            Input(InputType.Number) {
                min("0.00")
                max("1000.00")
                step(0.25)
                value("5.00")
                classes(input)
                placeholder("Valor a ser doado")
            }

            Button({ classes(sendButton) }) {
                Text("Fazer pagamento")
            }
        }
    }
}

object PaymentModalStyle : StyleSheet(AppStyleSheet) {
    val fadeInTop by keyframes {
        from {
            top((-300).px)
            opacity(0)
        }

        to {
            top(0.px)
            opacity(1)
        }
    }

    val container by style {
        display(None)
        height(100.percent)
        width(100.percent)
        position(Fixed)
        paddingTop(100.px)
        left(0.px)
        top(0.px)
        property("z-index", 1)
        backgroundColor(rgba(0, 0, 0, 0.4))
    }

    val content by style {
        position(Relative)
        backgroundColor(Color("#fefefe"))
        property("margin", "auto")
        padding(16.px)
        border(1.px, Solid, Color("#888"))
        width(35.percent)
        property("box-shadow", "0 4px 8px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19)")

        display(Flex)
        flexDirection(Column)

        animation(fadeInTop) {
            duration = listOf(400.ms)
        }
    }

    val title by style {
        fontSize(30.px)
    }

    val body by style {
        fontSize(20.px)
    }

    val card by style {
        width(50.percent)
        marginTop(40.px)
    }

    val sendButton by style {
        color(Color.white)
        backgroundColor(AppStyleSheet.accentLight)
        fontSize(24.px)
        padding(16.px)
        borderRadius(20.px)
        marginTop(40.px)
        property("width", "max-content")
    }

    val input by style {
        marginTop(32.px)
        width(280.px)
    }
}
