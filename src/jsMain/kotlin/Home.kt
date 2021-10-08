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
import br.com.semudando.AppStyleSheet.accentLight
import br.com.semudando.AppStyleSheet.primaryLight
import br.com.semudando.HomeStyles.accent
import br.com.semudando.HomeStyles.big
import br.com.semudando.HomeStyles.button
import br.com.semudando.HomeStyles.container
import br.com.semudando.HomeStyles.inviteAccent
import br.com.semudando.HomeStyles.inviteButton
import br.com.semudando.HomeStyles.inviteContainer
import br.com.semudando.HomeStyles.inviteDescription
import br.com.semudando.HomeStyles.inviteImage
import br.com.semudando.HomeStyles.inviteTitle
import br.com.semudando.HomeStyles.logo
import br.com.semudando.HomeStyles.logoImg
import br.com.semudando.HomeStyles.picture
import br.com.semudando.HomeStyles.recycledBackground
import br.com.semudando.HomeStyles.statement
import br.com.semudando.HomeStyles.statementAuthor
import br.com.semudando.HomeStyles.statementAuthorContainer
import br.com.semudando.HomeStyles.statementContainer
import br.com.semudando.HomeStyles.statementTexts
import br.com.semudando.HomeStyles.text
import br.com.semudando.HomeStyles.video
import br.com.semudando.HomeStyles.videoBackground
import br.com.semudando.HomeStyles.videoTitle
import br.com.semudando.stripe.PaymentModal
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.Color.white
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Block
import org.jetbrains.compose.web.css.DisplayStyle.Companion.Flex
import org.jetbrains.compose.web.css.FlexDirection.Companion.Column
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.backgroundImage
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.letterSpacing
import org.jetbrains.compose.web.css.lineHeight
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginBottom
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.maxHeight
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.whiteSpace
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Source
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Video

@Composable
fun Home() {
    TextBoxIntro()

    VideoIntro()

    Statement()

    Invite()
}

@Composable
fun TextBoxIntro() {
    Div({ classes(recycledBackground) }) {
        Div({ classes(container) }) {
            Div({ classes(logo) }) {
                Img("logos/logo.png") { classes(logoImg) }
            }

            Span({ classes(text) }) {
                Text("Nascemos para ter ")
                Span({ classes(accent) }) {
                    Text("impacto perene")
                }
                Text(" na vida das pessoas, reinserindo-as à sociedade por meio do nosso programa baseado no Rapid Re-Housing.")
            }

            Span({ classes(text, big) }) {
                Text("Juntos nós podemos! Vamos?")
            }

            Button({ classes(button); onClick { PaymentModal.show() } }) {
                Text("APOIE NOSSA CAUSA")
            }
        }
    }
}

@Composable
fun VideoIntro() {
    Div({ classes(videoBackground) }) {
        Span({ classes(videoTitle) }) {
            Text("Um pouco do nosso ")
            Span({ classes(accent) }) {
                Text("impacto")
            }
        }

        Video({
            classes(video)
            attr("controls", "true")
        }) {
            Source({
                attr("src", "videos/pitch.mp4")
                attr("type", "video/mp4")
            })
        }
    }
}

@Composable
fun Statement() {
    Div({ classes(recycledBackground) }) {
        Div({ classes(statementContainer) }) {
            Img("images/luciano.png", "Luciano Vicente de Souza") { classes(picture) }

            Div({ classes(statementTexts) }) {
                Span({ classes(statement) }) {
                    Text("Eu preciso realmente dessa oportunidade. Eu quero aprender mais. A gente nunca sabe tudo." + "Onde eu gostaria de estar? Eu quero estar aqui. Esse Luciano mudado, renovado.")
                }

                Div({ classes(statementAuthorContainer) }) {
                    Span({ classes(statementAuthor) }) {
                        Text("Luciano Vicente de Souza\nAssistido")
                    }
                }
            }
        }
    }
}

@Composable
fun Invite() {
    Div({ classes(inviteContainer) }) {

        Div {
            Span({ classes(inviteTitle) }) {
                Text("Faça parte")
            }

            Div({ style { marginTop(36.px) } }) {
                Span({ classes(inviteDescription) }) {
                    Text("do nosso ")
                }
                Span({ classes(inviteAccent) }) {
                    Text("time de doadores")
                }
            }

            Button({ classes(inviteButton) }) {
                Text("QUERO FAZER PARTE")
            }
        }

        Div({ style { property("margin-left", "auto") } }) {
            Img("images/equipe.jpeg") { classes(inviteImage) }
        }
    }
}

object HomeStyles : StyleSheet(AppStyleSheet) {

    val recycledBackground by style {
        minHeight(300.px)
        backgroundImage("""url("backgrounds/recycled.jpg")""")
        display(Flex)
    }

    val container by style {
        width(70.percent)
        property("margin", "auto")
        marginBottom(60.px)
    }

    val logo by style {
        marginTop(16.px)
    }

    val logoImg by style {
        maxWidth(300.px)
    }

    val text by style {
        fontSize(30.px)
        lineHeight(1.5.em)
        display(Block)
        textAlign("center")
    }

    val accent by style {
        backgroundColor(AppStyleSheet.accent)
        color(white)
    }

    val big by style {
        marginTop(16.px)
        fontSize(42.px)
        fontWeight("bold")
        color(white)
    }

    val button by style {
        color(white)
        backgroundColor(AppStyleSheet.accentLight)
        fontSize(32.px)
        padding(24.px)
        paddingLeft(128.px)
        paddingRight(128.px)
        letterSpacing(6.px)
        borderRadius(20.px)
        property("margin", "16px auto")
        marginTop(64.px)
        display(Flex)
    }

    val videoBackground by style {
        backgroundColor(primaryLight)
        minHeight(300.px)
        display(Flex)
        flexDirection(Column)
        alignItems(AlignItems.Center)
        padding(32.px)
    }

    val videoTitle by style {
        color(white)
        fontSize(32.px)
        margin(16.px)
        property("text-shadow", "black 0px 3px 4px")
    }

    val video by style {
        maxWidth(600.px)
    }

    val picture by style {
        maxWidth(600.px)
        maxHeight(400.px)

        margin(16.px)
    }

    val statementContainer by style {
        width(60.percent)
        property("margin", "auto")
        display(Flex)
        alignItems(AlignItems.Center)
    }

    val statementTexts by style {
        textAlign("center")
        width(50.percent)
        property("margin-left", "auto")
    }

    val statement by style {
        color(white)
        fontWeight("italic")
        fontSize(24.px)
    }

    val statementAuthorContainer by style {
        textAlign("end")
        whiteSpace("pre-line")
        margin(16.px)
    }

    val statementAuthor by style {
        color(white)
        fontWeight("bold")
    }

    val inviteContainer by style {
        width(70.percent)
        minHeight(400.px)
        property("margin", "auto")
        marginTop(64.px)
        display(Flex)
    }

    val inviteTitle by style {
        color(primaryLight)
        fontSize(60.px)
        letterSpacing(5.px)
        property("text-shadow", "black 0px 3px 4px")
    }

    val inviteDescription by style {
        color(primaryLight)
        letterSpacing(3.px)
        fontSize(30.px)
    }

    val inviteAccent by style {
        color(white)
        backgroundColor(accentLight)
        letterSpacing(3.px)
        fontSize(30.px)
    }

    val inviteButton by style {
        color(white)
        backgroundColor(AppStyleSheet.accentLight)
        fontSize(32.px)
        padding(24.px)
        letterSpacing(6.px)
        borderRadius(20.px)
        property("margin", "16px auto")
        marginTop(64.px)
        display(Flex)
    }

    val inviteImage by style {
        maxWidth(600.px)
        maxHeight(400.px)
    }
}
