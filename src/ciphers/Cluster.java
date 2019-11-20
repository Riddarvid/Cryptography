package ciphers;

import java.util.Objects;

public class Cluster implements Comparable<Cluster> {
    private final String cluster;
    private int count;

    public Cluster(String cluster) {
        this.cluster = cluster;
    }

    public void incCount() {
        count++;
    }

    public String getCluster() {
        return cluster;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cluster cluster1 = (Cluster) o;
        return Objects.equals(cluster, cluster1.cluster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cluster);
    }

    @Override
    public int compareTo(Cluster other) {
        return other.count - count;
    }

    @Override
    public String toString() {
        return cluster + ": " + count;
    }
}
