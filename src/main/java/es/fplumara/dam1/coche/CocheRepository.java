package es.fplumara.dam1.coche;

public interface CocheRepository {

    // Busca un coche en la bbdd (bbdd=base de datos)
    Coche findByMatricula(String matricula);

    // Guarda un coche en la bbdd
    Coche save(Coche coche);
}
