package com.grl.paises.domain

import android.provider.BaseColumns

class PaisContract {
    companion object {
        const val NOMBRE_BD = "paises"
        const val VERSION = 1

        class Entrada:BaseColumns{
            companion object{
                const val NOMBRE_TABLA = "paises"
                const val COLUMNA_ID = "id"
                const val COLUMNA_NOMBRE = "nombre"
                const val COLUMNA_BANDERA = "bandera"
                const val COLUMNA_MAPA = "mapa"
                const val COLUMNA_EUROPA = "europa"
                const val COLUMNA_POBLACION = "poblacion"
                const val COLUMNA_CAPITAL = "capital"
                const val COLUMNA_ES_EUROPEA = "esEuropea"
            }
        }
    }
}