#0.Archivo dedicado a aumentar el mana a cada minuto y definir el maximo

#1.Se detecta el maximo por jugador y se ajustan las scoreboards
execute store result bossbar islands_enet:mana_admin max run scoreboard players get @a[tag=mana_admin,limit=1] mana_maximo
execute store result bossbar islands_enet:mana_gali max run scoreboard players get @a[tag=mana_gali,limit=1] mana_maximo
execute store result bossbar islands_enet:mana_roli max run scoreboard players get @a[tag=mana_roli,limit=1] mana_maximo
execute store result bossbar islands_enet:mana_tino max run scoreboard players get @a[tag=mana_tino,limit=1] mana_maximo
execute store result bossbar islands_enet:mana_rodri max run scoreboard players get @a[tag=mana_rodri,limit=1] mana_maximo
execute store result bossbar islands_enet:mana_juan max run scoreboard players get @a[tag=mana_juan,limit=1] mana_maximo
execute store result bossbar islands_enet:mana_octa max run scoreboard players get @a[tag=mana_octa,limit=1] mana_maximo
execute store result bossbar islands_enet:mana_santi max run scoreboard players get @a[tag=mana_santi,limit=1] mana_maximo
execute store result bossbar islands_enet:mana_manu max run scoreboard players get @a[tag=mana_manu,limit=1] mana_maximo

#2.Se ajustan los valores de mana actual
execute store result bossbar islands_enet:mana_admin value run scoreboard players get @a[tag=mana_admin,limit=1] mana_actual
execute store result bossbar islands_enet:mana_admin value run scoreboard players get @a[tag=mana_juan,limit=1] mana_actual
execute store result bossbar islands_enet:mana_admin value run scoreboard players get @a[tag=mana_gali,limit=1] mana_actual
execute store result bossbar islands_enet:mana_admin value run scoreboard players get @a[tag=mana_tino,limit=1] mana_actual
execute store result bossbar islands_enet:mana_admin value run scoreboard players get @a[tag=mana_octa,limit=1] mana_actual
execute store result bossbar islands_enet:mana_admin value run scoreboard players get @a[tag=mana_santi,limit=1] mana_actual
execute store result bossbar islands_enet:mana_admin value run scoreboard players get @a[tag=mana_roli,limit=1] mana_actual
execute store result bossbar islands_enet:mana_admin value run scoreboard players get @a[tag=mana_gali,limit=1] mana_actual
execute store result bossbar islands_enet:mana_admin value run scoreboard players get @a[tag=mana_rodri,limit=1] mana_actual

#3.Se aumenta el mana actual si el timer es cero
execute if score @a[tag=mana_admin,limit=1] mana_timer matches ..0 run scoreboard players add @a[tag=mana_admin,limit=1] mana_actual 1
execute if score @a[tag=mana_juan,limit=1] mana_timer matches ..0 run scoreboard players add @a[tag=mana_juan,limit=1] mana_actual 1
execute if score @a[tag=mana_rodri,limit=1] mana_timer matches ..0 run scoreboard players add @a[tag=mana_rodri,limit=1] mana_actual 1
execute if score @a[tag=mana_manu,limit=1] mana_timer matches ..0 run scoreboard players add @a[tag=mana_manu,limit=1] mana_actual 1
execute if score @a[tag=mana_tino,limit=1] mana_timer matches ..0 run scoreboard players add @a[tag=mana_tino,limit=1] mana_actual 1
execute if score @a[tag=mana_roli,limit=1] mana_timer matches ..0 run scoreboard players add @a[tag=mana_roli,limit=1] mana_actual 1
execute if score @a[tag=mana_octa,limit=1] mana_timer matches ..0 run scoreboard players add @a[tag=mana_octa,limit=1] mana_actual 1
execute if score @a[tag=mana_santi,limit=1] mana_timer matches ..0 run scoreboard players add @a[tag=mana_santi,limit=1] mana_actual 1
execute if score @a[tag=mana_gali,limit=1] mana_timer matches ..0 run scoreboard players add @a[tag=mana_gali,limit=1] mana_actual 1

#4.Se reducen los contadores
scoreboard players remove @a mana_timer 1

#5.Se reinician los timers
execute if score @a[tag=mana_admin,limit=1] mana_timer matches ..0 run scoreboard players set @a[tag=mana_admin,limit=1] mana_timer 1200
execute if score @a[tag=mana_juan,limit=1] mana_timer matches ..0 run scoreboard players set @a[tag=mana_juan,limit=1] mana_timer 1200
execute if score @a[tag=mana_rodri,limit=1] mana_timer matches ..0 run scoreboard players set @a[tag=mana_rodri,limit=1] mana_timer 1200
execute if score @a[tag=mana_manu,limit=1] mana_timer matches ..0 run scoreboard players set @a[tag=mana_manu,limit=1] mana_timer 1200
execute if score @a[tag=mana_tino,limit=1] mana_timer matches ..0 run scoreboard players set @a[tag=mana_tino,limit=1] mana_timer 1200
execute if score @a[tag=mana_roli,limit=1] mana_timer matches ..0 run scoreboard players set @a[tag=mana_roli,limit=1] mana_timer 1200
execute if score @a[tag=mana_octa,limit=1] mana_timer matches ..0 run scoreboard players set @a[tag=mana_octa,limit=1] mana_timer 1200
execute if score @a[tag=mana_santi,limit=1] mana_timer matches ..0 run scoreboard players set @a[tag=mana_santi,limit=1] mana_timer 1200
execute if score @a[tag=mana_gali,limit=1] mana_timer matches ..0 run scoreboard players set @a[tag=mana_gali,limit=1] mana_timer 1200

