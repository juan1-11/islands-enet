#0.Archivo que muestra en pantalla aspectos del servidor si se tiene un objeto especial 
# Brujula con tag "admin_key"

#1.Se obtienen  valores de jugadores y ticks del dia por scoreboards 1 y 2 del load
execute store result score #game jugadores_activos if entity @a
execute store result score #game tick_dia run time query day

#2.Se muestra texto en pantalla
tellraw @a[tag=admin] {"text":"SERVIDOR: ","color":"aqua","bold":true,"shadow_color":true}
tellraw @a[tag=admin] [{"text":"Jugadores: ","font":"uniform",color:"gray"},{"score":{name:"#game",objective:"jugadores_activos"}}]
tellraw @a[tag=admin] [{"text":"Ticks del dia: ","font":"uniform",color:"gray"},{"score":{name:"#game",objective:"tick_dia"}}]
tellraw @a[tag=admin] [""]
tellraw @a[tag=admin] {"text":"PANEL: ","color":"aqua","bold":true,"shadow_color":true}
tellraw @a[tag=admin] {"text":"[LLAMAR FUNCION]",color:"red",font:alt}
tellraw @a[tag=admin] {"text":"[LLAMAR BLOQUE]",color:"red",font:alt}
tellraw @a[tag=admin] {"text":"[LLAMAR ESTRUCTURA]",color:"red",font:alt}
tellraw @a[tag=admin] {"text":"[LLAMAR ENTIDAD/JEFE]",color:"red",font:alt}
tellraw @a[tag=admin] {"text":"[LLAMAR ITEM]",color:"red",font:alt}