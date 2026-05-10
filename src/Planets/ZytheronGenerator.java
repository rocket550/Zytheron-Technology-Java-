package planets;

import arc.graphics.*;
import arc.math.geom.*;
import arc.util.noise.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;

public class ZytheronGenerator extends PlanetGenerator {
    
    @Override
    public Color getColor(Vec3 position) {
        // Usamos la semilla directamente (seed)
        float noise = Simplex.noise3d(seed, 7, 0.5, 1/22.0, position.x, position.y, position.z);
        
        // Colores del fondo marino y tierra
        if(noise < -0.1f) return Color.valueOf("1a3a8f"); // Fondo marino profundo (azul oscuro)
        if(noise < 0.0f) return Color.valueOf("f7e09a");  // Arena de playa
        return Color.valueOf("808080");                   // Piedra/Montaña
    }

    @Override
    public float getHeight(Vec3 position) {
        float noise = Simplex.noise3d(seed, 7, 0.5, 1/22.0, position.x, position.y, position.z);
        // El fondo marino tiene altura 0, las montañas suben
        return Math.max(0, noise); 
    }

    @Override
    public void generateSector(Sector sector) {
        // Generación básica para que no de error
    }
}
