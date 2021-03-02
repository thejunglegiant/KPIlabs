package data.database;

interface ShowDao {
    void insertAll(Show[] shows);
    void delete(Show item);
    Show[] getAll();
}
