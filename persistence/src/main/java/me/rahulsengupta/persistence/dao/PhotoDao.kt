package me.rahulsengupta.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import me.rahulsengupta.persistence.entity.PhotoEntity

@Dao
interface PhotoDao: BaseDao<PhotoEntity> {

    @Query("SELECT * FROM Photo")
    fun getPhotos(): List<PhotoEntity>
}