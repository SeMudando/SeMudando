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
import br.com.semudando.Page
import br.com.semudando.Page.Donate
import br.com.semudando.page.WhoWeAreStyles.introButton
import br.com.semudando.page.WhoWeAreStyles.introContainer
import br.com.semudando.page.WhoWeAreStyles.introContent
import br.com.semudando.page.WhoWeAreStyles.introP
import br.com.semudando.page.WhoWeAreStyles.introText
import br.com.semudando.page.WhoWeAreStyles.introTextBold
import br.com.semudando.page.WhoWeAreStyles.missionColumn
import br.com.semudando.page.WhoWeAreStyles.missionContainer
import br.com.semudando.page.WhoWeAreStyles.missionContent
import br.com.semudando.page.WhoWeAreStyles.missionText
import br.com.semudando.page.WhoWeAreStyles.openessContainer
import br.com.semudando.page.WhoWeAreStyles.openessContent
import br.com.semudando.page.WhoWeAreStyles.orangeBold
import br.com.semudando.page.WhoWeAreStyles.pdf
import br.com.semudando.page.WhoWeAreStyles.teamCategory
import br.com.semudando.page.WhoWeAreStyles.teamContainer
import br.com.semudando.page.WhoWeAreStyles.teamMember
import br.com.semudando.page.WhoWeAreStyles.teamMemberContainer
import br.com.semudando.page.WhoWeAreStyles.teamMemberName
import br.com.semudando.page.WhoWeAreStyles.video
import br.com.semudando.page.WhoWeAreStyles.whiteBold
import br.com.semudando.pageState
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Color.lightblue
import org.jetbrains.compose.web.css.Color.white
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.alignContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.alignSelf
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.backgroundImage
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.color
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.filter
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.fontWeight
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.maxWidth
import org.jetbrains.compose.web.css.minHeight
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textAlign
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Source
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Video

@Composable
fun WhoWeArePage() {
  Intro()
  Mission()
  Openess()
  MeetTheTeam()
}

@Composable
fun Intro() {
  Div({ classes(introContainer) }) {
    Div({ classes(introContent) }) {
      Div({ style { display(DisplayStyle.Flex); alignItems(AlignItems.Center) } }) {
        Div({ style { width(50.percent) } }) {
          P({ classes(introP) }) {
            Span({ classes(introText, introTextBold) }) {
              Text("O Se Mudando vai revolucionar o modo como a sociedade lida com o desafio social da população em situação de rua no Brasil.")
            }
          }
          P({ classes(introP) }) {
            Span({ classes(introText) }) {
              Text("Nascemos para ter impacto perene na vida das pessoas, reinserindo-as à sociedade por meio do nosso programa baseado no Rapid Re-Housing. Metodologia com sucesso comprovado no exterior, mais eficiente no processo de reintegração e menos custosa ao Estado, se comparada às estratégias nacionais.")
            }
          }
          P({ classes(introP) }) {
            Span({ classes(introText) }) {
              Text("Como forma de escalar o negócio, pretendemos ser um dos pioneiros no país a concretizar um Contrato de Impacto Social, com o qual captaremos investimento da iniciativa privada para resolver um problema do Estado, que por sua vez, dependendo da nossa eficiência vai remunerar a operação que por si retornará esse pagamento com acréscimos aos investidores.")
            }
          }
        }
        Div({ style { width(50.percent) } }) {
          Video({
            classes(video)
            attr("controls", "true")
            attr("poster", "videos/animacao_thumb.png")
          }) {
            Source({
              attr("src", "videos/animacao_rapid_rehousing.mp4")
              attr("type", "video/mp4")
            })
          }
        }
      }
      Button({ classes(introButton); onClick { pageState = Donate } }) {
        Text("Juntos, nós podemos! Vamos?")
      }
    }
  }
}

@Composable
fun Mission() {
  Div({ classes(missionContainer) }) {
    Div({ classes(missionContent) }) {

      Div({ classes(missionColumn) }) {
        Img("icons/goal.png") { style { maxWidth(32.px); filter { invert(100.percent) } } }
        Span({ classes(orangeBold) }) { Text("Missão") }
        Span({ classes(missionText) }) {
          Text("Queremos quebrar barreiras e participar da mudança na vida de pessoas com trajetória de rua ao fomentar sua reinserção na sociedade.")
        }
      }

      Div({ classes(missionColumn); style { alignSelf("flex-end") } }) {
        Span({ classes(orangeBold) }) { Text("Valores") }
        Img("images/valores.png")
      }

      Div({ classes(missionColumn) }) {
        Img("icons/vision.png") { style { maxWidth(32.px); filter { invert(100.percent) } } }
        Span({ classes(orangeBold) }) { Text("Visão") }
        Span({ classes(missionText) }) {
          Text("Ser referência no modelo de resolução do problema social de pessoas em situação de rua. No longo prazo se tornar um negócio de impacto social com a metodologia do Rapid Re-Housing.")
        }
      }
    }
  }
}

@Composable
fun Openess() {
  Div({ classes(openessContainer) }) {
    Div({ classes(openessContent) }) {
      Span({ classes(orangeBold) }) {
        Text("Transparência")
      }
      Div({ style { display(DisplayStyle.Flex) } }) {
        Pdf("reports/relatorio_1o_tri_2021.pdf", "1° Trimestre de 2021")
        Pdf("reports/relatorio_2o_tri_2021.pdf", "2° Trimestre de 2021")
      }
    }
  }
}

@Composable
fun Pdf(source: String, name: String) {
  A(source, { classes(pdf) }) {
    Img("icons/pdf.png")
    Text(name)
  }
}

@Composable
fun MeetTheTeam() {
  Div({ classes(teamContainer) }) {
    Span({ classes(whiteBold) }) {
      Text("Conheça nosso time")
    }

    TeamCategory("Gestão") {
      TeamMember("images/team/Foto Milena.webp", "Milena Maria")
      TeamMember("images/team/FOTO - Lucas dos Santos Miranda.webp", "Lucas Miranda")
      TeamMember("images/team/Jueio.webp", "Gabriel Dabus")
    }

    TeamCategory("Recursos Humanos") {
      TeamMember("images/team/Foto Murilo.webp", "Murilo Florêncio")
      TeamMember("images/team/Foto Lê- Assinatura.webp", "Letícia Sacco")
      TeamMember("images/team/Foto Natália- Assinatura.webp", "Natália Furtado")
    }

    TeamCategory("Captação") {
      TeamMember("images/team/Foto Tutu- Assinatura.webp", "Luiz Ricardo Lopez")
      TeamMember("images/team/Foto Rach- Assinatura.webp", "Raquel Izar")
      TeamMember("images/team/Foto Caio- Assinatura.webp", "Caio Bernardo Fróes")
    }

    TeamCategory("Administrativo Financeiro") {
      TeamMember("images/team/WhatsApp Image 2021-05-13 at 21_50_17_jp.webp", "Marcelo Vioto")
      TeamMember("images/team/WhatsApp Image 2021-05-10 at 00_19_12_jp.webp", "Gabriel da Silva Perez")
      TeamMember("images/team/Foto Henrique- Assinatura.webp", "Henrique Franzin")
    }

    TeamCategory("Marketing") {
      TeamMember("images/team/Foto Leca- Assinatura (1).webp", "Letícia Regina Natalino")
      TeamMember("images/team/Foto Carol- Assinatura.webp", "Ana Carolina Cianfroni")
      TeamMember("images/team/Foto Vini- Assinatura (1).webp", "Vinicius da Rocha Imato")
    }

    TeamCategory("Linha de Frente") {
      TeamMember("images/team/Foto Thalys Assinatura.webp", "Thalys Vinicius Moraes")
      TeamMember("images/team/Foto Valens- Assinatura.webp", "Valentina Heiderich")
      TeamMember("images/team/Foto Sofia- Assinatura.webp", "Sofia Côrte de Lucena")
      TeamMember("images/team/Foto Valeska- Assinatura.webp", "Tácito Périco de Oliveira")
      TeamMember("images/team/20210420_145304.webp", "Bernardo Machado")
      TeamMember("images/team/Foto Giulia- Assinatura.webp", "Giulia Frizzarin Bassa")
    }

    TeamCategory("Tecnologia") {
      TeamMember("images/team/Foto Léo Colman.jpeg", "Leonardo Colman Lopes")
    }
  }
}

@Composable
fun TeamCategory(categoryName: String, content: @Composable () -> Unit) {
  Div({ classes(teamCategory) }) {
    Span({ classes(whiteBold); style { fontSize(24.px) } }) {
      Text(categoryName)
    }
    Div({ classes(teamMemberContainer) }) {
      content()
    }
  }
}

@Composable
fun TeamMember(photo: String, name: String) {
  Div({ classes(teamMember) }) {
    Img(photo, name) { style { borderRadius(50.percent); width(150.px); height(150.px) } }
    Span({ classes(teamMemberName) }) { Text(name) }
  }
}


object WhoWeAreStyles : StyleSheet(AppStyleSheet) {
  val introContainer by style {
    minHeight(600.px)
    backgroundColor(white)
    display(DisplayStyle.Flex)
    justifyContent(JustifyContent.Center)
    flexDirection(FlexDirection.Column)
  }

  val introContent by style {
    width(70.percent)
    display(DisplayStyle.Flex)
    alignItems(AlignItems.Center)
    alignSelf(AlignSelf.Center)
    flexDirection(FlexDirection.Column)
  }

  val introP by style {
    padding(10.px)
    property("text-indent", "50px")
  }

  val introText by style {
    textAlign("justify")
    fontSize(18.px)
  }

  val introTextBold by style {
    backgroundColor(AppStyleSheet.lightBlue)
  }

  val video by style {
    maxWidth(100.percent)
  }

  val introButton by style {
    backgroundColor(lightblue)
    color(white)
    fontSize(54.px)
    padding(20.px)
    borderRadius(20.px)
  }

  val missionContainer by style {
    minHeight(500.px)
    backgroundColor(AppStyleSheet.darkGrayBlue)
    display(DisplayStyle.Flex)
    justifyContent(JustifyContent.Center)
  }

  val missionContent by style {
    width(70.percent)
    display(DisplayStyle.Flex)
    margin(50.px)
    justifyContent(JustifyContent.Center)
  }

  val missionColumn by style {
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
    textAlign("center")
    width(22.percent)
    margin(40.px)

    (self + " img") {
      alignSelf(AlignSelf.Center)
    }
  }

  val missionText by style {
    color(white)
  }

  val orangeBold by style {
    fontSize(35.px)
    fontWeight("bold")
    color(Color("#EB4A3B"))
    textAlign("center")
    property("text-shadow", "rgba(0, 0, 0, 0.4) 0px 4px 4px")
  }

  val whiteBold by style {
    margin(30.px)
    fontSize(35.px)
    fontWeight("bold")
    color(white)
    textAlign("center")
    property("text-shadow", "rgba(0, 0, 0, 0.4) 0px 4px 4px")
  }

  val openessContainer by style {
    backgroundColor(white)
    padding(30.px)
    minHeight(200.px)
    display(DisplayStyle.Flex)
    justifyContent(JustifyContent.Center)
  }

  val openessContent by style {
    maxWidth(60.percent)
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
    justifyContent(JustifyContent.Center)

    (self + " *") {
      margin(30.px)
    }
  }

  val pdf by style {
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
    justifyContent(JustifyContent.Center)
    alignContent(AlignContent.Center)
  }

  val teamContainer by style {
    backgroundImage("""url("backgrounds/recycled.jpg")""")
    minHeight(300.px)
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
    alignItems(AlignItems.Center)
  }

  val teamCategory by style {
    width(40.percent)
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
    justifyContent(JustifyContent.Center)
  }

  val teamMemberContainer by style {
    display(DisplayStyle.Flex)
    justifyContent(JustifyContent.Center)

    (self + " *") {
      margin(10.px)
    }

    (self + " img") {
      alignSelf(AlignSelf.Center)
    }
  }

  val teamMember by style {
    margin(10.px)
    maxWidth(33.percent)
    display(DisplayStyle.Flex)
    flexDirection(FlexDirection.Column)
  }

  val teamMemberName by style {
    color(white)
    textAlign("center")
  }
}