#0.Panel de administracion 
#Muestra texto del servidor en pantalla para los jugadores con el tag "admin"

#1.Se guarda la cantidad de jugadores y los ticks del dia
execute store result score #game jugadores_activos if entity @a
execute store result score #game tick_dia run time query day

#2.Se muestra texto en pantalla
tellraw @a[tag=admin] ["        SERVIDOR"]
tellraw @a[tag=admin] [". JUGADORES: ", {score:{name:"#game", objective:"jugadores_activos"}}]
tellraw @a[tag=admin] [". TICK DIA: ", {"score":{name:"#game", objective:"tick_dia"}}]
tellraw @a[tag=admin] [". VERSION: 1.0"]
tellraw @a[tag=admin] [""]
tellraw @a[tag=admin] ["         PANEL"]
tellraw @a[tag=admin] [{"text":". [LLAMAR FUNCION]","color":"aqua"}]
tellraw @a[tag=admin] [{"text":". [PROBAR BLOQUE]", "color":"aqua"}]
tellraw @a[tag=admin] [{"text":". [INVOCAR ESTRUCTURA]", "color":"aqua"}]
tellraw @a[tag=admin] [{"text":". [INVOCAR ENTIDAD/JEFE]", "color":"aqua"}]
tellraw @a[tag=admin] [{"text":". [DAR ITEM]", "color":"aqua"}]
