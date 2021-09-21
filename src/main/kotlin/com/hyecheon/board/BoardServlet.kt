package com.hyecheon.board

import java.io.PrintWriter
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/09/21
 */
class BoardServlet : HttpServlet() {
    override fun service(request: HttpServletRequest, response: HttpServletResponse) {
        val mode: String = request.getParameter("mode")
        val out: PrintWriter = response.writer

        if ("callList" == mode) {
            callList(request, out)
            return
        }

        if ("callWrite" == mode) {
            callWrite(request, out)
            return
        }

        if ("exeWrite" == mode) {
            exeWrite(request, out)
            return
        }

        out.println("mode=$mode")
    }

    private fun exeWrite(request: HttpServletRequest, out: PrintWriter) {
        out.print("this View exeWrite")
    }

    private fun callWrite(request: HttpServletRequest, out: PrintWriter) {
        out.print("this View callWrite")
    }

    private fun callList(request: HttpServletRequest, out: PrintWriter) {
        out.print("this View callList")
    }
}