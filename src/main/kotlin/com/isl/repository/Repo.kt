package com.isl.repository

import com.isl.data.model.Sign
import com.isl.data.table.SignTable
import com.isl.repository.DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.*

class Repo {

    suspend fun getSign(name:String) = dbQuery {
        SignTable.select { SignTable.name.lowerCase().eq(name.lowercase())}.map { rowToSign(it) }.singleOrNull()
    }

    suspend fun getRandomSign() = dbQuery {

        SignTable.selectAll().map { rowToSign(it) }.random()

    }

    private fun rowToSign(row:ResultRow?): Sign?{
        if(row == null){
            return null
        }else{
            return Sign(
                name = row[SignTable.name],
                pronounce = row[SignTable.pronounce],
                description = row[SignTable.description],
                imageUrl = row[SignTable.imageUrl])
        }
    }


}