package com.wreckingballsoftware.chowbubble.data

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext


class DataStoreWrapper(private val dataStore: DataStore<Preferences>) {
    private object PreferencesKey {
        val AUDIO_STATUS_KEY = booleanPreferencesKey("AudioStatus")
    }

    suspend fun putAudioStatus(isOn: Boolean) = withContext(Dispatchers.IO) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.AUDIO_STATUS_KEY] = isOn
        }
    }

    suspend fun getAudioStatus(default: Boolean): Boolean = withContext(Dispatchers.IO) {
        dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.first()[PreferencesKey.AUDIO_STATUS_KEY] ?: default
    }

    suspend fun clearAll() = withContext(Dispatchers.IO) {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}