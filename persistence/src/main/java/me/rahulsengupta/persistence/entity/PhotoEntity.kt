package me.rahulsengupta.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.rahulsengupta.abstractor.dto.Photo

@Entity(tableName = "Photo")
data class PhotoEntity(
    @PrimaryKey
    override val id: Int,
    override val albumId: Int,
    override val title: String,
    override val url: String
) : Photo