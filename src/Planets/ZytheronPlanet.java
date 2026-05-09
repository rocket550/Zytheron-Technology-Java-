package zytheron.content;

import arc.func.*;
import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.graphics.g3d.*;
import mindustry.graphics.g3d.PlanetGrid.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;


public static Planet Zytheron;

public static void load(){
    miPlaneta = new Planet("Zytheron Planets.sun, 1f, 3){{
        // Generador (debes tener la clase creada)
        generator = new ZytheronGenerator();
        
        // Visuales
        meshLoader = () -> new HexMesh(this, 5);
        atmosphereColor = Color.valueOf("32a852"); // Un verde radioactivo
        iconColor = Color.valueOf("32a852");
        
        // Configuración de campaña
        startSector = 15;
        alwaysUnlocked = true;
        
        // Reglas
        ruleSetter = rule -> {
            rule.waveTeam = Team.crux;
            rule.lighting = true; // Activa luz nocturna
        };
    }};
}
