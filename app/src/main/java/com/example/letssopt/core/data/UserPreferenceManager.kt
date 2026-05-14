package com.example.letssopt.core.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

// Context를 확장하여 dataStore 인스턴스 생성
private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferenceManager(private val context: Context) {

    companion object {
        private val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        private val ACCESS_TOKEN = stringPreferencesKey("access_token")
    }

    suspend fun saveUserLoginState(isLoggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN] = isLoggedIn
        }
    }
}