package com.hyecheon.web

import com.hyecheon.board.BoardServlet
import org.apache.catalina.startup.Tomcat
import java.io.File
import javax.servlet.http.HttpServlet

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/09/21
 */
fun main(args: Array<String>) {
    val root = File(".").absolutePath
    val baseDir = "$root${File.separatorChar}temp"

    val webPort = 18080

    val tomcat = Tomcat()
    tomcat.setPort(webPort)

    tomcat.setBaseDir(baseDir)
    tomcat.setPort(webPort)

    val context = tomcat.addContext("/", baseDir)

    val board: HttpServlet = BoardServlet()

    tomcat.addServlet("/", "board", board)
    context.addServletMappingDecoded("/board", "board")

    tomcat.start()

    tomcat.server.await()
    println("hello")
}