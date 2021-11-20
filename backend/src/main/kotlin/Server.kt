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

import com.stripe.Stripe
import com.stripe.model.PaymentIntent
import com.stripe.model.PaymentIntent.create
import com.stripe.param.PaymentIntentCreateParams
import com.stripe.param.PaymentIntentCreateParams.AutomaticPaymentMethods
import com.stripe.param.PaymentIntentCreateParams.builder
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.*
import io.ktor.features.ContentNegotiation
import io.ktor.http.HttpStatusCode
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.serialization.json
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
  Stripe.apiKey = System.getenv("STRIPE_API_KEY")

  embeddedServer(Netty, port = 9090) {
    install(ContentNegotiation) {
      json()
    }
    routing {
      get("payment") {
        val amountCents = call.request.queryParameters["amountCents"]?.toLong() ?: return@get call.respond(
          HttpStatusCode.BadRequest,
          "Missing amountCents")

        val paymentIntent = create(
          builder()
            .setAmount(amountCents)
            .setCurrency("brl")
            .setAutomaticPaymentMethods(AutomaticPaymentMethods.builder().setEnabled(true).build())
            .build()
        )
        call.respond(OK, StripeClientSecretResponse(paymentIntent.clientSecret))
      }
    }
  }.start(wait = true)
}