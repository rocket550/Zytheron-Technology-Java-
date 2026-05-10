package planets;

import arc.graphics.*;
import arc.math.*;
import arc.math.geom.*;
import arc.util.noise.*;
import mindustry.maps.planet.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.content.*;

public class ZytheronGenerator extends PlanetGenerator {
    
    public Color getColor(Vec3 position) {
        // Usamos una semilla fija (1) o 'seed' si el compilador la reconoce
        float noise = Simplex.noise3d(1, 7, 0.5, 1/22.0, position.x, position.y, position.z);
        
        if(noise < -0.1f) return Color.valueOf("1a3a8f"); // Azul Profundo
        if(noise < 0.0f) return Color.valueOf("f7e09a");  // Arena
        return Color.valueOf("808080");                   // Piedra
    }

    public float getHeight(Vec3 position) {
        float noise = Simplex.noise3d(1, 7, 0.5, 1/22.0, position.x, position.y, position.z);
        return Math.max(0, noise); 
    }

    public void generateSector(Sector sector) {
        // Necesario para que compile
    }
}
