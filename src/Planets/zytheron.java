public static Planet Zytheron;

public static void load(){
    miPlaneta = new Planet("Zytheron Planets.sun, 1f, 3){{
        // Generador (debes tener la clase creada)
        generator = new MiGeneradorPersonalizado();
        
        // Visuales
        meshLoader = () -> new HexMesh(this, 5);
        atmosphereColor = Color.valueOf("32a852"); // Un verde radioactivo
        iconColor = Color.valueOf("32a852");
        
        // Configuración de campaña
        startSector = 15;
        alwaysUnlocked = true;
        
        // Reglas
        ruleSetter = r -> {
            r.waveTeam = Team.crux;
            r.lighting = true; // Activa luz nocturna
        };
    }};
}