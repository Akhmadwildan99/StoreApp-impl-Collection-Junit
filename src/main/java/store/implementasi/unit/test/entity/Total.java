package store.implementasi.unit.test.entity;

import java.util.Objects;

public class Total {
    private Integer total;

    public Total(Integer total) {
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Total total1 = (Total) o;
        return Objects.equals(total, total1.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }

    @Override
    public String toString() {
        return "Total{" +
                "total=" + total +
                '}';
    }
}
