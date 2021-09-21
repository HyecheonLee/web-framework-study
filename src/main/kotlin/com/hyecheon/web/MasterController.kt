package com.hyecheon.web

import com.hyecheon.board.Board
import javax.servlet.RequestDispatcher
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/09/21
 */
class MasterController : HttpServlet() {
    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        println(req.pathInfo)
        val jspUrl = when (req.pathInfo) {
            "/callList" -> {
                val board = Board()
                board.callList(req)
            }
            "/callWrite" -> {
                val board = Board()
                board.callWrite(req)
            }
            "/exeWrite" -> {
                val board = Board()
                board.exeWrite(req)
            }
            else -> throw ServletException()
        }
        val dispatcher: RequestDispatcher = req.getRequestDispatcher(jspUrl)
        dispatcher.forward(req, resp)
    }
}