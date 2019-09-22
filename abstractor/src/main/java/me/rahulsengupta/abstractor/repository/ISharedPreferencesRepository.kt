package me.rahulsengupta.abstractor.repository

interface ISharedPreferencesRepository {
    fun getTheme(): String?
    fun setTheme(theme: String)
}