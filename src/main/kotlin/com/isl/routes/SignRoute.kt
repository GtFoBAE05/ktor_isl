package com.isl.routes

import com.isl.data.model.Sign
import com.isl.repository.Repo
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.locations.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.math.sign



const val API_VERSION = "/v1"
const val SIGN = "$API_VERSION/sign"

@Location("/random")
class random()

@Location("/find/{name}")
data class find(val name:String)

fun Route.SignRoutes(
    db:Repo
){
    get<random>{
        val sign = db.getRandomSign()
        call.respond(
            HttpStatusCode.OK,
            Sign(sign!!.name,sign.pronounce, sign.description, sign.imageUrl),
        )
    }

    get<find>{
        val name = call.parameters["name"]
        val sign = db.getSign(name.toString())

        if(sign == null){
            call.respond(
                HttpStatusCode.BadRequest,
                "Sign tidak ditemukan"
            )
        }else{
            call.respond(
                HttpStatusCode.OK,
                Sign(sign!!.name,sign.pronounce, sign.description, sign.imageUrl),
            )
        }

    }


}
























//private const val BASE_URL = "http://192.168.43.46:8100"
//private val signs = listOf(
//    Sign("A","a", "Huruf A", "$BASE_URL/image/a.jpg"),
//    Sign("B","b",  "Huruf B", "$BASE_URL/image/b.jpg"),
//    Sign("C","c",  "Huruf C", "$BASE_URL/image/c.jpg"),
//    Sign("D","d",  "Huruf D", "$BASE_URL/image/d.jpg"),
//)
//
//fun Route.randomSign(){
//    get("/randomsign"){
//        call.respond(
//            HttpStatusCode.OK,
//            signs.random()
//        )
//    }
//}
//
//fun Route.selectSign(){
//    get("/word/{cari}"){
//        val cari = call.parameters["cari"]
//
//        println(cari)
//        val result = signs.find { it.name.lowercase().equals(cari!!.lowercase()) }
//        println(result)
//
//        val index = signs.indexOf(result)
//
//
//
//        call.respond(
//            HttpStatusCode.OK,
//            signs[index]
//        )
//    }
//}