package com.hyecheon.board

import javax.servlet.http.HttpServletRequest

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/09/21
 */
class Board {

    fun callList(request: HttpServletRequest): String {
        val findStr = request.getParameter("findStr")
        println(findStr)
        return "/WEB-INF/jsp/list.jsp"
    }

    fun callWrite(request: HttpServletRequest): String {
        return "/WEB-INF/jsp/write.jsp"
    }

    fun exeWrite(request: HttpServletRequest): String {
        request.setAttribute("exeWriteResult", "ok")

        return callList(request)
    }
}