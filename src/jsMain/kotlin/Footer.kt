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
import br.com.semudando.FooterStyle.background
import br.com.semudando.FooterStyle.bold
import br.com.semudando.FooterStyle.container
import br.com.semudando.FooterStyle.footerText
import br.com.semudando.FooterStyle.footerTitle
import org.jetbrains.compose.web.css.Color.white
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.whiteSpace
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

// Links
// <a href="https://www.freepik.com/photos/background">Background photo created by efe_madrid - www.freepik.com</a>

@Composable
fun Footer() {
    Div({ classes(background) }) {
        Div({ style { width(50.percent) } }) {
            Div({ classes(container) }) {
                Span({ classes(footerTitle) }) {
                    Text("Se Mudando")
                }

                Span({ classes(footerText) }) {
                    Text("Gerando oportunidade para mudança.")
                }

                Div({ style { marginTop(16.px) } }) {
                    Span({ classes(footerText, bold) }) {
                        Text("Cidade: ")
                    }
                    Span({ classes(footerText) }) {
                        Text("São Carlos")
                    }
                }

                Span({ classes(footerText) }) {
                    Text("Contato: Gabriel Dabus\n")
                    Text("Whatsapp: (14) 99612-0450")
                }
            }
        }

        Div({ style { width(50.percent) } }) {
            Div({ classes(container) }) {
                Span({ classes(footerText) }) {
                    Text("Entre em contato com a gente!")
                }
                A("mailto:contato@semudando.com.br", { classes(footerText) }) {
                    Text("contato@semudando.com.br")
                }

                Span({ classes(footerText) }) {
                    Text("Nos acompanhe em nossas redes sociais")
                }

                Div({ style { margin(0.px) } }) {
                    Icons()
                }
            }
        }
    }
}

object FooterStyle : StyleSheet(AppStyleSheet) {

    val background by style {
        backgroundColor(primary)
        padding(16.px)
        display(DisplayStyle.Flex)
    }

    val container by style {
        width(50.percent)
        property("margin", "auto")
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
    }

    val footerTitle by style {
        fontWeight("bold")
        fontSize(20.px)
        color(white)
    }

    val footerText by style {
        color(white)
        fontSize(15.px)
        marginTop(16.px)
        whiteSpace("pre-line")
    }

    val bold by style {
        fontWeight("bold")
    }
}