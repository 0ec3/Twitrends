package org.wongiseng.frontend.services

import org.wongiseng.shared.model.auth.UserContext
import org.wongiseng.shared.model.SharedExceptions
import org.wongiseng.shared.rpc.server.MainServerRPC
import org.wongiseng.shared.rpc.server.secure.SecureRPC

import scala.concurrent.{ExecutionContext, Future}

/** Holds an active `UserContext` and provides access to the `SecureRPC` with a current `UserToken`. */
class UserContextService(rpc: MainServerRPC)(implicit ec: ExecutionContext) {
  private var userContext: Option[UserContext] = None

  def currentContext: Option[UserContext] = userContext
  def getCurrentContext: UserContext = userContext.getOrElse(throw new SharedExceptions.UnauthorizedException)

  /** Sends login request and saves returned context. */
  def login(username: String, password: String): Future[UserContext] = {
    if (userContext.isDefined) Future.successful(userContext.get)
    else {
      rpc.auth().login(username, password).map { ctx =>
        userContext = Some(ctx)
        ctx
      }
    }
  }

  /** Provides access to SecureRPC with current UserToken. */
  def secureRpc(): Option[SecureRPC] =
    userContext.map(ctx => rpc.secure(ctx.token))
}
