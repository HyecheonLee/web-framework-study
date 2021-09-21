package com.hyecheon.web

import org.apache.catalina.startup.Tomcat
import java.io.File
import java.util.*

/**
 * User: hyecheon lee
 * Email: rainbow880616@gmail.com
 * Date: 2021/09/21
 */
object RunCode5ByResourceBundle {

    @JvmStatic
    fun main(args: Array<String>) {
        val classpath = System.getProperty("java.class.path")
        val classpaths = classpath.split(":".toRegex()).toTypedArray()
        classpaths.forEach { println(it) }

        val init = ResourceBundle.getBundle("init")
        val webappDir = init.getString("webappDir")
        val baseDir = init.getString("baseDir")
        val webPort = init.getString("webPort").toInt()

        val tomcat = Tomcat()
        tomcat.addWebapp("", webappDir)

        // baseDir + /WEB-INF/web.xml
        tomcat.setBaseDir(baseDir)
        tomcat.setPort(webPort)
        tomcat.start()
        println("code start")
        tomcat.server.await()
    }
}
