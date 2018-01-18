package org.unreal.draft.util

import java.util.HashMap

class ResponseData {

    val ERRORS_KEY = "errors"

    private var message: String = ""
    private var code: Int = 0
    private val data = HashMap<String, Any>()

    fun getMessage(): String {
        return message
    }

    fun getCode(): Int {
        return code
    }

    fun getData(): Map<String, Any> {
        return data
    }

    fun putDataValue(key: String, value: Any?): ResponseData {
        if (value != null) {
            data.put(key, value)
        }
        return this
    }

    constructor(){}
    constructor(code: Int,message: String):this (){
        this.code = code
        this.message = message
    }
    companion object {
        fun ok(): ResponseData {
            return ResponseData(200, "Ok")
        }

        fun notFound(): ResponseData {
            return ResponseData(404, "Not Found")
        }

        fun badRequest(): ResponseData {
            return ResponseData(400, "Bad Request")
        }

        fun forbidden(): ResponseData {
            return ResponseData(403, "Forbidden")
        }

        fun unauthorized(): ResponseData {
            return ResponseData(401, "unauthorized")
        }

        fun serverInternalError(): ResponseData {
            return ResponseData(500, "Server Internal Error")
        }

        fun customerError(): ResponseData {
            return ResponseData(1001, "Customer Error")
        }
    }
}