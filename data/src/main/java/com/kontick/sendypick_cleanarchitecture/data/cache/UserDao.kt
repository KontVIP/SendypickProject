package com.kontick.sendypick_cleanarchitecture.data.cache

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kontick.sendypick_cleanarchitecture.data.cache.UserRoom

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: UserRoom)

    @Update
    suspend fun updateUser(userRoom: UserRoom)

    @Delete
    suspend fun deleteUser(userRoom: UserRoom)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<UserRoom>>

}
