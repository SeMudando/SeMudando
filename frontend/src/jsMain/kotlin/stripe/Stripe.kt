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

import br.com.semudando.stripe.Stripe.loadStripe
import kotlinx.coroutines.await
import kotlin.js.Promise

@JsModule("@stripe/stripe-js")
@JsNonModule
external object Stripe {
  fun loadStripe(publishableKey: String): Promise<dynamic>
}

var stripe: dynamic = null

suspend fun startStripe(){
  stripe = loadStripe(
    "pk_live_51JIv2cD0fOKTQjSDanRX38G8j0l0eZ1QlPkKHs5AaIz29kvuFJSVSR05Q8R50zwWOAVivyr0uO1lM10glAbt4skl00GNzrZfTk"
  ).await()
}