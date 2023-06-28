package next.dao;

public enum QueryType {
    INSERT, SELECT, UPDATE, DELETE;

    public String getQueryType() {
        return this.toString();
    }
}
