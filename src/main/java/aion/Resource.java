package aion;

public abstract class Resource {


    abstract String getType();

    abstract String getName();

    @Override
    abstract public boolean equals(Object obj);
}
