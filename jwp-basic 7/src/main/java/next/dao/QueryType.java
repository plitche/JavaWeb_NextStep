package next.dao;

public enum QueryType {
    INSERT, SELECT_ALL, UPDATE, SELECT_ONE;

    public String getQueryType() {
        return this.toString();
    }
}
