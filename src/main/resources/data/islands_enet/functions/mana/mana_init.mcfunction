#0.Archivo que carga las scoreboards de los jugadores

#1.Creacion de las scoreboards mana actual y maximo

scoreboard objectives add mana_actual dummy
scoreboard objectives add mana_maximo dummy
scoreboard objectives add mana_timer dummy


#2.Posicionamiento inicial de los manas maximos y actuales para el inicio del mundo

scoreboard players set @a mana_actual 0
scoreboard players set @a mana_maximo 5
scoreboard players set @a mana_timer 1200
