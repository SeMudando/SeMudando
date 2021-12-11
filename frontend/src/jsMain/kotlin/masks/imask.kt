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

package br.com.semudando.masks

import androidx.compose.runtime.NoLiveLiterals
import br.com.semudando.components.jsObject
import org.w3c.dom.Element

@NoLiveLiterals
fun MoneyMask(element: Element) {
  val opts: dynamic = jsObject {
    mask = "R\$num"
    blocks = jsObject {
      num = jsObject {
        mask = IMask.MaskedNumber
      }
    }
  }
  IMask(element, opts)
}

@NoLiveLiterals
fun CreditCardMask(element: Element) {
  val opts: dynamic = jsObject {
    mask = "0000 0000 0000 0000"
  }
  IMask(element, opts)
}

@NoLiveLiterals
fun DateMask(element: Element) {
  val opts: dynamic = jsObject {
    mask = IMask.Pattern
    mask = "mm/yy"
    blocks = jsObject {
      mm = jsObject {
        mask = IMask.MaskedRange
        from = 1
        to = 12
        maxLength = 2
      }
      yy = jsObject {
        mask = IMask.MaskedRange
        from = 0
        to = 99
        maxLength = 2
      }
    }
  }
  IMask(element, opts)
}

fun CvvMask(element: Element) {
  val opts: dynamic = jsObject {
    mask = "000"
  }
  IMask(element, opts)
}