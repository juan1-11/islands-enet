## Archivos necesarios para crear un mob, bloque o item

### Item:
    1. Textura.png
    2. Archivo de lenguaje (lang)
    3. [name].json (Archivo que dice como se ve el item en el inventario)
    
    4.ModItems.java (se agrega la confguracion del item al inicializador)

### Bloque:
    1.Textura.png
    2.Archivo de lenguaje (lang)
    3.blockstate/[name].json (Archivo que dice que textura tendra el bloque segun el estado en el que se encuentre, como si esta en el agua o no)
    4.model/block/[name].json (Archivo que dice que aspecto tendra en el mundo el bloque creado, y da la textura al bloque final modelado)
    5.model/item/[name].json (Archivo que deice como se vera el bloque en el inventario)
    6.loot_table/blocks/[name].json (archivo encargado de decir si el bloque da un item al romperse)

    7.ModBlocks.java (se agrega al inicializador y se establecen las propiedades del bloque)


### Mob:
    1. Textura.png
    2. Archivo de lenguaje (lang)
    3. entity/custom/[name]Entity.java (archivo que da IA al mob)
    4. entity/client/[name]Model.java (archivo que "crea" cobre figuras geometricas llamadas por tag el cuerpo del mob)
    5. entity/client/[name]Renderer (Archivo que pega a textura sobre el modelo creado)
    6. loot_table (Debe tener una aunque no de nada)

    7.ModEntities.java (Se agrega la inicializacion del mob)
    
    8.IslandsEnet.java (Se agrega la inicializacion del mob)
    9.IslandsEnetClient.java (Se agrega la inicializacion del mob)