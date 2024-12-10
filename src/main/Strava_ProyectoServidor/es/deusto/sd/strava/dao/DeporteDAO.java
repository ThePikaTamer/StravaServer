package es.deusto.sd.strava.dao;

public interface DeporteDAO {
    public DeporteDAO getInstance();

    public void save(Usuario usuario);
    
    public Deportes getDeportes(String deporte);
    public List<String> getNombre();

}
