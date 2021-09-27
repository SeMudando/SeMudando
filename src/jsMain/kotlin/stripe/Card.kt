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
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Form

@Composable
fun CardWrapper() {
    Form(attrs = { id("payment-form") }) {
        Div({ id("card-element") }) {

        }
        Div({ id("card-errors") }) {

        }
    }

    val stripe = loadStripe("pk_test_51JIv2cD0fOKTQjSDXK0rwdcFNeANXf9s2GaKfsoQZjJ1b1BcSy8TIMIVSmTPIcOdgAV1dPCbUFm3frFhli0Ta4gZ00Tb4eB3a3")
    console.log(stripe)

    val elements = stripe.then<dynamic> {
        val elements = it.elements()
        val card = elements.create("card")
        card.mount("#card-element")
    }
}
