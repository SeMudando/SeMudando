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

package br.com.semudando.page

import androidx.compose.runtime.Composable
import br.com.semudando.AppStyleSheet
import br.com.semudando.components.DonationForm
import br.com.semudando.page.DonatePageStyles.bulletedBold
import br.com.semudando.page.DonatePageStyles.bulletedText
import br.com.semudando.page.DonatePageStyles.donateContainer
import br.com.semudando.page.DonatePageStyles.whyContainer
import br.com.semudando.page.DonatePageStyles.whyPhoto
import br.com.semudando.page.DonatePageStyles.whyText
import org.jetbrains.compose.web.css.Color.white
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun DonatePage() {
  Div({ classes(whyContainer) }) {
    Div({ classes(whyPhoto) }) {
      Img("images/assistido2.png")
    }
    Div({ classes(whyText) }) {
      BulletParagraph("Por que doar?",
        "Nossa receita é inteiramente proveniente de doações. Com a sua ajuda nós mantemos o projeto em funcionamento e trabalhamos para reinserir pessoas em situação de rua na sociedade.")
      BulletParagraph("Existe um valor mínimo para doação?",
        "As doações podem ser feitas a partir de R\$ 1,00 (um real) e não tem limites. Caso você queira alterar ou cancelar o valor da sua doação nos meses seguintes isso também é possível.")
      BulletParagraph("Quais formas de pagamento?",
        "Você pode realizar o pagamento através de cartão de crédito ou boleto. O pagamento por boleto apresenta uma taxa a mais de R\$ 2,00 (dois reais).")
    }
  }
  Div({ classes(donateContainer) }) {
    DonationForm()
  }
}

@Composable
fun BulletParagraph(title: String, text: String) {
  Span({ classes(bulletedBold) }) {
    Text(title)
  }

  P({ classes(bulletedText) }) {
    Text(text)
  }
}

object DonatePageStyles : StyleSheet(AppStyleSheet) {

  val whyContainer by style {
    backgroundColor(AppStyleSheet.darkGrayBlue)
    display(DisplayStyle.Flex)
  }

  val whyPhoto by style {
    width(50.percent)
  }

  val whyText by style {
    width(50.percent)
    padding(5.percent)
  }

  val bulletedBold by style {
    fontWeight("bold")
    fontSize(22.px)
    color(white)
  }

  val bulletedText by style {
    fontSize(18.px)
    color(white)
  }

  val donateContainer by style {
    backgroundColor(white)
    display(DisplayStyle.Flex)
    padding(24.px)
    minHeight(200.px)
    justifyContent(JustifyContent.Center)
  }

}