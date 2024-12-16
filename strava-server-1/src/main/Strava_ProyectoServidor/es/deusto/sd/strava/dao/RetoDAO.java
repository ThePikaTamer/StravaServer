package es.deusto.sd.strava.dao;

public interface RetoDAO {
    public RetoDAO getInstance();

    public void save(Usuario usuario);
    
    public void getRetos();

}
