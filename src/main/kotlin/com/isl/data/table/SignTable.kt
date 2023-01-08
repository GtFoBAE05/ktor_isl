package com.isl.data.table

import org.jetbrains.exposed.sql.Table

object SignTable:Table() {
    val name = varchar("name", 512)
    val pronounce = varchar("pronounce", 512)
    val description = varchar("description", 512)
    val imageUrl = varchar("imageUrl", 512)

    override val primaryKey: PrimaryKey = PrimaryKey(name)
}