package com.grl.paises.domain

import android.content.Context
import android.database.Cursor
import com.grl.paises.Pais

class PaisDAO {
    fun cargarLista(context: Context?): MutableList<Pais> {
        lateinit var resultado: MutableList<Pais>
        lateinit var cursor: Cursor

        try {
            val db = DBopenHelper.getInstance(context)!!.readableDatabase
            val columnas = arrayOf(
                PaisContract.Companion.Entrada.COLUMNA_ID,
                PaisContract.Companion.Entrada.COLUMNA_NOMBRE,
                PaisContract.Companion.Entrada.COLUMNA_BANDERA,
                PaisContract.Companion.Entrada.COLUMNA_MAPA,
                PaisContract.Companion.Entrada.COLUMNA_CAPITAL,
                PaisContract.Companion.Entrada.COLUMNA_POBLACION,
                PaisContract.Companion.Entrada.COLUMNA_EUROPA,
                PaisContract.Companion.Entrada.COLUMNA_ES_EUROPEA,
            )
            cursor = db.query(
                PaisContract.Companion.Entrada.NOMBRE_TABLA, columnas,
                null, null, null, null, null
            )
            resultado = mutableListOf()
            while (cursor.moveToNext()) {
                val nueva = Pais(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(6),
                    cursor.getInt(3),
                    cursor.getString(5),
                    cursor.getString(4),
                    toBoolean(cursor.getInt(7))
                )
                resultado.add(nueva)
            }
        } finally {
            cursor.close()
        }

        return resultado
    }

    private fun toBoolean(int: Int): Boolean {
        return int == 0
    }
}