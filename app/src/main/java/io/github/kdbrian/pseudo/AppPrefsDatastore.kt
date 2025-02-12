package io.github.kdbrian.pseudo

const val appSettings = "appSettings"

//val Context.appPrefsDatastore : DataStore<Preferences> by preferencesDataStore(appSettings)
//
//class AppPrefsDatastore(val context: Context){
//
//    private val _loggedIn = booleanPreferencesKey("logged-in")
//    private val loggedIn = context.appPrefsDatastore.data.map { it[_loggedIn] ?: false }
//    suspend fun loginUser(){
//        context.appPrefsDatastore.updateData { prefs ->
//            prefs[]
//
//        }
//    }
//}