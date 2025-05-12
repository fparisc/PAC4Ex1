package edu.uoc.pac4.data;

import edu.uoc.pac4.exception.DataRepositoryException;

import java.util.HashMap;

public class DataRepository {
    private String name;
    private HashMap<Integer, DataEntry> dataEntries = new HashMap<>();

    public DataRepository(String name, DataEntry[] dataEntries) throws DataRepositoryException {
        this.dataEntries = new HashMap<>();
        setName(name);
        for (DataEntry entry : dataEntries) {
            addDataEntry(entry);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws DataRepositoryException {
        if (name == null || name.trim().isEmpty()) {
            throw new DataRepositoryException(DataRepositoryException.ERROR_NAME);
        }
        this.name = name.trim();
    }

    public void addDataEntry(DataEntry dataEntry) throws DataRepositoryException {
        if (dataEntry == null)
            throw new DataRepositoryException(DataRepositoryException.ERROR_DATA_ENTRY_NULL);
        if (dataEntries.containsKey(dataEntry.getId()))
            throw new DataRepositoryException(DataRepositoryException.ERROR_DATA_EXISTS);
        dataEntries.put(dataEntry.getId(), dataEntry);
    }

    public DataEntry getDataEntry(int id) throws DataRepositoryException {
        if (!dataEntries.containsKey(id))
            throw new DataRepositoryException(DataRepositoryException.ERROR_DATA_NOT_FOUND);
        return dataEntries.get(id);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n  \"name\": \"").append(name).append("\",\n  \"dataEntries\": [\n");
        dataEntries.values().forEach(entry -> sb.append("    ").append(entry).append(",\n"));
        if (!dataEntries.isEmpty()) sb.deleteCharAt(sb.length()-2);
        sb.append("  ]\n}");
        return sb.toString();
    }
}
